package user.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import user.dto.User;



public class UserDao {

	public void saveUser(User user) {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
	}
	
	
//	find  user 
	
	public void findUser(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		User dbUser=entityManager.find(User.class,id);
		
		if(dbUser !=null) {
			//that is present and that user exist
			
			System.out.println(dbUser);
		}
		else {
			//id is not present and user doesnot exist
			System.out.println("Sorry id is not present");
		}
	}
	
//	delete
	
	public void deleteUser( int id ) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		User dbUser=entityManager.find(User.class,id);

		if(dbUser !=null) {
			//id is present and that 
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(dbUser);
			entityTransaction.commit();
		}
		else {
			//
			System.out.println("Sorry it is not Present");
		}
	}
	
	//update1
	
//	public void updateUser(User user) {
//		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
//		EntityManager entityManager=entityManagerFactory.createEntityManager();
//        EntityTransaction entityTransaction=entityManager.getTransaction();
//        entityTransaction.begin();
//        entityManager.merge(user);
//        entityTransaction.commit();
        
        //Update2
	
//	public void updateUser(int id, User user) {
//		
//		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
//		EntityManager entityManager=entityManagerFactory.createEntityManager();
//		User dbUser = entityManager.find(User.class,id);
//		
//		if(dbUser != null) {
//			
//			EntityTransaction entityTransaction=entityManager.getTransaction();
//			entityTransaction.begin();
//			entityManager.merge(user);
//			entityTransaction.commit();
//		}
//		else {
//			//id is not present
//			System.out.println("Sorry id is not present to update the data");
//		}
//	}
	
	//update3
public void updateUser(int id, User user) {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		User dbUser = entityManager.find(User.class,id);
		
		if(dbUser != null) {
			
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			user.setId(id);
			entityManager.merge(user);
			entityTransaction.commit();
		}
		else {
			//id is not present
			System.out.println("Sorry id is not present to update the data");
		}
	}
	
	
}
