package com.masai.Dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.masai.Entity.CustomerSupportRepresentative;
import com.masai.Entity.Issues;
import com.masai.Entity.LoggedIn;
import com.masai.Entity.Status;
import com.masai.Entity.feedback;
import com.masai.Exceptions.SomeThingWentWrongException;
import com.masai.Service.CSRimpl;
import com.masai.Service.ICSRService;
import com.masai.Utility.EMUtils;

public class CSRDaoImpl implements ICSRDao {

	@Override
	public void login(String username, String password) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {

			
			em = EMUtils.createConnection();
			
			Query query = em.createQuery(
					"SELECT c.id from CustomerSupportRepresentative c where username =:un AND password = :pw AND isDeleted = 1");
			query.setParameter("un", username);
			query.setParameter("pw", password);

			List<Integer> list = query.getResultList();

			if (list.size() == 0) {
				throw new SomeThingWentWrongException("NO SUCH USER PRESENT");
			}

			LoggedIn.userid = list.get(0);

		} catch (PersistenceException e) {
			System.out.println(e.getMessage());
		} finally {
			if(em!=null) {
				em.close();
			}
		}

	}

	@Override
	public void changePassword(String oldPassword, String newPassword) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = EMUtils.createConnection();

			Query query = em.createQuery("SELECT count(c) FROM Customer c WHERE password = :oldPassword AND id = :id");
			query.setParameter("oldPassword", oldPassword);
			query.setParameter("id", newPassword);

			if ((int) query.getSingleResult() == 0) {
				throw new SomeThingWentWrongException("NO SUCH USER PRESENT");
			}

			CustomerSupportRepresentative csr = em.find(CustomerSupportRepresentative.class, LoggedIn.userid);
			EntityTransaction et = em.getTransaction();
			et.begin();
			csr.setPassword(newPassword);
			et.commit();
		} catch (PersistenceException e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
	}

	@Override
	public void addCSR(CustomerSupportRepresentative customer) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em = null;

		try {
			em = EMUtils.createConnection();

			Query query = em
					.createQuery("SELECT Count(c) FROM CustomerSupportRepresentative c WHERE username= :username");
			query.setParameter("username", customer.getUsername());

			if ((Long) query.getSingleResult() > 0) {
				throw new SomeThingWentWrongException(customer.getUsername() + " is ALREADY EXIST");
			}

			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(customer);
			et.commit();

		} catch (PersistenceException ex) {

			throw new SomeThingWentWrongException("UNABLE TO PROCESS THE REQUEST");
		} finally {
			em.close();
		}
	}

	@Override
	public void delete() throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = EMUtils.createConnection();
			CustomerSupportRepresentative customer = em.find(CustomerSupportRepresentative.class, LoggedIn.userid);
			EntityTransaction et = em.getTransaction();
			et.begin();
			customer.setIsDeleted(0);
			et.commit();
		} catch (PersistenceException ex) {
			System.out.println(ex.getMessage());
		} finally {
			em.close();
		}
	}

	@Override
	public List<Issues> viewIssues() {
		// TODO Auto-generated method stub
		EntityManager em = null;
		List<Issues> issuesList = null;
		try {
			em = EMUtils.createConnection();

			Query query = em.createQuery("SELECT c FROM Issues c ");

			issuesList = query.getResultList();

			if (issuesList.size() == 0) {
				System.out.println("NO ISSUES FOUND");
			}
			return issuesList;
		} catch (PersistenceException ex) {
			System.out.println(ex.getMessage());
		} finally {
			em.close();
		}
		return issuesList;
	}

	@Override
	public void assignToYou() throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em = null;
        Scanner sc=new Scanner(System.in);
		try {
			em = EMUtils.createConnection();

			CustomerSupportRepresentative csro=em.find(CustomerSupportRepresentative.class, LoggedIn.userid);
			ICSRService csr=new CSRimpl(); 
			csr.ViewIssues();
			System.out.println("Enter the ISSUE to be assigned");
			int choice=sc.nextInt();
			Issues issue=em.find(Issues.class, choice);
			if(issue !=null) {
				System.out.println();
				EntityTransaction et = em.getTransaction();
				et.begin();
				issue.setCsr(csro);
				et.commit();
			}
			

		} catch (PersistenceException ex) {

			throw new SomeThingWentWrongException("UNABLE TO PROCESS THE REQUEST");
		} finally {
			em.close();
		}
	}

	@Override
	public List<CustomerSupportRepresentative> ViewCsr() {
		// TODO Auto-generated method stub
		
		EntityManager em = null;
		List<CustomerSupportRepresentative> List = null;
		try {
			em = EMUtils.createConnection();

			Query query = em.createQuery("SELECT c FROM Issues c ");

			List = query.getResultList();
			return List;
		} catch (PersistenceException ex) {
			System.out.println(ex.getMessage());
		} finally {
			em.close();
		}
		return List;
	}

	@Override
	public void assignToOther(int id) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em = null;
        Scanner sc=new Scanner(System.in);
		try {
			em = EMUtils.createConnection();

			CustomerSupportRepresentative csro=em.find(CustomerSupportRepresentative.class, id);
			ICSRService csr=new CSRimpl(); 
			csr.ViewIssues();
			System.out.println("Enter the ISSUE to be assigned");
			int choice=sc.nextInt();
			Issues issue=em.find(Issues.class, choice);
			if(issue !=null) {
				System.out.println();
				EntityTransaction et = em.getTransaction();
				et.begin();
				issue.setCsr(csro);
				et.commit();
			}
			

		} catch (PersistenceException ex) {

			throw new SomeThingWentWrongException("UNABLE TO PROCESS THE REQUEST");
		} finally {
			em.close();
		}
	}

	@Override
	public void replyTOissue(int id, String reply) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em = null;
        Scanner sc=new Scanner(System.in);
		try {
			em = EMUtils.createConnection();

		
	
		
			Issues issue=em.find(Issues.class, id);
			if(issue !=null) {
				System.out.println();
				EntityTransaction et = em.getTransaction();
				et.begin();
				issue.setReply(reply);
				et.commit();
			}
			

		} catch (PersistenceException ex) {

			throw new SomeThingWentWrongException("UNABLE TO PROCESS THE REQUEST");
		} finally {
			em.close();
		}
	}

	@Override
	public void closeIssue(int id) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em = null;
        Scanner sc=new Scanner(System.in);
		try {
			em = EMUtils.createConnection();

		
	
		
			Issues issue=em.find(Issues.class, id);
			if(issue !=null) {
				System.out.println();
				EntityTransaction et = em.getTransaction();
				et.begin();
				issue.setStatus(Status.CLOSED);;
				et.commit();
			}
			

		} catch (PersistenceException ex) {

			throw new SomeThingWentWrongException("UNABLE TO PROCESS THE REQUEST");
		} finally {
			em.close();
		}
	}

	@Override
	public List<feedback> getFeedback() {
		// TODO Auto-generated method stub
		EntityManager em = null;
		List<feedback> issuesList = null;
		try {
			em = EMUtils.createConnection();

			Query query = em.createQuery("SELECT c FROM feedback c ");

			issuesList = query.getResultList();

			if (issuesList.size() == 0) {
				System.out.println("NO FEEDBACK FOUND");
			}
			return issuesList;
		} catch (PersistenceException ex) {
			System.out.println(ex.getMessage());
		} finally {
			em.close();
		}
		return issuesList;
		
		
	}
}
