package com.anysinsa.brand.application.dto;

import jakarta.validation.constraints.NotBlank;

import com.anysinsa.brand.domain.Brand;

public record BrandSaveRequest(@NotBlank String brandName) {
    public Brand toBrand() {
        return new Brand(brandName);
    }
}
