package org.example.sangecom.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * DTO for {@link org.example.sangecom.entity.Category}
 */
@AllArgsConstructor
@Getter
public class CategoryDto implements Serializable {
    private final String name;
    private final String imageName;
    private final Boolean isActive;
}