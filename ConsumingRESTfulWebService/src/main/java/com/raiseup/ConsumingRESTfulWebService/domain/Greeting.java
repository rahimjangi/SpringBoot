package com.raiseup.ConsumingRESTfulWebService.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Greeting {
    private Long id;
    @JsonProperty(value = "content")
    private String myContent;
}
