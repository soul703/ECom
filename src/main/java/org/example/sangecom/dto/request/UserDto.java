package org.example.sangecom.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link org.example.sangecom.entity.User}
 */
@AllArgsConstructor
@Getter
public class UserDto implements Serializable {
    private final String name;
    private final String mobileNumber;
    private final String email;
    private final String address;
    private final String city;
    private final String state;
    private final String pincode;
    private final String password;
    private final String profileImage;
    private final String role;
    private final Boolean isEnable;
    private final Boolean accountNonLocked;
    private final Integer failedAttempt;
    private final Date lockTime;
    private final String resetToken;
}