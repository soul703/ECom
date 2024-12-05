package org.example.sangecom.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * DTO for {@link org.example.sangecom.entity.OrderRequest}
 */
@AllArgsConstructor
@Getter
public class OrderRequestDto implements Serializable {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String mobileNo;
    private final String address;
    private final String city;
    private final String state;
    private final String pincode;
    private final String paymentType;
}