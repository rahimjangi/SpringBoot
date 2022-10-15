package com.raiseup.ConsumingRESTfulWebService.repository;

import com.raiseup.ConsumingRESTfulWebService.model.Greeting;
import org.springframework.data.repository.CrudRepository;

public interface GreetingRepository extends CrudRepository<Greeting,Long> {
}
