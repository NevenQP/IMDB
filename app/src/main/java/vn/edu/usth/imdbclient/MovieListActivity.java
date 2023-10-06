package vn.edu.usth.imdbclient;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.edu.usth.imdbclient.Models.MovieModel;
import vn.edu.usth.imdbclient.adapters.MovieRecyclerView;
import vn.edu.usth.imdbclient.adapters.OnMovieListener;
import vn.edu.usth.imdbclient.viewmodel.MovieListViewModel;

public class MovieListActivity extends AppCompatActivity implements OnMovieListener {


    private RecyclerView recyclerView;

    private MovieRecyclerView movieRecyclerAdapter;

    private MovieListViewModel movieListViewModel;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.movielist);
        recyclerView = findViewById(R.id.recyclerView);


        movieListViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);

        ConfigureRecyclerView();
        ObserveAnyChange();
        searchMovieApi("Loki", 1);

    }

    private void ObserveAnyChange() {

        movieListViewModel.getMovies().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                // Observing any data change
                if (movieModels != null) {
                    for (MovieModel movieModel: movieModels) {
                        Log.d("Tagy", "onChanged: "+movieModel.getTitle());

                        movieRecyclerAdapter.setmMovies(movieModels);
                    }
                }
                
                
            }
        });
    }

    private void searchMovieApi(String query, int pageNumber){
        movieListViewModel.searchMovieApi(query, pageNumber);
    }

    // Initializing recyclerView
    private void ConfigureRecyclerView() {
        movieRecyclerAdapter = new MovieRecyclerView(this);

        recyclerView.setAdapter(movieRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public void onMovieClick(int position) {

    }
}
