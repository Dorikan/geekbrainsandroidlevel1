package com.example.geekbrainsa1l1firstapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class dayListAdapter extends RecyclerView.Adapter<dayListAdapter.ViewHolder> {

    private ArrayList<String> data;
    private IRVDOnItemClick onItemClickCallback;
    private int limit = 3;

    public dayListAdapter(ArrayList<String> data, IRVDOnItemClick onItemClickCallback){
        this.data = data;
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_days_rv_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        setItemText(holder, data.get(position));
        setOnItemClickForItem(holder, data.get(position));
    }

    @Override
    public int getItemCount() {
        if(data.size() > limit){
            return limit;
        }
        else {
            return data == null ? 0 : data.size();
        }
    }

    private void setItemText(@NonNull ViewHolder holder, String text){
        holder.textView.setText(text);
    }
    private void setOnItemClickForItem(@NonNull ViewHolder holder, String text){
        holder.layout.setOnClickListener(v -> {
            if(onItemClickCallback!=null){
                onItemClickCallback.onItemClick(text);
            }
        });
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        FrameLayout layout;
        TextView textView;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            textView = itemView.findViewById(R.id.itemTextView);
            layout = itemView.findViewById(R.id.listItemLayout);
        }
    }
}
