package com.example.fragmentprova;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ColourSelectorAdapter extends ArrayAdapter<RowItem> {

    LayoutInflater inflater;
    Context context;
    RowItem rowItem;

    public ColourSelectorAdapter(FragmentActivity context, int resourceId, int textviewId, List<RowItem> list){

        super(context,resourceId,textviewId, list);
        inflater = context.getLayoutInflater();
        //    ColourSelectorAdapter adapter = new ColourSelectorAdapter(SecondActivity.this,
        //            R.layout.colourselectorlist, R.id.title, rowItem);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.colourselectorlist, parent, false);
        }
        RowItem rowItem = getItem(position);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.colour);
        txtTitle.setText(rowItem.getTitle());
        ImageView imageView = (ImageView) convertView.findViewById(R.id.colourImage);
        imageView.setImageResource(rowItem.getImageId());
        return convertView;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return rowview(convertView, position);
    }

    private View rowview(View convertView , int position){

        RowItem rowItem = getItem(position);

        viewHolder holder ;
        View rowview = convertView;
        if (rowview==null) {

            holder = new viewHolder();
            inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowview = inflater.inflate(R.layout.colourselectorlist, null, false);

            holder.txtTitle = (TextView) rowview.findViewById(R.id.colour);
            holder.imageView = (ImageView) rowview.findViewById(R.id.colourImage);
            rowview.setTag(holder);
        }else{
            holder = (viewHolder) rowview.getTag();
        }
        holder.imageView.setImageResource(rowItem.getImageId());
        holder.txtTitle.setText(rowItem.getTitle());

        return rowview;
    }

    private class viewHolder{
        TextView txtTitle;
        ImageView imageView;
    }
}