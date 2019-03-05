package com.example.fragmentprova;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FragmentDown extends Fragment {

    private RecyclerView myRecyclerViewDown;
    private List<Down> lstDown;
    private Vestito vestito;
    private ImageView imageView;
    private Button button;
    private DBAdapterLogin db;

    public static final String[] titles = new String[] {"apricot", "ashGray", "azure", "beige", "black", "blue", "bluegray", "bluejeans",
            "bottlegreen", "celeste", "coral", "darkGreen", "gold", "gray", "green",
            "greenblue", "lavender", "lightblue", "magenta", "midnightblue", "mintgreen",
            "navyblue", "oceanBlue", "oceanGreen", "olive", "orange", "pink", "red", "rose",
            "sand", "scarlet", "silver", "tangerine", "turquoise", "violet", "white", "yellow"};

    public static final String[]colores = {"#FACEB1", "#B4BFB7", "#0080FF", "#F5F5DC", "#000000", "#0000FF", "#6699CC", "#5CAEED", "#006B4F",
            "#B2FFFF", "#FF7E4F", "#013321", "#A67F00", "#808080", "#008000", "#1065B5", "#E6E6FA", "#ACD7E5", "#D1417F", "#191970", "#3EB589",
            "#1975D1", "#4F41B5", "#49BF92", "#808000", "#FF6600", "#FFBFCA", "#C40233", "#FF0080", "#C2B180", "#FF2200",
            "#BFBFBF", "#F28500", "#41E0D0", "#8702B0", "#FFFFFF", "#FFD400"};

    public static final Integer[] images = {
            R.drawable.apricot, R.drawable.ashgray, R.drawable.azure, R.drawable.beige,
            R.drawable.black, R.drawable.blue, R.drawable.bluegray, R.drawable.bluejeans,
            R.drawable.bottlegreen, R.drawable.celeste, R.drawable.coral, R.drawable.darkgreen,
            R.drawable.gold, R.drawable.gray, R.drawable.green, R.drawable.greenblue,
            R.drawable.lavender, R.drawable.lightblue, R.drawable.magenta, R.drawable.midnightblue,
            R.drawable.mintgreen, R.drawable.navyblue, R.drawable.oceanblue, R.drawable.oceangreen,
            R.drawable.olive, R.drawable.orange, R.drawable.pink, R.drawable.red,
            R.drawable.rose, R.drawable.sand, R.drawable.scarlet, R.drawable.silver,
            R.drawable.tangerine, R.drawable.turquoise, R.drawable.violet, R.drawable.white,
            R.drawable.yellow};

    Spinner spinner;
    List<RowItem> rowItems;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.down_fragment, null);
        imageView = view.findViewById(R.id.viewDown);
        button = view.findViewById(R.id.downButtonAdd);
        db = new DBAdapterLogin(view.getContext());

        vestito = new Vestito();
        vestito.setNome("Vestito");
        vestito.setDisponibile("1");

        myRecyclerViewDown = (RecyclerView) view.findViewById( R.id.down_recyclerview );
        RecyclerViewAdapterDown recyclerViewAdapterDown = new RecyclerViewAdapterDown( getContext(), lstDown );
        myRecyclerViewDown.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        myRecyclerViewDown.setAdapter( recyclerViewAdapterDown );

        myRecyclerViewDown.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), myRecyclerViewDown, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(view.getContext(),""+position, Toast.LENGTH_SHORT).show();
                vestito.setTipoVestito(Integer.toString(201+position));
                vestito.setTipoVestito(Integer.toString(position+1));
                vestito.setPic_tag(lstDown.get(position).getDownImage());
                imageView.setImageResource(lstDown.get(position).getDownImage());

            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));

        rowItems = new ArrayList<RowItem>();
        for (int i = 0; i < titles.length; i++) {
            RowItem item = new RowItem( images[i], titles[i] );
            rowItems.add( item );
        }

        spinner = (Spinner) view.findViewById(R.id.downspinner);
        ColorSelectorAdapter adapter = new ColorSelectorAdapter( getActivity(),
                R.layout.spinner_up, R.id.textView, rowItems);
        spinner.setAdapter( adapter );
        spinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemvalue = parent.getItemAtPosition( position ).toString();
                Toast.makeText( getActivity(), "SELECTED" + itemvalue, Toast.LENGTH_SHORT ).show();
                vestito.setColore(itemvalue);
                vestito.setColorCode(colores[position]);
                imageView.setColorFilter(Color.parseColor(colores[position]), PorterDuff.Mode.DARKEN);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        } );

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addVestito(vestito.getColore(), vestito.getColorCode(), Integer.parseInt(vestito.isDisponibile()), vestito.getNome(), "avorio", Integer.parseInt(vestito.getTipoVestito()), vestito.getPic_tag());
                Toast.makeText(view.getContext(), "vestito aggiunto", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        lstDown = new ArrayList<>();
        lstDown.add( new Down( R.drawable.pantaloni_tuta_regular ));
        lstDown.add( new Down( R.drawable.pantaloni_tuta_slim ));
        lstDown.add( new Down( R.drawable.pantaloni_sigaretta_tasconi ));
        lstDown.add( new Down( R.drawable.pantaloni_vitaalta_regular ));
        lstDown.add( new Down( R.drawable.pantaloni_vitaalta_sigaretta ));
        lstDown.add( new Down( R.drawable.pantaloni_vitaalta_zampa ));
        lstDown.add( new Down( R.drawable.tubino ));
        lstDown.add( new Down( R.drawable.gonna ));
        lstDown.add( new Down( R.drawable.gonna_orlata ));
    }
}
