package shargin.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shargin.entities.PriceEntity;
import shargin.repositories.PriceRepository;

@Service
public class PriceService {

	@Autowired
	PriceRepository repo;
	
	public int skipExistsAndSaveNew (List<PriceEntity> pricies) {
		List<PriceEntity> exists = repo.findAllById(pricies.stream().map(p->p.getId()).collect(Collectors.toList()));
		pricies.removeAll(exists);
		List<PriceEntity> saved = repo.saveAll(pricies);
		return saved.size();
	}
}
