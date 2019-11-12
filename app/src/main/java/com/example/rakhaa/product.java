package com.example.rakhaa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rakhaa.helpers.Utils;
import com.example.rakhaa.interfaces.ArrayListener;
import com.example.rakhaa.models.Locality;
import com.example.rakhaa.models.Product;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;

public class product extends AppCompatActivity {

    GridLayoutManager mLayoutManager;
    RecyclerView rec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        rec = findViewById(R.id.rec);
        mLayoutManager = new GridLayoutManager(this, 3);
        rec.setLayoutManager(mLayoutManager);
        rec.setLayoutManager(new LinearLayoutManager(this));
        new LinearSnapHelper().attachToRecyclerView(rec);

        new Utils(this).getproduct(new HashMap<>(), new ArrayListener<Product>() {
            @Override
            public void onDone(List<Product> list) {
                for (Product product : list) {
                    Toast.makeText(product.this,list.toString(), Toast.LENGTH_SHORT).show();
                    for (int c=0;c<list.size();c++) {
                        rec.setAdapter(new productAdapter(list));
                    }
                }
            }
        });
    }


    private class productAdapter extends RecyclerView.Adapter<productAdapter.productHolder>{
        List<com.example.rakhaa.models.Product> list;

        productAdapter(List<com.example.rakhaa.models.Product> list) {
            this.list = list;
        }

        @NonNull
        @Override
        public productHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new productHolder(LayoutInflater.from(product.this).inflate(R.layout.product_item,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull productHolder holder, int position) {
            com.example.rakhaa.models.Product pro = list.get(position);
           // holder.img.setImageResource(Integer.parseInt(pro.getImage()));
            holder.txt.setText(pro.getArName());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class productHolder extends RecyclerView.ViewHolder{
            TextView txt;
           // ImageView img;
            public productHolder(@NonNull View itemView) {
                super(itemView);
                //img = itemView.findViewById(R.id.img);
                txt = itemView.findViewById(R.id.txt);
            }
        }
    }


}
