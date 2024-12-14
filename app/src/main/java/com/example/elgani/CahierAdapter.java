package com.example.elgani;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//curl -H "Content-Type: application/json" -X POST http://192.168.245.183:5000 -d "{\"name\":\"Test Value\", {\"description\":\"Test Value\"}} "
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CahierAdapter extends RecyclerView.Adapter<CahierAdapter.CahierViewHolder> {

    private List<String> cahierList;
    private OnItemClickListener onItemClickListener;
    // Define an interface for item clicks
    public interface OnItemClickListener {
        void onItemClick(String item);
    }

    // Setter for the listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }
    public CahierAdapter(List<String> cahierList) {
        this.cahierList = cahierList;
    }

    @NonNull
    @Override
    public CahierViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cahier, parent, false);
        return new CahierViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CahierViewHolder holder, int position) {
        String cahier = cahierList.get(position);
        holder.cahierTitle.setText(cahier);
    }

    @Override
    public int getItemCount() {
        return cahierList.size();
    }

    static class CahierViewHolder extends RecyclerView.ViewHolder {
        TextView cahierTitle;

        public CahierViewHolder(@NonNull View itemView) {
            super(itemView);
            cahierTitle = itemView.findViewById(R.id.cahierTitle);
        }
    }
}
