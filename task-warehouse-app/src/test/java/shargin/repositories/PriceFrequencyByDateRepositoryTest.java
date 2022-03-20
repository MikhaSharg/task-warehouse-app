package shargin.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import shargin.entities.PriceFrequencyByDate;

@DataJpaTest
class PriceFrequencyByDateRepositoryTest {

	@Autowired
	PriceFrequencyByDateRepository repo;

	@Test
	@Sql(scripts = { "/sql/pricies_products_test_values.sql" })
	void shouldFindAllDataFromView() {
		List<PriceFrequencyByDate> expected = Arrays.asList(new PriceFrequencyByDate(LocalDate.of(2022, 10, 11), 4L),
				new PriceFrequencyByDate(LocalDate.of(2022, 10, 15), 1L),
				new PriceFrequencyByDate(LocalDate.of(2022, 10, 16), 1L),
				new PriceFrequencyByDate(LocalDate.of(2022, 10, 17), 1L),
				new PriceFrequencyByDate(LocalDate.of(2022, 10, 18), 1L));

		List<PriceFrequencyByDate> actual = repo.findAll();
		assertThat(actual).isEqualTo(expected);
	}
}
