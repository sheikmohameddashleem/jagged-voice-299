package com.masai.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.masai.Entity.Customer;
import com.masai.Entity.Issues;
import com.masai.Entity.LoggedIn;
import com.masai.Entity.Status;
import com.masai.Entity.feedback;
import com.masai.Exceptions.SomeThingWentWrongException;
import com.masai.Utility.EMUtils;

public class CustomerDao implements ICustomerDao {

	@Override
	public void addCSR(Customer customer) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em = null;

		try {
			em = EMUtils.createConnection();

			Query query = em
					.createQuery("SELECT Count(c) FROM Customer c WHERE username= :username");
			query.setParameter("username", customer.getUserName());

			if ((Long) query.getSingleResult() > 0) {
				throw new SomeThingWentWrongException(customer.getUserName() + " is ALREADY EXIST");
			}

			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(customer);
			et.commit();

		} catch (PersistenceException ex) {
			throw new SomeThingWentWrongException("UNABLE TO PROCESS THE REQUEST");
		} finally {
			if(em!=null) {
				em.close();
			}
		}
	}

	@Override
	public void login(String username, String password) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em=null;
		try {
			em=EMUtils.createConnection();
			
			Query query=em.createQuery("SELECT c.id from Customer c where UserName =:un AND password = :pw AND isDeleted = 1");
			query.setParameter("un", username);
			query.setParameter("pw", password);
			
			List<Integer> list=query.getResultList();
			
			if(list.size()==0) {
				System.out.println("Please register");
				throw new SomeThingWentWrongException("NO SUCH USER PRESENT");
			}
			
			LoggedIn.userid=list.get(0);
			
		}catch(PersistenceException e) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally {
			if(em!=null) {
				em.close();
			}
			
		}
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em=null;
		try {
			em=EMUtils.createConnection();
			
			Query query=em.createQuery("SELECT count(c) FROM Customer c WHERE password = :oldPassword AND id = :id");
			query.setParameter("oldPassword", oldPassword);
			query.setParameter("id", newPassword);
			
			
			
			if((int)query.getSingleResult() == 0) {
				throw new SomeThingWentWrongException("NO SUCH USER PRESENT");
			}
			
			Customer csr=em.find(Customer.class ,LoggedIn.userid);
			EntityTransaction et=em.getTransaction();
			et.begin();
			csr.setPassword(newPassword);
			et.commit();
		}catch(PersistenceException e) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally {
			if(em!=null) {
				em.close();
			}
		}
	}

	@Override
	public void delete() throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = EMUtils.createConnection();
			Customer customer = em.find(Customer.class, LoggedIn.userid);
			EntityTransaction et = em.getTransaction();
			et.begin();
			customer.setIsDeleted(0);
			et.commit();
		}catch(PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally{
			if(em!=null) {
				em.close();
			}
		}
	}

	@Override
	public void raiseIssue(String description) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em = null;

		try {
			em = EMUtils.createConnection();
 
			Customer cust=em.find(Customer.class, LoggedIn.userid);
			Issues issue=new Issues(description,Status.OPEN,cust,null,null);
            
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(issue);
			et.commit();

		} catch (PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		} finally {
			if(em!=null) {
				em.close();
			}
		}
		
		
	}

	

	@Override
	public void giveFeedback(int id,String feedback,int rating) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em = null;

		try {
			em = EMUtils.createConnection();

			Issues issue=em.find(Issues.class, id);

			feedback feed=new feedback(feedback,rating,issue);
			

			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(feed);
			et.commit();

		} catch (PersistenceException ex) {
			throw new SomeThingWentWrongException("UNABLE TO PROCESS THE REQUEST");
		} finally {
			if(em!=null) {
				em.close();
			}
		}
	}

}
