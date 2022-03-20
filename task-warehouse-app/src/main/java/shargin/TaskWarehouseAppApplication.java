package shargin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TaskWarehouseAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskWarehouseAppApplication.class, args);
	}
}
