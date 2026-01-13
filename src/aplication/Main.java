package aplication;

import java.util.Scanner;

import domain.ImportedProduct;
import domain.Product;
import domain.UsedProduct;

import java.util.Locale;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		
		List<Product> prd = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int number = scanner.nextInt();
		
		for(int i = 1; i <= number; i++) {
			System.out.println("Product "+i+" data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char letra = scanner.next().charAt(0);
			System.out.print("Name: ");
			scanner.nextLine();
			String name = scanner.nextLine();
			System.out.print("Price: ");
			Double price = scanner.nextDouble();
			if(letra == 'i') {
				System.out.print("Customs Fee: ");
				Double customsFee = scanner.nextDouble();
				Product product = new ImportedProduct(name, price, customsFee);
				prd.add(product);
			} else if(letra == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				scanner.nextLine();
				String date = scanner.nextLine();
				DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		        LocalDate data = LocalDate.parse(date, formatador);
				Product product = new UsedProduct(name, price, data);
				prd.add(product);
			} else {
				Product product = new Product(name, price);
				prd.add(product);
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for(Product products : prd) {
			System.out.println(products.priceTag());
		}
		scanner.close();
	}
}
