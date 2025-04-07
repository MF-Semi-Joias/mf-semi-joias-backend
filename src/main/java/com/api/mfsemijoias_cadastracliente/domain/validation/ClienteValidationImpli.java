package com.api.mfsemijoias_cadastracliente.domain.validation;

import com.api.mfsemijoias_cadastracliente.ports.in.ClienteValidation;

import java.util.regex.Pattern;

public class ClienteValidationImpli implements ClienteValidation {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^(\\+\\d{1,3}[- ]?)?\\d{10}$");
    private static final Pattern CPF_PATTERN = Pattern.compile("^(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{11})$");
    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-zÀ-ÿ\\s]+$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
    private static final Pattern USERNAME_PATTERN = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)[A-Za-z\\d]{6,}$");

    @Override
    public boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    @Override
    public boolean isValidPhoneNumber(String phoneNumber) {
        return PHONE_PATTERN.matcher(phoneNumber).matches();
    }

    @Override
    public boolean isValidCpf(String cpf) {
        return CPF_PATTERN.matcher(cpf).matches();
    }

    @Override
    public boolean isValidName(String name) {
        return NAME_PATTERN.matcher(name).matches();
    }

    @Override
    public boolean isValidPassword(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    @Override
    public boolean isValidUsername(String username) {
        return USERNAME_PATTERN.matcher(username).matches();
    }
}