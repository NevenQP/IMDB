package vn.edu.usth.imdbclient;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import vn.edu.usth.imdbclient.Models.MovieModel;
import vn.edu.usth.imdbclient.viewmodel.MovieListViewModel;

public class MovieListActivity extends AppCompatActivity {

    private MovieListViewModel movieListViewModel;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);


        movieListViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);
    }

    private void ObserveAnyChange() {

        movieListViewModel.getMovies().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {

            }
        });
    }

}
