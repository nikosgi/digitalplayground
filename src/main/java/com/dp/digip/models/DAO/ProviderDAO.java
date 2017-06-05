package com.dp.digip.models.DAO;

import com.dp.digip.models.Provider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Blob;

/**
 * Created by Christos on 24/5/2017.
 */
public interface ProviderDAO extends CrudRepository<Provider, Long> {

}
