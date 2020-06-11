package com.example.iutmanager.ui.dashboard;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.iutmanager.R;

import java.util.ArrayList;
import java.util.List;


public class DashboardFragment extends Fragment {

    /*
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;*/
    ListView listeEtudiants;
    //String[] etudiants;

    DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        /*ListView listView = (ListView) root.findViewById(R.id.listeEtudiants);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("test");
        /*String[] items = {"test", "oui"};
        arrayList = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<String>(getActivity( , R.layout.fragment_dashboard, arrayList);
        listView.setAdapter(adapter);*/
/*
        listeEtudiants = (listeEtudiants)root.findViewById(R.id.listeEtudiants);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Android");
        arrayList.add("yes");
        arrayList.add("no");

        ArrayAdapter adapter = new ArrayAdapter(dashboardViewModel,R.layout.fragment_dashboard),
        listeEtudiants.setAdapter(adapter);*/
        String[] etudiants = {"first", "second", "third","first", "second", "third","first", "second", "third"};
        ListView listView = (ListView) root.findViewById(R.id.listeEtudiants);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, etudiants);
        listView.setAdapter(adapter);
        return root;
    }
}