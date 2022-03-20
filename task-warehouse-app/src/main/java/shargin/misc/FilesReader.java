package shargin.misc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

@Component
public class FilesReader {

	private String fileExtension = "csv";

	private List<String> getFilePaths(String directoryPath) throws IOException {

		if (directoryPath == null) {
			throw new IllegalArgumentException("Path can't be null");
		}

		if (directoryPath.isEmpty()) {
			throw new IllegalArgumentException("Path can't be empty");
		}

		Path path = Path.of(directoryPath);

		if (!Files.isDirectory(path)) {
			throw new IllegalArgumentException("Input not directory path");
		}

		List<String> files;

		try (Stream<Path> getFiles = Files.walk(path)) {
			files = getFiles.filter(file -> !Files.isDirectory(file)).map(file -> file.toString().toLowerCase())
					.filter(file -> file.endsWith(fileExtension)).collect(Collectors.toList());

			if (files.isEmpty()) {
				throw new NoSuchFileException("Found no files with csv extension");
			}
			return files;
		}
	}

	public List<String> readFiles(String directoryPath) throws IOException {
		List<String> filePaths = getFilePaths(directoryPath);
		List<String> lines = new ArrayList<>();

		for (String path : filePaths) {

			try (BufferedReader buffer = new BufferedReader(new FileReader(path))) {
				String line;

				while ((line = buffer.readLine()) != null) {
					lines.add(line);
				}
			}
			Files.deleteIfExists(Path.of(path));
		}
		return lines;
	}
}