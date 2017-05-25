package com.dp.digip.models.DAO;

/**
 * Created by Nikos on 21/5/2017.
 */
import javax.transaction.Transactional;

import com.dp.digip.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface UserDAO extends CrudRepository<User, Long> {

    /**
     * Return the user having the passed email or null if no user is found.
     */

//    User user(String username, String pass_hash, String salt, Integer type_user);
//
//    //GETTERS
//
//    long getId();
//    String getUsername();
//    String getPass_hash();
//    Integer getType_user();
//    String getSalt();
//
//    //SETTERS
//    void setId(long value);
//    void setUsername(String value);
//    void setPass_hash();
//    void setType_user();
//    void setSalt();


}