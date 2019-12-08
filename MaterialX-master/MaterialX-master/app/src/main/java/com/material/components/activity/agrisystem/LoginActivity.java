package com.material.components.activity.agrisystem;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.material.components.R;
import com.material.components.model.User;
import com.material.components.utils.Tools;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private View parent_view;
    private EditText edtUsername;
    private EditText edtPassword;
    private User userLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        parent_view = findViewById(android.R.id.content);
        mapping();

        ((View) findViewById(R.id.sign_up)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LoginActivity.this, ViewAllDeviceActivity.class));
            }
        });
        ((View) findViewById(R.id.sign_in_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // System.out.println("==============================================");
               // System.out.println(edtPassword.getText());
               // System.out.println(edtUsername.getText());


                //controlLogin();

                startActivity(new Intent(LoginActivity.this, ViewAllDeviceActivity.class));
            }
        });

        Tools.setSystemBarColor(this);
    }

    private  void controlLogin()
    {
        UserTask userTask = new UserTask(edtUsername.getText().toString(), edtPassword.getText().toString());
        userTask.execute();
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

    public  class UserTask extends AsyncTask<Void, Void, User>
    {
        private String Username;
        private String Password;
        public UserTask(String Username, String Password) {
            this.Username = Username;
            this.Password = Password;
        }

        @Override
        protected User doInBackground(Void... voids) {
            User user = new User();
            try
            {
                URL url = new URL("http://192.168.100.6/agrisbotSystem/api/USER/?usn=" + Username + "&" + "pass=" + Password);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-type","application/json; charset=UTF-8");

                InputStreamReader isr = new InputStreamReader(connection.getInputStream(), "UTF-8");
                BufferedReader br = new BufferedReader(isr);
                StringBuilder builder = new StringBuilder();
                String line =null;
                while ((line = br.readLine()) != null)
                {
                    builder.append(line);
                }
                JSONArray jsonArray = new JSONArray(builder.toString());
                for(int i=0;i<jsonArray.length();i++)
                {
                    JSONObject jsonObject =jsonArray.getJSONObject(i);
                    user.setID(jsonObject.getString("ID"));
                }
                br.close();
            }
            catch (Exception e){
                Log.e("Loi", e.toString());
            }
            return user;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(User user) {
            super.onPostExecute(user);
            if(user.getID() == null || user.getID().trim().length()==0)
            {
                System.out.println("===================================");
                System.out.println("Không thể đăng nhập");
            }
            else
            {
                System.out.println("===================================");
                System.out.println("Đã đăng nhập");
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }

}
