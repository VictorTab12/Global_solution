package br.com.fiap.GlobalSolution.dto.request;

import java.time.LocalDate;

public record IncentiveScoreRequest(

        Integer point,
        Integer target,
        LocalDate date,
        AbstractRequest users
) {
}
