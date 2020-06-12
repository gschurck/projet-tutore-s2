package com.example.iutmanager.ui.notifications;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.iutmanager.R;

import java.util.Calendar;

public class NotificationsFragment extends Fragment {
    DatePickerDialog picker, picker2;
    EditText eText, eText2;
    Button btnGet;
    TextView tvw, textDeplace;
    static int day, day2, month, month2, year, year2;
    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        textDeplace = (TextView) root.findViewById(R.id.textView8);
        eText=(EditText) root.findViewById(R.id.editTextDate);
        eText.setInputType(InputType.TYPE_NULL);
        eText.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                day = cldr.get(Calendar.DAY_OF_MONTH);month = cldr.get(Calendar.MONTH);
                year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                day = dayOfMonth;
                                month = monthOfYear + 1;
                                eText.setText(day + "/" + (month) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();

            }
        });

        eText2=(EditText) root.findViewById(R.id.editTextDate2);
        eText2.setInputType(InputType.TYPE_DATETIME_VARIATION_DATE);
        eText2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                final Calendar cldr2 = Calendar.getInstance();
                day2 = cldr2.get(Calendar.DAY_OF_MONTH);
                month2 = cldr2.get(Calendar.MONTH);
                year2 = cldr2.get(Calendar.YEAR);
                // date picker dialog
                picker2 = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view2, int year2, int monthOfYear2, int dayOfMonth2) {
                                day2 = dayOfMonth2;
                                month2 = monthOfYear2+1;
                                eText2.setText(day2 + "/" + (month2) + "/" + year);
                            }
                        }, year2, month2, day2);
                picker2.show();
            }
        });

        btnGet=(Button)root.findViewById(R.id.button6);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnGet.setText("Cours déplacé");
                textDeplace.setText("Le cours du " + day + "/0" + month + "" + " est déplacé au " + day2 + "/0" + month2 );
            }
        });

        return root;
    }
}