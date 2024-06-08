package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailActivity extends AppCompatActivity {

    private String [][] doctor_detail1={
        {"Doctor Name : Ajit","Hospital Address:Pimpri","Exp:5","Mobile No:9898989898","400"},
        {"Doctor Name:Prasad","Hospital Address:Nigdi","Exp:3","Mobile No:9494949494","200"},
        {"Doctor Name:Swapnil","Hospital Address:Pune","Exp:7","Mobile No:9292929292","900"},
        {"Doctor Name:Deepak","Hospital Address:Mumbai","Exp:11","Mobile No:9999999999","2000"},
        {"Doctor Name:Ashok","Hospital Address:Baroda","Exp:15","Mobile No:7878787878","1000"}
    };
     private String [][] doctor_detail2={
        {"Doctor Name : Ajit","Hospital Address:Pimpri","Exp:5","Mobile No:9898989898","400"},
        {"Doctor Name:Prasad","Hospital Address:Nigdi","Exp:3","Mobile No:9494949494","200"},
        {"Doctor Name:Swapnil","Hospital Address:Pune","Exp:7","Mobile No:9292929292","900"},
        {"Doctor Name:Deepak","Hospital Address:Mumbai","Exp:11","Mobile No:9999999999","2000"},
        {"Doctor Name:Ashok","Hospital Address:Baroda","Exp:15","Mobile No:7878787878","1000"}
    };
     private String [][] doctor_detail3={
        {"Doctor Name : Ajit","Hospital Address:Pimpri","Exp:5","Mobile No:9898989898","400"},
        {"Doctor Name:Prasad","Hospital Address:Nigdi","Exp:3","Mobile No:9494949494","200"},
        {"Doctor Name:Swapnil","Hospital Address:Pune","Exp:7","Mobile No:9292929292","900"},
        {"Doctor Name:Deepak","Hospital Address:Mumbai","Exp:11","Mobile No:9999999999","2000"},
        {"Doctor Name:Ashok","Hospital Address:Baroda","Exp:15","Mobile No:7878787878","1000"}
    };
     private String [][] doctor_detail4={
        {"Doctor Name : Ajit","Hospital Address:Pimpri","Exp:5","Mobile No:9898989898","400"},
        {"Doctor Name:Prasad","Hospital Address:Nigdi","Exp:3","Mobile No:9494949494","200"},
        {"Doctor Name:Swapnil","Hospital Address:Pune","Exp:7","Mobile No:9292929292","900"},
        {"Doctor Name:Deepak","Hospital Address:Mumbai","Exp:11","Mobile No:9999999999","2000"},
        {"Doctor Name:Ashok","Hospital Address:Baroda","Exp:15","Mobile No:7878787878","1000"}
    };
     private String [][] doctor_detail5={
        {"Doctor Name : Ajit","Hospital Address:Pimpri","Exp:5","Mobile No:9898989898","400"},
        {"Doctor Name:Prasad","Hospital Address:Nigdi","Exp:3","Mobile No:9494949494","200"},
        {"Doctor Name:Swapnil","Hospital Address:Pune","Exp:7","Mobile No:9292929292","900"},
        {"Doctor Name:Deepak","Hospital Address:Mumbai","Exp:11","Mobile No:9999999999","2000"},
        {"Doctor Name:Ashok","Hospital Address:Baroda","Exp:15","Mobile No:7878787878","1000"}
    };

    TextView tv;
    Button btn;
    String [][] doctor_detail ={};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonLTBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

            if (title.compareTo("Family Phycians")==0)
                doctor_detail = doctor_detail1;
            else
            if (title.compareTo("Dietician")==0)
                doctor_detail = doctor_detail2;
            else
            if (title.compareTo("Dentist")==0)
                doctor_detail = doctor_detail3;
            else
            if (title.compareTo("Surgeon")==0)
                doctor_detail = doctor_detail4;
            else
                doctor_detail = doctor_detail5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailActivity.this,FindDoctorActivity.class));
            }
        });
        list = new ArrayList();
        for (int i =0;i<doctor_detail.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",doctor_detail[i][0]);
            item.put("line2",doctor_detail[i][1]);
            item.put("line3",doctor_detail[i][2]);
            item.put("line4",doctor_detail[i][3]);
            item.put("line5","Cons fees:"+doctor_detail[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"Line1","Line2","Line3","Line4","Line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView lst = findViewById(R.id.ListViewLT);
        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view,int i,long l) {
                Intent it = new Intent(DoctorDetailActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_detail[i][0]);
                it.putExtra("text3",doctor_detail[i][1]);
                it.putExtra("text4",doctor_detail[i][3]);
                it.putExtra("text5",doctor_detail[i][4]);
                startActivity(it);
            }
        });
    }
}