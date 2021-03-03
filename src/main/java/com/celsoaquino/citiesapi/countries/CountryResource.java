package com.celsoaquino.citiesapi.countries;

import com.celsoaquino.citiesapi.countries.Country;
import com.celsoaquino.citiesapi.countries.CountryController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryResource {


    private final CountryController countryController;

    public CountryResource(CountryController countryController) {
        this.countryController = countryController;
    }

    @GetMapping
    public Page<Country> countries(Pageable page) {
        return countryController.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getOne(@PathVariable Long id) {
        Optional<Country> optional = countryController.findById(id);
        return optional.map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
