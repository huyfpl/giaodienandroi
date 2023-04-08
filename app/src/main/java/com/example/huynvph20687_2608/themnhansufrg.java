package com.example.huynvph20687_2608;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;


public class themnhansufrg extends Fragment {
    TextInputEditText edtten,edtngay,edtphongban;
    DBHelper db;
    Button btnthem,btnhuy;


    public themnhansufrg() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_themnhansufrg, container, false);
        Calendar lich=Calendar.getInstance();
        db=new DBHelper(getActivity());
        edtten=view.findViewById(R.id.edttenban);
        edtphongban=view.findViewById(R.id.edtphongban);
        edtngay=view.findViewById(R.id.edtngay);
        btnthem=view.findViewById(R.id.btnthem);
        btnhuy=view.findViewById(R.id.btnhuy);
        edtngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int year = lich.get(Calendar.YEAR);
                int month = lich.get(Calendar.MONTH);
                int day = lich.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        edtngay.setText(String.format("%d/%d/%d", dayOfMonth, month+1, year));

                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten=edtten.getText().toString();
                String ngay=edtngay.getText().toString();
                String phong=edtphongban.getText().toString();
                if(ngay.equals("")&&ten.equals("")){
                    Toast.makeText(getActivity(), "Không để rỗng nhé!", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    ban b=new ban(ten,ngay,phong);
                    db.insert(b);
                    Toast.makeText(getActivity(), "Sucess", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtten.setText("");
                edtngay.setText("");
                edtphongban.setText("");
                Toast.makeText(getActivity(), "Sucess", Toast.LENGTH_SHORT).show();


            }
        });
        return view;

    }
}