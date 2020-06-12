package com.example.iutmanager.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.iutmanager.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DashboardFragment extends Fragment {


    ListView listeEtudiants;
    static ArrayList<String> etudiants = new ArrayList<String>();
    DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final ListView listView = (ListView) root.findViewById(R.id.listeEtudiants);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, etudiants);
        listView.setAdapter(adapter);

        Button btnAjouter = (Button) root.findViewById(R.id.button);
        final EditText textName = (EditText) root.findViewById(R.id.editTextPersonName);
        final TextView tv = (TextView) root.findViewById(R.id.textView4);
        btnAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addedName = textName.getText().toString();
                adapter.add(addedName);
            }
        });
        return root;
    }
}