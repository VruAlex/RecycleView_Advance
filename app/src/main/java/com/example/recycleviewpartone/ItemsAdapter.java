package com.example.recycleviewpartone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.Holder> implements Filterable {
    private Context context;
    private List<Items> items;

    private boolean NightMode;


    private List<Items> Search;


    ItemsAdapter(Context context, List<Items> items, boolean NightMode) {
        this.context = context;
        this.items = items;
        this.NightMode = NightMode;
        this.Search = items;
    }

    @NonNull
    @Override
    public ItemsAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int AAA) {
        View layout;
        layout = LayoutInflater.from(context).inflate(R.layout.items_items_activity, viewGroup, false);
        return new ItemsAdapter.Holder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.Holder holder, int position) {
        holder.title.setText(Search.get(position).getTitle());
        holder.description.setText(Search.get(position).getDescription());
        holder.date.setText(Search.get(position).getDate());
        holder.image.setImageResource(Search.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return Search.size();
    }


    @Override
    public Filter getFilter(){
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String key = constraint.toString();
                if (key.isEmpty()){
                    Search = items;
                }else {
                    List<Items>NFilter = new ArrayList<>();
                    for (Items row : items){
                        if (row.getTitle().toLowerCase().contains(key.toLowerCase())){
                            NFilter.add(row);
                        }
                    }
                    Search = NFilter;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = Search;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                Search = (List<Items>)results.values;
                notifyDataSetChanged();

            }
        };
    }



    class Holder extends RecyclerView.ViewHolder {
        TextView title, description, date;
        ImageView image;
        CardView cardView;

        Holder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.CardView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            date = itemView.findViewById(R.id.date);
            image = itemView.findViewById(R.id.img);


            if (NightMode) {
                setNightTheme();
            }

        }

        private void setNightTheme() {
            cardView.setBackgroundResource(R.color.black);
        }
    }
}














