package shargin.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pricies")
public class PriceEntity extends IdEntity {

	@Column(name = "price")
	private Float price;

	@Column(name = "date_time")
	private LocalDate date;

	@Column(name = "product_id")
	private Long productId;

	public PriceEntity() {
	}

	public PriceEntity(Long id, Float price, LocalDate date, Long productId) {
		super(id);
		this.price = price;
		this.date = date;
		this.productId = productId;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Long getProduct_id() {
		return productId;
	}

	public void setProduct_id(Long product_id) {
		this.productId = product_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(date, price, productId);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		PriceEntity other = (PriceEntity) obj;
		return Objects.equals(date, other.date) && Objects.equals(price, other.price)
				&& Objects.equals(productId, other.productId);
	}

	@Override
	public String toString() {
		return "Price [price=" + price + ", date=" + date + ", productId=" + productId + "]";
	}

}
