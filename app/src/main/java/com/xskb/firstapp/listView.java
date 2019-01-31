package com.xskb.firstapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class listView extends Activity implements AdapterView.OnItemClickListener,AdapterView.OnItemSelectedListener {
    Spinner drink,temp; //显示spinner的选项
    TextView text;
    String[] tempSet1 = {"冰","去冰","温"};
    String[] tempSet2 = {"冰","去冰"};
    String[] drinks = {"珍珠奶茶","奶茶","仙草奶茶","柠檬汁"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ListView listview  = findViewById(R.id.lv);
        listview.setOnItemClickListener(this);
        text = findViewById(R.id.order);
        temp = findViewById(R.id.temp);
        drink = findViewById(R.id.drink);

       ArrayAdapter<String> drinkAd = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,drinks);
        drinkAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        drink.setAdapter(drinkAd);

        drink.setOnItemSelectedListener(this);

    }
    ArrayList<String> selected = new ArrayList<>();
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView text  = (TextView) view;
       String item =  text.getText().toString();
       if(selected.contains(item)){
           selected.remove(item);
       }else{
           selected.add(item);
       }
       String msg;
       if(selected.size()>0){
           msg="";
           for(String str:selected){
               msg = msg+""+str;
           }
       }

      for(String tmp:selected){
          Log.d("console",tmp);
      }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String[] tempSet;
        if(position == 2){
            tempSet = tempSet2;
        }else{
            tempSet = tempSet1;
        }
        ArrayAdapter<String> tempAd = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,tempSet);
        tempAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp.setAdapter(tempAd);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void showOrder(View v){
        String msg = drink.getSelectedItem()+","+temp.getSelectedItem();
        text.setText(msg);
    }
}
