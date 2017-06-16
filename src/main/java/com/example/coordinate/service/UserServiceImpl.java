package com.example.coordinate.service;

import com.example.coordinate.repository.UserRepository;
import com.example.coordinate.model.Coordinate;
import com.example.coordinate.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    private final static Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<User> storeUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<ResponseEntity<Mono<User>>> updateCoordinate(String id, Coordinate coordinate) {

        return userRepository.findById(id)
                .map(u -> {
                    LOG.info(u.toString());
                    u.addCoordinate(coordinate);
                    LOG.info(u.toString());
                    return userRepository.save(u);
                })
                .map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.status(404).body(null));

    }
}
