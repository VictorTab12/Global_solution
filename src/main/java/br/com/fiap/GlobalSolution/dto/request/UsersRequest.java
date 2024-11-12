package br.com.fiap.GlobalSolution.dto.request;

public record UsersRequest(

        String username,
        String email,
        String password
) {
}
