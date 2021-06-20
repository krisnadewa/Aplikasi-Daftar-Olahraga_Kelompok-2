package com.example.projectsatu.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.projectsatu.R;
import com.example.projectsatu.adapter.SportAdapter;
import com.example.projectsatu.data.ListSports;
import com.example.projectsatu.network.ApiClient;
import com.example.projectsatu.network.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SportFragment extends Fragment {

    private RecyclerView recyclerView;
    private SportAdapter sportAdapter;

    public SportFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sportAdapter = new SportAdapter(getContext());
        sportAdapter.notifyDataSetChanged();

        recyclerView = view.findViewById(R.id.rv_sport);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(sportAdapter);

        getDataArticle();
    }

    private void getDataArticle() {
        ApiInterface service = ApiClient.getRetrofitInstance().create(ApiInterface.class);
        Call<ListSports> call = service.getSports();
        call.enqueue(new Callback<ListSports>() {
            @Override
            public void onResponse(Call<ListSports> call, Response<ListSports> response) {
                if (response.isSuccessful()) {
                    ListSports sports = response.body();
                    if (sports != null && sports.getSports() != null) {
                        sportAdapter.setData(sports.getSports());
                    }
                }
            }

            @Override
            public void onFailure(Call<ListSports> call, Throwable t) {
                Toast.makeText(getContext(), "Connection Failed" , Toast.LENGTH_SHORT).show();
                System.out.println(t.getMessage());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sport, container, false);
    }
}