package com.example.fragmentprova;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class FragmentArmadioOutfit extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_two, container, false);

        final Up up = new Up();
        final Down down = new Down();
        final Top top = new Top();


        LinearLayout linearLayout = view.findViewById(R.id.linearLayoutClosetOutTop);
        LinearLayout linearLayoutUp = view.findViewById(R.id.linearLayoutClosetOutUp);
        LinearLayout linearLayoutDown = view.findViewById(R.id.linearLayoutClosetOutDown);

        return view;
    }
}
