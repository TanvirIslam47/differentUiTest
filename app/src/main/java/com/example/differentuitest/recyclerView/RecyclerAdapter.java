package com.example.differentuitest.recyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.differentuitest.R;
import com.example.differentuitest.room.Users;

import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Context context;
    List<Users> list;
//    DeleteItemClicklistner deleteItemClicklistner;

    public RecyclerAdapter(Context context, List<Users> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.fNameTextView.setText(list.get(position).getFirstName());
        holder.lNameTextView.setText(list.get(position).getLastName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView fNameTextView, lNameTextView;
        public ViewHolder(View itemView) {
            super(itemView);

            fNameTextView = itemView.findViewById(R.id.recyclerFirstNameId);
            lNameTextView = itemView.findViewById(R.id.recyclerLastNameId);
        }
    }
}
