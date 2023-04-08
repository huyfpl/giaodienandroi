package com.example.huynvph20687_2608;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;


public class danhsachfrg extends Fragment {
    DBHelper db;
    RecyclerView rcv;
    banadapter adapter;
    ArrayList<ban> list=new ArrayList<>();
    public danhsachfrg() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_danhsachfrg, container, false);
        db=new DBHelper(getActivity());
        rcv=view.findViewById(R.id.rcvds);
        list.addAll(db.selectall());
        Log.d("TAG", "onCreateView: "+list+db.selectall());
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        rcv.setLayoutManager(manager);
        adapter=new banadapter(getActivity(),list);
        rcv.setAdapter(adapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        list.clear();
        list.addAll(db.selectall());
        adapter.notifyDataSetChanged();
    }
}