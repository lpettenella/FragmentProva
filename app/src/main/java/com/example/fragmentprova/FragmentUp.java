package com.example.fragmentprova;

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
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.fragmentprova.FragmentTop.titles;

public class FragmentUp extends Fragment {

    private RecyclerView myRecyclerViewUp;
    private List<Up> lstUp;
    private Vestito vestito;

    public static final String[] titles = new String[] {"apricot", "ashGray", "azure", "beige", "black", "blue", "bluegray", "bluejeans",
            "bottlegreen", "celeste", "coral", "darkGreen", "gold", "gray", "green",
            "greenblue", "lavender", "lightblue", "magenta", "midnightblue", "mintgreen",
            "navyblue", "oceanBlue", "oceanGreen", "olive", "orange", "pink", "red", "rose",
            "sand", "scarlet", "silver", "tangerine", "turquoise", "violet", "white", "yellow"};

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
        View view = inflater.inflate(R.layout.up_fragment, null);

        vestito = new Vestito();

        myRecyclerViewUp = (RecyclerView) view.findViewById( R.id.up_recyclerview );
        RecyclerViewAdapterUp recyclerViewAdapterUp = new RecyclerViewAdapterUp( getContext(), lstUp );
        myRecyclerViewUp.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        myRecyclerViewUp.setAdapter( recyclerViewAdapterUp );

        myRecyclerViewUp.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), myRecyclerViewUp, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(view.getContext(),""+position, Toast.LENGTH_SHORT).show();
                vestito.setTipoVestito(Integer.toString(101+position));
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

        spinner = (Spinner) view.findViewById(R.id.upspinner);
        ColorSelectorAdapter adapter = new ColorSelectorAdapter( getActivity(),
                R.layout.spinner_up, R.id.textView, rowItems);
        spinner.setAdapter( adapter );
        spinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String itemvalue = parent.getItemAtPosition( position ).toString();
                Toast.makeText( getActivity(), "SELECTED" + itemvalue, Toast.LENGTH_SHORT ).show();
                vestito.setColore(itemvalue);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        } );

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        lstUp = new ArrayList<>();
        lstUp.add(new Up( R.drawable.camicia_collo ));
        lstUp.add( new Up( R.drawable.camicia_collo_taschino ));
        lstUp.add( new Up( R.drawable.camicia_nocollo ));
        lstUp.add( new Up( R.drawable.camicia_nocollo_taschino ));
        lstUp.add( new Up( R.drawable.camici_manichecorte_collo ));
        lstUp.add( new Up( R.drawable.camicia_manichecorte_collo_taschino ));
        lstUp.add( new Up( R.drawable.polo_collo ));
        lstUp.add( new Up( R.drawable.polo_collo_taschino ));
        lstUp.add( new Up( R.drawable.polo_collo_orli ));
        lstUp.add( new Up( R.drawable.polo_collo_orli_taschino ));
        lstUp.add( new Up( R.drawable.tshirt_taschino_nocollo ));
        lstUp.add( new Up( R.drawable.tshirt_taschino ));

    }

}
