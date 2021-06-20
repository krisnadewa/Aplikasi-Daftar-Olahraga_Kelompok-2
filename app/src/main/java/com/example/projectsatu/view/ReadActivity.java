
 package com.example.projectsatu.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.projectsatu.R;
import com.example.projectsatu.adapter.SaranAdapter;
import com.example.projectsatu.database.AppDatabase;
import com.example.projectsatu.database.SaranModel;

import java.util.ArrayList;

 public class ReadActivity extends AppCompatActivity {
     private SaranAdapter saranAdapter;
     private RecyclerView rvSaran;
     private AppDatabase appDatabase;
     private ArrayList<SaranModel> listSaran = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        rvSaran = findViewById(R.id.rv_saran);
        saranAdapter = new SaranAdapter(getApplicationContext());
        saranAdapter.notifyDataSetChanged();

        if (appDatabase == null) {
            appDatabase = AppDatabase.iniDatabase(getApplicationContext());
        }

        listSaran.addAll(appDatabase.saranDAO().getSaran());
        saranAdapter.setData(listSaran);

        rvSaran.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvSaran.setAdapter(saranAdapter);
    }
}