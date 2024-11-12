package br.com.fiap.GlobalSolution.dto.request;

import java.time.LocalDate;

public record EnergyReadingRequest(

        LocalDate date,
        String consumption,
        String production

) {
}
