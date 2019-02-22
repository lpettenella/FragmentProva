package com.example.fragmentprova;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class FragmentAddWear extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_wear, null);

        final TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        final ViewPager viewPager = view.findViewById(R.id.container_addWear);
        final ViewPagerAdapterFragment adapterFragment = new ViewPagerAdapterFragment(getChildFragmentManager());

        adapterFragment.AddFragment(new FragmentTop(), "TOP");
        adapterFragment.AddFragment(new FragmentUp(), "UP");
        adapterFragment.AddFragment(new FragmentDown(), "DOWN");
        viewPager.setAdapter(adapterFragment);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.falpa_cappuccio_tascone);
        tabLayout.getTabAt(1).setIcon(R.drawable.tshirt_taschino);
        tabLayout.getTabAt(2).setIcon(R.drawable.pantaloni_sigaretta_tasconi);


        return view;
    }
}