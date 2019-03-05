package com.example.fragmentprova;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class RecyclerViewAdapterUp extends RecyclerView.Adapter<RecyclerViewAdapterUp.UpViewHolder> {

    Context uContext;
    List<Up> uData;

    public RecyclerViewAdapterUp(Context uContext, List<Up> lstUp) {
        this.uContext = uContext;
        this.uData = lstUp;
    }

    @NonNull
    @Override
    public UpViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View uv;
        uv = LayoutInflater.from(uContext).inflate(R.layout.item_up, parent, false);
        UpViewHolder upViewHolder = new UpViewHolder(uv);
        return upViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UpViewHolder upViewHolder, int position) {
        upViewHolder.uImageView.setImageResource(uData.get(position).getModelImage());
    }

    @Override
    public int getItemCount() {
        return uData.size();
    }

    public static class UpViewHolder extends RecyclerView.ViewHolder {

        private ImageView uImageView;

        public UpViewHolder(@NonNull View itemView) {
            super( itemView );

         uImageView = (ImageView) itemView.findViewById(R.id.img_up);
        }
    }
}
