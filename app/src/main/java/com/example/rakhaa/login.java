package com.example.rakhaa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.JsonObjectRequest;
import com.example.rakhaa.helpers.Utils;
import com.example.rakhaa.interfaces.ObjectListener;
import com.example.rakhaa.models.Login;
import com.google.android.material.snackbar.Snackbar;

import java.util.HashMap;
import java.util.Map;

public class login extends AppCompatActivity {
EditText name1,mobile1,password1;
//TextView forget;
Button login;
    String tag_string_req = "DoRequest",da,ti;
    JsonObjectRequest jsonObjectRequest;
    boolean cancel = false;
    String n,pa,m,f;
    HashMap<String, String> map;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dialog = new ProgressDialog(this);
        dialog.setCancelable(false);

        name1=(EditText)findViewById(R.id.name);
        mobile1=(EditText)findViewById(R.id.mobile);
        password1=(EditText)findViewById(R.id.password);



        /*forget=(TextView) findViewById(R.id.forget);
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
        login=(Button) findViewById(R.id.log);
        login.setOnClickListener(view -> {

            log();

           /* cancel = false;

            if (TextUtils.isEmpty(name.getText().toString())) {
                name.setError("Enter your phone ! ");
                cancel = true;
            }
            if (TextUtils.isEmpty(mobile.getText().toString())) {
                mobile.setError("Enter your password ! ");
                cancel = true;
            }
            if (TextUtils.isEmpty(password.getText().toString())) {
                password.setError("Enter your name ! ");
                cancel = true;
            }


            if (!cancel) {
                dialog.setMessage("Waiting...");
                dialog.show();
*/


               /* dialog.dismiss();
            }
*/

        });
    }

    public void log(){

        n = name1.getText().toString();
        pa = password1.getText().toString();
        m = mobile1.getText().toString();

        map = new HashMap<>();

        map.put("name", n);
        map.put("password",pa);
        map.put("phone", m);
        Log.d("req",map.toString());

        new Utils(login.this).getLogin(map, object -> {
            Log.d("req", map.toString());
            Log.d("login", "Sucsses" + object.isErorr());
            boolean s= (object.isErorr());
            if (s!=true) {
                Toast.makeText(login.this, "Sucsses" , Toast.LENGTH_SHORT).show();

                Intent i = new Intent(login.this, Main.class);
                startActivity(i);
            }else {
                Toast.makeText(login.this, "Error" + "Your data incorect! ", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

