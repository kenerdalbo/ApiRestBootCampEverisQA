package com.github.kenerdalbo.citiesapi.states;




import java.util.List;
import java.util.Locale;
import java.util.Optional;

import com.github.kenerdalbo.citiesapi.countries.Country;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/states")
public class StateResource {

    private final StateRepository repository;

    public StateResource(final StateRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<State> states() {
        return repository.findAll();
    }

    @GetMapping("/id={id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Optional<State> optional = repository.findById(id);

        if(optional.isPresent()){
            return ResponseEntity.ok().body(optional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/name={name}")
    public List<State> byName(@PathVariable String name){
        return repository.byName(name.toUpperCase(Locale.ROOT));
    }

}