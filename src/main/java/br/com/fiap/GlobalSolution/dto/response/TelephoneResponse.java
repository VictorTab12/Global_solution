package br.com.fiap.GlobalSolution.dto.response;

import lombok.Builder;

@Builder
public record TelephoneResponse(

        Long id,
        String ddi,
        String ddd,
        String number,
        UsersResponse users
) {
}
