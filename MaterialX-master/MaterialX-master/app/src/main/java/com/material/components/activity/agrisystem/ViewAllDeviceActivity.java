package com.material.components.activity.agrisystem;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.material.components.R;
import com.material.components.adapter.AdapterViewAllDevice;
import com.material.components.data.DataGenerator;
import com.material.components.fragment.FragmentSettingGeneral;
import com.material.components.fragment.FragmentViewAllDevice;
import com.material.components.fragment.FragmentViewAllNotification;
import com.material.components.utils.Tools;
import com.material.components.widget.SpacingItemDecoration;

import java.util.List;

public class ViewAllDeviceActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private BottomNavigationView navigation;
    private View parent_view;

    private RecyclerView recyclerView;
    private RecyclerView recyclerViewReady;

    private AdapterViewAllDevice mAdapter;
    private AdapterViewAllDevice mAdapterReady;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_device);
        parent_view = findViewById(android.R.id.content);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, new FragmentViewAllDevice()).commit();

        initComponent();

        Intent serviceIntent = new Intent(this, NotificationService.class);


        ContextCompat.startForegroundService(this, serviceIntent);




    }



    private void initComponent() {
        //init app bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.transparent));
        toolbar.setNavigationIcon(R.drawable.ic_indruino_white);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Agribot System");
        Tools.setSystemBarColor(this);

        //init BottomNavigation
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment setlectFragment =null;
                switch (item.getItemId()) {
                    case R.id.navigation_device:
                        setlectFragment = new FragmentViewAllDevice();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, setlectFragment).commit();
                        return true;
                    case R.id.navigation_notification:
                        setlectFragment = new FragmentViewAllNotification();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, setlectFragment).commit();
                        return true;
                    case R.id.navigation_setting:
                        setlectFragment = new FragmentSettingGeneral();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, setlectFragment).commit();
                        return true;
                }
                Toast.makeText(ViewAllDeviceActivity.this, mTextMessage.getText(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });


    }
}
