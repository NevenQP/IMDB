package vn.edu.usth.imdbclient.featured;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import vn.edu.usth.imdbclient.models.MovieModel;

public class FeatResponse {
    @SerializedName("total_results")
    @Expose()
    private int total_count;

    @SerializedName("results")
    @Expose()
    private List<Feat> feats;

    public int getTotal_count() {
        return total_count;
    }

    public List<Feat> getFeats() {
        return feats;
    }

    @Override
    public String toString() {
        return "MovieSearchResponse{" +
                "total_count=" + total_count +
                ", movies=" + feats +
                '}';
    }
}
