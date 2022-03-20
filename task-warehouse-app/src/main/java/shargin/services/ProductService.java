package shargin.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shargin.entities.PriceEntity;
import shargin.entities.PriceFrequencyByDate;
import shargin.entities.PriceFrequencyByProduct;
import shargin.entities.ProductEntity;
import shargin.models.Product;
import shargin.models.Statistic;
import shargin.repositories.PriceFrequencyByDateRepository;
import shargin.repositories.PriceFrequencyByProductRepository;
import shargin.repositories.PriceRepository;
import shargin.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	@Autowired
	PriceRepository priceRepository;
	@Autowired
	PriceFrequencyByProductRepository priceFrequencyByProductRepository;
	@Autowired
	PriceFrequencyByDateRepository priceFrequencyByDateRepository;

	public List<Product> findAllProductsByDate(LocalDate date) {
		List<PriceEntity> priceEntities = priceRepository.findAllByDate(date);
		List<ProductEntity> productEntites = productRepository.findAllById(priceEntities.
				stream().
				map(PriceEntity::getProduct_id).
				collect(Collectors.toList()));
		List<Product> products = new ArrayList<>(priceEntities.size());
		for(PriceEntity price : priceEntities) {
			products.add(Product.toProduct(
					productEntites.stream().
								filter(product->product.getId().equals(price.getProduct_id())).
								findAny().orElseThrow(()->new NoSuchElementException("Not found necessary products for Product Model")), price));
		}
		return products; 
	}

	public Statistic getStatistic() {
		List<PriceFrequencyByProduct> priceFrequencyByProducts = priceFrequencyByProductRepository.findAll();
		List<PriceFrequencyByDate> priceFrequencyByDates = priceFrequencyByDateRepository.findAll();
		Integer amountExistProducts = priceFrequencyByProducts.size();
		return Statistic.getStatictic(amountExistProducts, priceFrequencyByProducts, priceFrequencyByDates);
	}

	public int skipExistsAndSaveNew (List<ProductEntity> pricies) {
		List<ProductEntity> exists = productRepository.findAllById(pricies.stream().map(p->p.getId()).collect(Collectors.toList()));
		pricies.removeAll(exists);
		List<ProductEntity> saved = productRepository.saveAll(pricies);
		return saved.size();
	}
	
}
