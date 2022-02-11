package org.sda4sda.beliefs.svc;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Mono<Greeting> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return Mono.just(new Greeting(counter.incrementAndGet(), String.format(template, name)));
	}
}