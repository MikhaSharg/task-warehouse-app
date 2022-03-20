package shargin.repositories;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import shargin.entities.PriceFrequencyByProduct;

@Repository
@Transactional
public interface PriceFrequencyByProductRepository extends ReadOnlyRepository<PriceFrequencyByProduct, Long> {

}
