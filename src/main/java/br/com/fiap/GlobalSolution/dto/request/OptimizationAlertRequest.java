package br.com.fiap.GlobalSolution.dto.request;

import java.time.LocalDate;

public record OptimizationAlertRequest(

        String type,
        LocalDate date,
        String description,
        AbstractRequest telephone
) {
}
