package com.material.components.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.material.components.R;
import com.material.components.adapter.AdapterListMessage;
import com.material.components.data.DataGenerator;
import com.material.components.model.People;

import java.util.List;


public class FragmentViewAllNotification extends Fragment {


    private RecyclerView recyclerView;
    private AdapterListMessage mAdapter;
    View root;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable  ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root =  inflater.inflate(R.layout.fragment_view_all_notification,container,false);
        initComponent(root);
        return root;
    }


    private void initComponent(View root) {
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

    }
}
