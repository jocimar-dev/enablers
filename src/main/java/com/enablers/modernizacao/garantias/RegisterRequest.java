package com.enablers.modernizacao.garantias;

import org.hibernate.validator.constraints.br.CPF;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class RegisterRequest {
    @NotNull
    private String name;

    @CPF
    private String cpf;

    @Email
    private String email;

    @NotNull
    private String phone;

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Register toRegister() {
        return new Register(name, cpf, email, phone);
    }
}
