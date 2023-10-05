package vn.edu.usth.imdbclient;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.fragment.app.Fragment;
import android.text.InputType;
import com.google.android.material.snackbar.Snackbar;

public class SignUp extends Fragment {
    public SignUp() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        CheckBox showPasswordCheckBox = view.findViewById(R.id.show_password);
        EditText emailEditText = view.findViewById(R.id.emailEditText);
        EditText passwordEditText = view.findViewById(R.id.passwordEditText);
        Button createAccountButton = view.findViewById(R.id.sign_up);


        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get user input
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                //Validate email and password using the utility methods
                if (!ValidationUtils.isEmailValid(email)) {
                    emailEditText.setError("Invalid email address");
                    return;
                }

                if (!ValidationUtils.isPasswordValid(password)) {
                    passwordEditText.setError("Password must be at least 8 characters long");
                    return;
                }
                boolean accountCreated = true; // Change this based on your actual account creation logic

                if (accountCreated) {
                    // Show a Snackbar notification
                    Snackbar.make(view, "Account created successfully", Snackbar.LENGTH_SHORT).show();

                    Fragment logInFragment = new LogIn();

                    // Use a FragmentTransaction to replace the current fragment
                    getParentFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, logInFragment)
                            .addToBackStack(null)
                            .commit();
                } else {
                    // Handle account creation failure
                }
            }
        });
        showPasswordCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Set the inputType to text to show the password
                    passwordEditText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    // Set the inputType back to textPassword to mask the password
                    passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }

                // Move the cursor to the end of the text
                passwordEditText.setSelection(passwordEditText.getText().length());
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

}