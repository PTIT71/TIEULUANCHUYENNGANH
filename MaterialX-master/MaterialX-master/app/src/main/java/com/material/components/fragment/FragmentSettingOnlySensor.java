package com.material.components.fragment;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.material.components.R;
import com.material.components.adapter.AdapterSettingOnlySensor;
import com.material.components.data.DataGenerator;
import com.material.components.model.Event;
import com.material.components.utils.Tools;
import com.material.components.widget.SpacingItemDecoration;

import java.util.List;


public class FragmentSettingOnlySensor extends Fragment {

    View root;
    private RecyclerView recyclerView;
    private AdapterSettingOnlySensor mAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable  ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root =  inflater.inflate(R.layout.fragment_setting_only_sensor,container,false);
        initViewStatus(root);
        return root;
    }

    private void initViewStatus(final View  root)
    {

        //AVAILABLE DEVICE
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(root.getContext(), 1));
        recyclerView.addItemDecoration(new SpacingItemDecoration(2, Tools.dpToPx(root.getContext(), 3), true));
        recyclerView.setHasFixedSize(true);

        //Set lại trong souxe là 3
        List<Integer> items = DataGenerator.getNatureImages(root.getContext());
        items.addAll(DataGenerator.getNatureImages(root.getContext()));

        //set data and list adapter
        mAdapter = new AdapterSettingOnlySensor(root.getContext(), items);
        recyclerView.setAdapter(mAdapter);

        // on item list clicked
        mAdapter.setOnItemClickListener(new AdapterSettingOnlySensor.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Integer obj, int position) {
                showCustomDialog(root);
            }
        });


    }

    private void showCustomDialog(View  root) {
        final Dialog dialog = new Dialog(root.getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.dialog_event);
        dialog.setCancelable(true);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        final Button spn_from_date = (Button) dialog.findViewById(R.id.spn_from_date);
        final Button spn_from_time = (Button) dialog.findViewById(R.id.spn_from_time);
        final Button spn_to_date = (Button) dialog.findViewById(R.id.spn_to_date);
        final Button spn_to_time = (Button) dialog.findViewById(R.id.spn_to_time);
        final TextView tv_email = (TextView) dialog.findViewById(R.id.tv_email);
        final EditText et_name = (EditText) dialog.findViewById(R.id.et_name);
        final EditText et_location = (EditText) dialog.findViewById(R.id.et_location);
        final AppCompatCheckBox cb_allday = (AppCompatCheckBox) dialog.findViewById(R.id.cb_allday);
        final AppCompatSpinner spn_timezone = (AppCompatSpinner) dialog.findViewById(R.id.spn_timezone);

        String[] timezones = getResources().getStringArray(R.array.timezone);
       // ArrayAdapter<String> array = new ArrayAdapter<>(this, R.layout.simple_spinner_item, timezones);
       // array.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
       // spn_timezone.setAdapter(array);
        spn_timezone.setSelection(0);

        ((ImageButton) dialog.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        ((Button) dialog.findViewById(R.id.bt_save)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Event event = new Event();
                event.email = tv_email.getText().toString();
                event.name = et_name.getText().toString();
                event.location = et_location.getText().toString();
                event.from = spn_from_date.getText().toString() + " (" + spn_from_time.getText().toString() + ")";
                event.to = spn_to_date.getText().toString() + " (" + spn_to_time.getText().toString() + ")";
                event.is_allday = cb_allday.isChecked();
                event.timezone = spn_timezone.getSelectedItem().toString();
               // displayDataResult(event);

                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setAttributes(lp);
    }


}
