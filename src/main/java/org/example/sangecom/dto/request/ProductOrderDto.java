package org.example.sangecom.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.sangecom.entity.OrderAddress;
import org.example.sangecom.entity.Product;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link org.example.sangecom.entity.ProductOrder}
 */
@AllArgsConstructor
@Getter
public class ProductOrderDto implements Serializable {
    private final String orderId;
    private final LocalDate orderDate;
    private final Product product;
    private final Double price;
    private final Integer quantity;
    private final UserDto user;
    private final String status;
    private final String paymentType;
    private final OrderAddress orderAddress;
}