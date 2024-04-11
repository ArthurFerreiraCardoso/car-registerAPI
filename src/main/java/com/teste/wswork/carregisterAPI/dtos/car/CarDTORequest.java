package com.teste.wswork.carregisterAPI.dtos.car;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class CarDTORequest {
    @NotEmpty
    @JsonProperty("name")
    private String name;
    @NotEmpty
    @JsonProperty("modelId")
    private Long model;
    @NotEmpty
    @JsonProperty("year")
    private int year;
    @NotEmpty
    @JsonProperty("gas")
    private String gas;
    @NotEmpty
    @JsonProperty("numDoors")
    private int numDoors;
    @NotEmpty
    @JsonProperty("color")
    private String color;

}
