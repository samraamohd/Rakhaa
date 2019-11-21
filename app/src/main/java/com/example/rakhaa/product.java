package com.example.rakhaa;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rakhaa.helpers.Utils;
import com.example.rakhaa.interfaces.ArrayListener;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;





    public class Product extends AppCompatActivity {

        GridLayoutManager mLayoutManager;
        RecyclerView rec;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.product);

            prod();
        }

        public void prod(){
            rec = findViewById(R.id.rec);
            mLayoutManager = new GridLayoutManager(this, 3);
            rec.setLayoutManager(mLayoutManager);

            new Utils(this).getproduct(new HashMap<>(), new ArrayListener<com.example.rakhaa.models.Product>() {
                @Override
                public void onDone(List<com.example.rakhaa.models.Product> list) {
                    for (com.example.rakhaa.models.Product product : list) {
                        // Toast.makeText(product.this,list.toString(), Toast.LENGTH_SHORT).show();
                        for (int c = 0; c < list.size(); c++) {
                            rec.setAdapter( new productAdapter(list));
                        }
                    }
                }
            });


        }

        public class productAdapter extends RecyclerView.Adapter<productAdapter.productHolder> {
            List<com.example.rakhaa.models.Product> list;

            productAdapter(List<com.example.rakhaa.models.Product> list) {
                this.list = list;
            }

            @NonNull
            @Override
            public productHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new productHolder(LayoutInflater.from(Product.this).inflate(R.layout.product_item, parent, false));
            }

            @Override
            public void onBindViewHolder(@NonNull productHolder holder, int position) {
                com.example.rakhaa.models.Product pro = list.get(position);
                Picasso.with(Product.this).load(pro.getImage()).into(holder.img);
                holder.txt.setText(pro.getArName());
                holder.des.setText(pro.getArDescription());

            }

            @Override
            public int getItemCount() {
                return list.size();
            }

             class productHolder extends RecyclerView.ViewHolder {
                TextView txt, des;
                ImageView img;

                public productHolder(@NonNull View itemView) {
                    super(itemView);
                    img = itemView.findViewById(R.id.img);
                    txt = itemView.findViewById(R.id.txt);
                    des = itemView.findViewById(R.id.des);
                    itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i=new Intent(Product.this,Main.class);
                            startActivity(i);
                        }
                    });
                }
            }
        }

        ;

        }

