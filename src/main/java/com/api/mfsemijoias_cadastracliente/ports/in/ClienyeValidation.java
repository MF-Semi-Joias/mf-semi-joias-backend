package com.api.mfsemijoias_cadastracliente.ports.in;

public interface ClienyeValidation {

    boolean isValidEmail(String email);

    boolean isValidPhoneNumber(String phoneNumber);

    boolean isValidCpf(String cpf);

    boolean isValidName(String name);

    boolean isValidPassword(String password);

    boolean isValidUsername(String username);

}
