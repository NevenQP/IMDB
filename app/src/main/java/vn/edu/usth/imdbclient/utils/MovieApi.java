package vn.edu.usth.imdbclient.utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import vn.edu.usth.imdbclient.featured.Feat;
import vn.edu.usth.imdbclient.featured.FeatResponse;
import vn.edu.usth.imdbclient.Models.MovieModel;
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

    @GET("/3/search/{movie_id}")
    Call <MovieModel> getMovie(
            @Path("movie_id") int movie_id,
            @Query("api_key") String api_key
    );

    @GET("/3/movie/popular")
    Call<FeatResponse> searchFeat(
            @Query("api_key") String api_key,
            @Query("page") String page
    );

    @GET("/3/trending/movie/day")
    Call<FeatResponse> searchMovieH(
            @Query("api_key") String api_key
    );

    @GET("/3/trending/tv/day")
    Call<FeatResponse> searchTvH(
            @Query("api_key") String api_key
    );



}
