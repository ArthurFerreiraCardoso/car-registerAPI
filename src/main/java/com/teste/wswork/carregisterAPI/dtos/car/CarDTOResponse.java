package com.teste.wswork.carregisterAPI.dtos.car;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTOResponse {

    @JsonProperty("modelId")
    private Long model;

    @JsonProperty("name")
    private String name;

    @JsonProperty("year")
    private int year;

    @JsonProperty("gas")
    private String gas;

    @JsonProperty("numDoors")
    private int numDoors;

    @JsonProperty("color")
    private String color;
}
