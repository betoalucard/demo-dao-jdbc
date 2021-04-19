package application;


import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerdao = DaoFactory.createSellerDao();
		System.out.println("=== Test 1: seller findById ===");
		Seller seller = sellerdao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== Test 2: seller findByIdDepartment ===");
		Department department = new Department(2,null);
		List<Seller> list = sellerdao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
			
		}
		
		System.out.println("\n=== Test 3: seller findAll ===");
		
		list = sellerdao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
			
		}
		
		System.out.println("\n=== Test 4: seller insert===");
		Seller newseller = new Seller(null,"Greg","greg@gmail.com", new Date(), 4000.00,department);
		sellerdao.insert(newseller);
		System.out.println("Inserted! new id = "+newseller.getId());
		
		System.out.println("\n=== Test 5: seller Update===");
		seller = sellerdao.findById(1);
		seller.setName("Martha Waine");
		sellerdao.update(seller);
		System.out.println("Update  completed");
		
		System.out.println("\n=== Test 6: seller Delete===");
		
		System.out.println("Enter id for delete test");
		int id = sc.nextInt();
		sellerdao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
		
		
	}
	

}
