package vn.edu.usth.imdbclient;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class LogIn extends Fragment {
    public LogIn() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_log_in, container, false);

        Button button1 = (Button) view.findViewById(R.id.sign_up);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an instance of the fragment you want to open
                Fragment fragment = new SignUp(); // Replace with your fragment class

                // Use a FragmentManager to replace the current fragment with the new one
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, fragment) // Replace "fragment_container" with the ID of the container where the fragment will be displayed
                        .addToBackStack(null) // Optional: Adds the transaction to the back stack
                        .commit();
            }
        });

        Button button2 = (Button) view.findViewById(R.id.loginButton);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an instance of the fragment you want to open
                Fragment fragment = new You_Login(); // Replace with your fragment class

                // Use a FragmentManager to replace the current fragment with the new one
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, fragment) // Replace "fragment_container" with the ID of the container where the fragment will be displayed
                        .addToBackStack(null) // Optional: Adds the transaction to the back stack
                        .commit();
            }
        });
        return view;
    }
}