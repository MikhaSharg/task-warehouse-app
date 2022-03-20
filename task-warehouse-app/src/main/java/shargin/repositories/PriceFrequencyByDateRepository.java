package shargin.repositories;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import shargin.entities.PriceFrequencyByDate;

@Repository
@Transactional
public interface PriceFrequencyByDateRepository extends ReadOnlyRepository<PriceFrequencyByDate, LocalDate>{

}
