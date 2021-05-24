package com.github.kenerdalbo.citiesapi.states;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.xml.bind.SchemaOutputResolver;
import java.util.List;


public interface StateRepository extends JpaRepository<State, Long> {

    @Query(value = "SELECT * FROM estado WHERE UPPER(nome) like %:name%", nativeQuery = true)
    List<State> byName(@Param("name")String name);



}
