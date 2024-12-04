package com.fipe.project.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// quarta requisicao: todos os dados do veiculo

@JsonIgnoreProperties(ignoreUnknown = true)
public record VehicleData(@JsonAlias("TipoVeiculo")Integer type,
                          @JsonAlias("Valor")String price,
                          @JsonAlias("Marca")String brand,
                          @JsonAlias("Modelo")String model,
                          @JsonAlias("AnoModelo")Integer year,
                          @JsonAlias("Combustivel")String fuel,
                          @JsonAlias("MesReferencia")String referenceMonth) {
    @Override
    public String toString() {
        return "Tipo de Veículo: " + type
                + ", Valor: " + price
                + ", Marca: " + brand
                + ", Modelo: " + model
                + ", Ano de produção:  " + year
                + ", Tipo de combustível:  " + fuel
                + ", Modelo:  " + referenceMonth;

    }
}