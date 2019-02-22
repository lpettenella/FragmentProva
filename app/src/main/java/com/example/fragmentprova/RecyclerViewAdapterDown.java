package com.example.fragmentprova;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class RecyclerViewAdapterDown extends RecyclerView.Adapter<RecyclerViewAdapterDown.DownViewHolder> {

    Context dContext;
    List<Down> dData;

    public RecyclerViewAdapterDown(Context dContext, List<Down> dData) {
        this.dContext = dContext;
        this.dData = dData;
    }

    @NonNull
    @Override
    public DownViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vd;
        vd = LayoutInflater.from(dContext).inflate(R.layout.item_down, parent, false);
        DownViewHolder downViewHolder = new DownViewHolder(vd);
        return downViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DownViewHolder downViewHolder, int position) {
        downViewHolder.dImgView.setImageResource(dData.get(position).getDownImage());
    }

    @Override
    public int getItemCount() {
        return dData.size();
    }

    public static class DownViewHolder extends RecyclerView.ViewHolder {

        private ImageView dImgView;

        public DownViewHolder(@NonNull View itemView) {
            super( itemView );

            dImgView = (ImageView) itemView.findViewById(R.id.img_down);
        }
    }
}