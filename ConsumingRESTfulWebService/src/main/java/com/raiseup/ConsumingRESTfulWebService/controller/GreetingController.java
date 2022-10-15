package com.raiseup.ConsumingRESTfulWebService.controller;

import com.raiseup.ConsumingRESTfulWebService.domain.Greeting;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/greeting")
public class GreetingController {
    private final RestTemplate restTemplate;

    @RequestMapping("/")
    public ResponseEntity<List<Greeting>> getGreetings() {
        Greeting[] greetings = restTemplate.getForObject(
                "http://localhost:8181/greeting/",
                Greeting[].class
        );

        return new ResponseEntity<>(Arrays.stream(greetings).toList(), HttpStatus.OK);
    }

    @RequestMapping("/{id}")
    public ResponseEntity<Greeting> getGreeting(@PathVariable Long id) {
        Greeting greeting = restTemplate.getForObject(
                "http://localhost:8181/greeting/" + id,
                Greeting.class
        );
        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<Greeting>saveGreeting(@RequestBody Greeting greeting){
        ResponseEntity<Greeting> response = restTemplate.postForEntity(
                "http://localhost:8181/greeting/",
                greeting,
                Greeting.class
        );
        log.info("Post entity: {}",response);
        return response;
    }
}
