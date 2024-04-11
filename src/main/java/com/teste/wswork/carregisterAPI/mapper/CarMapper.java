package com.teste.wswork.carregisterAPI.mapper;

import com.teste.wswork.carregisterAPI.dtos.car.CarDTORequest;
import com.teste.wswork.carregisterAPI.dtos.car.CarDTOResponse;
import com.teste.wswork.carregisterAPI.models.Car;
import com.teste.wswork.carregisterAPI.models.Model;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarDTOResponse toCarDTO(Car car);

    CarDTORequest toCarDTORequest(Car car);

    List<CarDTOResponse> listToCarDTOResponseList(List<Car> carList);

    Car toCar(CarDTORequest carDTORequest);

    @Mappings({
            @Mapping(source = "model", target = "model"),
            @Mapping(source = "model", target = "modelId", qualifiedByName = "mapModelToId")
    })

    default Long mapModelToId(Model model) {
        return model != null ? model.getId() : null;
    }

    default Model mapIdToModel(Long id) {
        if (id == null) {
            return null;
        }
        Model model = new Model();
        model.setId(id);
        return model;
    }
}
