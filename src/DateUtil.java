import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.time.temporal.Temporal;

public final class DateUtil {

	private static final String DATE_FORMAT = "dd/MM/uuuu";
	private static final String DATETIME_FORMAT = DATE_FORMAT + " HH:mm";

	private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT)
			.withResolverStyle(ResolverStyle.STRICT);

	private static final DateTimeFormatter datetimeFormatter = DateTimeFormatter.ofPattern(DATETIME_FORMAT)
			.withResolverStyle(ResolverStyle.STRICT);

	private DateUtil() {
	}

	public static <T extends Temporal> T stringToDate(String date_text, Class<T> cls) {
		try {
			if (cls == LocalDate.class) {
				return cls.cast(LocalDate.parse(date_text, dateFormatter));
			} else if (cls == LocalDateTime.class) {
				return cls.cast(LocalDateTime.parse(date_text, datetimeFormatter));
			} else {
				throw new RuntimeException(cls + " is not a valid type for this method!");
			}
		} catch (DateTimeParseException e) {
			return null;
		}
	}

	public static <T extends Temporal> String dateToString(T date) {
		if (date instanceof LocalDate) {
			return dateFormatter.format(date);
		} else if (date instanceof LocalDateTime) {
			return datetimeFormatter.format(date);
		} else {
			throw new RuntimeException(date.getClass() + " is not a valid type for this method!");
		}
	}

}
