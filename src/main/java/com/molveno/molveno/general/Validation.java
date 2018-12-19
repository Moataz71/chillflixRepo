package com.molveno.molveno.general;
import java.util.regex.Pattern;

public class Validation
{
    public static boolean isValidEmail(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        System.out.println("Please enter a valid email address");
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

}
