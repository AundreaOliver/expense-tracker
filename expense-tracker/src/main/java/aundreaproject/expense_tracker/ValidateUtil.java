package aundreaproject.expense_tracker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtil {

	private static String specialCharsRegexPattern = "[$&+,:;=?@#|'<>.^*()%!-]";

	public ValidateUtil() {

	}

	public boolean isStringContainsSpecialChars(String str) {
		Pattern special = Pattern.compile(specialCharsRegexPattern);
		Matcher hasSpecial = special.matcher(str);
		return hasSpecial.find();

	}

//	private boolean containsNumsOnly(double amt) {
//		Pattern p = Pattern.compile(numsRegexPattern);
//		
//	}
}
