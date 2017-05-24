package com.dp.digip.models;

/**
 * Created by Nikos on 21/5/2017.
 */
import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface UserDAO extends CrudRepository<User, Long> {

    /**
     * Return the user having the passed email or null if no user is found.
     *
     * @param email the user email.
     */
    public User findByEmail(String email);

    // ------------------------
    // PUBLIC METHODS
    // ------------------------

    User user();

    User user(long id);

    User user(String email, String name);

    // Getter and setter methods

    long getId();

    void setId(long value);

    String getEmail();

    void setEmail(String value);

    String getName();

    void setName(String value);

}