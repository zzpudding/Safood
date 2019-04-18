package com.example.zhangyujia.asd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;
import org.litepal.LitePal;

import java.util.List;

public class InitialSettingActivity extends Activity {

    private static final String TAG="InitialActivity";

    public Allergy milk;
    public Allergy egg;
    public Allergy peanuts;
    public Allergy shellfish;
    public Allergy soybean;
    public Allergy wheat;
    public Allergy fish;
    public Allergy treenuts;

    ImageButton milk_btn;
    ImageButton eggs_btn;
    ImageButton fish_btn;
    ImageButton shell_btn;
    ImageButton wheat_btn;
    ImageButton soya_btn;
    ImageButton treenuts_btn;
    ImageButton peanuts_btn;

    int milk_isPressed=0;
    int eggs_isPressed=0;
    int fish_isPressed=0;
    int shell_isPressed=0;
    int wheat_isPressed=0;
    int soya_isPressed=0;
    int treenuts_isPressed=0;
    int peanuts_isPressed=0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initialsetting);
        milk_btn =  findViewById(R.id.allergy1);
        eggs_btn =  findViewById(R.id.allergy2);
        fish_btn =  findViewById(R.id.allergy3);
        shell_btn = findViewById(R.id.allergy4);
        treenuts_btn = findViewById(R.id.allergy5);
        peanuts_btn =  findViewById(R.id.allergy6);
        wheat_btn = findViewById(R.id.allergy7);
        soya_btn =  findViewById(R.id.allergy8);

        List<Allergy> allergies =LitePal.findAll(Allergy.class);
        if( allergies.size()==0){

            Log.d(TAG,"Initial database");
            milk=new Allergy();
            milk.setChecked(0);
            milk.setAllergyTypeName("Milk");
            milk.setAllergy_1("Milk");
            milk.setAllergy_2("Yogurt");
            milk.save();


            egg=new Allergy();
            egg.setChecked(0);
            egg.setAllergyTypeName("Egg");
            egg.setAllergy_1("Egg");
            egg.setAllergy_2("Mayonnaise");
            egg.save();

            peanuts=new Allergy();
            peanuts=new Allergy();
            peanuts.setChecked(0);
            peanuts.setAllergyTypeName("Peanuts");
            peanuts.setAllergy_1("Peanuts");
            peanuts.setAllergy_2("Chocolate");
            peanuts.save();

            shellfish=new Allergy();
            shellfish.setChecked(0);
            shellfish.setAllergyTypeName("Shellfish");
            shellfish.setAllergy_1("Shellfish");
            shellfish.setAllergy_2("Lobster");
            shellfish.save();

            soybean=new Allergy();
            soybean.setChecked(0);
            soybean.setAllergyTypeName("soybean");
            soybean.setAllergy_1("soybean");
            soybean.setAllergy_2("Tofu");
            soybean.save();

            wheat=new Allergy();
            wheat.setChecked(0);
            wheat.setAllergyTypeName("Wheat");
            wheat.setAllergy_1("Barley");
            wheat.setAllergy_2("Rice");
            wheat.save();

            fish=new Allergy();
            fish.setChecked(0);
            fish.setAllergyTypeName("Fish");
            fish.setAllergy_1("Cod");
            fish.setAllergy_2("Salmon");
            fish.save();

            treenuts=new Allergy();
            treenuts.setChecked(0);
            treenuts.setAllergyTypeName("Treenuts");
            treenuts.setAllergy_1("Almond");
            treenuts.setAllergy_2("Brazil Nut");
            treenuts.save();

        }
        else {
            Log.d(TAG,"No Initial");

            Allergy milk = LitePal.find(Allergy.class, 1);
            Allergy eggs = LitePal.find(Allergy.class, 2);
            Allergy peanuts = LitePal.find(Allergy.class, 3);
            Allergy shellfish = LitePal.find(Allergy.class, 4);
            Allergy soybean = LitePal.find(Allergy.class, 5);
            Allergy wheat = LitePal.find(Allergy.class, 6);
            Allergy fish = LitePal.find(Allergy.class, 7);
            Allergy treanuts = LitePal.find(Allergy.class, 8);

            milk_isPressed=milk.isChecked();
            eggs_isPressed=eggs.isChecked();
            peanuts_isPressed=peanuts.isChecked();
            shell_isPressed=shellfish.isChecked();
            wheat_isPressed=wheat.isChecked();
            fish_isPressed=fish.isChecked();
            treenuts_isPressed=treanuts.isChecked();
            soya_isPressed=soybean.isChecked();

            if(milk_isPressed==1)  milk_btn.setBackgroundResource(R.drawable.nomilk);

            if(eggs_isPressed==1)  eggs_btn.setBackgroundResource(R.drawable.noeggs);

            if(fish_isPressed==1)  fish_btn.setBackgroundResource(R.drawable.nofish);

            if(shell_isPressed==1)  shell_btn.setBackgroundResource(R.drawable.noshell);
            if(treenuts_isPressed==1)  treenuts_btn.setBackgroundResource(R.drawable.notreenuts);
            if(peanuts_isPressed==1)  peanuts_btn.setBackgroundResource(R.drawable.nopeanuts);
            if(wheat_isPressed==1)  wheat_btn.setBackgroundResource(R.drawable.nowheat);
            if(soya_isPressed==1)  soya_btn.setBackgroundResource(R.drawable.nosoya);
        }

        addListenerOnButton();
    }

    public void finishIniActivity(View view){
        Intent intent = new Intent(this, TagActivity.class);
        startActivity(intent);
        Toast.makeText(InitialSettingActivity.this,
                "Allergy setting is saved!", Toast.LENGTH_SHORT).show();
        //to write: save allergy data to firebase
    }

    public void addListenerOnButton() {




        milk_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(milk_isPressed==0){
                    milk_btn.setBackgroundResource(R.drawable.nomilk);
//                    Allergy milk= new Allergy();
                    Allergy allergy = LitePal.find(Allergy.class, 1);
                    allergy.setChecked(1); // raise the price
                    allergy.save();
                    milk_isPressed=1;

                    Toast.makeText(InitialSettingActivity.this,
                            "Milk is banned!", Toast.LENGTH_SHORT).show();

                }else{
                    milk_btn.setBackgroundResource(R.drawable.milk);
                    Allergy allergy = LitePal.find(Allergy.class, 1);
                    allergy.setChecked(0); // raise the price
                    allergy.save();
                    milk_isPressed=0;
                }
            }
        });



        eggs_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eggs_isPressed==0){
                    eggs_btn.setBackgroundResource(R.drawable.noeggs);
                    Allergy allergy = LitePal.find(Allergy.class, 2);
                    allergy.setChecked(1); // raise the price
                    allergy.save();
                    eggs_isPressed=1;
                    Toast.makeText(InitialSettingActivity.this,
                            "Eggs are banned!", Toast.LENGTH_SHORT).show();
                }else{
                    eggs_btn.setBackgroundResource(R.drawable.eggs);
                    Allergy allergy = LitePal.find(Allergy.class, 2);
                    allergy.setChecked(0); // raise the price
                    allergy.save();
                    eggs_isPressed=0;
                }
            }
        });
//
        peanuts_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(peanuts_isPressed==0){
                    peanuts_btn.setBackgroundResource(R.drawable.nopeanuts);
                    Toast.makeText(InitialSettingActivity.this,
                            "Peanuts are banned!", Toast.LENGTH_SHORT).show();
                    Allergy allergy = LitePal.find(Allergy.class, 3);
                    allergy.setChecked(1); // raise the price
                    allergy.save();
                    peanuts_isPressed=1;
                }else{
                    peanuts_btn.setBackgroundResource(R.drawable.peanuts);
                    Allergy allergy = LitePal.find(Allergy.class, 3);
                    allergy.setChecked(0); // raise the price
                    allergy.save();
                    peanuts_isPressed=0;
                }
            }
        });

        shell_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(shell_isPressed==0){
                    shell_btn.setBackgroundResource(R.drawable.noshell);
                    Allergy allergy = LitePal.find(Allergy.class, 4);
                    allergy.setChecked(1); // raise the price
                    allergy.save();
                    shell_isPressed=1;
                    Toast.makeText(InitialSettingActivity.this,
                            "Crustacean shellfish is banned!", Toast.LENGTH_SHORT).show();
                }else{
                    shell_btn.setBackgroundResource(R.drawable.shell);
                    Allergy allergy = LitePal.find(Allergy.class, 4);
                    allergy.setChecked(0); // raise the price
                    allergy.save();
                    shell_isPressed=0;
                }
            }
        });
        soya_btn.setOnClickListener(new OnClickListener() {
            @Override
                public void onClick(View v) {
                    if(soya_isPressed==0){
                            soya_btn.setBackgroundResource(R.drawable.nosoya);
                        Allergy allergy = LitePal.find(Allergy.class, 5);
                        allergy.setChecked(1); // raise the price
                        allergy.save();
                        soya_isPressed=1;
                                Toast.makeText(InitialSettingActivity.this,
                                        "Soya is banned!", Toast.LENGTH_SHORT).show();
                            }else{
                                soya_btn.setBackgroundResource(R.drawable.soya);
                        Allergy allergy = LitePal.find(Allergy.class, 5);
                        allergy.setChecked(0); // raise the price
                        allergy.save();
                        soya_isPressed=0;
                            }
                        }
                    });


        wheat_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wheat_isPressed==0){
                    wheat_btn.setBackgroundResource(R.drawable.nowheat);
                    Allergy allergy = LitePal.find(Allergy.class, 6);
                    allergy.setChecked(1); // raise the price
                    allergy.save();
                    wheat_isPressed=1;
                    Toast.makeText(InitialSettingActivity.this,
                            "Wheat is banned!", Toast.LENGTH_SHORT).show();
                }else{
                    wheat_btn.setBackgroundResource(R.drawable.wheat);
                    Allergy allergy = LitePal.find(Allergy.class, 6);
                    allergy.setChecked(0); // raise the price
                    allergy.save();
                    wheat_isPressed=0;
                }
            }
        });

        fish_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fish_isPressed==0){
                    fish_btn.setBackgroundResource(R.drawable.nofish);
                    Allergy allergy = LitePal.find(Allergy.class, 7);
                    allergy.setChecked(1); // raise the price
                    allergy.save();
                    fish_isPressed=1;
                    Toast.makeText(InitialSettingActivity.this,
                            "Fish is banned!", Toast.LENGTH_SHORT).show();
                }else{
                    fish_btn.setBackgroundResource(R.drawable.fish);
                    Allergy allergy = LitePal.find(Allergy.class, 7);
                    allergy.setChecked(0); // raise the price
                    allergy.save();
                    fish_isPressed=0;
                }
            }
        });


        treenuts_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(treenuts_isPressed==0){
                    treenuts_btn.setBackgroundResource(R.drawable.notreenuts);
                    Allergy allergy = LitePal.find(Allergy.class, 8);
                    allergy.setChecked(1); // raise the price
                    allergy.save();
                    treenuts_isPressed=1;
                    Toast.makeText(InitialSettingActivity.this,
                            "Tree nuts are banned!", Toast.LENGTH_SHORT).show();
                }else{
                    treenuts_btn.setBackgroundResource(R.drawable.treenuts);
                    Allergy allergy = LitePal.find(Allergy.class, 8);
                    allergy.setChecked(0); // raise the price
                    allergy.save();
                    treenuts_isPressed=0;
                }
            }
        });

    }
}
