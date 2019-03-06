package com.example.fragmentprova;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.icu.text.UnicodeSetSpanner;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class FragmentTwo extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_two, container, false);
        final Up up = new Up();
        final Down down = new Down();
        final Top top = new Top();


        LinearLayout linearLayout = view.findViewById(R.id.linearLayoutClosetTop);
        LinearLayout linearLayoutUp = view.findViewById(R.id.linearLayoutClosetUp);
        LinearLayout linearLayoutDown = view.findViewById(R.id.linearLayoutClosetDown);

        ImageButton btnAddWear = view.findViewById(R.id.btnAddWear);
        DBAdapterLogin db = new DBAdapterLogin(getContext());

        ArrayList<Vestito> topVest = db.getVestiti("top");
        ArrayList<Vestito> upVest = db.getVestiti("up");
        ArrayList<Vestito> downVest = db.getVestiti("down");

        for(Vestito v: topVest){
            ImageButton imageButton = new ImageButton(getContext());
            int res = top.getLstTop().get(top.getTypeTop().indexOf(Integer.parseInt(v.getTipoVestito())));
            imageButton.setColorFilter(Color.parseColor(v.getColorCode()), PorterDuff.Mode.DARKEN);
            imageButton.setImageResource(res);
            linearLayout.addView(imageButton);
        }

        for(Vestito v: upVest){
            ImageButton imageButton = new ImageButton(getContext());
            int res = up.getLstUp().get(up.getTypeUp().indexOf(Integer.parseInt(v.getTipoVestito())));
            imageButton.setColorFilter(Color.parseColor(v.getColorCode()), PorterDuff.Mode.DARKEN);
            imageButton.setImageResource(res);
            linearLayoutUp.addView(imageButton);
        }

        for(Vestito v: downVest){
            ImageButton imageButton = new ImageButton(getContext());
            int res = down.getLstDown().get(down.getTypeDown().indexOf(Integer.parseInt(v.getTipoVestito())));
            imageButton.setColorFilter(Color.parseColor(v.getColorCode()), PorterDuff.Mode.DARKEN);
            imageButton.setImageResource(res);
            linearLayoutDown.addView(imageButton);
        }

        btnAddWear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.container, new FragmentAddWear()).commit();
            }
        });

        return view;
    }
}
