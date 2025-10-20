package com.epam.training.dariia_binevych.validations_epam_email_exercise;

import java.util.regex.Pattern;

public class EpamEmailValidation {

    public static boolean validateEpamEmail(String email) {
        if (email == null) {
            return false;
        }
        String regex = "^[a-z]+_[a-z]+[0-9]*@epam\\.com$";
        return Pattern.matches(regex, email);
    }
}






