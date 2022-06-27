package com.rumeysaozer.javaretrofitrxjavasingle.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rumeysaozer.javaretrofitrxjavasingle.databinding.ItemRowBinding;
import com.rumeysaozer.javaretrofitrxjavasingle.model.BloodItem;
import com.rumeysaozer.javaretrofitrxjavasingle.view.DetailsActivity;

import java.util.ArrayList;

public class BloodAdapter extends RecyclerView.Adapter<BloodAdapter.BloodHolder> {
    private ArrayList<BloodItem> bloodList;
    public BloodAdapter(ArrayList<BloodItem> bloodList){
        this.bloodList = bloodList;
    }
    @NonNull
    @Override
    public BloodAdapter.BloodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @NonNull  ItemRowBinding itemRowBinding = ItemRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new BloodHolder(itemRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BloodAdapter.BloodHolder holder, int position) {
        holder.itemRowBinding.group.setText(bloodList.get(position).group);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(holder.itemView.getContext(), DetailsActivity.class);
            intent.putExtra("blood",bloodList.get(position));
            holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bloodList.size();
    }

    public class BloodHolder extends RecyclerView.ViewHolder{
        ItemRowBinding itemRowBinding;
        public BloodHolder(@NonNull ItemRowBinding binding) {
            super(binding.getRoot());
            this.itemRowBinding = binding;
        }
    }
}
