package com.example.user.hansamustada_1202144142_modul4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void intent(View view) {

        Intent intent = new Intent(this, ListMahasiswa.class);
        startActivity(intent);

    }

    public void intentgambar(View view) {
        Intent intent = new Intent(this, CariGambar.class);
        startActivity(intent);

    }
}
