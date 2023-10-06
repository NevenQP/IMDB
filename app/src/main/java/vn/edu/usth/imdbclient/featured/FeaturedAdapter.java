package vn.edu.usth.imdbclient.featured;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import vn.edu.usth.imdbclient.Models.MovieModel;
import vn.edu.usth.imdbclient.Movie;
import vn.edu.usth.imdbclient.R;
import vn.edu.usth.imdbclient.adapters.MovieViewHolder;
import vn.edu.usth.imdbclient.adapters.OnMovieListener;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.ViewHolder> {
    private List<Feat> feats;
    OnMovieListener onMovieListener;

    public FeaturedAdapter(List<Feat> feats) {
        this.feats = feats;
    }

    @Override
    public int getItemCount() {
        return feats.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_vid_1, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Feat u = feats.get(position);
        holder.title.setText(u.getTitle());
        holder.year.setText(u.getRelease_date());
        holder.rating.setText(String.valueOf(u.getVote_average()));
        holder.duration.setText(u.getOriginal_language());

        Glide.with(holder.itemView.getContext())
                .load("https://image.tmdb.org/t/p/w500/"+u.getPoster_path())
                .into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent object to open the desired activity.
                Intent intent = new Intent(view.getContext(), Movie.class);
                intent.putExtra("movie2", u);
                view.getContext().startActivity(intent);
            }
        });
    }
    public Feat getSelectedMovie(int position) {
        if (feats != null && feats.size() > 0) {
            return feats.get(position);
        }
        return null;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, duration, year, rating;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.movie_title);
            year = itemView.findViewById(R.id.movie_release_year);
            rating = itemView.findViewById(R.id.movie_rating);
            imageView = itemView.findViewById(R.id.movie_image);
            duration = itemView.findViewById(R.id.movie_original_language);
        }
    }
}
