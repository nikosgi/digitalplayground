package com.dp.digip; 

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.dp.digip.models.User;
import com.dp.digip.models.Event;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;
import org.hibernate.search.jpa.Search ;
import org.hibernate.search.jpa.FullTextQuery;
import org.apache.lucene.search.Query;
import java.lang.Exception;

import static java.lang.System.out;

@Repository
@Transactional
public class CustomSearch {

	// Spring will inject here the entity manager object
	@PersistenceContext
	private EntityManager entityManager;

	public List<User> userSearch(String text){

		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
	
		//valto na ginete mia fora kai oxi se kathe search
		try{	
			fullTextEntityManager.createIndexer().startAndWait();
		}catch(Exception ex){
			out.println("exception gotten");		
		}		


		QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
			.buildQueryBuilder().forEntity(User.class).get();

		Query query =
			queryBuilder
			.keyword()
			.onFields("username", "email")
			.matching(text)
			.createQuery();

		//wrap Lucene query in an Hibernate Query object
		FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(query, User.class);
          
                // execute search and return results (sorted by relevance as default)
                @SuppressWarnings("unchecked")
                List<User> results = jpaQuery.getResultList();
                			

		return results;

	}

	public List<Event> eventSearch(String text){
			
               	FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);

		 try{
                        fullTextEntityManager.createIndexer().startAndWait();
                }catch(Exception ex){
                        out.println("exception gotten");
                }

               	QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
                       	.buildQueryBuilder().forEntity(Event.class).get();

                Query query =
                        queryBuilder
                        .keyword()
                        .onFields("name", "description")
                        .matching(text)
                        .createQuery();

                //wrap Lucene query in an Hibernate Query object
                FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(query, Event.class);
                
                // execute search and return results (sorted by relevance as default)
		
	        @SuppressWarnings("unchecked")
        	List<Event> results = jpaQuery.getResultList();

		return results;
	
	}

}
