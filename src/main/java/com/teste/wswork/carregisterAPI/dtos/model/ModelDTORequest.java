package com.teste.wswork.carregisterAPI.dtos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class ModelDTORequest {
    @NotEmpty
    @JsonProperty("brandId")
    private Long brand;
    @NotEmpty
    @JsonProperty("name")
    private String name;
    @NotEmpty
    @JsonProperty("fipe_value")
    private Double fipeValue;
}
