package shargin.misc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:parser.properties")
public class ParserConfig {

	@Value("${pathToDirectoryWithCsvFiles}")
	private String pathToDirectoryWithCsvFiles;

	@Value("${startTimeForReadingCsvFiles}")
	private String startTimeForReadingCsvFiles;

	ParserConfig() {
	}

	public String getPathToDirectoryWithCsvFiles() {
		return pathToDirectoryWithCsvFiles;
	}

	public String getStartTimeForReadingCsvFiles() {
		return startTimeForReadingCsvFiles;
	}

}
