package com.example.projectsatu.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectsatu.R;
import com.example.projectsatu.adapter.SaranAdapter;
import com.example.projectsatu.database.AppDatabase;
import com.example.projectsatu.database.SaranModel;
import com.example.projectsatu.view.ReadActivity;

public class SaranFragment extends Fragment {
    private AppDatabase appDatabase;
    private Button btnSubmit, btnLihatData;
    private EditText etSaran;


    public SaranFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnSubmit = view.findViewById(R.id.btn_submit);
        btnLihatData = view.findViewById(R.id.btn_lihatdata);
        etSaran = view.findViewById(R.id.et_saran);

        appDatabase = AppDatabase.iniDatabase(getContext());

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    SaranModel saranModel = new SaranModel();

                    saranModel.setSaran(etSaran.getText().toString());

                    appDatabase.saranDAO().insertSaran(saranModel);

                    Log.d("MainActivity", "Berhasil Menyimpan");
                    Toast.makeText(getContext(), "Berhasil Menyimpan", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Log.e("MainActivity", "Gagal Menyimpan , msg : " +e.getMessage());
                    Toast.makeText(getContext(), "Gagal Menyimpan", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLihatData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ReadActivity.class);

                startActivity(intent);

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_saran, container, false);
    }
}