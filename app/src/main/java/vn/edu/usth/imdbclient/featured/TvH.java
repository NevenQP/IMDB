package vn.edu.usth.imdbclient.featured;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.edu.usth.imdbclient.Movie;
import vn.edu.usth.imdbclient.R;
import vn.edu.usth.imdbclient.adapters.MovieRecyclerView;
import vn.edu.usth.imdbclient.reponse.MovieSearchResponse;
import vn.edu.usth.imdbclient.utils.Credentials;
import vn.edu.usth.imdbclient.utils.MovieApi;

public class TvH extends Fragment {
    FeaturedAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tv, container, false);

        RecyclerView recyclerView = v.findViewById(R.id.recycleViewTv);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(Credentials.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    MovieApi movieApi = retrofit.create(MovieApi.class);

                    Response response = movieApi.searchTvH(Credentials.API_KEY).execute();
                    List<Feat> list = new ArrayList<>(((FeatResponse)response.body()).getFeats());

                    // Set the adapter for the RecyclerView.
                    adapter = new FeaturedAdapter(list);
                    recyclerView.setAdapter(adapter);

                    // Call the notifyDataSetChanged() method on the adapter.
                    recyclerView.getAdapter().notifyDataSetChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

        return v;
    }
}