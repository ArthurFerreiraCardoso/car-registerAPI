package com.teste.wswork.carregisterAPI.controller;

import com.teste.wswork.carregisterAPI.dtos.model.ModelDTORequest;
import com.teste.wswork.carregisterAPI.dtos.model.ModelDTOResponse;
import com.teste.wswork.carregisterAPI.service.ModelService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/model")
public class ModelController {

    @Autowired
    private ModelService modelService;


    @GetMapping(value = "/model-list", produces = "application/json")
    public ResponseEntity<List<ModelDTOResponse>> findAll() {
        List<ModelDTOResponse> modelList = modelService.findAll();
        return ResponseEntity.ok().body(modelList);
    }

    @GetMapping(value = "/search-by-id/{id}", produces = "application/json")
    public ResponseEntity<ModelDTOResponse> findById(@PathVariable Long id) throws NotFoundException {
        ModelDTOResponse modelDTO = modelService.findById(id);

        if (modelDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(modelDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping(value = "/save-model", produces = "application/json")
    public ResponseEntity<ModelDTORequest> saveModel(@RequestBody ModelDTORequest modelDTORequest) {
        try {
            modelService.saveModel(modelDTORequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(modelDTORequest);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(modelDTORequest);
        }
    }

    @PutMapping(value = "/update-model/{id}", produces = "application/json")
    public ResponseEntity<ModelDTORequest> updateModel(@PathVariable Long id, @RequestBody ModelDTORequest modelDTORequest) {
        try {
            modelService.updateModel(id, modelDTORequest);
            return ResponseEntity.status(HttpStatus.OK).body(modelDTORequest);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @DeleteMapping(value = "/delete-model/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws NotFoundException {
        modelService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
