package com.cengtel.reto2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;

public class AgregadosActivity extends AppCompatActivity {

    private TextView title;
    private HashMap<String, String> inventory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregados);

        title = (TextView) findViewById(R.id.tv_titulo);

        Intent i = getIntent();
        inventory = (HashMap<String, String>) i.getSerializableExtra("inventario");

        title.setText(inventory.toString());

    }
}