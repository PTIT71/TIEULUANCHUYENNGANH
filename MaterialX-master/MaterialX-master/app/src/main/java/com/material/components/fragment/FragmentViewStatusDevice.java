package com.material.components.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
import android.widget.TextView;
import android.widget.Toast;

import com.material.components.R;

import  com.material.components.adapter.AdapterDetailDevice;
import  com.material.components.adapter.AdapterDetailDeviceMonitor;
import com.material.components.data.DataGenerator;
import com.material.components.fragment.FragmentViewStatusDevice;
import com.material.components.fragment.testFragment;
import com.material.components.utils.Tools;
import com.material.components.widget.SpacingItemDecoration;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;



public class FragmentViewStatusDevice extends Fragment {

    private RecyclerView recyclerView;
    private AdapterDetailDevice mAdapter;
    private RecyclerView recyclerView2;
    private AdapterDetailDeviceMonitor mAdapter2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable  ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_view_detail_device, container, false);
        initMotitor(root);
        initViewStatus(root);

        return root;
    }


    private  void  initMotitor(View  root)
    {

        //AVAILABLE DEVICE
        recyclerView2 = (RecyclerView) root.findViewById(R.id.recyclerView2);
        recyclerView2.setLayoutManager(new GridLayoutManager(root.getContext(), 2));
        recyclerView2.addItemDecoration(new SpacingItemDecoration(2, Tools.dpToPx(root.getContext(), 3), true));
        recyclerView2.setHasFixedSize(true);
        List<Integer> items = DataGenerator.getNatureImages(root.getContext());
        items.addAll(DataGenerator.getNatureImages(root.getContext()));
        //set data and list adapter
        mAdapter2 = new AdapterDetailDeviceMonitor(root.getContext(), items);
        recyclerView2.setAdapter(mAdapter2);
    }

    private void initViewStatus(View  root)
    {

        //AVAILABLE DEVICE
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(root.getContext(), 2));
        recyclerView.addItemDecoration(new SpacingItemDecoration(2, Tools.dpToPx(root.getContext(), 3), true));
        recyclerView.setHasFixedSize(true);

        //Set lại trong souxe là 3
        List<Integer> items = DataGenerator.getNatureImages(root.getContext());
        items.addAll(DataGenerator.getNatureImages(root.getContext()));

        //set data and list adapter
        mAdapter = new AdapterDetailDevice(root.getContext(), items);
        recyclerView.setAdapter(mAdapter);

        // on item list clicked
        mAdapter.setOnItemClickListener(new AdapterDetailDevice.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Integer obj, int position) {
              //  Snackbar.make(parent_view, "Item " + position + " clicked", Snackbar.LENGTH_SHORT).show();
            }
        });


    }


}
