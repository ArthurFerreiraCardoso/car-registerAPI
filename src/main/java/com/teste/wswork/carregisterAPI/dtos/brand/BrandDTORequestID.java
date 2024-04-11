package com.teste.wswork.carregisterAPI.dtos.brand;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class BrandDTORequestID {
    @NotEmpty
    @JsonProperty("id")
    private Long id;
    @NotEmpty
    @JsonProperty("brandName")
    private String brandName;
}
