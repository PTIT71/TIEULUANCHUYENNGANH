package com.material.components.activity.agrisystem;

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
import android.widget.TextView;
import android.widget.Toast;

import com.material.components.R;

import  com.material.components.adapter.AdapterDetailDevice;
import  com.material.components.adapter.AdapterDetailDeviceMonitor;
import com.material.components.data.DataGenerator;
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

        initToolbar();
        initViewStatus();
        initNavigationMenu();
        initMotitor();
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
        Tools.setSystemBarLight(this);*/
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.transparent));
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setTitle("Drawer News");
        Tools.setSystemBarColor(this);
    }

    private  void  initMotitor()
    {
        //AVAILABLE DEVICE
        recyclerView2 = (RecyclerView) findViewById(R.id.recyclerView2);
        recyclerView2.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView2.addItemDecoration(new SpacingItemDecoration(2, Tools.dpToPx(this, 3), true));
        recyclerView2.setHasFixedSize(true);
        List<Integer> items = DataGenerator.getNatureImages(this);
        items.addAll(DataGenerator.getNatureImages(this));
        //set data and list adapter
        mAdapter2 = new AdapterDetailDeviceMonitor(this, items);
        recyclerView2.setAdapter(mAdapter2);
    }

    private void initViewStatus()
    {
        //AVAILABLE DEVICE
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.addItemDecoration(new SpacingItemDecoration(2, Tools.dpToPx(this, 3), true));
        recyclerView.setHasFixedSize(true);

        //Set lại trong souxe là 3
        List<Integer> items = DataGenerator.getNatureImages(this);
        items.addAll(DataGenerator.getNatureImages(this));

        //set data and list adapter
        mAdapter = new AdapterDetailDevice(this, items);
        recyclerView.setAdapter(mAdapter);

        // on item list clicked
        mAdapter.setOnItemClickListener(new AdapterDetailDevice.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Integer obj, int position) {
                Snackbar.make(parent_view, "Item " + position + " clicked", Snackbar.LENGTH_SHORT).show();
            }
        });
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
        drawer.openDrawer(GravityCompat.START);
        updateCounter(nav_view);
        menu_navigation = nav_view.getMenu();


    }

    private void onItemNavigationClicked(MenuItem item) {

        if (!is_account_mode) {
            Toast.makeText(getApplicationContext(), item.getTitle() + " Selected", Toast.LENGTH_SHORT).show();
            actionBar.setTitle(item.getTitle());
            drawer.closeDrawers();
        } else {
            TextView name = (TextView) navigation_header.findViewById(R.id.name);
            TextView email = (TextView) navigation_header.findViewById(R.id.email);
            CircularImageView avatar = (CircularImageView) navigation_header.findViewById(R.id.avatar);
            switch (item.getItemId()) {
                case 1000:
                    name.setText("Evans Collins");
                    email.setText(item.getTitle().toString());
                    avatar.setImageResource(R.drawable.photo_male_5);
                    break;
                case 2000:
                    name.setText("Adams Green");
                    email.setText(item.getTitle().toString());
                    avatar.setImageResource(R.drawable.photo_male_2);
                    break;
                default:
                    Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
                    break;
            }
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

    }

    private void updateCounter(NavigationView nav) {
        if (is_account_mode) return;
        Menu m = nav.getMenu();
        ((TextView) m.findItem(R.id.nav_all_inbox).getActionView().findViewById(R.id.text)).setText("75");
        ((TextView) m.findItem(R.id.nav_notification).getActionView().findViewById(R.id.text)).setText("68");

        TextView badgePrioInbx = (TextView) m.findItem(R.id.nav_priority_inbox).getActionView().findViewById(R.id.text);
        badgePrioInbx.setText("3 new");
        badgePrioInbx.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));

        TextView badgeSocial = (TextView) m.findItem(R.id.nav_social).getActionView().findViewById(R.id.text);
        badgeSocial.setText("51 new");
        badgeSocial.setBackgroundColor(getResources().getColor(R.color.green_500));


    }
}
