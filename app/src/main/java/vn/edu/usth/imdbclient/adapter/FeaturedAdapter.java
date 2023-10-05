package vn.edu.usth.imdbclient.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import vn.edu.usth.imdbclient.R;
import vn.edu.usth.imdbclient.Vid_1;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.ViewHolder> {
    private ArrayList<Feat> emplist;

    public FeaturedAdapter(ArrayList<Feat> emplist) {
        this.emplist = emplist;
    }

    // This method creates a new ViewHolder object for each item in the RecyclerView
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the layout for each item and return a new ViewHolder object
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_list, parent, false);
        return new ViewHolder(itemView);
    }

    // This method returns the total
    // number of items in the data set
    @Override
    public int getItemCount() {
        Log.v("Tag", "Error" +emplist.size());
        return emplist.size();
    }

    // This method binds the data to the ViewHolder object
    // for each item in the RecyclerView
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Feat currentEmp = emplist.get(position);
        holder.name.setText(currentEmp.getName());
        holder.email.setText(currentEmp.getEmail());
    }

    // This class defines the ViewHolder object for each item in the RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView email;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            email = itemView.findViewById(R.id.tvEmail);
        }
    }
}
