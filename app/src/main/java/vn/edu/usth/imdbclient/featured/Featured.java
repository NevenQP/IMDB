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

public class Featured extends Fragment {
    FeaturedAdapter adapter;
    private MovieRecyclerView movieRecyclerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_featured, container, false);

        RecyclerView recyclerView = v.findViewById(R.id.recycleView);
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

                    Response response = movieApi.searchFeat(Credentials.API_KEY,"1").execute();
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

    public static Featured newInstance(String param1,
                                       String param2) {
        Featured fragment = new Featured();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        args.putString("param2", param2);
        fragment.setArguments(args);
        return fragment;
    }

    public void onMovieClick(int position) {

        Intent intent = new Intent(this.getActivity(), Movie.class);
        intent.putExtra("movie", movieRecyclerAdapter.getSelectedMovie(position));
        startActivity(intent);

    }
}