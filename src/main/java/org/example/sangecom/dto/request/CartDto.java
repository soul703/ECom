package org.example.sangecom.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.sangecom.entity.Product;

import java.io.Serializable;

/**
 * DTO for {@link org.example.sangecom.entity.Cart}
 */
@AllArgsConstructor
@Getter
public class CartDto implements Serializable {
    private final UserDto user;
    private final Product product;
    private final Integer quantity;
}