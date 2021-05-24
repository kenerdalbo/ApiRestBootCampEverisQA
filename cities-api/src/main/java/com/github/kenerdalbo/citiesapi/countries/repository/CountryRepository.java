package com.github.kenerdalbo.citiesapi.countries.repository;

import com.github.kenerdalbo.citiesapi.countries.Country;
import com.github.kenerdalbo.citiesapi.states.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country,Long> {

    @Query(value = "SELECT * FROM pais WHERE UPPER(nome) like %:name%", nativeQuery = true)
    List<Country> byName(@Param("name")String name);
}
