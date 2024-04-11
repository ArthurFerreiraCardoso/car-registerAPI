package com.teste.wswork.carregisterAPI.dtos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.teste.wswork.carregisterAPI.models.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelDTOResponse {

    @JsonProperty("brandId")
    private Brand brand;

    @JsonProperty("name")
    private String name;

    @JsonProperty("fipe_value")
    private Double fipeValue;
}
