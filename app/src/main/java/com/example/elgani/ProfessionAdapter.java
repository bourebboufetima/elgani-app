package com.example.elgani;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ProfessionAdapter extends RecyclerView.Adapter<ProfessionAdapter.ProfessionViewHolder> {

    private List<Profession> professionList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(String professionName);
    }

    public ProfessionAdapter(List<Profession> professionList, OnItemClickListener listener) {
        this.professionList = professionList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProfessionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_profession, parent, false);
        return new ProfessionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfessionViewHolder holder, int position) {
        Profession profession = professionList.get(position);
        holder.name.setText(profession.getName());
        holder.icon.setImageResource(profession.getIcon());
        holder.itemView.setOnClickListener(v -> listener.onItemClick(profession.getName()));
    }

    @Override
    public int getItemCount() {
        return professionList.size();
    }

    static class ProfessionViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView icon;

        public ProfessionViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.profession_name);
            icon = itemView.findViewById(R.id.profession_icon);
        }
    }
}

