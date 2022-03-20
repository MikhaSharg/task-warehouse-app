package shargin.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import shargin.entities.ProductEntity;

@DataJpaTest
class ProductRepositoryTest {

	@Autowired
	ProductRepository repo;

	@Test
	@Sql(scripts = { "/sql/products_test_values.sql" })
	void shoulFindOneProductById() {
		ProductEntity expected = new ProductEntity(1L, "apples");
		ProductEntity actual = repo.findById(1L).get();
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	@Sql(scripts = { "/sql/products_test_values.sql" })
	void shoulFindAllProducts() {
		List<ProductEntity> expected = Arrays.asList(new ProductEntity(1L, "apples"), new ProductEntity(2L, "eggs"),
				new ProductEntity(3L, "bread"), new ProductEntity(4L, "milk"), new ProductEntity(5L, "sugar"));
		List<ProductEntity> actual = repo.findAll();
		assertThat(actual).isEqualTo(expected);
	}
	
	@Test
	void shoulSaveAllProducts() {
		List<ProductEntity> expected = Arrays.asList(new ProductEntity(1L, "apples"), new ProductEntity(2L, "eggs"),
				new ProductEntity(3L, "bread"), new ProductEntity(4L, "milk"), new ProductEntity(5L, "sugar"));
		List<ProductEntity> actual = repo.saveAll(expected);
		assertThat(actual).isEqualTo(expected);
		assertThat(repo.findAll()).isEqualTo(expected);
	}
}
