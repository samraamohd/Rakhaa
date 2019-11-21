package com.example.rakhaa.helpers;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.rakhaa.interfaces.ArrayListener;
import com.example.rakhaa.interfaces.ObjectListener;
import com.example.rakhaa.interfaces.handlerListener;
import com.example.rakhaa.models.Categories;
import com.example.rakhaa.models.Locality;
import com.example.rakhaa.models.Login;
import com.example.rakhaa.models.Pcat;
import com.example.rakhaa.models.Product;
import com.example.rakhaa.models.Regist;
import com.example.rakhaa.models.Search;
import com.example.rakhaa.models.State;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {
    private Context context;

    public Utils(Context context) {
        this.context = context;
    }

    private static final String BASE_URL = "http://rakha.sd/api/";
    private void makeRequest(Endpoint endpoint, HashMap<String, String>  map, final handlerListener listener){
//        Log.d( "makeRequest: ",BASE_URL.concat(endpoint.name()));
        StringRequest request = new StringRequest(Request.Method.POST, BASE_URL.concat(endpoint.name()), listener::onDone, error -> listener.onError(error.networkResponse.data==null?error.getMessage():new String(error.networkResponse.data))){
            @Override
            protected Map<String, String> getParams() {
                return map;
            }
        };
        Volley.newRequestQueue(context).add(request);
    }

    public void getLogin(HashMap<String,String> data, ObjectListener<Login> listener){
        makeRequest(Endpoint.customer_login, data, new handlerListener() {
            @Override
            public void onDone(String msg) {

                listener.onObject(new Gson().fromJson(msg,Login.class));            }

            @Override
            public void onError(String error) {
                Toast.makeText(context, error, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getState(HashMap<String,String> data, ArrayListener<State> listener){
        makeRequest(Endpoint.states, data, new handlerListener() {
            @Override
            public void onDone(String msg) {
                listener.onDone(new Gson().fromJson(msg,new TypeToken<List<State>>(){}.getType()));
            }

            @Override
            public void onError(String error) {
                Log.d( "onError: ",error);
            }
        });
    }

    public void getLocality(HashMap<String,String> data, ArrayListener<Locality> listener){
        makeRequest(Endpoint.locality, data, new handlerListener() {
            @Override
            public void onDone(String msg) {

                listener.onDone(new Gson().fromJson(msg,new TypeToken<List<Locality>>(){}.getType()));
            }

            @Override
            public void onError(String error) {
                Toast.makeText(context, error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getRegist(HashMap<String,String> map , ObjectListener<Regist> listener){
        makeRequest(Endpoint.customer_registration, map, new handlerListener() {
            @Override
            public void onDone(String msg) {
                listener.onObject(new Gson().fromJson(msg,Regist.class));
               // listener.onDone(new Gson().fromJson(msg,new TypeToken<List<Locality>>(){}.getType()));
            }

            @Override
            public void onError(String error) {
                Toast.makeText(context, error, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getproduct(HashMap<String,String> data, ArrayListener<Product> listener){
        makeRequest(Endpoint.product, data, new handlerListener() {
            @Override
            public void onDone(String msg) {

                listener.onDone(new Gson().fromJson(msg,new TypeToken<List<Product>>(){}.getType()));
            }

            @Override
            public void onError(String error) {
                Toast.makeText(context, error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getcategry(HashMap<String,String> data, ArrayListener<Categories> listener){
        makeRequest(Endpoint.Categories, data, new handlerListener() {
            @Override
            public void onDone(String msg) {

                listener.onDone(new Gson().fromJson(msg,new TypeToken<List<Categories>>(){}.getType()));
            }

            @Override
            public void onError(String error) {
                Toast.makeText(context, error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getpcat(String id, ArrayListener<Pcat> listener){
        HashMap<String,String> map = new HashMap<>();
        map.put("sub_category_id",id);
        makeRequest(Endpoint.Pcat, map, new handlerListener() {
            @Override
            public void onDone(String msg) {

                listener.onDone(new Gson().fromJson(msg,new TypeToken<List<Pcat>>(){}.getType()));
            }

            @Override
            public void onError(String error) {
                Toast.makeText(context, error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getsearch(String id, String name, ArrayListener<Search> listener){
        HashMap<String,String> map = new HashMap<>();
        map.put("category_id",id);
        map.put("name",name);
        makeRequest(Endpoint.product_search, map, new handlerListener() {
            @Override
            public void onDone(String msg) {

                listener.onDone(new Gson().fromJson(msg,new TypeToken<List<Search>>(){}.getType()));
            }
            @Override
            public void onError(String error) {
                Toast.makeText(context, error, Toast.LENGTH_SHORT).show();
            }
        });
    }


}
