package vn.edu.usth.imdbclient;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.SearchView;


import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import vn.edu.usth.imdbclient.adapters.MovieRecyclerView;
import vn.edu.usth.imdbclient.adapters.OnMovieListener;
import vn.edu.usth.imdbclient.viewmodel.MovieListViewModel;

public class Search extends Fragment implements OnMovieListener {

    private RecyclerView recyclerView;
    private MovieRecyclerView movieRecyclerAdapter;
    private MovieListViewModel movieListViewModel;
    private SearchView searchView;

    public Search() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        recyclerView = view.findViewById(R.id.searchRecyclerView);
        searchView = view.findViewById(R.id.search_view);

        movieListViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);
        ConfigureRecyclerView();
        SetupSearchView();


        // Handle search query submit
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                movieListViewModel.searchMovieApi(
                        query,
                        1
                );
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Handle text changes if needed
                return false;
            }
        });

        return view;
    }

    private void searchMovie(String query, int pageNumber){
        movieListViewModel.searchMovieApi(query, pageNumber);
    }

    private void ConfigureRecyclerView() {
        movieRecyclerAdapter = new MovieRecyclerView(this);
        recyclerView.setAdapter(movieRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void SetupSearchView() {
        searchView.setIconifiedByDefault(false);
        searchView.setQueryHint("Search movies...");
    }

    @Override
    public void onMovieClick(int position) {
        // Handle item click if needed
    }
}
