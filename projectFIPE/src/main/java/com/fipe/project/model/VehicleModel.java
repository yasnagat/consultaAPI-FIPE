package com.fipe.project.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

// segundo tipo de informacao da pesquisa: modelo do veiculo escolhido

@JsonIgnoreProperties(ignoreUnknown = true)
public record VehicleModel(List<VehicleBrand> modelos) {

}