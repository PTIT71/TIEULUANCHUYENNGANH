package com.material.components.activity.agrisystem;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.material.components.R;

import  com.material.components.adapter.AdapterDetailDevice;
import  com.material.components.adapter.AdapterDetailDeviceMonitor;
import com.material.components.data.DataGenerator;
import com.material.components.fragment.FragmentControlMonitor;
import com.material.components.fragment.FragmentFeedback;
import com.material.components.fragment.FragmentSettingDevice;
import com.material.components.fragment.FragmentStatistical;
import com.material.components.fragment.FragmentViewNotificationDevice;
import com.material.components.fragment.FragmentViewStatusDevice;
import com.material.components.fragment.testFragment;
import com.material.components.utils.Tools;
import com.material.components.widget.SpacingItemDecoration;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;

public class DetailDeviceActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private  AdapterDetailDevice mAdapter;
    private View parent_view;

    private RecyclerView recyclerView2;
    private  AdapterDetailDeviceMonitor mAdapter2;

    private ActionBar actionBar;
    private Toolbar toolbar;
    private Menu menu_navigation;
    private DrawerLayout drawer;
    private View navigation_header;
    private boolean is_account_mode = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_device);
        parent_view = findViewById(android.R.id.content);
        getSupportFragmentManager().beginTransaction().replace(R.id.bottom_fragment, new FragmentViewStatusDevice()).commit();

        initToolbar();
       // initViewStatus();
        initNavigationMenu();
       // initMotitor();
    }


    private void initToolbar() {

        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.light_blue_500), PorterDuff.Mode.SRC_ATOP);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setTitle("Device");
        Tools.setSystemBarColor(this, R.color.grey_5);
        Tools.setSystemBarLight(this);
         */
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.transparent));
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setTitle("Status Device");
        Tools.setSystemBarColor(this);
    }

    private void initNavigationMenu() {
        final NavigationView nav_view = (NavigationView) findViewById(R.id.nav_view);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            public void onDrawerOpened(View drawerView) {
                updateCounter(nav_view);
                super.onDrawerOpened(drawerView);
            }
        };
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(final MenuItem item) {
                onItemNavigationClicked(item);
                return true;
            }
        });

        // open drawer at start
      //  drawer.openDrawer(GravityCompat.START);
        updateCounter(nav_view);
        menu_navigation = nav_view.getMenu();


    }



    private void onItemNavigationClicked(MenuItem item) {
            Fragment setlectFragment =null;
            switch (item.getItemId()) {
                case R.id.nav_status:
                    setlectFragment = new FragmentViewStatusDevice();
                    getSupportFragmentManager().beginTransaction().replace(R.id.bottom_fragment, setlectFragment).commit();
                    break;
                case R.id.nav_notification:
                    setlectFragment = new FragmentViewNotificationDevice();
                    getSupportFragmentManager().beginTransaction().replace(R.id.bottom_fragment, setlectFragment).commit();
                    break;
                case R.id.nav_control:
                    setlectFragment = new FragmentControlMonitor();
                    getSupportFragmentManager().beginTransaction().replace(R.id.bottom_fragment, setlectFragment).commit();
                    break;
                case R.id.nav_statistical:
                    setlectFragment = new FragmentStatistical();
                    getSupportFragmentManager().beginTransaction().replace(R.id.bottom_fragment, setlectFragment).commit();
                    break;
                case R.id.nav_settings:
                    setlectFragment = new FragmentSettingDevice();
                    getSupportFragmentManager().beginTransaction().replace(R.id.bottom_fragment, setlectFragment).commit();
                    break;
                case R.id.nav_help:
                    setlectFragment = new FragmentFeedback();
                    getSupportFragmentManager().beginTransaction().replace(R.id.bottom_fragment, setlectFragment).commit();
                    break;
                default:
                    Toast.makeText(getApplicationContext(), item.getTitle() + " Selected", Toast.LENGTH_SHORT).show();
                    break;
            }
            actionBar.setTitle(item.getTitle());
            drawer.closeDrawers();
    }

        /*
        Fragment setlectFragment =null;
        switch (item.getItemId()) {
            case R.id.nav_notification:
               setlectFragment = new testFragment();
               getSupportFragmentManager().beginTransaction().replace(R.id.bottom_fragment, setlectFragment);
                break;
            default:
                Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
        }*/
        /*
        */



    private void updateCounter(NavigationView nav) {
        if (is_account_mode) return;
        Menu m = nav.getMenu();
        //((TextView) m.findItem(R.id.nav_all_inbox).getActionView().findViewById(R.id.text)).setText("75");
        //((TextView) m.findItem(R.id.nav_notification).getActionView().findViewById(R.id.text)).setText("68");

       // TextView badgePrioInbx = (TextView) m.findItem(R.id.nav_priority_inbox).getActionView().findViewById(R.id.text);
       //// badgePrioInbx.setText("3 new");
       // badgePrioInbx.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));

       // TextView badgeSocial = (TextView) m.findItem(R.id.nav_social).getActionView().findViewById(R.id.text);
       // badgeSocial.setText("51 new");
       /// badgeSocial.setBackgroundColor(getResources().getColor(R.color.green_500));


    }
}
