package com.anysinsa.brand.presentation.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anysinsa.brand.application.BrandService;
import com.anysinsa.brand.domain.Brand;

@RestController
public class BrandController {
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping(path = "/api/v1/brands")
    public ResponseEntity<List<Brand>> findBrands() {
        return ResponseEntity.ok().body(brandService.findBrands());
    }
}
