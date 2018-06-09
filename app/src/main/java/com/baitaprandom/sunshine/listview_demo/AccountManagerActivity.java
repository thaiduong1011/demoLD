package com.baitaprandom.sunshine.listview_demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AccountManagerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    ArrayAdapter<String> adapterSpinnerDanhMuc;
    EditText edtMess;
    Button btnSend;

    List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_manager);

        AnhXa();

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    void AnhXa(){
        spinner = findViewById(R.id.spinner);
        edtMess = findViewById(R.id.edtMess);
        btnSend = findViewById(R.id.btnSend);

        list.add("Nhà cái 1");
        list.add("Nhà cái 2");
        list.add("Nhà cái 3");
        list.add("Nhà cái 4");
        list.add("Nhà cái 5");

        adapterSpinnerDanhMuc = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list){

            public View getView(int position, View convertView,ViewGroup parent) {

                View v = super.getView(position, convertView, parent);

                ((TextView) v).setTextSize(16);
                ((TextView) v).setTextColor(Color.BLACK);

                return v;

            }

            public View getDropDownView(int position, View convertView,ViewGroup parent) {

                View v = super.getDropDownView(position, convertView,parent);

                ((TextView) v).setTextSize(16);
                ((TextView) v).setTextColor(Color.BLACK);
                ((TextView) v).setGravity(Gravity.CENTER);

                return v;

            }

        };

        spinner.setAdapter(adapterSpinnerDanhMuc);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
