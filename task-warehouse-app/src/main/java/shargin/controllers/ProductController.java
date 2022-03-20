package shargin.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import shargin.models.Product;
import shargin.models.Statistic;
import shargin.services.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService service;

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProductsByDate(@RequestParam String date) {
		List<Product> products = service.findAllProductsByDate(LocalDate.parse(date));
		return ResponseEntity.ok(products);
	}

	@GetMapping("/statistic")
	public ResponseEntity<Statistic> getStatistic() {
		Statistic statistic = service.getStatistic();
		return ResponseEntity.ok(statistic);
	}

}
