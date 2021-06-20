package com.example.projectsatu.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectsatu.R;
import com.example.projectsatu.database.AppDatabase;
import com.example.projectsatu.database.SaranModel;

import java.util.ArrayList;

public class SaranAdapter extends RecyclerView.Adapter<SaranAdapter.ViewHolder>{
    private Context context;
    private ArrayList<SaranModel> saranItems = new ArrayList<SaranModel>();
    private AppDatabase appDatabase;

    public SaranAdapter(Context context) {
        this.context = context;
        appDatabase = AppDatabase.iniDatabase(this.context);
    }

    public void setData(ArrayList<SaranModel> items) {
        saranItems.clear();
        saranItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SaranAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist_saran,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SaranAdapter.ViewHolder holder, int position) {
        holder.tvSaran.setText(saranItems.get(position).getSaran());

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    SaranModel saranModel = new SaranModel();

                    saranModel.setSaran(saranItems.get(position).getSaran());
                    saranModel.setId(saranItems.get(position).getId());

                    appDatabase.saranDAO().deleteSaran(saranModel);

                    Log.d("SaranAdapter", "Berhasil Dihapus");
                    Toast.makeText(context, "Berhasil Dihapus", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Log.e("MainActivity", "Gagal Dihapus , msg : " +e.getMessage());
                    Toast.makeText(context, "Gagal Dihapus", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return saranItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button btnDelete;
        TextView tvSaran;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btnDelete = itemView.findViewById(R.id.btn_delete);

            tvSaran = itemView.findViewById(R.id.tv_saran);
        }
    }
}
