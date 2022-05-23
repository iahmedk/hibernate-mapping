package com.ty.mapping.uni.manytoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveAmazonOrders {

	public static void main(String[] args) {

		EntityManager entityManager = Persistence.createEntityManagerFactory("Imtiyaz").createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Item item1 = new Item();
		item1.setName("Laptop");
		item1.setPrice(55000.00);
		item1.setQty(1);

		Item item2 = new Item();
		item2.setName("Mobile");
		item2.setPrice(38000.00);
		item2.setQty(1);

		/*
		 * Item item3 = new Item(); item3.setName("Refrigerator");
		 * item3.setPrice(21000.00); item3.setQty(1);
		 */

		AmazonOrder amazonOrder = new AmazonOrder();
		amazonOrder.setAddress("Kurubara Halli Bangalore");
		amazonOrder.setStatus("In Progress");
		amazonOrder.setName("Personal Use");

		item1.setAmazonOrder(amazonOrder);
		item2.setAmazonOrder(amazonOrder);
		// item3.setAmazonOrder(amazonOrder);

		entityTransaction.begin();
		entityManager.persist(amazonOrder);
		entityManager.persist(item1);
		entityManager.persist(item2);
		// entityManager.persist(item3);
		entityTransaction.commit();
	}

}
