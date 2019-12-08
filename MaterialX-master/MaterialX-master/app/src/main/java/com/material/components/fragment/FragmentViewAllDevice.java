package com.material.components.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.material.components.R;
import com.material.components.activity.agrisystem.DetailDeviceActivity;
import com.material.components.adapter.AdapterDetailDevice;
import com.material.components.adapter.AdapterDetailDeviceMonitor;
import com.material.components.adapter.AdapterViewAllDevice;
import com.material.components.data.DataGenerator;
import com.material.components.utils.Tools;
import com.material.components.widget.SpacingItemDecoration;

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
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable  ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_view_all_device, container, false);
        intReadyDevice(root);

        return root;
    }


    private void intReadyDevice(final View root) {
        //Set lại trong souxe là 3
        List<Integer> items = DataGenerator.getNatureImages(root.getContext());
        items.addAll(DataGenerator.getNatureImages(root.getContext()));

        //AVAILABLE DEVICE
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(root.getContext(), 2));
        recyclerView.addItemDecoration(new SpacingItemDecoration(2, Tools.dpToPx(root.getContext(), 3), true));
        recyclerView.setHasFixedSize(true);


        //set data and list adapter
        mAdapter = new AdapterViewAllDevice(root.getContext(), items);
        recyclerView.setAdapter(mAdapter);

        // on item list clicked
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, Integer obj, int position) {
               // Snackbar.make(parent_view, "Item " + position + " clicked", Snackbar.LENGTH_SHORT).show();
                startActivity(new Intent(root.getContext(), DetailDeviceActivity.class));
            }
        });

        //READY AVAILBLE
/*
        recyclerViewReady = (RecyclerView) findViewById(R.id.recyclerViewReady);
        recyclerViewReady.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerViewReady.addItemDecoration(new SpacingItemDecoration(2, Tools.dpToPx(this, 3), true));
        recyclerViewReady.setHasFixedSize(true);

        //set data and list adapter
        mAdapterReady = new AdapterViewAllDevice(this, items);
        recyclerViewReady.setAdapter(mAdapterReady);

        // on item list clicked
        mAdapterReady.setOnItemClickListener(new AdapterViewAllDevice.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Integer obj, int position) {
                Snackbar.make(parent_view, "Item " + position + " clicked", Snackbar.LENGTH_SHORT).show();
            }
        });
*/
    }


}
