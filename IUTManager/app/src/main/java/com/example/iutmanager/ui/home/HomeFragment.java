package com.example.iutmanager.ui.home;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.iutmanager.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private Object Context;

    ListView listeDevoirs;
    static ArrayList<String> Devoirs = new ArrayList<String>();

    private void updateList() {

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Devoirs);
        final ListView listView = (ListView) root.findViewById(R.id.listeDevoirs);
        listView.setAdapter(adapter);
        adapter.add("test");
        FloatingActionButton fab = (FloatingActionButton) root.findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText taskEditText = new EditText(getActivity());
                AlertDialog dialog = new AlertDialog.Builder(getActivity())
                        .setTitle("Ajouter un devoir")
                        .setMessage("Que voulez-vous ajouter ?")
                        .setView(taskEditText)
                        .setPositiveButton("Ajouter", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String task = String.valueOf(taskEditText.getText());
                                adapter.add(task);
                            }
                        })
                        .setNegativeButton("Annuler", null)
                        .create();
                dialog.show();
            }
        });

        return root;
    }


}