package vn.edu.usth.imdbclient;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import vn.edu.usth.imdbclient.Models.MovieModel;

public class Movie extends AppCompatActivity {

    private ImageView detailImage;
    private TextView detailTitle, detailDuration, detailRate, detailYear, detailOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the layout for the activity
        setContentView(R.layout.fragment_movie_detail);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              finish();
          }
        });
        // Get the views from the layout
        detailImage = findViewById(R.id.detailImage);
        detailDuration = findViewById(R.id.detailLanguage);
        detailTitle = findViewById(R.id.detailTitle);
        detailRate = findViewById(R.id.detailRate);
        detailYear = findViewById(R.id.detailYear);
        detailOverview = findViewById(R.id.detailOverview);

        GetDataFromIntent();
    }

    private void GetDataFromIntent() {
        if (getIntent().hasExtra("movie")) {
            MovieModel movieModel = getIntent().getParcelableExtra("movie");

            detailTitle.setText(movieModel.getTitle());
            detailDuration.setText(movieModel.getOriginal_language());
            detailRate.setText(movieModel.getVote_average());
            detailYear.setText(movieModel.getRelease_date());
            detailOverview.setText(movieModel.getMovie_overview());

            Glide.with(this)
                    .load("https://image.tmdb.org/t/p/w500/" + movieModel.getPoster_path())
                    .into(detailImage);
        }
    }
}