package com.raiseup.ConsumingRESTfulWebService.dto;


import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GreetingResponse {

    private Long id;
    private String name;
    private String content;

}
