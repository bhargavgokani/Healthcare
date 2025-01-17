package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private String[][] packages = {
            {"Packages 1 : Full Body Checkup","","","","999"},
            {"Packages 2 : Blood Glucose Fasting","","","","299"},
            {"Packages 3 : COVID-19 Antibody checkup","","","","899"},
            {"Packages 4 : Thyroid Check","","","","499"},
            {"Packages 5 : Immunity checkup","","","","699"},
    };
    private String[] packages_details = {
            "Blood Glucose Fasting\n"+
                    "Complete Hemogram \n"+
                    "HbA1c\n"+
                    "Iron studies\n"+
                    "Kidney Function Test\n"+
                    "LDH Lactate Dehydrogenase,Serum\n"+
                    "Lipid Profile\n"+
                    "Liver Function Test",
            "Blood Glucose Fasting",
            "COVID-19 Antibody checkup",
            "Thyroid Profile ",
            "Complete Hemogram\n"+
                    "CRP Quantitative,Serum\n"+
                    "Iron Studies\n"+
                    "Kidney Function Test\n"+
                    "Vitamin D \n"+
                    "Liver Function Test\n"+
                    "Lipid Profile"

    };
    HashMap<String,String>item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGoToCart,btnBack;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnGoToCart = findViewById(R.id.buttonLTGotoCart);
        btnBack = findViewById(R.id.buttonLTBack);
        listView = findViewById(R.id.ListViewLT);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this,HomeActivity.class));
            }
        });
        btnGoToCart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        startActivity(new Intent(LabTestActivity.this,HomeActivity.class));
                    }
                });
        list = new ArrayList();
        for (int i=0;i<packages.length;i++){
            item = new HashMap<String,String>();
            item.put("line 1",packages[i][0]);
            item.put("line 2",packages[i][1]);
            item.put("line 3",packages[i][2]);
            item.put("line 4",packages[i][3]);
            item.put("line 5","Total cost : "+packages[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        listView.setAdapter(sa);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(LabTestActivity.this,LabTestDetailActivity2.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",packages_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });
    }
}