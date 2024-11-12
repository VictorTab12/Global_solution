package br.com.fiap.GlobalSolution.dto.response;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record OptimizationAlertResponse(

        Long id,
        String type,
        LocalDate date,
        String description,
        TelephoneResponse telephone
) {
}
