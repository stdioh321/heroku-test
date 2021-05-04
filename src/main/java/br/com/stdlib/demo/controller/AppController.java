package br.com.stdlib.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Profile("dev")
public class AppController {

    @Value("${prof}")
    private String profMsg;

    @Autowired
    private ResourceLoader resourceLoader;


    @GetMapping(path = {"/"})
    public ResponseEntity get() throws IOException {
        String msg = profMsg;
        return ResponseEntity.ok(msg);
    }

}
@RestController
@Profile("default")
class AppDefaultController {
    @Value("${prof}")
    private String profMsg;

    @GetMapping(path = {"/"})
    public ResponseEntity get() throws IOException {
        return ResponseEntity.ok(profMsg);
    }

}
