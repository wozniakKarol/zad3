package com.example.coordinate.controller;


import com.example.coordinate.model.Coordinate;
import com.example.coordinate.model.User;
import com.example.coordinate.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
public class UserController {

    private final static Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping(path = "user/coordinate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<User> addUser(@Valid @RequestBody User user) {
        LOG.info("Received start");
        try {
            return userService.storeUser(user);
        } finally {
            LOG.info("Request end");
        }
    }

    @PutMapping(path = "user/coordinate/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Mono<User>>> updateUserCoordinate(@PathVariable final String id, @RequestBody Coordinate coordinate) {
        LOG.info("Received start");
        try {
            LOG.info(id.toString() + coordinate.toString());
            return userService.updateCoordinate(id, coordinate);
        } finally {
            LOG.info("Request end");
        }
    }

}
