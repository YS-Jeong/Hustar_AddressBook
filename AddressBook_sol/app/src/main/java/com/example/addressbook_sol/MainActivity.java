package com.example.addressbook_sol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    // Member Variable--------------------------------------
    private final boolean                         D = true;
    private final String                          TAG = "MainActivity";

    // View Object
    private EditText                              nameETXT, phoneETXT, emailETXT;
    private ListView                              addressLST;
    private Button                                addBTN, delBTN;

    // Data
    private ArrayList<Address>                    addressList = new ArrayList<Address>();
    private ArrayList<HashMap<String, String>>    arrDatas;
    private SimpleAdapter                         adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Member Method - AppCompatActivity's override---------
        super.onCreate(savedInstanceState);
        // Activity 화면 설정 필수!
        setContentView(R.layout.activity_main);

        init();

        if(D) Log.i(TAG, "onCreat()");
    }

    public void init(){
        // XML View 객체 가져오기
        nameETXT = findViewById(R.id.nameETXT);
        phoneETXT = findViewById(R.id.phoneETXT);
        emailETXT = findViewById(R.id.emailETXT);
        addressLST = findViewById(R.id.addressLST);
        addBTN = findViewById(R.id.addBTN);
        delBTN = findViewById(R.id.delBTN);

        arrDatas = new ArrayList<HashMap<String, String>>();

        addBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> map = new HashMap<>();

                map.put("name", nameETXT.getText().toString());
                map.put("phone", phoneETXT.getText().toString());
                map.put("email", emailETXT.getText().toString());

                arrDatas.add(map);
                adapter = new SimpleAdapter(MainActivity.this, arrDatas, R.layout.list, new String[]{"name","phone","email"}, new int[]{R.id.nameTXT, R.id.phoneTXT, R.id.addressTXT});

                addressLST.setAdapter(adapter);
                initETXT();
            }
        });

        delBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = arrDatas.size() - 1;
                if(index>=0){
                    arrDatas.remove(index);
                    addressLST.setAdapter(adapter);
                } else{
                    Toast.makeText(MainActivity.this, "Has No Data",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    // Member Method - XML onClick------------------------------
   /* public void click(View v){
        switch(v.getId())
        {
            case R.id.addBTN:
                // 3개의 EditText 값 읽어서 객체 생성 및 추가
                // (1) 3개의 EditText 값 입력 여부 체크
                if(nameETXT.getText().length()>0 && phoneETXT.getText().length()>0 && emailETXT.getText().length()>0){
                    // (2)-1 Address 객체 생성 및 ArrayList 추가
                    addressList.add(new Address(nameETXT.getText().toString(), phoneETXT.getText().toString(), emailETXT.getText().toString()));
                    Log.i(TAG, "add => "+addressList.size());

                    // 3개 입력필드 지우기
                    initETXT();

                    // TextView에 출력
                    displayAddress();

                }else{
                    // (2)-2 사용자에게 알림 띄우기
                    Toast.makeText(getApplicationContext(),R.string.add_msg, Toast.LENGTH_LONG).show();
                }

                break;

            case R.id.delBTN:
                // 모두 삭제 또는 가장 최근에 추가한 데이터 삭제
                if(addressList.size()>0){
                    int lastIdx = addressList.size()-1;
                    addressList.remove(lastIdx);

                    // TextView에 출력
                    displayAddress();

                } else{
                    Toast.makeText(this, R.string.del_msg, Toast.LENGTH_LONG).show();
                }

                break;
        }
    }

    // Member Method - Custom-----------------------------------
    // 3개 입력 필드 초기화
    */

      private void initETXT(){
        nameETXT.setText("");
        phoneETXT.setText("");
        emailETXT.setText("");
    }
    /*
    // textView 출력
    //private void displayAddress(){
        String datas = "";
        for(int idx =0; idx<addressList.size(); idx++)
            datas += addressList.get(idx).getInfo();

        if(datas.length()>0)
            addressTXT.setText(datas);
        else
            addressTXT.setText(R.string.nothing);
    }*/
}