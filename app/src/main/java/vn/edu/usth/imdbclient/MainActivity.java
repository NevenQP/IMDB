package vn.edu.usth.imdbclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import vn.edu.usth.imdbclient.adapters.MovieRecyclerView;
import vn.edu.usth.imdbclient.adapters.OnMovieListener;
import vn.edu.usth.imdbclient.viewmodel.MovieListViewModel;


public class MainActivity extends AppCompatActivity implements OnMovieListener {
    private RecyclerView recyclerView;
    private MovieRecyclerView movieRecyclerAdapter;
    private MovieListViewModel movieListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the RecyclerView and MovieRecyclerView adapter
        recyclerView = findViewById(R.id.recyclerView);
        movieRecyclerAdapter = new MovieRecyclerView(this);

        // Set the adapter on the RecyclerView
        recyclerView.setAdapter(movieRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(navListener);

        // as soon as the application opens the first
        // fragment should be shown to the user
        // in this case it is algorithm fragment
        loadFragment(new Home());
    }


    private final BottomNavigationView.OnItemSelectedListener navListener = item -> {
        // By using switch we can easily get
        // the selected fragment
        // by using there id.
        Fragment selectedFragment = null;
        int itemId = item.getItemId();
        if (itemId == R.id.home) {
            selectedFragment = new Home();
        } else if (itemId == R.id.search) {
            selectedFragment = new Search();
        } else if (itemId == R.id.you){
            selectedFragment = new You();
        }
        // It will help to replace the
        // one fragment to other.
        if (selectedFragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
        }
        return true;
    };

    private void loadFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.commit();
        }
    }

    @Override
    public void onMovieClick(int position) {

    }
}