package com.teste.wswork.carregisterAPI.validate;

import com.teste.wswork.carregisterAPI.models.Brand;
import com.teste.wswork.carregisterAPI.models.Model;
import com.teste.wswork.carregisterAPI.repositories.BrandRepository;
import com.teste.wswork.carregisterAPI.repositories.ModelRepository;
import javassist.NotFoundException;

import java.util.Objects;
import java.util.Optional;

public final class ValidateData {

    private ValidateData() {
    }

    public static Model validateModel(Long modelId, ModelRepository modelRepository) throws NotFoundException {
        try {
            if (Objects.isNull(modelId) || modelId == 0) {
                Model newModel = new Model();
                return modelRepository.save(newModel);
            } else {
                Optional<Model> optionalModel = modelRepository.findById(modelId);
                if (optionalModel.isPresent()) {
                    return optionalModel.get();
                } else {
                    throw new NotFoundException("Model not found with id: " + modelId);
                }
            }
        } catch (Exception e) {
            throw new NotFoundException("Error validating model: " + e.getMessage());
        }
    }


    public static Brand validateBrand(Long brand, BrandRepository brandRepository) throws NotFoundException {
        try {
            if (Objects.isNull(brand) || brand == 0) {
                Brand newBrand = new Brand();
                return brandRepository.save(newBrand);
            } else {
                Optional<Brand> optionalBrand = brandRepository.findById(brand);
                if (optionalBrand.isPresent()) {
                    return optionalBrand.get();
                } else {
                    throw new NotFoundException("Brand not found with id: " + brand);
                }
            }
        } catch (Exception e) {
            throw new NotFoundException("Error validating brand: " + e.getMessage());
        }
    }

    public static Long validateIdBrand(Long id, BrandRepository brandRepository) throws NotFoundException {
        try {
            if (Objects.isNull(id) || id == 0) {
                Brand newBrand = new Brand();
                return brandRepository.save(newBrand).getId();
            } else {
                Optional<Brand> optionalBrand = brandRepository.findById(id);
                if (optionalBrand.isPresent()) {
                    return optionalBrand.get().getId();
                } else {
                    throw new NotFoundException("Brand not found with id: " + id);
                }
            }
        } catch (Exception e) {
            throw new NotFoundException("Error validating brand: " + e.getMessage());
        }
    }
}
