package com.material.components.activity.agrisystem;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import com.material.components.R;
import com.material.components.helper.SessionManager;
import com.material.components.model.User;
import com.material.components.utils.Tools;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {

    private View parent_view;
    private EditText edtUsername;
    private EditText edtPassword;
    SessionManager sessionManager;
    public static final String CHANNEL_ID = "exampleServiceChannel";
    NotificationCompat.Builder mBuilder;
    NotificationManager mNotifyMgr;
    int mNotificationId = 001;
    String strContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        parent_view = findViewById(android.R.id.content);
        mapping();
        sessionManager = new SessionManager(getApplication());
        ((View) findViewById(R.id.sign_up)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LoginActivity.this, SignUpAgrisActivity.class));
            }
        });
        ((View) findViewById(R.id.sign_in_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                UserTask userTask = new UserTask();

                String dataGet = "?USN=" + edtUsername.getText()+ "&PASS="+edtPassword.getText();
                userTask.execute(dataGet);



                startActivity(new Intent(LoginActivity.this, ViewAllDeviceActivity.class));
            }
        });

        if(sessionManager.Check())
        {
            startActivity(new Intent(LoginActivity.this, ViewAllDeviceActivity.class));
        }

        Tools.setSystemBarColor(this);
        createNotificationChannel();

    }


    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(
                    CHANNEL_ID,
                    "Example Service Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(serviceChannel);
        }
    }

    private void mapping()
    {
        try
        {
            edtUsername = findViewById(R.id.edtUsername);
            edtPassword = findViewById(R.id.edtPassword);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Error Mapping Login Screen");
        }
    }

    public  class UserTask extends AsyncTask<String, Void, User>
    {
        @Override
        protected User doInBackground(String... strings) {
            try
            {
                URL  url = new URL("http://192.168.1.82/agrisystem/api/USER/" + strings[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                System.out.println("===================: " + url.toString());
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");

                InputStreamReader isr = new InputStreamReader(connection.getInputStream(),"UTF-8");
                BufferedReader br = new BufferedReader(isr);
                StringBuilder builder = new StringBuilder();
                String line = null;
                while((line = br.readLine())!=null)
                {
                    builder.append(line);
                }

                JSONObject jsonObject = new JSONObject(builder.toString());
                String userID = jsonObject.getString("ID");
                String name = jsonObject.getString("NAME");
                User user = new User();
                user.setID(jsonObject.getString("ID"));
                return user;
            }
            catch(Exception ex)
            {
                Log.e("Loi", ex.toString());
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(User user) {
            super.onPostExecute(user);
            if(user != null)
            {
                sessionManager.SetLogin(true);
                sessionManager.setIDLogin(user.getID());
                startActivity(new Intent(LoginActivity.this, ViewAllDeviceActivity.class));
            }
            else
            {
                showConfirmDialog();
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        private void showConfirmDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
            builder.setTitle("Đăng nhập không thành công");
            builder.setNegativeButton(R.string.CLOSE, null);
            builder.show();
        }
    }

}
