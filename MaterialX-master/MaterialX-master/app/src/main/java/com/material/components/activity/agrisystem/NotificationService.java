package com.material.components.activity.agrisystem;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;

import com.material.components.R;
import com.material.components.adapter.AdapterDetailDevice;
import com.material.components.fragment.FragmentViewStatusDevice;
import com.material.components.helper.SessionManager;
import com.material.components.model.Monitor;
import com.material.components.model.SensorDevice;
import com.material.components.model.warning;
import com.material.components.utils.common;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import static com.material.components.activity.agrisystem.LoginActivity.CHANNEL_ID;

public class NotificationService extends Service {

    Context ctx;

    @Override
    public void onCreate() {
        super.onCreate();
        ctx = this;
        sessionManager = new SessionManager(ctx);
        MyTask myTask = new MyTask();
        Timer timer = new Timer();
        timer.schedule(myTask, 0000, 2000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

      //  String input = intent.getStringExtra("inputExtra");


        //do heavy work on a background thread
        //stopSelf();




        return START_NOT_STICKY;
    }
    SessionManager sessionManager;
    public class MyTask extends TimerTask {

        GetSensorByDevice getSensorByDevice;

        public  MyTask()
        {

        }

        @Override
        public void run() {
          getSensorByDevice = new GetSensorByDevice();
          if(sessionManager.getIDLogin()!=null)
          {
              getSensorByDevice.execute(sessionManager.getIDLogin());
          }


        }

    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent){
        return null;
    }
    Notification notification;
    class GetSensorByDevice extends AsyncTask<String, Void, ArrayList<warning>>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(ArrayList<warning> warnings) {
            super.onPostExecute(warnings);
           // Intent notificationIntent = new Intent(this, ViewAllDeviceActivity.class);
           // PendingIntent pendingIntent = PendingIntent.getActivity(this,
              //      0, notificationIntent, 0);


            for (warning item : warnings) {
                 notification = new NotificationCompat.Builder(ctx, CHANNEL_ID)
                        .setContentTitle(item.getID()
                        )
                        .setContentText(item.getMessage())
                        .setSmallIcon(R.drawable.ic_confirmation_number)
                        //.setContentIntent(pendingIntent)
                        .build();


                startForeground(1, notification);

            }

            this.cancel(true);

        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected ArrayList<warning> doInBackground(String... strings) {
            ArrayList<warning> lstDV = new ArrayList<warning>();
            try
            {
                String pagram = "?IDUSER=" + strings[0];
                URL url = new URL("http://"+common.ip+"/agrisystem/api/WARNINGSMAX/" +pagram);
                System.out.println("==================: " + url.toString());
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-type","application/json; charset=UTF-8");

                InputStreamReader isr = new InputStreamReader(connection.getInputStream(),"UTF-8");
                BufferedReader br = new BufferedReader(isr);
                StringBuilder builder = new StringBuilder();
                String line = null;
                while((line = br.readLine())!=null)
                {
                    builder.append(line);
                }


                JSONArray jsonArray = new JSONArray(builder.toString());
                for(int i=0;i<jsonArray.length();i++)
                {
                    JSONObject jsonObject =jsonArray.getJSONObject(i);
                    warning dv = new warning();
                    dv.setID(jsonObject.getString("ID"));
                    dv.setMessage(jsonObject.getString("MESSAGE"));
                    dv.setValue(jsonObject.getString("VALUE"));
                    dv.setIDSensor(jsonObject.getString("IDSENSOR"));
                    //dv.setStartDate(jsonObject.getString("STARTDATE"));
                    lstDV.add(dv);
                }
                br.close();
                return lstDV;
            }
            catch (Exception e){
                Log.e("Loi", e.toString());
            }
            return null;
        }
    }
}
