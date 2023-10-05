package vn.edu.usth.imdbclient.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import vn.edu.usth.imdbclient.R;

public class FeaturedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    TextView name, email;
    ImageView imageView;
    OnMovieListener onMovieListener;


    public FeaturedViewHolder(@NonNull View itemView, OnMovieListener onMovieListener) {
        super(itemView);

        name = itemView.findViewById(R.id.tvName);
        email = itemView.findViewById(R.id.tvEmail);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        onMovieListener.onMovieClick((getAdapterPosition()));

    }
}
