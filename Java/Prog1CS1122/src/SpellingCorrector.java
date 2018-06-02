import java.io.FileNotFoundException;
import java.io.IOException;

public class SpellingCorrector {

	/**
	 * 
	 * @param dictFilename
	 *            name of the dictionary file to load
	 */
	void loadDictionary(String dictFilename) throws IOException {
		// TODO
	}

	/**
	 * <description of what getDictionary does>
	 * 
	 * @return Contents of the dictionary file as an array of Strings
	 */
	String[] getDictionary() {
		// TODO
		return null; // you can remove this line
	}

	/**
	 * <description of what distancesArray does>
	 * 
	 * @param x
	 *            String to be compared to y
	 * @param y
	 *            String to be compared to x
	 * @return Array used to compute edit distance between x and y
	 */
	int[][] distancesArray(String x, String y) {
		// TODO

		return null; // you can remove this line
	}

	/**
	 * 
	 * @param x
	 *            String to be compared to y
	 * @param y
	 *            String to be compared to x
	 * @return The edit distance for strings x and y
	 */
	int editDistance(String x, String y) {
		int distance = -1;

		// TODO
		// Note: you are allowed to call distancesArray in this method

		return distance;
	}

	/**
	 * 
	 * @param s
	 *            String to find closest match for
	 * @return
	 */
	String bestMatch(String s) {
		String match = "no match";

		// TODO

		return match;
	}

	/**
	 * 
	 * @param input
	 *            Name of the input file to be 'corrected'
	 * @param output
	 *            Name of the 'corrected' output file
	 * @throws FileNotFoundException
	 */
	void correctFile(String input, String output) throws FileNotFoundException {
		// TODO
	}

}
