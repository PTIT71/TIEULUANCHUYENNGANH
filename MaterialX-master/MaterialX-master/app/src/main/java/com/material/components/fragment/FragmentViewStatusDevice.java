package com.material.components.fragment;

import android.content.DialogInterface;
import android.hardware.Sensor;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.google.android.gms.maps.SupportMapFragment;
import com.material.components.R;
import com.material.components.adapter.AdapterDetailDevice;
import com.material.components.adapter.AdapterDetailDeviceMonitor;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.material.components.R;

import  com.material.components.adapter.AdapterDetailDevice;
import  com.material.components.adapter.AdapterDetailDeviceMonitor;
import com.material.components.data.DataGenerator;
import com.material.components.fragment.FragmentViewStatusDevice;
import com.material.components.fragment.testFragment;
import com.material.components.model.Device;
import com.material.components.model.Event;
import com.material.components.model.Monitor;
import com.material.components.model.SensorDevice;
import com.material.components.utils.Tools;
import com.material.components.utils.common;
import com.material.components.widget.SpacingItemDecoration;
import com.mikhaellopez.circularimageview.CircularImageView;

import org.joda.time.DateTime;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import org.joda.time.Days;


public class FragmentViewStatusDevice extends Fragment {

    private RecyclerView recyclerView;
    private AdapterDetailDevice mAdapter;
    private RecyclerView recyclerView2;
    private AdapterDetailDeviceMonitor mAdapter2;
    String DeviceID = "";
    TextView NumberOfDay, DateStart, NameDevice, SubDescription;
    View root;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable  ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root =  inflater.inflate(R.layout.fragment_view_detail_device, container, false);
        initMotitor(root);
        initViewStatus(root);
        DeviceID = getActivity().getIntent().getExtras().getString("ID_DEVICE");
        System.out.println("==============================================" + DeviceID);
        PhanChieu(root);
        MyTask myTask = new MyTask();
        Timer timer = new Timer();
        timer.schedule(myTask, 0000, 2000);



        return root;
    }
    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getDate() - date1.getDate();
        return timeUnit.convert(diffInMillies,TimeUnit.DAYS);
    }

    private void chayTask()
    {

    }

    private void  PhanChieu(final View  root)
    {
        NumberOfDay = root.findViewById(R.id.numberOfDay);
        DateStart = root.findViewById(R.id.dateStart);
        NameDevice = root.findViewById(R.id.NameDevice);
        SubDescription = root.findViewById(R.id.subDescription);
    }

    private  void  initMotitor(final View  root)
    {

        //AVAILABLE DEVICE
        recyclerView2 = (RecyclerView) root.findViewById(R.id.recyclerView2);
        recyclerView2.setLayoutManager(new GridLayoutManager(root.getContext(), 2));
        recyclerView2.addItemDecoration(new SpacingItemDecoration(2, Tools.dpToPx(root.getContext(), 3), true));
        recyclerView2.setHasFixedSize(true);
        /*
        List<Integer> items = DataGenerator.getNatureImages(root.getContext());
        items.addAll(DataGenerator.getNatureImages(root.getContext()));

        List<Monitor> lstMonitor = new ArrayList<>();

        Monitor m1 = new Monitor();
        m1.setName("Máy bơm 1");
        m1.setStatus(1);
        lstMonitor.add(m1);*/

    }

    private void initViewStatus(final View  root)
    {

        //AVAILABLE DEVICE
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(root.getContext(), 2));
        recyclerView.addItemDecoration(new SpacingItemDecoration(2, Tools.dpToPx(root.getContext(), 3), true));
        recyclerView.setHasFixedSize(true);

        //Set lại trong souxe là 3
        List<Integer> items = DataGenerator.getNatureImages(root.getContext());
        items.addAll(DataGenerator.getNatureImages(root.getContext()));


        List<SensorDevice> lstSenSor = new ArrayList<>();

        SensorDevice s = new SensorDevice();
            s.setId("13241234");
            s.setName("Nhiệt độ");
            s.setCurrentvalue("25");
            s.setMaxvalue("30.4");
            s.setType(1);
            s.setMinvalue("10.1");
            lstSenSor.add(s);

        SensorDevice s2 = new SensorDevice();
        s2.setId("13241234");
        s2.setName("Độ ẩm");
        s2.setCurrentvalue("24");
        s2.setType(2);
        s2.setMaxvalue("32.4");
        s2.setMinvalue("10.1");
        lstSenSor.add(s2);

        SensorDevice s3 = new SensorDevice();
        s3.setId("13241234");
        s3.setName("Độ ẩm đất");
        s3.setCurrentvalue("23");
        s3.setType(2);
        s3.setMaxvalue("31.4");
        s3.setMinvalue("10.1");
        lstSenSor.add(s3);



        //set data and list adapter
        mAdapter = new AdapterDetailDevice(root.getContext(), lstSenSor);
        recyclerView.setAdapter(mAdapter);

        // on item list clicked
        mAdapter.setOnItemClickListener(new AdapterDetailDevice.OnItemClickListener() {
            @Override
            public void onItemClick(View view, SensorDevice obj, int position) {
                showConfirmDialog(root);
            }
        });


    }

    private void showConfirmDialog(final View  root) {
        AlertDialog.Builder builder = new AlertDialog.Builder(root.getContext());
        builder.setTitle("Bạn chắc chắn muốn thay đổi?");
        builder.setMessage("Hoạt động này sẽ làm thay đổi những cài đặt trước đó");
        builder.setPositiveButton(R.string.AGREE, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                showDialogFullscreen(root);
            }
        });
        builder.setNegativeButton(R.string.DISAGREE, null);
        builder.show();
    }

    private void showDialogFullscreen(final View  root) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        Fragment setlectFragment = new FragmentSettingOnlySensor();
        //        // newFragment.setRequestCode(DIALOG_QUEST_CODE);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.bottom_fragment, setlectFragment).commit();

    }


    public class MyTask extends TimerTask {

        GetDevice getDevice;
        GetSensorByDevice getSensorByDevice;
        GetMonitorByDevice getMonitorByDevice;

        public  MyTask()
        {

        }
        public  MyTask(GetDevice gd)
        {
            getDevice=gd;
        }
        @Override
        public void run() {
            getDevice=new GetDevice();
            getSensorByDevice = new GetSensorByDevice();
            getMonitorByDevice = new GetMonitorByDevice();

            getDevice.execute(DeviceID);
            getSensorByDevice.execute(DeviceID);
            getMonitorByDevice.execute(DeviceID);
        }

    }
    int index = 0;

    class GetDevice extends AsyncTask<String, Integer, Device>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected void onPostExecute(Device device) {
            super.onPostExecute(device);

            NameDevice.setText(device.getName().trim());
            SubDescription.setText(device.getSubDescription().trim());
            DateStart.setText(device.getStartDate().substring(0,10));

            Date s = new Date();
            SimpleDateFormat  f = new SimpleDateFormat("yyyy-MM-dd");
            try {
                s = f.parse(device.getStartDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            DateTime dt1 = new DateTime(s);

            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(System.currentTimeMillis());
            System.out.println(formatter.format(date));


            DateTime dt2 = new DateTime(date);
            System.out.print("============HERE================ " + Days.daysBetween(dt1, dt2).getDays() + " days, ");
            //System.out.println("============================ " + getDateDiff(s,t,TimeUnit.DAYS) );

            NumberOfDay.setText(Days.daysBetween(dt1, dt2).getDays()+"");



            this.cancel(true);

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

        }

        @Override
        protected Device doInBackground(String... strings) {
            try
            {
                URL url = new URL("http://" + common.ip +"/agrisystem/api/DEVICE/?ID=" + strings[0]);
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
                String DeviceID = jsonObject.getString("ID");
                Integer DeviceStatus = jsonObject.getInt("STATUS");
                Device device = new Device();
                device.setStatus(DeviceStatus);
                device.setName(jsonObject.getString("NAME"));
                device.setStartDate(jsonObject.getString("STARTDATE"));
                device.setSubDescription(jsonObject.getString("SUBDESCRIPTION"));
                return device;
            }
            catch(Exception ex)
            {
                Log.e("Loi", ex.toString());
            }
            return null;
        }
    }

    class GetSensorByDevice extends  AsyncTask<String, Void, ArrayList<SensorDevice>>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(ArrayList<SensorDevice> sensors) {
            super.onPostExecute(sensors);

            //set data and list adapter
            mAdapter = new AdapterDetailDevice(root.getContext(), sensors);
            recyclerView.setAdapter(mAdapter);

            // on item list clicked
            mAdapter.setOnItemClickListener(new AdapterDetailDevice.OnItemClickListener() {
                @Override
                public void onItemClick(View view, SensorDevice obj, int position) {
                    showConfirmDialog(root);
                }
            });

            this.cancel(true);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected ArrayList<SensorDevice> doInBackground(String... strings) {
            ArrayList<SensorDevice> lstDV = new ArrayList<SensorDevice>();
            try
            {
                String pagram = "?IDDV=" + strings[0];
                URL url = new URL("http://"+common.ip+"/agrisystem/api/SENSOR/" +pagram);
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
                    SensorDevice dv = new SensorDevice();
                    dv.setName(jsonObject.getString("NAME"));
                    dv.setId(jsonObject.getString("ID"));
                    dv.setCurrentvalue(jsonObject.getString("NUMBER"));
                    dv.setType(1);
                    dv.setMaxvalue("30");
                    dv.setMinvalue("60");
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

    class GetMonitorByDevice extends  AsyncTask<String, Void, ArrayList<Monitor>>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(ArrayList<Monitor> monitors) {
            super.onPostExecute(monitors);

            //set data and list adapter
            mAdapter2 = new AdapterDetailDeviceMonitor(root.getContext(), monitors);
            recyclerView2.setAdapter(mAdapter2);

            mAdapter2.setOnItemClickListener(new AdapterDetailDeviceMonitor.OnItemClickListener() {
                @Override
                public void onItemClick(View view, Monitor obj, int position) {
                    Fragment setlectFragment =null;
                    setlectFragment = new FragmentControlMonitor();
                    Bundle bundle = new Bundle();
                    bundle.putString("ID", obj.getID());
                    setlectFragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.bottom_fragment, setlectFragment).commit();
                }
            });
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected ArrayList<Monitor> doInBackground(String... strings) {
            ArrayList<Monitor> lstDV = new ArrayList<Monitor>();
            try
            {
                String pagram = "?IDDV=" + strings[0];
                URL url = new URL("http://"+common.ip+"/agrisystem/api/MONITOR/" +pagram);
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
                    Monitor dv = new Monitor();
                    dv.setName(jsonObject.getString("NAME"));
                    dv.setStatus(jsonObject.getInt("STATUS"));
                    dv.setID(jsonObject.getString("ID"));
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
