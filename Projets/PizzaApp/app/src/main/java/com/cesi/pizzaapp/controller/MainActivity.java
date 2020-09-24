package com.cesi.pizzaapp.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import static java.lang.Thread.sleep;
import com.cesi.pizzaapp.R;

import java.util.List;
import com.cesi.pizzaapp.model.MyListData;

public class MainActivity extends AppCompatActivity {

    List<String> pizzas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.createPizzas();
    }

    private void createPizzas(){

        MyListData[] myListData = new MyListData[] {
                new MyListData("Pizza Reine", android.R.drawable.ic_dialog_info),
                new MyListData("Pizza 4Fromages", android.R.drawable.ic_dialog_info),
                new MyListData("Pizza Marguarita", android.R.drawable.ic_dialog_info),
                new MyListData("Pizza Végétarienne", android.R.drawable.ic_dialog_info),
                new MyListData("Pizza Cannibale", android.R.drawable.ic_dialog_info),
                new MyListData("Pizza Oriental", android.R.drawable.ic_dialog_info),
                new MyListData("Pizza Paysanne", android.R.drawable.ic_dialog_info),
                new MyListData("Pizza Raclette", android.R.drawable.ic_dialog_info),
                new MyListData("Pizza Napolitaine", android.R.drawable.ic_dialog_info),
                new MyListData("Pizza Vicking", android.R.drawable.ic_dialog_info),
                new MyListData("Pizza 4 Saisons", android.R.drawable.ic_dialog_info),
                new MyListData("Pizza Texas", android.R.drawable.ic_dialog_info),

        };



        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        MyListAdapter adapter = new MyListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}