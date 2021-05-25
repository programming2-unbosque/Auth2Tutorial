package edu.unbosque.Auth2Tutorial.jpa.repositories;

import edu.unbosque.Auth2Tutorial.jpa.entities.UserApp;

import javax.persistence.EntityManager;
import java.util.Optional;

public class UserAppRepositoryImpl implements UserAppRepository {

    private EntityManager entityManager;

    public UserAppRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<UserApp> findByUsername(String username) {
        UserApp user = entityManager.find(UserApp.class, username);
        return user != null ? Optional.of(user) : Optional.empty();
    }

    @Override
    public Optional<UserApp> save(UserApp user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            return Optional.of(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

}
