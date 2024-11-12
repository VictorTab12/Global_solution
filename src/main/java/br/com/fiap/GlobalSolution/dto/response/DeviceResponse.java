package br.com.fiap.GlobalSolution.dto.response;

import lombok.Builder;

@Builder
public record DeviceResponse(

        Long id,
        String type,
        String name,
        String status,
        UsersResponse users
) {
}
