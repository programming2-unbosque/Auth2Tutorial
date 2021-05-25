package edu.unbosque.Auth2Tutorial.jpa.repositories;

import edu.unbosque.Auth2Tutorial.jpa.entities.UserApp;

import java.util.Optional;

public interface UserAppRepository {

    Optional<UserApp> findByUsername(String username);

    Optional<UserApp> save(UserApp user);

}
