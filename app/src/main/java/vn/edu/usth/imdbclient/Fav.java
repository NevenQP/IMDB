package vn.edu.usth.imdbclient;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class Fav extends Fragment {
    public Fav() {
        // Required empty public constructor
    }
    private boolean isLiked = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fav, container, false);
        ImageButton button = (ImageButton) view.findViewById(R.id.fav);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isLiked = !isLiked;

                if (isLiked) {
                    button.setImageResource(R.drawable.bookmarked);
                } else {
                    button.setImageResource(R.drawable.bookmark);
                }
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}