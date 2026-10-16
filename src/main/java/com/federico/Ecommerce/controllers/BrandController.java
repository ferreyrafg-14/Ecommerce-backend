package com.federico.Ecommerce.controllers;

import com.federico.Ecommerce.dto.request.brand.BrandRequestDto;
import com.federico.Ecommerce.dto.response.brand.BrandResponseDto;
import com.federico.Ecommerce.services.BrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/brands")
public class BrandController {
    private final BrandService brandService;

    public  BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping
    public ResponseEntity<BrandResponseDto> addBrand(@RequestBody BrandRequestDto dto){
        BrandResponseDto response = brandService.addBrand(dto);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<BrandResponseDto> getBrandById(@PathVariable Integer id) {
        BrandResponseDto response = brandService.getBrandById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<BrandResponseDto>> getAllBrands() {
        List<BrandResponseDto> response = brandService.getAllBrands();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BrandResponseDto> updateBrand(@PathVariable Integer id,
                                                        @RequestBody BrandRequestDto dto) {
        BrandResponseDto response = brandService.updateBrand(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BrandResponseDto> deleteBrandById(@PathVariable Integer id) {
        BrandResponseDto response = brandService.deleteBrandById(id);
        return ResponseEntity.ok(response);
    }
}
