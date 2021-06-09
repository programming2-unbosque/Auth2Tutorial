package edu.unbosque.Auth2Tutorial.jpa.repositories;

import edu.unbosque.Auth2Tutorial.jpa.entities.Owner;

import java.util.Optional;

public interface OwnerRepository {

    Optional<Owner> save(Owner owner);
}
