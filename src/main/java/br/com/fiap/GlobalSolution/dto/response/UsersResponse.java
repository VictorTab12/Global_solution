package br.com.fiap.GlobalSolution.dto.response;

import lombok.Builder;

@Builder
public record UsersResponse(

        Long id,
        String username,
        String email,
        String password
) {
}
