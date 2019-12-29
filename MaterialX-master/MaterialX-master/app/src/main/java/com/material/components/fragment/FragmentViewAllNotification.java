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
import com.material.components.model.Message;
import com.material.components.model.People;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

        List<Message> lstMessage = new ArrayList<>();

        Message m1 = new Message();
        try {
            m1.setDate(new SimpleDateFormat("yyyy/MM/dd").parse("2019/10/20"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        m1.setHour("11:02 AM");
        m1.setNameDevice("Trụ xà lách");
        m1.setMessageContent("Đến ngưỡng nhiệt độ cao nhất");
        lstMessage.add(m1);

        Message m2 = new Message();


        try {
            m2.setDate(new SimpleDateFormat("yyyy/MM/dd").parse("2019/11/21"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        m2.setHour("09:02 PM");
        m2.setNameDevice("Trụ mướp");
        m2.setMessageContent("Nhiệt độ quá cao 40 độ rồi");
        lstMessage.add(m2);

        Message m3 = new Message();
        try {
            m3.setDate(new SimpleDateFormat("yyyy/MM/dd").parse("2019/12/11"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        m3.setHour("09:02 PM");
        m3.setNameDevice("Trụ dưa leo");
        m3.setMessageContent("Nhiệt độ thất quá 0 độ rồi");
        lstMessage.add(m3);

        int sect_idx = 0;
        Date dtem = null;
        try {
            dtem = new SimpleDateFormat("yyyy/MM/dd").parse("1009/12/11");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //  List<String> months = DataGenerator.getStringsMonth(root.getContext());
        /*
        for (int i = 0; i < lstMessage.size(); i++) {
            if(lstMessage.get(i).getDate() != dtem)
            {
                dtem = lstMessage.get(i).getDate();
            }
            lstMessage.add(sect_idx, new Message(lstMessage.get(sect_idx).getNameDevice(), true));
            sect_idx++;
        }
        */


        //set data and list adapter
        mAdapter = new AdapterListMessage(root.getContext(), lstMessage);
        recyclerView.setAdapter(mAdapter);

        // on item list clicked
        mAdapter.setOnItemClickListener(new AdapterListMessage.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Message obj, int position) {
                //Snackbar.make(parent_view, "Item " + obj.name + " clicked", Snackbar.LENGTH_SHORT).show();
            }
        });

    }
}
