package shargin.models;

import java.util.List;
import java.util.Objects;

import shargin.entities.PriceFrequencyByDate;
import shargin.entities.PriceFrequencyByProduct;

public class Statistic {

	private final Integer amount;
	private final List<PriceFrequencyByProduct> priceFrequencyByProduct;
	private final List<PriceFrequencyByDate> priceFrequencyByDate;

	private Statistic(Integer amount, List<PriceFrequencyByProduct> priceFrequencyByProduct,
			List<PriceFrequencyByDate> priceFrequencyByDate) {
		this.amount = amount;
		this.priceFrequencyByProduct = priceFrequencyByProduct;
		this.priceFrequencyByDate = priceFrequencyByDate;
	}

	public static Statistic getStatictic(Integer amount, List<PriceFrequencyByProduct> byProduct,
			List<PriceFrequencyByDate> byDate) {
		return new Statistic(amount, byProduct, byDate);
	}

	public Integer getAmount() {
		return amount;
	}

	public List<PriceFrequencyByProduct> getPriceFrequencyByProduct() {
		return priceFrequencyByProduct;
	}

	public List<PriceFrequencyByDate> getPriceFrequencyByDate() {
		return priceFrequencyByDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, priceFrequencyByDate, priceFrequencyByProduct);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Statistic other = (Statistic) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(priceFrequencyByDate, other.priceFrequencyByDate)
				&& Objects.equals(priceFrequencyByProduct, other.priceFrequencyByProduct);
	}

	@Override
	public String toString() {
		return "Statistic [amount=" + amount + ", priceFrequencyByProduct=" + priceFrequencyByProduct
				+ ", priceFrequencyByDate=" + priceFrequencyByDate + "]";
	}

}
