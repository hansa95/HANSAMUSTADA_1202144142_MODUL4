package com.example.user.hansamustada_1202144142_modul4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;

public class ListMahasiswa extends AppCompatActivity {
    //Todo: Bikin Array
    private String[] names ={"Hansa","Andi","Isa","Rengganis","Enki","Feng","Ginanjar","Alif","Hafizh","Asti"};

    //variable
    ListView listView;
    private int index = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa);

        //set listview
        listView = (ListView) findViewById(R.id.ListView);
        listView.setAdapter(new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,new ArrayList<String>()));

    }

    //todo: execute!
    public void start(View view) {
        new mahasiswa().execute();
    }

    //todo: bikin class Asynctask
    class mahasiswa extends AsyncTask<Void,String,String>
    {
        ProgressDialog progressDialog;
        ArrayAdapter<String> adapter;

        @Override
        protected void onPreExecute() {
            //set adapter
           adapter =(ArrayAdapter<String>)listView.getAdapter();

           //Todo: Bikin Progress Dialog
           progressDialog = new ProgressDialog(ListMahasiswa.this);
           progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
           progressDialog.setMax(100);
           progressDialog.setProgress(0);
           progressDialog.show();
        }

        @Override
        protected String doInBackground(Void... params) {
            //Todo: bikin counter i
            for (int i = 0; i<names.length;i++ ){
                index=i;
                publishProgress(names[i]);

                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return "Sukses cuy";

        }

        @Override
        protected void onProgressUpdate(String... values)
        {
            //Todo: panggil isi array
            adapter.add(values[0]);

            //Todo: itung progress
            float p = (index+1)/(float)names.length;
            progressDialog.setProgress((int) Math.floor(p*100));


        }

        @Override
        protected void onPostExecute(String Result) {
            Toast.makeText(getApplicationContext(), Result,Toast.LENGTH_LONG).show();

            //tutup progress
            progressDialog.hide();
        }
    }
}
