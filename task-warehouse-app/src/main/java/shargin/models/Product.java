package shargin.models;

import java.util.Objects;

import shargin.entities.PriceEntity;
import shargin.entities.ProductEntity;

public class Product {

	private String name;
	private Float price;

	private Product(String name, Float price) {
		super();
		this.name = name;
		this.price = price;
	}

	public static Product toProduct(ProductEntity productEntity, PriceEntity priceEntity) {
		if (productEntity.getId() == priceEntity.getProduct_id()) {
			return new Product(productEntity.getName(), priceEntity.getPrice());
		} else {
			throw new IllegalArgumentException("Wrong entities in signatur of method toProduct");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(name, other.name) && Objects.equals(price, other.price);
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}

}
