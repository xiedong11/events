package com.zhuandian.eventbus.takephoto;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.zhuandian.eventbus.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class TakePhotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_photo);

        ((Button) findViewById(R.id.takephoto)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(intent, 1);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK){
            String sdStatus = Environment.getExternalStorageState();

            if(!sdStatus.equals(Environment.MEDIA_MOUNTED)){
                System.out.println(" ------------- sd card is not avaiable ---------------");
                return;
            }


            String name = "photo.jpg";

            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap) bundle.get("data");

            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/");
            file.mkdirs(); //创建文件夹

            String fileName = Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+name;

            FileOutputStream b =null;

            try {
                b=new FileOutputStream(fileName);
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,b);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }finally {
                try {
                    b.flush();
                    b.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            ((ImageView) findViewById(R.id.picture)).setImageBitmap(bitmap);

        }
    }
}
