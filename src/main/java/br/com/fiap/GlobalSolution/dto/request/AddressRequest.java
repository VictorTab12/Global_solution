package br.com.fiap.GlobalSolution.dto.request;

public record AddressRequest(

        String cep,
        String street,
        String number,
        String complement,
        String neighborhood,
        String city,
        String state,
        AbstractRequest users

) {
}
