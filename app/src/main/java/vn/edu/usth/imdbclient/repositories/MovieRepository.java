package vn.edu.usth.imdbclient.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import vn.edu.usth.imdbclient.Models.MovieModel;
import vn.edu.usth.imdbclient.request.MovieApiClient;

public class MovieRepository {

    private static MovieRepository instance;

    private MovieApiClient movieApiClient;

    public static MovieRepository getInstance() {

        if (instance == null){
            instance = new MovieRepository();
        }
        return instance;

    }

    private MovieRepository() {

        movieApiClient = MovieApiClient.getInstance();

    }

    public LiveData<List<MovieModel>> getMovies(){return movieApiClient.getMovies();}

    public void searchMovieApi(String query, int pageNumber) {
        movieApiClient.searchMovieApi(query, pageNumber);
    }

}

