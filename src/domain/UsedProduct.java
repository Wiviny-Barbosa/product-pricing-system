package domain;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class UsedProduct extends Product {
	private LocalDate manufactureDate;
	
	public UsedProduct() {
		super();
	}

	public UsedProduct(String name, Double price, LocalDate manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	@Override
	public String priceTag() {
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String data = this.manufactureDate.format(formatador);
		return this.getName() + " (used) $ " + String.format("%.2f", this.getPrice()) + " (Manufacture date: "+data+")";
	}
}
