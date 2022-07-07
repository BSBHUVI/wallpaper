package com.example.wallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
   public boolean r;
   public  int[] img=new int[]{R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void change(View view){
        if(!r){
            new Timer().schedule(new MyTimer(),0,3000);
            r=true;
        }
    }

    private class MyTimer extends TimerTask {
        @Override
        public void run() {
            try{
                WallpaperManager wallpaperManager=WallpaperManager.getInstance(getBaseContext());
                Random random=new Random();
                wallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources(),img[random.nextInt(5)]));
            } catch(IOException e){
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();

            }
        }
    }
}

