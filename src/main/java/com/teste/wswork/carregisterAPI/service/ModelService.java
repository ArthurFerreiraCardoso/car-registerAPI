package com.teste.wswork.carregisterAPI.service;

import com.teste.wswork.carregisterAPI.dtos.model.ModelDTORequest;
import com.teste.wswork.carregisterAPI.dtos.model.ModelDTOResponse;
import com.teste.wswork.carregisterAPI.mapper.IModelMapper;
import com.teste.wswork.carregisterAPI.models.Model;
import com.teste.wswork.carregisterAPI.repositories.BrandRepository;
import com.teste.wswork.carregisterAPI.repositories.ModelRepository;
import com.teste.wswork.carregisterAPI.validate.ValidateData;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelService {

    @Autowired
    private IModelMapper IModelMapper;
    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private BrandRepository brandRepository;


    public List<ModelDTOResponse> findAll() {
        List<Model> models = modelRepository.findAll();
        return IModelMapper.listoModelDTOResponseList(models);
    }

    public ModelDTOResponse findById(Long id) throws NotFoundException {
        Optional<Model> modelOptional = modelRepository.findById(id);
        if (modelOptional.isPresent()) {
            Model model = modelOptional.get();
            return IModelMapper.toModelDTO(model);
        } else {
            throw new NotFoundException("Model not found with ID: " + id);
        }
    }

    public Model saveModel(ModelDTORequest modelDTORequest) throws NotFoundException {
        Model model = IModelMapper.toModel(modelDTORequest);
        model.setBrand(ValidateData.validateBrand(modelDTORequest.getBrand(), brandRepository));
        return modelRepository.save(model);
    }

    public ModelDTORequest updateModel(Long id, ModelDTORequest modelDTORequest) throws NotFoundException {
        Model modelId = modelRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Model not found with ID: " + id));

        Model modelUpdate = IModelMapper.toModel(modelDTORequest);
        modelId.setBrand(modelUpdate.getBrand());
        modelId.setName(modelUpdate.getName());
        modelId.setFipeValue(modelUpdate.getFipeValue());
        modelRepository.save(modelId);

        return IModelMapper.toModelDTORequest(modelId);
    }

    public void delete(Long id) throws NotFoundException {
        Model model = modelRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Model not found with ID: " + id));
        modelRepository.delete(model);
    }
}
