package com.teste.wswork.carregisterAPI.mapper;

import com.teste.wswork.carregisterAPI.dtos.brand.BrandDTORequest;
import com.teste.wswork.carregisterAPI.dtos.brand.BrandDTORequestID;
import com.teste.wswork.carregisterAPI.dtos.brand.BrandDTOResponse;
import com.teste.wswork.carregisterAPI.dtos.brand.BrandDTOResponseID;
import com.teste.wswork.carregisterAPI.models.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    BrandDTOResponseID toBrandDTO(Brand brand);

    BrandDTORequestID toBrandDTORequest(Brand brand);
    BrandDTORequest toBrandDTORequestUp(Brand brand);

    List<BrandDTOResponse> listoBrandDTOResponseList(List<Brand> brands);

    @Mapping(source = "brandName", target = "brandName")
    @Mapping(source = "id", target = "id")

    Brand toBrand(BrandDTORequestID brandDTORequestID);
    Brand toBrandUp(BrandDTORequest brandDTORequest);

}
