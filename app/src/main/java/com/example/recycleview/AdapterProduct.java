package com.example.recycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder> {

    private ArrayList<listproduct> listproducts;
    private ItemClickListener itemClickListener;

    public AdapterProduct(ArrayList<listproduct> items) {
        this.listproducts = items;
    }

    public void setOnItemClickListener(ItemClickListener listener) {
        this.itemClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final listproduct currentItem = listproducts.get(position);

        holder.namaitem.setText(currentItem.getNamaItem());
        holder.logoitem.setImageResource(currentItem.getLogoitem());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listproducts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView namaitem;
        ImageView logoitem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namaitem = itemView.findViewById(R.id.namaproduct);
            logoitem = itemView.findViewById(R.id.logoproduct);
        }
    }

    public interface ItemClickListener {
        void onItemClick(int position);
    }
}








