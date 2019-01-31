package com.xskb.firstapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

public class first extends Activity implements CompoundButton.OnCheckedChangeListener {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        int[] id = {R.id.check1,R.id.check2,R.id.check3,R.id.check4};
        for(int i:id){
            CheckBox chk = findViewById(i);
            chk.setOnCheckedChangeListener(this);
        }
    }
    public void goBack(View view){
        //getActivity().finish();
    }
    public void takeOrder(View view){
        String str = "";
        //int[] id = {R.id.check1,R.id.check2,R.id.check3,R.id.check4};
        for(CompoundButton chk:selected){
            str = str + "\n" +chk.getText();

        }
        if(str.length()>0){
            Log.d("console",str);
            str = "你点了"+str;
        }else{
            str="请点餐";
        }
        TextView content  = findViewById(R.id.showOrder);
        content.setText(str);
    }
    //  存储已选对象选项的结合
    ArrayList<CompoundButton> selected = new ArrayList<>();
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            selected.add(buttonView);

        }else{
            selected.remove(buttonView);
        }

    }
}
