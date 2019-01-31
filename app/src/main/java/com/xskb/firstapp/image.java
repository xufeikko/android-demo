package com.xskb.firstapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;

public class image extends Activity {
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        spinner = findViewById(R.id.seasons);

    }
    public void order(View v){
        String[] seasonss = getResources().getStringArray(R.array.seasons);
        int index = spinner.getSelectedItemPosition();
        Log.d("console",seasonss[index]);
    }
}
