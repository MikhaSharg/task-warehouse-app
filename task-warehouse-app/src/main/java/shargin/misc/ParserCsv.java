package shargin.misc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import shargin.entities.IdEntity;
import shargin.entities.PriceEntity;
import shargin.entities.ProductEntity;

@Component
public class ParserCsv {

	private static final String regexPatternForLine = "\\d*;\\w*;\\d*;(\\d*|\\d*,\\d*);\\d{1,4}(.|-)\\d{1,2}(.|-)\\d{1,4}";
	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

	public List<List<? extends IdEntity>> parseData(List<String> dataFromFile, String divider) {

		List<ProductEntity> products = new ArrayList<>();
		List<PriceEntity> pricies = new ArrayList<>();

		if (dataFromFile.isEmpty()) {
			throw new IllegalArgumentException("List can't be empty");
		}

		for (String line : dataFromFile) {

			if (validateLine(line)) {
				String[] data = line.split(";|,");
				if (data.length == 5) {
					products.add(new ProductEntity(Long.parseLong(data[0]), data[1]));
					pricies.add(
							new PriceEntity(Long.parseLong(data[2]), Float.parseFloat(data[3]), LocalDate.parse(data[4], dateTimeFormatter), Long.parseLong(data[0])));
				}
			}

		}

		return Arrays.asList(products, pricies);
	}

	private boolean validateLine(String line) {
		return line.matches(regexPatternForLine);

	}
}
