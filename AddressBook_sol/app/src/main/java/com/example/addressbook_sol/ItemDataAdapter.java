package com.example.addressbook_sol;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ItemDataAdapter extends ArrayAdapter<ItemData> {
    //Member Variable ---------------------------------------
    private Context                   context;
    private int                       layoutResId;
    private ArrayList<ItemData>       dataList;

    // Constructor Method --------------------------------------------------------------
    public ItemDataAdapter(@NonNull Context context, int resource, @NonNull ArrayList<ItemData> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layoutResId = resource;
        this.dataList = objects;
    }

    // Override Method ---------------------------------------------------------------------
    @Override
    public int getCount() {
        return dataList.size();
    }

    @NonNull

    @Override
    // convertView -> 그려주는 뷰
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Data ==> XML Layout 넣어서 사용할 수 있도록 객체 생성
        // (1) item Layout xml ==> Java 객체 변환
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layoutResId, null);
            DriveHolder holder = new DriveHolder(convertView);
            convertView.setTag(holder);
        }
        /*
        // (2) item Layout's view 객체 가져오기  => DriveHolder 클래스에서 진행
        TextView nameTXT = convertView.findViewById(R.id.nameTXT);
        TextView phoneTXT = convertView.findViewById(R.id.phoneTXT);
        TextView addrTXT = convertView.findViewById(R.id.addressTXT);
        ImageView iconIMG = convertView.findViewById(R.id.iconIMG);
        */

        DriveHolder holder = (DriveHolder) convertView.getTag();

        TextView nameTXT = holder.nameTXT;
        TextView phoneTXT = holder.phoneTXT;
        TextView addrTXT = holder.addressTXT;
        ImageView iconIMG = holder.iconIMG;

        // (3) Data 준비
        final ItemData    item = dataList.get(position);

        // (4) Layout < --- > Data
        nameTXT.setText(item.getName());
        phoneTXT.setText(item.getPhone());
        addrTXT.setText(item.getAddress());
        //iconIMG.setImageResource(item.getImgResId());


        //Image 크기 동일하게
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), item.getImgResId());
        bitmap = bitmap.createScaledBitmap(bitmap, 200, 200, true);
        iconIMG.setImageBitmap(bitmap);

        return convertView;
    }
}
