package com.example.fragmentprova;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.style.IconMarginSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.fragmentprova.Up;

import com.example.fragmentprova.utility.Preferenze;

import java.util.ArrayList;
import java.util.Arrays;

public class FragmentOne extends Fragment{

    ImageView imageView;
    ImageView imageView2;
    ImageButton btnConferma;
    ImageButton btnRifiuta;
    ImageButton btnModifica;
    ImageButton btnCrea;
    ImageButton btnArmadio;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_one, container, false);
        final DBAdapterLogin db = new DBAdapterLogin(view.getContext());
        final Preferenze pref = new Preferenze();
        final Up up = new Up();
        final Down down = new Down();
        final Top top = new Top();

        imageView = view.findViewById(R.id.imageView);
        imageView2 = view.findViewById(R.id.imageView2);

        int asd = view.getContext().getResources().getIdentifier("tshirt_red", "drawable", getActivity().getPackageName());

        db.addVestito("red", 1, "maglia rossa", "avorio", 1, R.drawable.ic_tshirt);
        db.addVestito("yellow", 1, "pantalone", "cacca", 204, R.drawable.pantaloni_sigaretta_tasconi);
        //db.addVestito("arancione", 1, "maglia arancia", "avorio", 1, R.drawable.hoodie_orange);
        //db.addVestito("blu", 1, "pantalone jeans", "cacca", 2, R.drawable.trauser_denim);
        //db.addVestito("blu",1,"maglia verde", "cacca",1, R.drawable.tshirt_denim);
        //db.addVestito("verde",1,"panta verdi","cacca",2, R.drawable.trauser2_olive);
        //db.addVestito("rosso",1, "cardigan red","cacca",1, R.drawable.cardigan_red);

        btnConferma = view.findViewById(R.id.btnConferma);
        btnRifiuta = view.findViewById(R.id.btnRifiuta);
        btnModifica = view.findViewById(R.id.btnModifica);
        btnCrea = view.findViewById(R.id.btnCrea);
        btnArmadio = view.findViewById(R.id.btnArmadio);

        ArrayList<Vestito> id = db.getVestiti("InvernaleFeriale", pref);
        StringBuilder sb = new StringBuilder();
        if(id!=null) {
            int i = 0;
            for (Vestito v1 : id) {
                sb.append(v1.getNome()+" "+v1.getColore());
                if (i == 0) {
                    int col = view.getContext().getResources().getIdentifier(v1.getColore(), "drawable", getActivity().getPackageName());
                    int res = 0;
                    if(Integer.parseInt(v1.getTipoVestito())>100)
                        res = up.getLstUp().get(up.getTypeUp().indexOf(Integer.parseInt(v1.getTipoVestito())));
                    else
                        res = top.getLstTop().get(top.getTypeTop().indexOf(Integer.parseInt(v1.getTipoVestito())));
                    imageView.setImageResource(res);
                    imageView.setColorFilter(col);
                }
                else if (i == 1) {
                    int col = view.getContext().getResources().getIdentifier(v1.getColore(), "drawable", getActivity().getPackageName());
                    int res = down.getLstDown().get(down.getTypeDown().indexOf(Integer.parseInt(v1.getTipoVestito())));
                    imageView2.setImageResource(res);
                    imageView2.setColorFilter(col, PorterDuff.Mode.SRC_ATOP);
                }
                i++;
            }
            Toast.makeText(view.getContext(), sb, Toast.LENGTH_LONG).show();
        }

        btnConferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnConferma.setBackgroundResource(R.mipmap.rifiuta);
                pref.setEccentric(true);
            }
        });

        btnRifiuta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Vestito> id = db.getVestiti("InvernaleFeriale", pref);
                StringBuilder sb = new StringBuilder();
                if(id!=null) {
                    for (Vestito v1 : id) {
                        sb.append(v1.getNome());
                        if (v1.getTipoVestito().equals("1"))
                            imageView.setImageResource(v1.getPic_tag());
                        else if (v1.getTipoVestito().equals("2"))
                            imageView2.setImageResource(v1.getPic_tag());
                    }
                    Toast.makeText(view.getContext(), sb, Toast.LENGTH_LONG).show();
                }
            }
        });

        btnModifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragmentModificaOutfit = new FragmentModificaOutfit();
                getFragmentManager().beginTransaction().replace(R.id.container, fragmentModificaOutfit).commit();
                db.addVestito("rosso", 1, "maglia", "avorio", 1, R.drawable.t_shirt_maschio);
                db.addVestito("giallo", 1, "pantalone", "cacca", 2, R.drawable.pantaloni_sigaretta_tasconi);
            }
        });

        btnCrea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragmentAddOutfit = new FragmentAddOutfit();
                getFragmentManager().beginTransaction().replace(R.id.container, fragmentAddOutfit).commit();
            }
        });

        btnArmadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragmentArmadioOutfit = new FragmentArmadioOutfit();
                getFragmentManager().beginTransaction().replace(R.id.container, fragmentArmadioOutfit).commit();
            }
        });

        return view;
    }
}
