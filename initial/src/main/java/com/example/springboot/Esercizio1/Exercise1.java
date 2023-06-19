package com.example.springboot.Esercizio1;

import com.sun.net.httpserver.Authenticator;
import jdk.jshell.Snippet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Random;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@RestController
public class Exercise1 {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/greeting")
    ResponseEntity<String> greeting(){
        return ResponseEntity.status(HttpStatus.OK).body("Good Afternoon!");
    }

    @RestController
    public class parteTre{
        @GetMapping("/info")
        ResponseEntity<String> info(){
            return ResponseEntity.ok().build();
        }
    }

    @RestController
    public class random{
        @GetMapping("/random")
        ResponseEntity<Objects> random1() {
            boolean random = new Random().nextBoolean();
            if (random) {
                return new ResponseEntity<Objects>(OK);
            } else {
                return new ResponseEntity<Objects>(BAD_REQUEST);
            }
        }
    }
}
