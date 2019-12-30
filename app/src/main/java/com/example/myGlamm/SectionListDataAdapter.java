package com.example.myGlamm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myGlamm.model.Item;

import java.util.ArrayList;

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder> {

    private ArrayList<Item> itemsList;
    private Context mContext;

    public SectionListDataAdapter(Context context, ArrayList<Item> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.result_item_layout, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int i) {
        Item singleItem = itemsList.get(i);
        holder.tvkey.setText(singleItem.getKey());
        holder.tvValue.setText(""+singleItem.getValue());
    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView tvkey;

        protected TextView tvValue;


        public SingleItemRowHolder(View view) {
            super(view);

            this.tvkey = (TextView) view.findViewById(R.id.tvkey);
            this.tvValue = (TextView) view.findViewById(R.id.tvValue);
        }

    }

}
