package br.edu.ifpr.cars.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotBlank(message = "Digite o seu nome")
    @Valid
    @Size(min = 2, max=50, message = "Tamanho deve ser entre 3 e 50 caracteres")
    @Pattern(regexp = "^[^\\s]+$", message = "O nome não pode conter espaços.")
    String name;
    LocalDate birthDate;
    @NotBlank(message = "Digite o seu email")
    @Valid
    @Pattern(regexp = "^[^\\s]+$", message = "O email não pode conter espaços.")
    String email;
    @NotBlank(message = "Digite o seu cpf")
    @Valid
    @Pattern(
        regexp = "^(\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2})$",
        message = "O CPF deve estar no formato 000.000.000-00."
    )
    String cpf;
}
