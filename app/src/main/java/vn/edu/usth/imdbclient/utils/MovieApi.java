package vn.edu.usth.imdbclient.utils;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import vn.edu.usth.imdbclient.reponse.MovieSearchResponse;

public interface MovieApi {

    //Search for Movies
    @GET
    Call<MovieSearchResponse> searchMovie(
        @Query("api_key") String key,
        @Query("query") String query,
        @Query("page") String page
    );

}
