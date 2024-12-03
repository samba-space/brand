package com.anysinsa.brand.presentation.api;

import java.util.List;

import com.anysinsa.brand.application.dto.BrandResponseDTO;
import io.micrometer.observation.annotation.Observed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.anysinsa.brand.application.BrandService;
import com.anysinsa.brand.domain.Brand;

@Observed
@RestController
public class BrandController {

    private static final Logger logger = LoggerFactory.getLogger(BrandController.class);

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping(path = "/api/v1/brands")
    public ResponseEntity<List<Brand>> findBrands() {
        logger.info("findBrands");
        return ResponseEntity.ok().body(brandService.findBrands());
    }

    @GetMapping(path = "/api/v1/brands/{id}")
    public ResponseEntity<BrandResponseDTO> findBrandById(@PathVariable Long id) {
        logger.info("findBrandById::{}", id);
        return ResponseEntity.ok().body(brandService.findBrandById(id));
    }

    @GetMapping(path = "/api/v1/brands/health")
    public String health() {
        return "brand-health";
    }
}
