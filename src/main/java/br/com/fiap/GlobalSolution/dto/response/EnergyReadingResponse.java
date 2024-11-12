package br.com.fiap.GlobalSolution.dto.response;

import lombok.Builder;

import java.time.LocalDate;
import java.util.Collection;

@Builder
public record EnergyReadingResponse(

        Long id,
        LocalDate date,
        String consumption,
        String production,
        Collection<DeviceResponse> device
) {
}
