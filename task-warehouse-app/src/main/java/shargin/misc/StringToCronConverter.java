package shargin.misc;

public class StringToCronConverter {

	private StringToCronConverter() {}
	
	public static String convertTimeToCron(String timeString) {
		String cronPattern = "0 %s %s * * *";
		String inputStringPattern = "\\s*\\d{1,2}:\\d{1,2}\\s*";
		if (timeString.matches(inputStringPattern)) {
			String withoutSpaces = timeString.replaceAll(" ", "");
			String[] splitedFigures = withoutSpaces.split(":");
			return String.format(cronPattern, splitedFigures[1], splitedFigures[0]);
		} else {
			throw new IllegalArgumentException(
					"Start time to reading CSV file in proper file is in wrong format. It must be as 00:00");
		}
	}
}
