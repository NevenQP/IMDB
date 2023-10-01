package vn.edu.usth.imdbclient.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import vn.edu.usth.imdbclient.R;

public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    TextView title, duration, year, rating;
    ImageView imageView;
    OnMovieListener onMovieListener;


    public MovieViewHolder(@NonNull View itemView, OnMovieListener onMovieListener) {
        super(itemView);

        title = itemView.findViewById(R.id.movie_title);
        year = itemView.findViewById(R.id.movie_release_year);
        rating = itemView.findViewById(R.id.movie_rating);
        imageView = itemView.findViewById(R.id.movie_image);

        itemView.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        onMovieListener.onMovieClick((getAdapterPosition()));

    }
}
