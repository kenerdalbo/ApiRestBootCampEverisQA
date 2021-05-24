package com.github.kenerdalbo.citiesapi.countries.repository;

import com.github.kenerdalbo.citiesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {
}
