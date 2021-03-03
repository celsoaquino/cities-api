package com.celsoaquino.citiesapi.countries;

import com.celsoaquino.citiesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryController extends JpaRepository<Country, Long> {
}
