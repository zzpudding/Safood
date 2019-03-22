package com.example.zhangyujia.asd;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;

public class InitalSettingActivity extends Activity {

    ImageButton milk_btn;
    ImageButton eggs_btn;
    ImageButton fish_btn;
    ImageButton shell_btn;
    ImageButton wheat_btn;
    ImageButton soya_btn;
    ImageButton treenuts_btn;
    ImageButton peanuts_btn;

    boolean milk_isPressed=true;
    boolean eggs_isPressed=true;
    boolean fish_isPressed=true;
    boolean shell_isPressed=true;
    boolean wheat_isPressed=true;
    boolean soya_isPressed=true;
    boolean treenuts_isPressed=true;
    boolean peanuts_isPressed=true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initialsetting);
        addListenerOnButton();
    }

    public void addListenerOnButton() {

        milk_btn = (ImageButton) findViewById(R.id.allergy1);
        eggs_btn = (ImageButton) findViewById(R.id.allergy2);
        fish_btn = (ImageButton) findViewById(R.id.allergy3);
        shell_btn = (ImageButton) findViewById(R.id.allergy4);
        treenuts_btn = (ImageButton) findViewById(R.id.allergy5);
        peanuts_btn = (ImageButton) findViewById(R.id.allergy6);
        wheat_btn = (ImageButton) findViewById(R.id.allergy7);
        soya_btn = (ImageButton) findViewById(R.id.allergy8);


        milk_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(milk_isPressed){
                    milk_btn.setBackgroundResource(R.drawable.nomilk);
                    Toast.makeText(InitalSettingActivity.this,
                            "Milk is banned!", Toast.LENGTH_SHORT).show();
                }else{
                    milk_btn.setBackgroundResource(R.drawable.milk);
                }
                milk_isPressed=!milk_isPressed;
            }
        });

        fish_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fish_isPressed){
                    fish_btn.setBackgroundResource(R.drawable.nofish);
                    Toast.makeText(InitalSettingActivity.this,
                            "Fish is banned!", Toast.LENGTH_SHORT).show();
                }else{
                    fish_btn.setBackgroundResource(R.drawable.fish);
                }
                fish_isPressed=!fish_isPressed;
            }
        });


        eggs_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eggs_isPressed){
                    eggs_btn.setBackgroundResource(R.drawable.noeggs);
                    Toast.makeText(InitalSettingActivity.this,
                            "Eggs are banned!", Toast.LENGTH_SHORT).show();
                }else{
                    eggs_btn.setBackgroundResource(R.drawable.eggs);
                }
                eggs_isPressed=!eggs_isPressed;
            }
        });

        peanuts_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(peanuts_isPressed){
                    peanuts_btn.setBackgroundResource(R.drawable.nopeanuts);
                    Toast.makeText(InitalSettingActivity.this,
                            "Peanuts are banned!", Toast.LENGTH_SHORT).show();
                }else{
                    peanuts_btn.setBackgroundResource(R.drawable.peanuts);
                }
                peanuts_isPressed=!peanuts_isPressed;
            }
        });

        soya_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(soya_isPressed){
                    soya_btn.setBackgroundResource(R.drawable.nosoya);
                    Toast.makeText(InitalSettingActivity.this,
                            "Soya is banned!", Toast.LENGTH_SHORT).show();
                }else{
                    soya_btn.setBackgroundResource(R.drawable.soya);
                }
                soya_isPressed=!soya_isPressed;
            }
        });

        shell_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(shell_isPressed){
                    shell_btn.setBackgroundResource(R.drawable.noshell);
                    Toast.makeText(InitalSettingActivity.this,
                            "Crustacean shellfish is banned!", Toast.LENGTH_SHORT).show();
                }else{
                    shell_btn.setBackgroundResource(R.drawable.shell);
                }
                shell_isPressed=!shell_isPressed;
            }
        });

        treenuts_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(treenuts_isPressed){
                    treenuts_btn.setBackgroundResource(R.drawable.notreenuts);
                    Toast.makeText(InitalSettingActivity.this,
                            "Tree nuts are banned!", Toast.LENGTH_SHORT).show();
                }else{
                    treenuts_btn.setBackgroundResource(R.drawable.treenuts);
                }
                treenuts_isPressed=!treenuts_isPressed;
            }
        });

        wheat_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wheat_isPressed){
                    wheat_btn.setBackgroundResource(R.drawable.nowheat);
                    Toast.makeText(InitalSettingActivity.this,
                            "Wheat is banned!", Toast.LENGTH_SHORT).show();
                }else{
                    wheat_btn.setBackgroundResource(R.drawable.wheat);
                }
                wheat_isPressed=!wheat_isPressed;
            }
        });


    }
}
