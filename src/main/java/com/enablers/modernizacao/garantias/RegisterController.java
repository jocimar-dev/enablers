package com.enablers.modernizacao.garantias;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class RegisterController {

    @PersistenceContext
    private EntityManager manager;

    private final RegisterRepository repository;

    public RegisterController(RegisterRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/registry")
    public ResponseEntity<?> findById(@PathVariable long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok()
                        .body(record))
                .orElse(ResponseEntity.notFound()
                        .build());
    }
    @PostMapping("/registry")
    @Transactional
    public String create(@RequestBody @Valid RegisterRequest createRegister) {

        Register newRegister = createRegister.toRegister();
        manager.persist(newRegister);
        return newRegister.toString();

    }

    @DeleteMapping(path ={"/registry/{id}"})
    public ResponseEntity <?> delete(@PathVariable long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
