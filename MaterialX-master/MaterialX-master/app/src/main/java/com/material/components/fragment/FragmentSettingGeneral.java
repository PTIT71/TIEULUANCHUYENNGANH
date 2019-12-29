package com.material.components.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.material.components.R;
import com.material.components.helper.SessionManager;


public class FragmentSettingGeneral extends Fragment {
    View root;
    SessionManager sessionManager;
    Button btnLogout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable  ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root =  inflater.inflate(R.layout.fragment_setting_general,container,false);
        sessionManager = new SessionManager(getContext());
        TextView txtTest = root.findViewById(R.id.name);

        btnLogout = root.findViewById(R.id.logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    sessionManager.setIDLogin("");
                    sessionManager.SetLogin(false);
            }
        });
        txtTest.setText(sessionManager.getIDLogin());


        return root;
    }
}
