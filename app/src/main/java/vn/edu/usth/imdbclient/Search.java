package vn.edu.usth.imdbclient;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.edu.usth.imdbclient.adapters.MovieRecyclerView;
import vn.edu.usth.imdbclient.adapters.OnMovieListener;
import vn.edu.usth.imdbclient.Models.MovieModel;
import vn.edu.usth.imdbclient.viewmodel.MovieListViewModel;

public class Search extends Fragment implements OnMovieListener {

    private RecyclerView recyclerView;
    private MovieRecyclerView movieRecyclerAdapter;
    private MovieListViewModel movieListViewModel;
    private SearchView searchView;
    private FrameLayout search_fragment_container;

    public Search() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);

        search_fragment_container = (FrameLayout) getActivity().findViewById(R.id.search_fragment_container);

        movieListViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);


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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        recyclerView = view.findViewById(R.id.searchRecyclerView);
        searchView = view.findViewById(R.id.search_view);

        ConfigureRecyclerView();
        SetupSearchView();


        return view;
    }

    private void ConfigureRecyclerView() {
        movieRecyclerAdapter = new MovieRecyclerView(this);
        recyclerView.setAdapter(movieRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);




        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                if (!recyclerView.canScrollHorizontally(1)){
                    movieListViewModel.searchNextpage();

                }

            }
        });
    }

    private void SetupSearchView() {
        // Handle search query submit
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                movieListViewModel.searchMovieApi(query,1);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Handle text changes if needed
                return false;
            }
        });
    }


    @Override
    public void onMovieClick(int position) {

        Intent intent = new Intent(this.getActivity(), Movie.class);
        intent.putExtra("movie", movieRecyclerAdapter.getSelectedMovie(position));
        startActivity(intent);

    }
}