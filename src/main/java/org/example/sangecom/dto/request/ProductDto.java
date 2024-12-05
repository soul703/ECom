package org.example.sangecom.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * DTO for {@link org.example.sangecom.entity.Product}
 */
@AllArgsConstructor
@Getter
public class ProductDto implements Serializable {
    private final String title;
    private final String description;
    private final String category;
    private final Double price;
    private final int stock;
    private final String image;
    private final int discount;
    private final Double discountPrice;
    private final Boolean isActive;
}