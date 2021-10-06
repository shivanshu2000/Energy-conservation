package com.example.energyconservation;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;



public class OverviewFragment extends Fragment {

    private TextView tvOverview,toDetailsFragment;
    private FrameLayout frameLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

       View view=inflater.inflate(R.layout.fragment_overview, container, false);

        tvOverview=view.findViewById(R.id.tv_overview);
        toDetailsFragment=view.findViewById(R.id.to_details_fragment);
        frameLayout=view.findViewById(R.id.fragment_container);

        return view;
    }
}