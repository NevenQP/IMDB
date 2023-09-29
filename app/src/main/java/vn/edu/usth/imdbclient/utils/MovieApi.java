package vn.edu.usth.imdbclient.utils;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import vn.edu.usth.imdbclient.reponse.MovieSearchResponse;

public interface MovieApi {
    //https://api.themoviedb.org/3/search/movie?api_key=afbe1584345c368fe1993b68f04f783e&query=Loki
    //Search for Movies
    @GET("/3/search/movie?")
    Call<MovieSearchResponse> searchMovie(
            @Query("api_key") String key,
            @Query("query") String query,
            @Query("page") String page
    );

}
