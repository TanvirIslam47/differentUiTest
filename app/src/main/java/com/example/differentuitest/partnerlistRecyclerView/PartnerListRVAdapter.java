package com.example.differentuitest.partnerlistRecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.differentuitest.R;

import java.util.List;

public class PartnerListRVAdapter extends RecyclerView.Adapter<PartnerListRVAdapter.MyViewHolder> {

    private List<PartnerListRVModel> objectList;
    private LayoutInflater inflater;


    public PartnerListRVAdapter(Context context, List<PartnerListRVModel> objectList) {
        inflater = LayoutInflater.from(context);
        this.objectList = objectList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.partner_list_ui, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView partnerName;


        public MyViewHolder(View itemView) {
            super(itemView);

            partnerName = itemView.findViewById(R.id.partnerNameId);

        }

    }


    @Override
    public int getItemCount() {
        return objectList.size();
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PartnerListRVModel current = objectList.get(position);
        holder.partnerName.setText(current.getPartnerName());
    }
}
