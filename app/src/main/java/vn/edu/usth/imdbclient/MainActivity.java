package vn.edu.usth.imdbclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(navListener);

        // as soon as the application opens the first
        // fragment should be shown to the user
        // in this case it is algorithm fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Home()).commit();
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

    public void OpenMovie(View view){
        ImageButton button = (ImageButton) view;
        Fragment fragment = new Movie(); // Replace with your fragment class

        // Use a FragmentManager to replace the current fragment with the new one
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment) // Replace "fragment_container" with the ID of the container where the fragment will be displayed
                .addToBackStack(null) // Optional: Adds the transaction to the back stack
                .commit();
    }
}