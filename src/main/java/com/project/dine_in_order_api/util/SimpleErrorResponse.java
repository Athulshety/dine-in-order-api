package com.project.dine_in_order_api.util;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class SimpleErrorResponse {
    private String type;
    private int status;
    private String message;

}
