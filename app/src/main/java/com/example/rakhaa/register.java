package com.example.rakhaa;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.toolbox.JsonObjectRequest;
import com.example.rakhaa.helpers.Utils;
import com.example.rakhaa.interfaces.ArrayListener;
import com.example.rakhaa.models.Locality;
import com.example.rakhaa.models.Regist;

import java.util.HashMap;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class register extends AppCompatActivity {
    EditText name,password,mobile,street,box,address1,address2,email;
    Button regist;
    Spinner state,loca;
    String n,p,m,st,b,ad,add,e;
    HashMap<String,String> map ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=(EditText)findViewById(R.id.name2);
        password=(EditText)findViewById(R.id.password2);
        mobile=(EditText)findViewById(R.id.mobile2);
        street=(EditText)findViewById(R.id.street);
        box=(EditText)findViewById(R.id.pobox);
        address1=(EditText)findViewById(R.id.add1);
        address2=(EditText)findViewById(R.id.add2);
        email=(EditText)findViewById(R.id.email);

        state=findViewById(R.id.state);
        loca=findViewById(R.id.loca);

         map = new HashMap<>();

        new Utils(this).getState(new HashMap<>(), list -> {

            state.setAdapter(new ArrayAdapter<>(com.example.rakhaa.register.this,android.R.layout.simple_spinner_dropdown_item
                    ,list));

        });

        map.put("state_id","1");
        new Utils(this).getLocality(map, new ArrayListener<Locality>() {
            @Override
            public void onDone(List<Locality> list) {
                for(Locality locality : list){
                   // Toast.makeText(register.this, locality.getName(), Toast.LENGTH_SHORT).show();
                    loca.setAdapter(new ArrayAdapter<>(com.example.rakhaa.register.this,android.R.layout.simple_spinner_dropdown_item
                            ,list));

                }
            }
        });


        regist=(Button)findViewById(R.id.regist);
        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reg();
            }
        });

    }
    public void reg(){

        n=name.getText().toString();
        p=password.getText().toString();
        m=mobile.getText().toString();
        st=street.getText().toString();
        b=box.getText().toString();
        e=email.getText().toString();
        ad=address1.getText().toString();
        add=address2.getText().toString();
        HashMap<String,String> map = new HashMap<>();

        map.put("name", n);
        map.put("password",p);
        map.put("phone", m);
        map.put("address1", ad);
        map.put("address2", add);
        map.put("box", b);
        map.put("street", st);
        map.put("state_id", "1");
        map.put("locality_id", "1");
        map.put("email", e);
        map.put("national_id", "1");
        Log.d("req",map.toString());

        new Utils(register.this).getRegist(map, object -> {
            Log.d("req", map.toString());
            Log.d("regist", "Sucsses" + object.toString());
            Intent i=new Intent(register.this,Main.class);
            startActivity(i);
            Toast.makeText(register.this, object.toString(), Toast.LENGTH_SHORT).show();
        });

    }
}






