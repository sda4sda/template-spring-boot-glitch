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
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

		Long count = counter.incrementAndGet();
		String message = String.format(template, name);

		return new Greeting(count, message);
	}

	@GetMapping("/mono-greeting")
	public Mono<Greeting> monoGreeting(@RequestParam(value = "name", defaultValue = "World") String name) {

		Long count = counter.incrementAndGet();
		String message = String.format(template, name);

		return Mono.just(new Greeting(count, message));
	}
}
