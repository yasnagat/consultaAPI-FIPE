package com.fipe.project.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// primeiro retorno da pesquisa, marcas e seus codigos de acordo com o veiculo escolhido

@JsonIgnoreProperties(ignoreUnknown = true)
public record VehicleBrand(@JsonAlias("codigo")String code, @JsonAlias("nome")String name) {

    @Override
    public String toString() {
        return "Código: " + code + ", Nome: " + name;
    }
}

