package com.example.rakhaa.ui;

import android.os.Bundle;

import com.example.rakhaa.R;
import com.example.rakhaa.helpers.Utils;
import com.example.rakhaa.interfaces.ArrayListener;
import com.example.rakhaa.models.Categories;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.rakhaa.ui.ui.main.SectionsPagerAdapter;

import java.util.HashMap;
import java.util.List;

public class Catogry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catogry);
        ViewPager viewPager = findViewById(R.id.view_pager);
        TabLayout tabs = findViewById(R.id.tabs);
        new Utils(this).getcategry(new HashMap<>(), new ArrayListener<Categories>() {
            @Override
            public void onDone(List<Categories> list) {
            //    SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(list, getSupportFragmentManager());
             //   viewPager.setAdapter(sectionsPagerAdapter);
                tabs.setupWithViewPager(viewPager);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}