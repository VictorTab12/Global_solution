package br.com.fiap.GlobalSolution.dto.request;

public record TelephoneRequest(

        String ddi,
        String ddd,
        String number,
        AbstractRequest users
) {
}
