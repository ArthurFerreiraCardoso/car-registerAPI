package com.teste.wswork.carregisterAPI.controller;

import com.teste.wswork.carregisterAPI.dtos.brand.BrandDTORequest;
import com.teste.wswork.carregisterAPI.dtos.brand.BrandDTORequestID;
import com.teste.wswork.carregisterAPI.dtos.brand.BrandDTOResponse;
import com.teste.wswork.carregisterAPI.dtos.brand.BrandDTOResponseID;
import com.teste.wswork.carregisterAPI.service.BrandService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping(value = "/brand-list", produces = "application/json")
    public ResponseEntity<List<BrandDTOResponse>> findAll() {
        List<BrandDTOResponse> brandList = brandService.findAll();
        return ResponseEntity.ok().body(brandList);
    }

    @GetMapping(value = "/search-by-id/{id}", produces = "application/json")
    public ResponseEntity<BrandDTOResponseID> findById(@PathVariable Long id) throws NotFoundException {
        BrandDTOResponseID brandDTOId = brandService.findById(id);

        if ( brandDTOId != null) {
            return ResponseEntity.status(HttpStatus.OK).body( brandDTOId);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping(value = "/save-brand", produces = "application/json")
    public ResponseEntity<BrandDTORequestID> saveBrand(@RequestBody BrandDTORequestID brandDTORequestID) {
        try {
            brandService.saveBrand(brandDTORequestID);
            return ResponseEntity.status(HttpStatus.CREATED).body(brandDTORequestID);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(brandDTORequestID);
        }
    }

    @PutMapping(value = "/update-brand/{id}", produces = "application/json")
    public ResponseEntity<BrandDTORequest> updateBrand(@PathVariable Long id, @RequestBody BrandDTORequest brandDTORequest) {
        try {
            brandService.updateBrand(id, brandDTORequest);
            return ResponseEntity.status(HttpStatus.OK).body(brandDTORequest);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @DeleteMapping(value = "/delete-brand/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws NotFoundException {
        brandService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}

