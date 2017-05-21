package postfix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class TestCases {
	public static Collection<Object[]> generalTestCases() {
		Object[][] data = new Object[][] {
				{ "simple plus", "4 + 3", "43+", 7 },
				{ "simple minus", "4 - 3", "43-", 1 },
				{ "simple multiplication", "4 * 3", "43*", 12 },
				{ "simple division", "7 / 2", "72/", 3.5 },
				{ "3 plus", "9 + 9 + 9 + 9", "99+9+9+", 36 },
				{ "2 minus", "3 - 3 - 3", "33-3-", -3 },
				{ "2 minus with parantheses", "3 - ( 3 - 3 )", "333--", 3 },
				{ "paranthesis at beginning", "( 3 + 2 )", "32+", 5 },
				{ "operator precedence I", "1 * 2 + 3", "12*3+", 5 },
				{ "operator precedence II", "1 + 2 * 3", "123*+", 7 },
				{ "operator precedence III", "9 - 1 - 2 - 3 * 2 - 1", "91-2-32*-1-", -1 },
				{ "fractions II II", "1 + 2 + 3 / 4 + 5 + 6 * ( 7 + 8 )",
						"12+34/+5+678+*+", 98.75 }
		};
		return asCollection(data);
	}

	public static Collection<Object[]> exponentialTestCases() {
		return Arrays.asList(new Object[][] {
				{ "exponential I", "4 ^ 2", "4 2 ^", 16 },
				{ "exponential II", "1 + 2 - 3 ^ 4", "1 2 + 3 4 ^ -", -78 },
				{ "exponential III", "1 ^ 2 - 3 * 4", "1 2 ^ 3 4 * -", -11 },
				{ "exponential IV", "1 + 2 * 3 - 4 ^ 5 + 6",
						"1 2 3 * + 4 5 ^ - 6 +", -1011 } });
	}

	public static Collection<Object[]> multiDigitTestCases() {
		return Arrays.asList(new Object[][] {
				{ "multi digit I", "40 * 31", "40 31 *", 1240 },
				{ "multi digit II", "10 ^ 2", "10 2 ^", 100 },
				{ "multi digit III", "13 + 21 * 35", "13 21 35 * +", 748 } });
	}
	
	/** 
	 * little helper to convert an Object[][] in a Collection<Object[]>
	 * @param data
	 * @return
	 */
	private static Collection<Object[]> asCollection(Object[][] data) {
		Collection<Object[]> dataCollection = new ArrayList<Object[]>();
		for (Object[] testCase : data) {
			dataCollection.add(testCase);
		}
		return dataCollection;
	}
}
