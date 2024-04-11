package com.teste.wswork.carregisterAPI.dtos.brand;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandDTOResponse {

    @JsonProperty("brandName")
    private String brandName;

}
