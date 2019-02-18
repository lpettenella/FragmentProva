package com.example.fragmentprova;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    private int[] images = {R.drawable.cardigan, R.drawable.cardigan_collo, R.drawable.falpa_cappuccio_tascone,
            R.drawable.maglioncino_collo, R.drawable.maglione_dolcevita, R.drawable.polo_collo, R.drawable.pullover,
            R.drawable.tshirt_taschino,};

    public ImageAdapter(Context context) {
        this.context = context;}

    @Override
    public int getCount() {
        return images.length;}

    @Override
    public boolean isViewFromObject( View view, Object object) {
        return view == object;}

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (position == 0) {
                    Toast.makeText(context, "Cardigan Selected", Toast.LENGTH_SHORT).show();
                } else if (position == 1) {
                    Toast.makeText(context, "Cardigan necked Selected", Toast.LENGTH_SHORT).show();
                } else if (position == 2) {
                    Toast.makeText(context, "Hoodie Selected", Toast.LENGTH_SHORT).show();
                } else if (position == 3) {
                    Toast.makeText(context, "Necked Pullover Selected", Toast.LENGTH_SHORT).show();
                } else if (position == 4) {
                    Toast.makeText(context, "Necked Sweather Selected", Toast.LENGTH_SHORT).show();
                } else if (position == 5) {
                    Toast.makeText(context, "Necked Polo Selected", Toast.LENGTH_SHORT).show();
                } else if (position == 6) {
                    Toast.makeText(context, "Pullover Selected", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "T-shirt 2 Selected", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}