package br.edu.ifpr.cars.api;

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

import br.edu.ifpr.cars.domain.Passenger;
import br.edu.ifpr.cars.domain.PassengerRepository;


@Service
@RestController //indica que é um controlador rest
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE) //indica que o retorno é json
public class PassengerController {
    @Autowired //injeção de dependencia
    PassengerRepository passengerRepository; //objeto instancia do repositorio

    @GetMapping("/passenger")
    public List<Passenger> listPassengers() {
        return passengerRepository.findAll();
    }

    @GetMapping("/passenger/{id}")
    public Passenger findPassenger(@PathVariable("id") Long id) {
        return passengerRepository.findById(id).orElseThrow(
            () -> new  ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    @PostMapping("/passenger")
    public Passenger createPassenger(@RequestBody Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @PostMapping("/passenger{id}")
    public Passenger fullUpdatePassenger(@PathVariable("id") Long id, @RequestBody Passenger passenger) {
        Passenger foundDriver = findPassenger(id);
        foundDriver.setName(passenger.getName());
        foundDriver.setEmail(passenger.getEmail());
        return passengerRepository.save(foundDriver);
    }

    @PatchMapping("/passenger{id}")
    public Passenger incrementalUpdateDriver(@PathVariable("id") Long id, @RequestBody Passenger passenger) {
        Passenger foundDriver = findPassenger(id);

        foundDriver.setName(Optional.ofNullable(passenger.getName()).orElse(foundDriver.getName()));
        foundDriver.setEmail(Optional.ofNullable(passenger.getEmail()).orElse(foundDriver.getEmail()));

        return passengerRepository.save(foundDriver);
    }

    @DeleteMapping("/passenger/{id}")
    public void deletePassenger(@PathVariable("id") Long id) {
        passengerRepository.deleteById(id);
    }
}