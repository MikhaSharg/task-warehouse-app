package shargin.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shargin.entities.ProductEntity;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
