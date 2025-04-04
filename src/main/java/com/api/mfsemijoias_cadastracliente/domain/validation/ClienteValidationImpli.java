package com.api.mfsemijoias_cadastracliente.domain.validation;

import com.api.mfsemijoias_cadastracliente.ports.in.ClienyeValidation;

import java.util.regex.Pattern;

public class ClienteValidationImpli  implements ClienyeValidation {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");


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

    @Override
    public boolean isValidAddress(String address) {
        return true;
    }
}
