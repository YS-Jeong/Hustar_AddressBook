package com.example.addressbook_sol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomListActivity extends AppCompatActivity {
    private final String          TAG = "CustomListActivity";
    private final boolean         D = true;
    private ListView              dataLST;

    private ArrayList<ItemData>   dataArrays;
    private ItemDataAdapter       adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        init();
    }

    // Member Method - Custom -----------------------------------
    private void init(){
        dataLST = findViewById(R.id.dataLST);

        dataArrays = new ArrayList<ItemData>();
        dataArrays.add( new ItemData("TEST", "010", "Daegu", R.drawable.flower_01));
        dataArrays.add( new ItemData("KIM", "011", "Jeju", R.drawable.flower_02));

        adapter = new ItemDataAdapter(this, R.layout.item_data, dataArrays);

        dataLST.setAdapter(adapter);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.nameTXT:
            case R.id.phoneTXT:
            case R.id.addressTXT:
                Log.i(TAG,"TEXT => "+((TextView)v).getText());
                break;

            case R.id.iconIMG:
                Log.i(TAG,"IMAGE");
                break;
        }
    }
}