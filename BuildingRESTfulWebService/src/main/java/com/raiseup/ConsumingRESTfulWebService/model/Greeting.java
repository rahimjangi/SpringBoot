package com.raiseup.ConsumingRESTfulWebService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Greeting {
    @Id
    @GeneratedValue(generator = "greeting_seq",strategy = GenerationType.SEQUENCE)
    private Long id;
    private String content;
}
