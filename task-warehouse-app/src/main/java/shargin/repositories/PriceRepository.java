package shargin.repositories;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shargin.entities.PriceEntity;

@Repository
@Transactional
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {
	List<PriceEntity> findAllByDate(LocalDate date);
	PriceEntity findByPrice (Float price);
}
