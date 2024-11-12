package br.com.fiap.GlobalSolution.dto.request;

public record DeviceRequest(

        String type,
        String name,
        String status,
        AbstractRequest users
) {
}
