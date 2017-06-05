package com.dp.digip.models.DAO;

import com.dp.digip.models.Parent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Blob;

/**
 * Created by Christos on 24/5/2017.
 */
public interface ParentDAO extends CrudRepository<Parent, Long>{

}
