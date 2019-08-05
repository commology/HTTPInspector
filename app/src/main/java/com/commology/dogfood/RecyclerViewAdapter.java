package com.commology.dogfood;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public abstract class RecyclerViewAdapter<Data> extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<Data> mDataset;
    private int mLayoutResID;

    public RecyclerViewAdapter(ArrayList<Data> dataset, int resID) {
        mDataset = dataset;
        mLayoutResID = resID;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mLayoutResID, parent, false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(view) {
            @Override
            public void onItemClick(View view, int position) {
                RecyclerViewAdapter.this.onItemClick(view, position, mDataset);
            }
        };
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        onBindItemView(holder, position, mDataset);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public abstract void onItemClick(View view, int position, ArrayList<Data> dataset);

    public abstract void onBindItemView(@NonNull RecyclerViewHolder holder, int position, ArrayList<Data> dataset);

    public abstract static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

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
}
