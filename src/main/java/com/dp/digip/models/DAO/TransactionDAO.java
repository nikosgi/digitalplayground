package com.dp.digip.models.DAO;


import javax.transaction.Transactional;
import com.dp.digip.models.Transaction;
import com.dp.digip.models.TransactionId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TransactionDAO extends CrudRepository<Transaction, TransactionId> {


}

