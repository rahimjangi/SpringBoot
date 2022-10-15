package com.raiseup.ConsumingRESTfulWebService.service;

import com.raiseup.ConsumingRESTfulWebService.model.Greeting;
import com.raiseup.ConsumingRESTfulWebService.repository.GreetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GreetingService {
    private final GreetingRepository greetingRepository;


    public Greeting getGreeting(Long id) {

        return greetingRepository.findById(id).orElse(new Greeting());
    }

    public Greeting save(Greeting greeting) {
        return greetingRepository.save(greeting);
    }

    public Iterable<Greeting> getGreetings() {
        return greetingRepository.findAll();
    }
}
