package com.teste.wswork.carregisterAPI.service;

import com.teste.wswork.carregisterAPI.dtos.brand.BrandDTORequest;
import com.teste.wswork.carregisterAPI.dtos.brand.BrandDTORequestID;
import com.teste.wswork.carregisterAPI.dtos.brand.BrandDTOResponse;
import com.teste.wswork.carregisterAPI.dtos.brand.BrandDTOResponseID;
import com.teste.wswork.carregisterAPI.mapper.BrandMapper;
import com.teste.wswork.carregisterAPI.models.Brand;
import com.teste.wswork.carregisterAPI.repositories.BrandRepository;
import com.teste.wswork.carregisterAPI.validate.ValidateData;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {

    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private BrandRepository brandRepository;


    public List<BrandDTOResponse> findAll() {
        List<Brand> brands = brandRepository.findAll();
        return brandMapper.listoBrandDTOResponseList(brands);
    }

    public BrandDTOResponseID findById(Long id) throws NotFoundException {
        Optional<Brand> brandOptional = brandRepository.findById(id);
        if (brandOptional.isPresent()) {
            Brand brand = brandOptional.get();
            return brandMapper.toBrandDTO(brand);
        } else {
            throw new NotFoundException("Brand not found with ID: " + id);
        }
    }

    public Brand saveBrand(BrandDTORequestID brandDTORequestID) throws NotFoundException {
        Brand brand = brandMapper.toBrand(brandDTORequestID);
        brand.setId(ValidateData.validateIdBrand(brand.getId(), brandRepository));
        return brandRepository.save(brand);
    }

    public BrandDTORequest updateBrand(Long id, BrandDTORequest brandDTORequest) throws NotFoundException {
        Brand brandId = brandRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Brand not found with ID: " + id));

        Brand brandUpdate = brandMapper.toBrandUp(brandDTORequest);
        brandId.setBrandName(brandUpdate.getBrandName());
        brandRepository.save(brandId);

        return brandMapper.toBrandDTORequestUp(brandId);
    }

    public void delete(Long id) throws NotFoundException {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Brand not found with ID: " + id));
        brandRepository.delete(brand);
    }
}
