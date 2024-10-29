package org.webflowClient.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonDeserialize
public class ProductDto {
    private int id;
    private String name;
    private int quantity;
    private double price;

}
