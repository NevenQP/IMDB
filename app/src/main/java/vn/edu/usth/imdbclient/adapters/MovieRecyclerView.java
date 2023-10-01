package vn.edu.usth.imdbclient.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import vn.edu.usth.imdbclient.Models.MovieModel;
import vn.edu.usth.imdbclient.R;

public class MovieRecyclerView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MovieModel> mMovies;
    private OnMovieListener onMovieListener;


    public MovieRecyclerView(OnMovieListener onMovieListener) {
        this.onMovieListener = onMovieListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_vid_1, parent, false);
        return new MovieViewHolder(view, onMovieListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {

        ((MovieViewHolder)holder).title.setText(mMovies.get(i).getTitle());
        ((MovieViewHolder)holder).year.setText(mMovies.get(i).getRelease_date());
        ((MovieViewHolder)holder).rating.setText(String.valueOf(mMovies.get(i).getVote_average()));

        Glide.with(holder.itemView.getContext())
                .load("https://image.tmdb.org/t/p/w500/"+mMovies.get(i).getPoster_path())
                .into(((MovieViewHolder)holder).imageView);


    }

    @Override
    public int getItemCount() {

        if (mMovies != null) {
            return mMovies.size();
        }
        return 0;

    }

    public void setmMovies(List<MovieModel> mMovies) {
        this.mMovies = mMovies;
        notifyDataSetChanged();
    }
}