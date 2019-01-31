package com.xskb.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity implements RadioGroup.OnCheckedChangeListener,TextWatcher {
   /* EditText userName,phone,address;
    TextView text;*/

   TextView text ;
   Button btn,reset;
   int counter = 0;
    RadioGroup unit;
    EditText value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* userName = findViewById(R.id.userName);
        phone = findViewById(R.id.phone);
        address = findViewById(R.id.address);
        text = findViewById(R.id.text);*/

      /* text  = findViewById(R.id.textView);
       btn = findViewById(R.id.button);
        reset = findViewById(R.id.reset);
       btn.setOnClickListener(this);
       btn.setOnLongClickListener(this);
       reset.setOnLongClickListener(this);*/

      /*TextView btn3 = findViewById(R.id.button3);
      btn3.setOnTouchListener(this);*/
      unit  = findViewById(R.id.unit);
      unit.setOnCheckedChangeListener(this);
      value = findViewById(R.id.value);
      value.addTextChangedListener(this);

    }

   /* @Override
    public void onClick(View v) {
        text.setText(String.valueOf(++counter));
    }

    @Override
    public boolean onLongClick(View v) {
        if(v.getId() == R.id.reset){
            counter = 0;
            text.setText("0");
        }else if(v.getId() == R.id.button){
            counter += 2;
            text.setText(String.valueOf(counter));
        }

        return true;
    }*/
//对某一个TextView的触控
    /*@Override
    public boolean onTouch(View v, MotionEvent event) {
        Vibrator vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            vb.vibrate(5000);
        }else if(event.getAction() == MotionEvent.ACTION_UP){
            vb.cancel();
        }
        return true;
    }*/

   /* public void btnClick(View v){
        String str  = userName.getText().toString()+phone.getText().toString()+address.getText().toString();
        text.setText(str);
    }*/
   //对整个屏幕的触控事件
   /*@Override
   public boolean onTouchEvent(MotionEvent e){
       Vibrator vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
       if(e.getAction() == MotionEvent.ACTION_DOWN){
           vb.vibrate(new long[]{0,100,1000,100},2);
       }else if(e.getAction() == MotionEvent.ACTION_UP){
           vb.cancel();
       }
            return true;
   }*/
   //radio选择
    public void show(View v){
       TextView text = findViewById(R.id.text);
        RadioGroup greed = findViewById(R.id.greed);
        int id = greed.getCheckedRadioButtonId();
        RadioButton btn = findViewById(id);
        String content = btn.getText().toString();
        text.setText(content);
        switch(greed.getCheckedRadioButtonId()){
            case R.id.adult :
                text.setText("买全票");
                break;
            case R.id.child:
                text.setText("买办票");
                break;
            case R.id.senior:
                text.setText("不用买票");
                break;

        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        calc();
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        calc();
    }
    protected void calc(){
        TextView degF = findViewById(R.id.degF);
        TextView degC = findViewById(R.id.degC);
        double f,c;
        if(unit.getCheckedRadioButtonId()== R.id.unitF){
            Log.d("console","aa");
           // System.out(unit.getCheckedRadioButtonId());
         /* f =  Double.parseDouble(value.getText().toString());
          c = (f -32)*5/9;*/
        }else{
            /*c = Double.parseDouble(value.getText().toString());
            f = c*9/5+32;*/
        }
        /*degF.setText(String.format("%.1f",f));
        degC.setText(String.format("%.1f",c));*/
    }

    public void goNext(View view){
        Intent inter = new Intent(MainActivity.this,first.class);
        startActivity(inter);
    }
    public void goImage(View view){
        Intent intentImage = new Intent(MainActivity.this,image.class);
        startActivity(intentImage);
    }
    public void goListView(View view){
        Intent intentListView = new Intent(MainActivity.this,listView.class);
        startActivity(intentListView);
    }
    public void goToast(View view){
       // Intent intentToast = new Intent(MainActivity.this,toast_alert.class);
        startActivity(new Intent(this,toast_alert.class));
    }
    public void goCamera(View view){
        // Intent intentToast = new Intent(MainActivity.this,toast_alert.class);
        startActivity(new Intent(this,camear.class));
    }
    public void goWebView(View view){
        // Intent intentToast = new Intent(MainActivity.this,toast_alert.class);
        startActivity(new Intent(this,webView.class));
    }

}
