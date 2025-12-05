package br.edu.ifpr.cars.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.edu.ifpr.cars.domain.Driver;
import br.edu.ifpr.cars.domain.DriverRepository;
import jakarta.validation.Valid;

@Service
@RestController //indica que é um controlador rest
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE) //indica que o retorno é json
public class DriverController {
    @Autowired //injeção de dependencia
    DriverRepository driverRepository; //objeto instancia do repositorio

    @GetMapping("/drivers")
    public List<Driver> listDrivers() {
        return driverRepository.findAll();
    }

    @GetMapping("/drivers/{id}")
    public Driver findDrivers(@PathVariable("id") Long id) {
        return driverRepository.findById(id).orElseThrow(
            () -> new  ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    @PostMapping("/drivers")
    public Driver createDriver(@RequestBody @Valid Driver driver) {
        return driverRepository.save(driver);
    }

    @PostMapping("/drivers/{id}")
    public Driver fullUpdateDriver(@PathVariable("id") Long id, @RequestBody Driver driver) {
        Driver foundDriver = findDrivers(id);
        foundDriver.setName(driver.getName());
        foundDriver.setBirthDate(driver.getBirthDate());
        foundDriver.setEmail(driver.getEmail());
        foundDriver.setCpf(driver.getCpf());
        return driverRepository.save(foundDriver);
    }

    @PatchMapping("/drivers/{id}")
    public Driver incrementalUpdateDriver(@PathVariable("id") Long id, @RequestBody Driver driver) {
        Driver foundDriver = findDrivers(id);

        foundDriver.setName(Optional.ofNullable(driver.getName()).orElse((foundDriver.getName())));
        foundDriver.setBirthDate(Optional.ofNullable(driver.getBirthDate()).orElse((foundDriver.getBirthDate())));
        foundDriver.setEmail(Optional.ofNullable(driver.getEmail()).orElse((foundDriver.getEmail())));
        foundDriver.setCpf(Optional.ofNullable(driver.getCpf()).orElse((foundDriver.getCpf())));

        return driverRepository.save(foundDriver);
    }

    @DeleteMapping("/drivers/{id}")
    public void deleteDriver(@PathVariable("id") Long id) {
        driverRepository.deleteById(id);
    }
}
