package com.example.gkapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.StateHolder> {
    private Context context;
    private List<States> StatesList;

    public StateAdapter(Context context,List<States> states){
        this.context=context;
        this.StatesList=states;
    }
    @NonNull
    @Override
    public StateHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.stateitem,parent,false);
        return  new StateHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StateAdapter.StateHolder holder, int position) {
        States state=StatesList.get(position);
        holder.smN.setText(String.valueOf(state.getName()));
        Glide.with(context).load(state.getImage()).into(holder.smV);
        holder.sbn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(context,DetailedActivity.class);
                        Bundle bundle=new Bundle();
                        bundle.putString("name",state.getName());
                        bundle.putString("population",state.getPopulation());
                        bundle.putString("capital",state.getCapital());
                        bundle.putString("gdp",state.getGdp());
                        bundle.putString("cmname",state.getCmName());
                        bundle.putString("rulingparty",state.getRulingParty());
                        bundle.putString("gdppercapita",state.getGdpPerCapita());
                        bundle.putString("image",state.getImage());


                        intent.putExtras(bundle);
                        context.startActivity(intent);
                    }
                }
        );

    }


    @Override
    public int getItemCount() {
        return StatesList.size();
    }

    public class StateHolder extends  RecyclerView.ViewHolder {
        ImageView smV;
        TextView smN;
        Button sbn;

        public StateHolder(@NonNull View itemView) {
            super(itemView);
            smV=itemView.findViewById(R.id.stateImage);
            smN=itemView.findViewById(R.id.statename);
            sbn=itemView.findViewById(R.id.detailsBtn);
        }
    }
}
