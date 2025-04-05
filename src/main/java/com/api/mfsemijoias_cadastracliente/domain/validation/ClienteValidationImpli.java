package com.api.mfsemijoias_cadastracliente.domain.validation;

import com.api.mfsemijoias_cadastracliente.ports.in.ClienyeValidation;

import java.util.regex.Pattern;

public class ClienteValidationImpli  implements ClienyeValidation {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
private static final Pattern PHONE_PATTERN = Pattern.compile("^(\\+\\d{1,3}[- ]?)?\\d{10}$");
private static final Pattern CPF_PATTERN = Pattern.compile("^(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{11})$");
private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-zÀ-ÿ\\s]+$");
private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
private static final Pattern USERNAME_PATTERN = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)[A-Za-z\\d]{6,}$");


    @Override
    public boolean isValidEmail(String email) {
        EMAIL_PATTERN.matcher(email).matches();


        return true;
    }

    @Override
    public boolean isValidPhoneNumber(String phoneNumber) {
        return true;
    }

    @Override
    public boolean isValidCpf(String cpf) {
        return true;
    }

    @Override
    public boolean isValidName(String name) {
        return  true;
    }

    @Override
    public boolean isValidPassword(String password) {
        return true;
    }

    @Override
    public boolean isValidUsername(String username) {
        return true;
    }


}
