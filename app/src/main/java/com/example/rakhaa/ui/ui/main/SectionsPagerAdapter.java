package com.example.rakhaa.ui.ui.main;

import android.util.Log;

import com.example.rakhaa.models.Categories;
import com.example.rakhaa.models.SubCategoriesItem;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {


    private static final String TAG = SectionsPagerAdapter.class.getSimpleName();
    private List<SubCategoriesItem> Categories = new ArrayList<>();


    public SectionsPagerAdapter(List<SubCategoriesItem> Categories, FragmentManager fm) {
        super(fm);

        this.Categories = Categories;
        Log.d(TAG, "SectionsPagerAdapter: ".concat(Categories.size()+""));
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return PlaceholderFragment.newInstance(Integer.parseInt(Categories.get(position).getId()));
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return Categories.get(position).getName();
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return Categories.size();
    }
}