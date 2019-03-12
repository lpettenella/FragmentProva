package com.example.fragmentprova;

import android.content.ContentResolver;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.media.Image;
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
import com.example.fragmentprova.utility.StagioneOutfit;

import java.util.ArrayList;
import java.util.Arrays;

public class FragmentOne extends Fragment{

    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    ImageButton btnConferma;
    ImageButton btnRifiuta;
    ImageButton btnModifica;
    ImageButton btnCrea;
    ImageButton btnArmadio;
    DBAdapterLogin db;
    ArrayList<Vestito> selectedOutfit;
    ArrayList<Integer> posFatto;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_one, container, false);
        db = new DBAdapterLogin(view.getContext());
        final Preferenze pref = new Preferenze();
        final Up up = new Up();
        final Down down = new Down();
        final Top top = new Top();
        posFatto = new ArrayList<>();
        selectedOutfit = new ArrayList<>();
        final String stagione = new StagioneOutfit().getStagione();

        imageView = view.findViewById(R.id.imageView);
        imageView2 = view.findViewById(R.id.imageView2);
        imageView3 = view.findViewById(R.id.imageView4);

        int asd = view.getContext().getResources().getIdentifier("tshirt_red", "drawable", getActivity().getPackageName());

        //db.addVestito("red", "#C40233", 1, "maglia rossa", "avorio", 3, R.drawable.ic_tshirt);
        //db.addVestito("yellow", "#FFD400", 1, "pantalone", "cacca", 201, R.drawable.pantaloni_sigaretta_tasconi);
        //db.addVestito("yellow", "#FFD400", 1, "intimo", "cacca", 111, R.drawable.pantaloni_sigaretta_tasconi);
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

        ArrayList<Vestito> id = db.getVestitiFatti(stagione+"Feriale", pref, posFatto);
        posFatto.add(id.get(0).getPosFatto());
        StringBuilder sb = new StringBuilder();

            for(Vestito v: id){
                Toast.makeText(getContext(), sb.append(v.getId())+ " ", Toast.LENGTH_SHORT).show();
            }
            if(id!=null) {
                for (Vestito v1 : id) {

                    int res = 0;
                    if(Integer.parseInt(v1.getTipoVestito())>100 && Integer.parseInt(v1.getTipoVestito()) < 200) {
                        res = up.getLstUp().get(up.getTypeUp().indexOf(Integer.parseInt(v1.getTipoVestito())));
                        imageView3.setImageResource(res);
                        imageView3.setColorFilter(Color.parseColor(v1.getColorCode()), PorterDuff.Mode.DARKEN);
                    }

                    else if(Integer.parseInt(v1.getTipoVestito())<100) {
                        res = top.getLstTop().get(top.getTypeTop().indexOf(Integer.parseInt(v1.getTipoVestito())));
                        imageView.setImageResource(res);
                        imageView.setColorFilter(Color.parseColor(v1.getColorCode()), PorterDuff.Mode.DARKEN);
                    }

                    else {
                        res = down.getLstDown().get(down.getTypeDown().indexOf(Integer.parseInt(v1.getTipoVestito())));
                        imageView2.setImageResource(res);
                        imageView2.setColorFilter(Color.parseColor(v1.getColorCode()), PorterDuff.Mode.DARKEN);
                    }
                }
        }
        btnConferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedOutfit!=null)
                    db.addOutfitFatto(selectedOutfit.get(0).getSelected(), selectedOutfit);
                Toast.makeText(getContext(), "Outfit SCELTO", Toast.LENGTH_SHORT).show();
            }
        });

        btnRifiuta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(posFatto.size() >= db.getoutfitFattiCount()-1){
                    posFatto.clear();
                }
                ArrayList<Vestito> id = db.getVestitiFatti(stagione+"Feriale", pref, posFatto);
                posFatto.add(id.get(0).getPosFatto());
                StringBuilder sb = new StringBuilder();

                for(Vestito v1: id){
                    Toast.makeText(getContext(), sb.append(v1.getId())+ " ", Toast.LENGTH_SHORT).show();
                }
                if(id!=null) {
                    for (Vestito v1 : id) {

                        int res = 0;
                        if(Integer.parseInt(v1.getTipoVestito())>100 && Integer.parseInt(v1.getTipoVestito()) < 200) {
                            res = up.getLstUp().get(up.getTypeUp().indexOf(Integer.parseInt(v1.getTipoVestito())));
                            imageView3.setImageResource(res);
                            imageView3.setColorFilter(Color.parseColor(v1.getColorCode()), PorterDuff.Mode.DARKEN);
                        }

                        else if(Integer.parseInt(v1.getTipoVestito())<100) {
                            res = top.getLstTop().get(top.getTypeTop().indexOf(Integer.parseInt(v1.getTipoVestito())));
                            imageView.setImageResource(res);
                            imageView.setColorFilter(Color.parseColor(v1.getColorCode()), PorterDuff.Mode.DARKEN);
                        }

                        else {
                            res = down.getLstDown().get(down.getTypeDown().indexOf(Integer.parseInt(v1.getTipoVestito())));
                            imageView2.setImageResource(res);
                            imageView2.setColorFilter(Color.parseColor(v1.getColorCode()), PorterDuff.Mode.DARKEN);
                        }
                    }
                }

            }
        });

        btnModifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragmentModificaOutfit = new FragmentModificaOutfit();
                getFragmentManager().beginTransaction().replace(R.id.container, fragmentModificaOutfit).commit();
            }
        });

        btnCrea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<Vestito> id = db.getVestiti(stagione+"Feriale", pref);
                StringBuilder sb = new StringBuilder();
                if(id!=null) {
                    int i = 0;
                    for (Vestito v1 : id) {

                        int res = 0;
                        if(Integer.parseInt(v1.getTipoVestito())>100 && Integer.parseInt(v1.getTipoVestito()) < 200) {
                            res = up.getLstUp().get(up.getTypeUp().indexOf(Integer.parseInt(v1.getTipoVestito())));
                            imageView3.setImageResource(res);
                            imageView3.setColorFilter(Color.parseColor(v1.getColorCode()), PorterDuff.Mode.DARKEN);
                        }

                        else if(Integer.parseInt(v1.getTipoVestito())<100) {
                            res = top.getLstTop().get(top.getTypeTop().indexOf(Integer.parseInt(v1.getTipoVestito())));
                            imageView.setImageResource(res);
                            imageView.setColorFilter(Color.parseColor(v1.getColorCode()), PorterDuff.Mode.DARKEN);
                        }

                        else {
                            res = down.getLstDown().get(down.getTypeDown().indexOf(Integer.parseInt(v1.getTipoVestito())));
                            imageView2.setImageResource(res);
                            imageView2.setColorFilter(Color.parseColor(v1.getColorCode()), PorterDuff.Mode.DARKEN);
                        }
                    }
                }
                selectedOutfit = id;
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
