package com.example.huynvph20687_2608;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class banadapter extends RecyclerView.Adapter<banadapter.datbanhoder>{
    private Context context;
    private List<ban> list;
    DBHelper db;

    public banadapter(Context context, List<ban> list) {
        this.context = context;
        this.list = list;
        db=new DBHelper(context);
    }

    @NonNull
    @Override
    public datbanhoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_hienthi,null);
        return new datbanhoder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull datbanhoder holder, int position) {
        ban b=list.get(position);
        Log.d("zzz", String.valueOf(b));
        holder.txtten.setText(b.getTen());
        holder.txtngay.setText(b.getNgay());
        holder.txtphongban.setText(b.getPhongban());
        holder.imgdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.delete(b.getId());
                list.clear();
                list.addAll(db.selectall());
                notifyDataSetChanged();
                Toast.makeText(context, "Sucess", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class datbanhoder extends RecyclerView.ViewHolder{
        TextView txtten,txtngay,txtphongban;
        ImageView imgedit,imgdelete;
        public datbanhoder(@NonNull View itemView) {
            super(itemView);
            txtten=itemView.findViewById(R.id.txttennhansu);
            txtngay=itemView.findViewById(R.id.txtngay);
            txtphongban=itemView.findViewById(R.id.txtphongban);
            imgedit=itemView.findViewById(R.id.imgedit);
            imgdelete=itemView.findViewById(R.id.imgdelete);
        }
    }
}
