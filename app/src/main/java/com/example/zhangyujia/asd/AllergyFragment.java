package com.example.zhangyujia.asd;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AllergyFragment extends Fragment {
    private View v;

    DatabaseReference databaseAllergy;


    public AllergyFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_allergysetting, container, false);
        configureImageButton();
        return v;
    }

    private void configureImageButton() {
        // TODO Auto-generated method stub
        Button setAllergy = (Button) v.findViewById(R.id.setAllergy);

        Allergy allergy;
        int allergySetting = 0;

        ImageButton btn_allergy1 = (ImageButton) v.findViewById(R.id.allergy1);
        ImageButton btn_allergy2 = (ImageButton) v.findViewById(R.id.allergy2);


        btn_allergy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value1 = 1;
                Toast.makeText(getActivity(), "You Clicked the allergy 1!", Toast.LENGTH_LONG).show();
            }
        });

        btn_allergy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value2 = 2;
                Toast.makeText(getActivity(), "You Clicked the allergy 2!", Toast.LENGTH_LONG).show();
            }
        });

        setAllergy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }
}
