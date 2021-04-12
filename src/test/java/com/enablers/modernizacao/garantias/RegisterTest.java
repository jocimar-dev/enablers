package com.enablers.modernizacao.garantias;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.test.web.servlet.MockMvc;

public class RegisterTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @PersistenceContext
    private EntityManager em;
    @Test
    public void mustRegisterValidUser() throws Exception {
        RegisterRequest request = new RegisterRequest();

        String name = "Jhon";
        String cpf = "76573561031";
        String email = "teste@teste.com.br";
        String phone = "61991234567";
    }

}
