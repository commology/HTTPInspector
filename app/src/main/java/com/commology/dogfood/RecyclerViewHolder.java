package com.commology.dogfood;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private static final String TAG = "RecyclerViewHolder";

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        onItemClick(v, this.getAdapterPosition());
    }

    public abstract void onItemClick(View view, int position);
}
