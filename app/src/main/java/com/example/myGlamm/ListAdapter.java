package com.example.myGlamm;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.myGlamm.R;
import com.example.myGlamm.model.search.RestaurantsItem;


import java.util.ArrayList;
import java.util.List;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> implements Filterable {

    Context context;
    ArrayList<RestaurantsItem> resultarrayItems;
    ArrayList<RestaurantsItem> masterList;
    int selectedPosition=-1;
    RecyclerViewListItem recyclerViewListItem;

    public ListAdapter(Context context, ArrayList<RestaurantsItem> masterList, RecyclerViewListItem recyclerViewListItem) {
        this.context = context;
        this.resultarrayItems = masterList;
        this.masterList = masterList;
        this.recyclerViewListItem = recyclerViewListItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_row, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.card_title.setText(resultarrayItems.get(i).getRestaurant().getName());
        viewHolder.card_subtitle.setText("Reviews :"+ resultarrayItems.get(i).getRestaurant().getAllReviewsCount());
        viewHolder.action_button_1.setText(""+resultarrayItems.get(i).getRestaurant().getUserRating().getAggregateRating());
        viewHolder.action_button_2.setText(""+resultarrayItems.get(i).getRestaurant().getUserRating().getVotes());

        if(resultarrayItems.get(i).getRestaurant().getPhotos()!=null && !TextUtils.isEmpty(resultarrayItems.get(i).getRestaurant().getPhotos().get(0).getPhoto().getUrl()))
        {
            Glide.with(context)
                    .load(resultarrayItems.get(i).getRestaurant().getPhotos().get(0).getPhoto().getUrl())
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(viewHolder.imageView);
        }

//        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                selectedPosition = i;
//                ListAdapter.this.notifyDataSetChanged();
//                //Finding the original position of item from master list
//                int pos = masterList.indexOf(resultarrayItems.get(i));
//                recyclerViewListItem.onItemClicked(pos);
//
//            }
//        });
    }



    @Override
    public int getItemCount() {
        return resultarrayItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView card_title;
        TextView card_subtitle;
        TextView action_button_1;
        TextView action_button_2;
        ImageView imageView;

        //set onclick listener to the entire view
        public ViewHolder(View view) {
            super(view);

            card_title=view.findViewById(R.id.card_title);
            card_subtitle=view.findViewById(R.id.card_subtitle);
            action_button_1=view.findViewById(R.id.action_button_1);
            action_button_2=view.findViewById(R.id.action_button_2);
            imageView=view.findViewById(R.id.imageView);

        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    resultarrayItems = masterList;
                } else {
                    List<RestaurantsItem> filteredList = new ArrayList<RestaurantsItem>();
                    for (RestaurantsItem row : masterList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getRestaurant().getName().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    resultarrayItems = (ArrayList<RestaurantsItem>) filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = resultarrayItems;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                resultarrayItems = (ArrayList<RestaurantsItem>) filterResults.values;

                // refresh the list with filtered data
                notifyDataSetChanged();
            }
        };
    }
}
