package com.ty.mapping.uni.manytoone;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class TestAmazonOrders {

	public static void main(String[] args) {

		EntityManager entityManager = Persistence.createEntityManagerFactory("Imtiyaz").createEntityManager();

		Item item = entityManager.find(Item.class, 6);

		if (item != null) {

			System.out.println("Item name : " + item.getName());
			System.out.println("Item Price : " + item.getPrice());
			System.out.println("Item Qty : " + item.getQty());
			System.out.println("Order Name : " + item.getAmazonOrder().getName());
			System.out.println("Order Address : " + item.getAmazonOrder().getAddress());
			System.out.println("Order Status : " + item.getAmazonOrder().getStatus());
		} else {
			System.out.println("Item doesn't exists");
		}
	}

}
