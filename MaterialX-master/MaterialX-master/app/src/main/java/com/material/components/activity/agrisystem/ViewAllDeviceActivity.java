package com.material.components.activity.agrisystem;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
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
import com.material.components.fragment.FragmentViewAllDevice;
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
                switch (item.getItemId()) {
                    case R.id.navigation_recent:
                        mTextMessage.setText(item.getTitle());
                        return true;
                    case R.id.navigation_favorites:
                        mTextMessage.setText(item.getTitle());
                        return true;
                    case R.id.navigation_nearby:
                        mTextMessage.setText(item.getTitle());
                        return true;
                }
                Toast.makeText(ViewAllDeviceActivity.this, mTextMessage.getText(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });



    }
}
