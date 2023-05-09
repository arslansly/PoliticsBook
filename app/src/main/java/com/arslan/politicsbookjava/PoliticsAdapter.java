package com.arslan.politicsbookjava;

import android.content.Intent;
import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arslan.politicsbookjava.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class PoliticsAdapter extends RecyclerView.Adapter<PoliticsAdapter.PoliticsHolder> {
    ArrayList<Politics> politicsArrayList;

    public PoliticsAdapter(ArrayList<Politics> politicsArrayList) {
        this.politicsArrayList = politicsArrayList;
    }

    @NonNull
    @Override
    public PoliticsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new PoliticsHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PoliticsHolder holder, int position) {
        holder.binding.recyclerViewTextView.setText(politicsArrayList.get(position).name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(),DetailsActivity.class);
                //chosenPolitics = politicsArrayList.get(position);
                //intent.putExtra("politics",politicsArrayList.get(position));
                Singleton singleton = Singleton.getInstance();
                singleton.setSentPolitics(politicsArrayList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return politicsArrayList.size();
    }

    public class PoliticsHolder extends RecyclerView.ViewHolder{

        private RecyclerRowBinding binding;

        public PoliticsHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
