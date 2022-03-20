package shargin.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import shargin.entities.PriceFrequencyByProduct;

@DataJpaTest
class PriceFrequencyByProductRepositoryTest {

	@Autowired
	PriceFrequencyByProductRepository repo;
	
	@Test
	@Sql (scripts =   {"/sql/pricies_products_test_values.sql"})
	void shouldFindAllDataFromView() {
		List <PriceFrequencyByProduct> expected = Arrays.asList(
				new PriceFrequencyByProduct(1L, "apples", 2L),
				new PriceFrequencyByProduct(2L, "eggs", 2L),
				new PriceFrequencyByProduct(3L, "bread", 2L),
				new PriceFrequencyByProduct(4L, "milk", 1L),
				new PriceFrequencyByProduct(5L, "sugar", 1L)
				);
		
		List<PriceFrequencyByProduct> actual = repo.findAll();
		assertThat(actual).isEqualTo(expected);
	}

}
