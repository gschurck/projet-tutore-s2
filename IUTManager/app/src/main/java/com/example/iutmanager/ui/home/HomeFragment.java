package com.example.iutmanager.ui.home;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.iutmanager.MainActivity;
import com.example.iutmanager.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;

public class HomeFragment extends Fragment {

    FloatingActionButton plusButton;
    private HomeViewModel homeViewModel;
    private Object Context;
    static String date;
    CalendarView calendar;
    ListView listeDevoirs;
    static int dayOfMonth;
    int nbDevoirs = 0;
    static ArrayList<String> Devoirs = new ArrayList<String>(5);
    ArrayList<ArrayList<String>> devoirsDate = new ArrayList<ArrayList<String>>(31);
    ArrayList<Boolean> checkEdited = new ArrayList<Boolean>(31);
    ArrayList emptyArray;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        /*plusButton = MainActivity.getPlusButton();
        plusButton.setVisibility(View.VISIBLE);*/
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Devoirs);
        final ListView listView = (ListView) root.findViewById(R.id.listeDevoirs);
        listView.setAdapter(adapter);


        final TextView texte1 = (TextView) root.findViewById(R.id.textView3);

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
                                nbDevoirs +=1;
                                switch (nbDevoirs){
                                    case 0:
                                        texte1.setText("Vous n'avez donné aucun devoirs pour aujourd'hui");
                                        break;
                                    case 1:
                                        texte1.setText("Vous avez donné " + nbDevoirs + " devoir pour aujourd'hui");
                                        break;
                                    default:
                                        texte1.setText("Vous avez donné " + nbDevoirs + " devoirs pour aujourd'hui");
                                        break;
                                }

                                /*devoirsDate.set(dayOfMonth, Devoirs);
                                checkEdited.set(dayOfMonth, true);*/
                            }
                        })
                        .setNegativeButton("Annuler", null)
                        .create();
                dialog.show();
            }
        });

        CalendarView calendar = (CalendarView) root.findViewById(R.id.calendarView);
        /*calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                month+=1;
                TextView texte = (TextView) root.findViewById(R.id.textView5);
                texte.setText("Devoirs du " + dayOfMonth + "/0"  + month + " :");
                if (checkEdited.get(dayOfMonth) == true) {
                    Devoirs = devoirsDate.get(dayOfMonth);
                }
                else {
                    Devoirs = emptyArray;
                }
            }
        });*/

        return root;
    }


}