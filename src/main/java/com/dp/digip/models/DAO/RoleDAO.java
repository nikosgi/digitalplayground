package com.dp.digip.models.DAO;

/**
 * Created by Nikos on 21/5/2017.
 */
import javax.transaction.Transactional;

import com.dp.digip.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface RoleDAO extends CrudRepository<Role, Long> {

}
