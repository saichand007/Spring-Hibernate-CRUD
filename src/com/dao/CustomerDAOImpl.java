package com.dao;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public List<Customer> getCustomers()
	{
		//get current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//create a query
		Query<Customer> theQuery=currentSession.createQuery("from Customer",Customer.class);
		
		//execute query and get result list
		List<Customer> customers=theQuery.list();
		
		//return results
		return customers;
	}



	@Override
	public void saveCustomer(Customer theCustomer) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theCustomer);
	}



	@Override
	public Customer getCustomers(int id) {
		// TODO Auto-generated method stub
		Session currentSession=sessionFactory.getCurrentSession();
		
		Customer theCustomer=currentSession.get(Customer.class, id);
		
		return theCustomer;
		
		
	}



	@Override
	public void deleteCustomer(int id) {
		
	Session currentSession=sessionFactory.getCurrentSession();
		
		Customer theCustomer=currentSession.get(Customer.class, id);
		
		currentSession.delete(theCustomer);
	}




}
