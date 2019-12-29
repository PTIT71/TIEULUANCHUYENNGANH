package com.material.components.fragment;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.material.components.R;
import com.material.components.model.Device;
import com.material.components.model.Monitor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentControlMonitor extends Fragment {

    TextView txtTitle;
    Button btnOn, btnOff;
     View root;
  String MONITORID="";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root =  inflater.inflate(R.layout.fragment_control_monitor, container, false);

        txtTitle = root.findViewById(R.id.title);
        btnOff = root.findViewById(R.id.btnoff);
        btnOn = root.findViewById(R.id.btnOn);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            MONITORID = bundle.getString("ID");
        }
        btnOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Monitor monitor = new Monitor();
                monitor.setID(MONITORID);
                monitor.setStatus(1);

                UpdateStatusDevice updateStatusDevice = new UpdateStatusDevice();
                updateStatusDevice.execute(monitor);


            }
        });

        btnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Monitor monitor = new Monitor();
                monitor.setID(MONITORID);
                monitor.setStatus(0);
                UpdateStatusDevice updateStatusDevice = new UpdateStatusDevice();
                updateStatusDevice.execute(monitor);
            }
        });

        return root;
    }

    class UpdateStatusDevice extends AsyncTask<Monitor,Void, Boolean>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);

        }

        @Override
        protected Boolean doInBackground(Monitor... monitors) {
            try
            {
                Monitor monitor = monitors[0];
                int newStatus = monitor.getStatus();

                String pagrams="?ID="+monitor.getID() + "&status=" +newStatus;
                URL url = new URL("http://192.168.1.82/agrisystem/api/MONITOR/" + pagrams);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                System.out.println("===================: " + url.toString());

                connection.setRequestMethod("PUT");
                connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                InputStreamReader isr = new InputStreamReader(connection.getInputStream(),"UTF-8");
                BufferedReader br = new BufferedReader(isr);
                StringBuilder builder = new StringBuilder();
                String line = null;
                while((line = br.readLine())!=null)
                {
                    builder.append(line);
                }
                boolean kq = builder.toString().contains("true");
                if(kq)
                {
                    System.out.println("http://===============: UPDATE STATUS THANH CONG");
                }
                else {
                    System.out.println("http://================: UPDATE STATUS Khong THANH CONG");
                }
                return true;
            }
            catch (Exception ex)
            {
                Log.e("LOI",ex.toString());
            }
            return false;

        }
    }

}
