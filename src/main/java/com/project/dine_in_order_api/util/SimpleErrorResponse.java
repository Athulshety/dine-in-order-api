package com.project.dine_in_order_api.util;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class SimpleErrorResponse {
    private String type;
    private  int status;
    private String  message;
}
