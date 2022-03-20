package shargin.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table (name = "frequency_by_date")
public class PriceFrequencyByDate {

	@Id 
	@Column (name = "date_time")
	private  LocalDate date;
	
	private  Long frequency;

	
	public PriceFrequencyByDate() {}
	
	public PriceFrequencyByDate(LocalDate date, Long frequency) {
		this.date = date;
		this.frequency = frequency;
	}

	public LocalDate getDate() {
		return date;
	}

	public Long getFrequency() {
		return frequency;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, frequency);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PriceFrequencyByDate other = (PriceFrequencyByDate) obj;
		return Objects.equals(date, other.date) && Objects.equals(frequency, other.frequency);
	}

	@Override
	public String toString() {
		return "PriceFrequencyByDate [date=" + date + ", frequency=" + frequency + "]";
	}

}
