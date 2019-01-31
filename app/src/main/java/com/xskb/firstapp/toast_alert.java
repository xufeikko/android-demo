package com.xskb.firstapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class toast_alert extends Activity implements AdapterView.OnItemClickListener {
    String[] queArr = {"什么门永远关不上？","什么东西没人爱吃","什么瓜不能吃","什么布切不断","什么鼠最爱干净","偷什么不犯法"};
    String[] ansArr = {"球门","亏","傻瓜","瀑布","环保署","偷笑"};
    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_alert);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,queArr);
        ListView lv = findViewById(R.id.lv);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
        toast = Toast.makeText(this,"",Toast.LENGTH_SHORT);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       // Toast.makeText(this,"答案："+ansArr[position],Toast.LENGTH_SHORT).show();
        toast.setText("答案："+ansArr[position]);
        toast.show();
    }
    public void alert(View view){
        AlertDialog.Builder bdr = new AlertDialog.Builder(this);
        bdr.setMessage("对话框")
            .setNegativeButton("no",null)
            .setPositiveButton("yes",null)
            .show();
    }
}
