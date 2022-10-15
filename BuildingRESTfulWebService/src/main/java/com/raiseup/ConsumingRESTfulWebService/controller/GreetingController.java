package com.raiseup.ConsumingRESTfulWebService.controller;

import com.raiseup.ConsumingRESTfulWebService.dto.GreetingResponse;
import com.raiseup.ConsumingRESTfulWebService.model.Greeting;
import com.raiseup.ConsumingRESTfulWebService.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/greeting")
@RequiredArgsConstructor
public class GreetingController {
    private final GreetingService greetingService;

    @RequestMapping("/")
    public ResponseEntity<List<Greeting>>getGreetings(){
        Iterable<Greeting> iterable = greetingService.getGreetings();
        List<Greeting> greetings= new ArrayList<>();
        iterable.forEach(greetings::add);
        return new ResponseEntity<>(greetings,HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<GreetingResponse> getGreetingName(@PathVariable Long id, @RequestParam(name="name",required = false)String name){
        Greeting greeting = greetingService.getGreeting(id);
        GreetingResponse greetingResponse = GreetingResponse.builder()
                .content(greeting.getContent())
                .name(name)
                .id(greeting.getId())
                .build();
        if(name==null){
            greetingResponse.setName("guest");
        }
        return new ResponseEntity<>(greetingResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<Greeting> createGreeting(@RequestBody Greeting greeting){
        Greeting savedGreeting = greetingService.save(greeting);
        return new ResponseEntity<>(savedGreeting,HttpStatus.ACCEPTED);
    }

}
