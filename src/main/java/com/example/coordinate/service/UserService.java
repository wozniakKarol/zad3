package com.example.coordinate.service;


import com.example.coordinate.model.Coordinate;
import com.example.coordinate.model.User;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<User> storeUser(User user);

    Mono<ResponseEntity<Mono<User>>> updateCoordinate(String id, Coordinate coordinate);
}
