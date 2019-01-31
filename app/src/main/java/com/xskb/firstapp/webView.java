package com.xskb.firstapp;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class webView extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        WebView wv = findViewById(R.id.wv);
        wv.loadUrl("http://www.jd.com");
    }
}
