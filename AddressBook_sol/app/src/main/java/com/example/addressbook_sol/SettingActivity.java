package com.example.addressbook_sol;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SettingActivity extends AppCompatActivity {
    // Member Variable----------------------------------------------------
    private final boolean           D = true;
    private final String            TAG = "SettingActivity";

    // View Object -------------------------------------------------------
    private LinearLayout            setLAY;
    private TextView                idTXT;
    private EditText                nameETXT;
    private RadioGroup              radioGroup;
    private RadioButton             whiteRBTN, darkRBTN, blueRBTN;
    private CheckBox                saveCBTN, connectCBTN;
    private Button                  saveBTN, cancelBTN, modifyBTN;
    private static int              i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        // 초기화 ----------------------------------------------------------
        init();

    }

    // Member Method - Custom --------------------------------------------
    // 초기화 메서드
    public void init(){
        // View 객체 가져오기 ---------------------------------------------
        setLAY = findViewById(R.id.setLAY);
        idTXT = findViewById(R.id.idTXT);
        nameETXT = findViewById(R.id.nameETXT);
        radioGroup = findViewById(R.id.radioGroup);
        whiteRBTN = findViewById(R.id.whiteRBTN);
        darkRBTN = findViewById(R.id.darkRBTN);
        blueRBTN = findViewById(R.id.blueRBTN);
        saveCBTN = findViewById(R.id.saveCBTN);
        connectCBTN = findViewById(R.id.connectCBTN);
        saveBTN = findViewById(R.id.saveBTN);
        cancelBTN = findViewById(R.id.cancelBTN);
        modifyBTN = findViewById(R.id.modifyBTN);

        // View 이벤트 리스너 설정 -------------------------------------------------------------------
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.whiteRBTN)
                    setLAY.setBackgroundColor(Color.WHITE);
                else if(checkedId==R.id.darkRBTN)
                    setLAY.setBackgroundColor(Color.DKGRAY);
                else
                    setLAY.setBackgroundColor(Color.BLUE);
            }
        });

        saveCBTN.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.i(TAG, isChecked ? "Auto Save" : "Unchecked Auto Save");
            }
        });

        connectCBTN.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.i(TAG, isChecked ? "Auto Connect WiFi" : "Unchecked Auto Connect WiFi");
            }
        });

        saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "User name: " + nameETXT.getText().toString() + ", " + "Checked White: " + whiteRBTN.isChecked() + ", " + "Checked Dark: " + darkRBTN.isChecked() + ", " + "Checked Blue: " + blueRBTN.isChecked()
                       + ", " + "Auto Save: " + saveCBTN.isChecked() + ", " + "Auto WiFi: " + connectCBTN.isChecked());
            }
        });

        cancelBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                whiteRBTN.setChecked(false);
                darkRBTN.setChecked(false);
                blueRBTN.setChecked(false);
                saveCBTN.setChecked(false);
                connectCBTN.setChecked(false);
                setLAY.setBackgroundColor(Color.WHITE);
                nameETXT.setText(null);
            }
        });

        modifyBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    nameETXT.setFocusable(false);
                    nameETXT.setClickable(false);
                    i =1;
                } else {
                    nameETXT.setFocusable(true);
                    nameETXT.setClickable(true);
                    i = 0;
                }
            }
        });
    }
}