package com.anysinsa.brand.application;

import java.util.List;

import com.anysinsa.brand.application.dto.BrandResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anysinsa.brand.application.exception.AlreadyBrandNameException;
import com.anysinsa.brand.domain.Brand;
import com.anysinsa.brand.domain.BrandRepository;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> findBrands() {
        return brandRepository.findAll();
    }

    public BrandResponseDTO findBrandById(Long id) {
        Brand findBrand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("브랜드를 찾을 수 없습니다."));
        return new BrandResponseDTO(findBrand.getId(), findBrand.getName());
    }
}
