package com.example.user.hansamustada_1202144142_modul4;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class CariGambar extends AppCompatActivity {
    ImageView mGambar;
    EditText mEditText;
    Bitmap bitmap;

    //testing manual, but ngga jalan
    String linkURL ="https://itunes.apple.com/us/app/effectshop-pic-collage-maker/id876291194?mt=8";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_gambar);


        mGambar = (ImageView) findViewById(R.id.tampilkan);
        mEditText =(EditText)findViewById(R.id.URL);
    }

    public void cari(View view) {
        new getImagefromURL(mGambar).execute(linkURL);
    }

    class getImagefromURL extends AsyncTask<String,Void,Bitmap>{

        ImageView imgView;
        public getImagefromURL(ImageView imgV){
            this.imgView = imgV;
        }

        @Override
        protected Bitmap doInBackground(String... url) {
            String urlGambar= url[0];
            bitmap = null;

            try {
                InputStream srt = new java.net.URL(urlGambar).openStream();
                bitmap = BitmapFactory.decodeStream(srt);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return bitmap;
        }

        protected void onPostExecute(String result) {
         super.onPostExecute(bitmap);
        //set gambar
            imgView.setImageBitmap(bitmap);

        }
    }
}
