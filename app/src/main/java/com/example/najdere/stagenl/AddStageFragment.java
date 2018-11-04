package com.example.najdere.stagenl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class AddStageFragment extends Fragment implements DatePickerDialog.OnDateSetListener {

    private FloatingActionButton floatingActionButton;
    private View addlayout;
    private View greylayout;
    private ImageView imageView;
    private TextView editText;

    private Button finishbutton;

    public AddStageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_layout, container, false);



        floatingActionButton = view.findViewById(R.id.floatingActionButton);
        addlayout = view.findViewById(R.id.add_layout);
        greylayout = view.findViewById(R.id.grey_layout);
        finishbutton = view.findViewById(R.id.button);
        imageView = view.findViewById(R.id.imageView2);
        editText = view.findViewById(R.id.editTextDate);
        final Animation slideUp = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up);
        final Animation slideDown = AnimationUtils.loadAnimation(getContext(), R.anim.slide_down);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {
                floatingActionButton.setVisibility(View.GONE);
                addlayout.setVisibility(View.VISIBLE);
                greylayout.setVisibility(View.VISIBLE);
                addlayout.startAnimation(slideUp);

            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        AddStageFragment.this::onDateSet
                        ,
                        now.get(Calendar.YEAR), // Initial year selection
                        now.get(Calendar.MONTH), // Initial month selection
                        now.get(Calendar.DAY_OF_MONTH) // Inital day selection
                );
// If you're calling this from a support Fragment
                dpd.show(getFragmentManager(), "Datepickerdialog");
// If you're calling this from an AppCompatActivity
// dpd.show(getSupportFragmentManager(), "Datepickerdialog");






            }
        });

        finishbutton = view.findViewById(R.id.button);

        finishbutton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {
                addlayout.startAnimation(slideDown);

                floatingActionButton.setVisibility(View.VISIBLE);
                addlayout.setVisibility(View.GONE);
                greylayout.setVisibility(View.GONE);



            }
        });




        return view;

    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

        String date = "First Contact: "+dayOfMonth+"/"+(monthOfYear+1)+"/"+year;
        editText.setText(date);
    }
}