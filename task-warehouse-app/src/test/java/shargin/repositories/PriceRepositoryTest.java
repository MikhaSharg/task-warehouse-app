package shargin.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import shargin.entities.PriceEntity;

@DataJpaTest
class PriceRepositoryTest {

	List<PriceEntity> expected = Arrays.asList(
			new PriceEntity(1L, 111.11f, LocalDate.of(2022, 10, 11), 1L),	
			new PriceEntity(2L, 222.22f, LocalDate.of(2022, 10, 12), 2L),	
			new PriceEntity(3L, 333.33f, LocalDate.of(2022, 10, 13), 3L),	
			new PriceEntity(4L, 444.44f, LocalDate.of(2022, 10, 14), 4L),	
			new PriceEntity(5L, 555.55f, LocalDate.of(2022, 10, 15), 5L),	
			new PriceEntity(6L, 666.66f, LocalDate.of(2022, 10, 16), 1L),	
			new PriceEntity(7L, 777.77f, LocalDate.of(2022, 10, 17), 2L),	
			new PriceEntity(8L, 888.88f, LocalDate.of(2022, 10, 18), 3L));	
	
	@Autowired
	PriceRepository repo;
	
	@Test
	@Sql (scripts = {"/sql/pricies_test_values.sql"})
	void shouldFindOnePriceById() {
		PriceEntity expected = new PriceEntity(1L, 111.11f, LocalDate.of(2022, 10, 11), 1L);
		PriceEntity acrual = repo.findById(1L).get();
		assertThat(acrual).isEqualTo(expected);
	}
	
	@Test
	@Sql (scripts = {"/sql/pricies_test_values.sql"})
	void shouldFindAllPricies() {
		List<PriceEntity> actual = repo.findAll();
		assertThat(actual).isEqualTo(expected);
	}
	
	@Test
	@Sql (scripts = {"/sql/products_test_values.sql"})
	void shouldSaveAllPricies() {
		List<PriceEntity> actual = repo.saveAll(expected);
		assertThat(actual).isEqualTo(expected);
		assertThat(repo.findAll()).isEqualTo(expected);
	}
	
	@Test
	@Sql (scripts = {"/sql/pricies_test_values.sql"})
	void shouldFindAllPriciesByDate() {
		List<PriceEntity> expectedList = Arrays.asList(new PriceEntity(1L, 111.11f, LocalDate.of(2022, 10, 11), 1L));
		LocalDate date = LocalDate.of(2022, 10, 11);
		List<PriceEntity> actual = repo.findAllByDate(date);
		assertThat(actual).isEqualTo(expectedList);
	}
	
}
