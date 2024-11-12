package br.com.fiap.GlobalSolution.dto.response;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record IncentiveScoreResponse(

        Long id,
        Integer point,
        Integer target,
        LocalDate date,
        UsersResponse users
) {
}
