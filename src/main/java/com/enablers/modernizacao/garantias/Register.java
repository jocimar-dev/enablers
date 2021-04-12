package com.enablers.modernizacao.garantias;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.hibernate.validator.constraints.br.CPF;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;
    @CPF
    private String cpf;

    @Email
    private String email;

    @NotNull
    private String phone;

    public Register(String name,
                    String cpf,
                    String email,
                    String phone) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return new java.util.StringJoiner(", ", Register.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("cpf='" + cpf + "'")
                .add("email='" + email + "'")
                .add("phone='" + phone + "'")
                .toString();
    }

    public Long getId() {
        return id;
    }

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

    @Deprecated
    public Register() {

    }
}
