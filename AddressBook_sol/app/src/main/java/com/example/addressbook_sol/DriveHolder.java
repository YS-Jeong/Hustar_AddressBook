package com.example.addressbook_sol;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

// ListView item 표시해주는 XML Layout ==> Java Object 저장
public class DriveHolder {
    public ImageView iconIMG;
    public TextView  nameTXT, phoneTXT, addressTXT;

    public DriveHolder(View root){
        iconIMG = root.findViewById(R.id.iconIMG);
        nameTXT = root.findViewById(R.id.nameTXT);
        phoneTXT = root.findViewById(R.id.phoneTXT);
        addressTXT = root.findViewById(R.id.addressTXT);
    }

}
