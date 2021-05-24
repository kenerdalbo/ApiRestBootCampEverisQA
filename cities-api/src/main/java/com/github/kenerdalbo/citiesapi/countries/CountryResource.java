package com.github.kenerdalbo.citiesapi.countries;

import com.github.kenerdalbo.citiesapi.countries.Country;
import com.github.kenerdalbo.citiesapi.countries.repository.CountryRepository;
import com.github.kenerdalbo.citiesapi.states.State;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryResource {


    private CountryRepository repository;

    public CountryResource(CountryRepository repository) {
        this.repository = repository;
    }
    @GetMapping
    public Page<Country> countries(Pageable page){
        return repository.findAll(page);
        
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Optional<Country> optional = repository.findById(id);

        if(optional.isPresent()){
            return ResponseEntity.ok().body(optional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/name={name}")
    public List<Country> byName(@PathVariable String name){
        return repository.byName(name.toUpperCase(Locale.ROOT));
    }
}
