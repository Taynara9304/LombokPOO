package br.edu.ifpr.cars.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotBlank(message = "Digite o seu nome")
    @Valid
    String name;
    LocalDate birthDate;
    @NotBlank(message = "Digite o seu email")
    @Valid
    String email;
    @NotBlank(message = "Digite o seu cpf")
    @Valid
    String cpf;
}
