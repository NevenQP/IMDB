package vn.edu.usth.imdbclient.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import vn.edu.usth.imdbclient.Models.MovieModel;
import vn.edu.usth.imdbclient.repositories.MovieRepository;

public class MovieListViewModel extends ViewModel {

    private MovieRepository movieRepository;

    public MovieListViewModel(){
        movieRepository = MovieRepository.getInstance();
    }
    public LiveData<List<MovieModel>> getMovies() {
        return movieRepository.getMovies();
    }

    public void searchMovieApi(String query, int pageNumber) {
        movieRepository.searchMovieApi(query, pageNumber);
    }

}
