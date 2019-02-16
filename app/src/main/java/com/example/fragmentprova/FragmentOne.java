package com.example.fragmentprova;

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

import java.util.ArrayList;

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

        imageView = view.findViewById(R.id.imageView);
        imageView2 = view.findViewById(R.id.imageView2);

        db.addVestito("rosso", 1, "maglia", "avorio", 1, R.drawable.t_shirt_maschio);
        db.addVestito("giallo", 1, "pantalone", "cacca", 2, R.drawable.pantaloni_sigaretta_tasconi);
        db.addVestito("arancione", 1, "maglia arancia", "avorio", 1, R.drawable.t_shirt_maschio);
        db.addVestito("jeans", 1, "pantalone jeans", "cacca", 2, R.drawable.pantaloni_sigaretta_tasconi);
        btnConferma = view.findViewById(R.id.btnConferma);
        btnRifiuta = view.findViewById(R.id.btnRifiuta);
        btnModifica = view.findViewById(R.id.btnModifica);
        btnCrea = view.findViewById(R.id.btnCrea);
        btnArmadio = view.findViewById(R.id.btnArmadio);

        ArrayList<Vestito> id = db.getVestiti("InvernaleFeriale");
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

        btnConferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnConferma.setBackgroundResource(R.mipmap.rifiuta);
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
