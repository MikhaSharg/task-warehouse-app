package shargin.misc;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
@EnableScheduling
public class SchedulingConfig implements SchedulingConfigurer {

	@Autowired
	DataCsvSaver saver;

	@Autowired
	ParserConfig config;

	@Bean
	public Executor taskExecutor() {
		return Executors.newSingleThreadExecutor();
	}

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

		taskRegistrar.addCronTask(new Runnable() {

			@Override
			public void run() {
				try {
					saver.saveDataFromCsvFiles();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}, StringToCronConverter.convertTimeToCron(config.getStartTimeForReadingCsvFiles()));

	}

}
