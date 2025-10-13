package br.edu.ifpr.cars.domain;

import java.time.LocalDate;

@Entity
@Data
public class Driver {
    Long id;
    String name;
    LocalDate birthDate;

}
