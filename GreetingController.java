package com.example.demo; /**
 * Created by Bryan on 7/12/2017.
 */
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/greeting")
    public Greeting greeting(@RequestParam(required=false, defaultValue="World") String name) {
        System.out.println(name);
        Greeting g = new Greeting(counter.incrementAndGet(), String.format(template,name));
        System.out.println("==== in greeting ===="+"   hello, "+g.getContent());
        return g;
    }

}