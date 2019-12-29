package com.material.components.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.material.components.R;
import com.material.components.activity.agrisystem.DetailDeviceActivity;
import com.material.components.activity.agrisystem.LoginActivity;
import com.material.components.adapter.AdapterDetailDevice;
import com.material.components.adapter.AdapterDetailDeviceMonitor;
import com.material.components.adapter.AdapterViewAllDevice;
import com.material.components.data.DataGenerator;
import com.material.components.helper.SessionManager;
import com.material.components.model.Device;
import com.material.components.model.DeviceUser;
import com.material.components.utils.Tools;
import com.material.components.widget.SpacingItemDecoration;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.material.components.adapter.AdapterViewAllDevice.*;


public class FragmentViewAllDevice extends Fragment {

    private TextView mTextMessage;
    private BottomNavigationView navigation;
    private View parent_view;

    private RecyclerView recyclerView;
    private RecyclerView recyclerViewReady;

    private AdapterViewAllDevice mAdapter;
    private AdapterViewAllDevice mAdapterReady;
    SessionManager sessionManager;
    View root = null;
    Button btnAdd;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable  ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root =  inflater.inflate(R.layout.fragment_view_all_device, container, false);
        sessionManager = new SessionManager(getContext());
        intReadyDevice(root);
        btnAdd = root.findViewById(R.id.btnAdd);

        String IDUser = sessionManager.getIDLogin();
        System.out.println("==================================== IDUSE: "+ IDUser);
        GetDeviceByUser getDeviceByUser = new GetDeviceByUser();
        getDeviceByUser.execute(IDUser);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogAddDevice(root);
            }
        });

        return root;
    }


    private void intReadyDevice(final View root) {
        //Set lại trong souxe là 3
        List<Integer> items = DataGenerator.getNatureImages(root.getContext());
        items.addAll(DataGenerator.getNatureImages(root.getContext()));
        //
        List<Device> lstDevice = new ArrayList<Device>();
        Device d1 = new Device();
        d1.setName("Trụ xà lách");
        d1.setStartDate("2019/01/12");
        Device d2 = new Device();
        d2.setName("Trụ Dưa Leo");
        d2.setStartDate("2019/01/18");
        Device d3 = new Device();
        d3.setName("Trụ mướp");
        d3.setStartDate("2019/03/16");
        lstDevice.add(d1);
        lstDevice.add(d2);
        lstDevice.add(d3);

        //AVAILABLE DEVICE
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(root.getContext(), 2));
        recyclerView.addItemDecoration(new SpacingItemDecoration(2, Tools.dpToPx(root.getContext(), 3), true));
        recyclerView.setHasFixedSize(true);



        //set data and list adapter




    }

    public void DialogAddDevice(final View root)
    {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(root.getContext());
        alertDialog.setTitle("ID DEVICE");
        final EditText input = new EditText(root.getContext());
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.MarginLayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        alertDialog.setView(input);

        alertDialog.setPositiveButton("Conntect",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String idDevice = input.getText().toString();
                        DeviceTask deviceTask = new DeviceTask();

                        String dataGet = "?PARTCODE=" + idDevice;
                        deviceTask.execute(dataGet);
                    }
                });

        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        alertDialog.show();
    }

    private void showConfirmDialog(String title, String message) {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(root.getContext());
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setNegativeButton(R.string.CLOSE, null);
        builder.show();
    }

    public  class DeviceTask extends AsyncTask<String, Void, Device>
    {
        @Override
        protected Device doInBackground(String... strings) {
            try
            {
                URL url = new URL("http://192.168.1.82/agrisystem/api/DEVICE/" + strings[0]);
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
                device.setID(DeviceID);
                device.setStatus(DeviceStatus);
                return device;
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
        protected void onPostExecute(Device device) {
            super.onPostExecute(device);
            if(device != null)
            {
                    if(device.getStatus() ==1)
                    {
                        showConfirmDialog("Đăng nhập không thành công!!","Thiết bị được đăng nhâp bởi người dùng khác\nVui lòng kiểm tra lại");
                    }
                    else
                    {
                        showConfirmDialog("Đăng nhập thành công!!","chúc mừng");
                        DeviceUser UD = new DeviceUser();
                        UD.setIDDevice(device.getID());
                        UD.setIDUser(sessionManager.getIDLogin());
                        LuuDeviceTheoUser luuDeviceTheoUser = new LuuDeviceTheoUser();
                        luuDeviceTheoUser.execute(UD);

                        UpdateStatusDevice updateStatusDevice = new UpdateStatusDevice();
                        updateStatusDevice.execute(device);


                    }
            }
            else
            {
                showConfirmDialog("Không tim thấy ID thiết bị","Vui lòng kiểm tra lại");
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }


        }

    class LuuDeviceTheoUser extends AsyncTask<DeviceUser,Void, Boolean>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {

            super.onPostExecute(aBoolean);
            GetDeviceByUser getDeviceByUser = new GetDeviceByUser();
            getDeviceByUser.execute("9467846098");
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Boolean doInBackground(DeviceUser... deviceUsers) {
            try
            {
                DeviceUser deviceUser = deviceUsers[0];
                String pagrams="?ID_User="+ deviceUser.getIDUser()+ "&ID_Device=" + deviceUser.getIDDevice();
                URL url = new URL("http://192.168.1.82/agrisystem/api/USER_DEVICE/" + pagrams);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                System.out.println("===================: " + url.toString());

                connection.setRequestMethod("POST");
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
                    System.out.println("http://===============: LUU USER DEVICE THANH CONG");

                }
                else {
                    System.out.println("http://================: LUU USER DEVICE Khong THANH CONG");
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

    class UpdateStatusDevice extends AsyncTask<Device,Void, Boolean>
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
        protected Boolean doInBackground(Device... devices) {
            try
            {
                Device device = devices[0];
                int newStatus = 0;
                if(device.getStatus() == 0) {
                    newStatus =1;
                }
                String pagrams="?ID="+device.getID() + "&status=" +newStatus;
                URL url = new URL("http://192.168.1.82/agrisystem/api/DEVICE/" + pagrams);
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

    class GetDeviceByUser extends  AsyncTask<String, Void, ArrayList<Device>>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(ArrayList<Device> devices) {
            super.onPostExecute(devices);
            mAdapter = new AdapterViewAllDevice(root.getContext(), devices);

            recyclerView.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();
            // on item list clicked
            mAdapter.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(View view, Device obj, int position) {
                    Intent intent = new Intent(root.getContext(), DetailDeviceActivity.class);
                    intent.putExtra("ID_DEVICE", obj.getID());
                    startActivity(intent);
                }
            });

        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected ArrayList<Device> doInBackground(String... strings) {
            ArrayList<Device> lstDV = new ArrayList<Device>();
            try
            {
                String pagram = "?IDUser=" + strings[0];
                URL url = new URL("http://192.168.1.82/agrisystem/api/USER_DEVICE/"+pagram);
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
                    Device dv = new Device();
                    dv.setName(jsonObject.getString("NAME"));
                    String d = jsonObject.getString("STARTDATE");

                    Date dateStart=new SimpleDateFormat("yyyy-MM-dd").parse(d);
                    dv.setStartDate(dateStart.toString());
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
