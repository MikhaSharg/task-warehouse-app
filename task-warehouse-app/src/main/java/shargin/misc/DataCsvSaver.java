package shargin.misc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import shargin.entities.IdEntity;
import shargin.entities.PriceEntity;
import shargin.entities.ProductEntity;
import shargin.services.PriceService;
import shargin.services.ProductService;

@Component
public class DataCsvSaver {

	private static final Logger log = LoggerFactory.getLogger(DataCsvSaver.class);

	@Autowired
	FilesReader filesReader;
	@Autowired
	ParserCsv parser;
	@Autowired
	PriceService priceService;
	@Autowired
	ProductService productService;
	@Autowired
	ParserConfig config;

	public DataCsvSaver() {
		super();
	}

	@Transactional
	public void saveDataFromCsvFiles() throws Exception {

		String pathToFiles = config.getPathToDirectoryWithCsvFiles();
		List<String> linesFromFile = new ArrayList<>();

		try {
			log.info("Started reading files from directory {}", pathToFiles);
			linesFromFile = filesReader.readFiles(pathToFiles);
			log.info("Files were read from directory {}", pathToFiles);
		} catch (IOException e) {
			log.warn("Can't read files from directory {}", pathToFiles);
			e.printStackTrace();
		}

		List<List<? extends IdEntity>> parsedData = parser.parseData(linesFromFile, ";");
		log.info("Parsed {} Products and Pricies", parsedData.get(0).size());

		for (List<? extends IdEntity> entity : parsedData) {
			if (!entity.isEmpty()) {
				String type = entity.get(0).getClass().getSimpleName();

				switch (type) {
				case "ProductEntity":
					int savedProducts = productService.skipExistsAndSaveNew((List<ProductEntity>) entity);
					log.info("{} products from CSV file were saved to the data base", savedProducts);
					break;

				case "PriceEntity":
					int savedPricies = priceService.skipExistsAndSaveNew((List<PriceEntity>) entity);
					log.info("{} pricies from CSV file were saved to the data base", savedPricies);
					break;
				}
			}
		}
	}
}