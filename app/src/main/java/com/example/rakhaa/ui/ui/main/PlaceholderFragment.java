package com.example.rakhaa.ui.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rakhaa.DetailsProduct;
import com.example.rakhaa.R;
import com.example.rakhaa.details;
import com.example.rakhaa.helpers.Utils;
import com.example.rakhaa.interfaces.ArrayListener;
import com.example.rakhaa.models.Pcat;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {
private RecyclerView Prodect_recycler;
    Pcat pro;

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment newInstance(int id) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, id);
        fragment.setArguments(bundle);
        return fragment;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {

            index = getArguments().getInt(ARG_SECTION_NUMBER);
            Prodect_recycler = view.findViewById(R.id.subc);
            Prodect_recycler.setLayoutManager(new GridLayoutManager(getContext(),3));

            new Utils(getContext()).getpcat(index + "", new ArrayListener<Pcat>() {
                @Override
                public void onDone(List<Pcat> list) {
                    Prodect_recycler.setAdapter(new productAdapter(list));
                }
            });

        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_catogry, container, false);
//        final TextView textView = root.findViewById(R.id.section_label);
//        pageViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
        private class productAdapter extends RecyclerView.Adapter<productAdapter.productHolder> {
        List<Pcat> list;

        productAdapter(List<Pcat> list) {
            this.list = list;
        }

        @NonNull
        @Override
        public productAdapter.productHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new productHolder(LayoutInflater.from(getContext()).inflate(R.layout.product_item, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull productHolder holder, int position) {
            pro = list.get(position);
            Picasso.with(getContext()).load(pro.getImage()).into(holder.img);
            holder.txt.setText(pro.getArName());
            holder.des.setText(pro.getArDescription());
            String name,de,im,sn,pr,w,s,c,mc,sc;
            name=pro.getArName();
            de=pro.getArDescription();
            im=pro.getImage();
            sn=pro.getEnName();
            pr=pro.getPriceCost();

            holder.txt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i=new Intent(getContext(), details.class);
                    i.putExtra("name",name);
                    i.putExtra("des",de);
                    i.putExtra("im",im);
                    i.putExtra("sn",sn);
                    i.putExtra("pr",pr);
                    startActivity(i);
                   // Toast.makeText(getContext(),name+de, Toast.LENGTH_SHORT).show();
                }
            });

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
/*
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(getContext(),pro.getId()+pro.getArName(), Toast.LENGTH_SHORT).show();

                    }
                });
*/
            }
        }
    }
}