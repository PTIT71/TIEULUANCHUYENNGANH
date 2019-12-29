package com.material.components.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.material.components.R;
import com.material.components.activity.list.ListMultiSelection;
import com.material.components.adapter.AdapterDetailDevice;
import com.material.components.adapter.AdapterDetailDeviceMonitor;
import com.material.components.adapter.AdapterListInbox;
import com.material.components.adapter.AdapterListMessage;
import com.material.components.adapter.AdapterListSectioned;
import com.material.components.data.DataGenerator;
import com.material.components.model.Inbox;
import com.material.components.model.People;
import com.material.components.utils.Tools;
import com.material.components.widget.LineItemDecoration;
import com.material.components.widget.SpacingItemDecoration;

import java.util.List;


public class FragmentViewNotificationDevice extends Fragment {

    private RecyclerView recyclerView;
    private AdapterListMessage mAdapter;
    View root;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable  ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root =  inflater.inflate(R.layout.fragment_view_notification_device, container, false);
        initComponent(root);
        return root;
    }


    private void initComponent(View root) {
        /*
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        recyclerView.setHasFixedSize(true);

        List<People> items = DataGenerator.getPeopleData(root.getContext());
        items.addAll(DataGenerator.getPeopleData(root.getContext()));
        items.addAll(DataGenerator.getPeopleData(root.getContext()));

        int sect_count = 0;
        int sect_idx = 0;
        List<String> months = DataGenerator.getStringsMonth(root.getContext());
        for (int i = 0; i < items.size() / 6; i++) {
            items.add(sect_count, new People(months.get(sect_idx), true));
            sect_count = sect_count + 5;
            sect_idx++;
        }

        //set data and list adapter
        mAdapter = new AdapterListMessage(root.getContext(), items);
        recyclerView.setAdapter(mAdapter);

        // on item list clicked
        mAdapter.setOnItemClickListener(new AdapterListMessage.OnItemClickListener() {
            @Override
            public void onItemClick(View view, People obj, int position) {
                //Snackbar.make(parent_view, "Item " + obj.name + " clicked", Snackbar.LENGTH_SHORT).show();
            }
        });
*/
    }



}
