package vn.edu.usth.imdbclient;

import android.util.Patterns;

public class ValidationUtils {

    public static boolean isEmailValid(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isPasswordValid(String password) {
        // Implement your password strength requirements here
        return password.length() >= 8;
    }
}

