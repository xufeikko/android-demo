package com.xskb.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class camear extends Activity {
    Uri imgUri;
    ImageView imv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camear);
        imv = findViewById(R.id.imageView);
    }
    public void onGet(View view){
        String dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();
        String fname = "p"+System.currentTimeMillis()+".jpg";
        imgUri = Uri.parse("file://"+dir+"/"+fname);
        Intent it = new Intent("android.media.action.IMAGE_CAPTURE");
        it.putExtra(MediaStore.EXTRA_OUTPUT,imgUri);
        startActivityForResult(it,100);
    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode == Activity.RESULT_OK && requestCode ==100){
            Bitmap bmp =  BitmapFactory.decodeFile(imgUri.getPath());
            imv.setImageBitmap(bmp);
        }else{
            Toast.makeText(this,"拍照失败",Toast.LENGTH_SHORT).show();
        }
    }
}
