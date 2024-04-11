package com.teste.wswork.carregisterAPI.mapper;

import com.teste.wswork.carregisterAPI.dtos.model.ModelDTORequest;
import com.teste.wswork.carregisterAPI.dtos.model.ModelDTOResponse;
import com.teste.wswork.carregisterAPI.models.Brand;
import com.teste.wswork.carregisterAPI.models.Model;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IModelMapper {

    ModelDTOResponse toModelDTO(Model model);

    ModelDTORequest toModelDTORequest(Model model);

    List<ModelDTOResponse> listoModelDTOResponseList(List<Model> models);

    Model toModel(ModelDTORequest modelDTORequest);

    @Mappings({
            @Mapping(source = "brand", target = "brand"),
            @Mapping(source = "brand", target = "BrandId", qualifiedByName = "mapBrandToId")
    })

    default Long mapBrandToId(Brand brand) {
        return brand != null ? brand.getId() : null;
    }

    default Brand mapIdToBrand(Long id) {
        if (id == null) {
            return null;
        }
        Brand brand = new Brand();
        brand.setId(id);
        return brand;
    }

}
