package com.vault.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.vault.model.Record;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class Dao {
	
	@PersistenceContext
	private EntityManager entityManager;
	int BATCH_SIZE = 5;
	
	@Transactional
	public void store (Record record) {
		
		entityManager.persist(record);
	}
	
	@Transactional
	public void batchStore (List<Record> records) 
	{
		
		 for (int i = 0; i < records.size(); i++) 
		 {
		        if (i > 0 && i % BATCH_SIZE == 0) 
		        {
		            entityManager.flush();
		            entityManager.clear();
		        }
		        entityManager.persist(records.get(i));
		    }
	}


	
	@SuppressWarnings("unchecked")
	public List<Record> retrieveAll() 
	{
		Query query = entityManager.createQuery("FROM Record ",Record.class);
		List<Record>  records = query.getResultList();
		return records;
		
	}
	
	

}
