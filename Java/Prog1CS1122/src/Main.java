import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SpellingCorrector theSpeller = new SpellingCorrector();

			theSpeller.loadDictionary("dictionary.txt");

			String x = "abcde";
			String y = "abcde";
			int[][] D = null;
			int distance = theSpeller.editDistance(x, y);
			System.out.println(x + " -> " + y + " distance = " + distance);
			D = theSpeller.distancesArray(x, y);
			printArray(D);

			x = "kitten";
			y = "sitting";
			distance = theSpeller.editDistance(x, y);
			System.out.println(x + " -> " + y + " distance = " + distance);
			D = theSpeller.distancesArray(x, y);
			printArray(D);

			x = "gattacca";
			y = "acgtacgt";
			distance = theSpeller.editDistance(x, y);
			System.out.println(x + " -> " + y + " distance = " + distance);
			D = theSpeller.distancesArray(x, y);
			printArray(D);

			String nonWord = "nessicary";
			String match = theSpeller.bestMatch(nonWord);
			System.out.println("Best match for " + nonWord + " is '" + match
					+ "'.");

			nonWord = "nesiccary";
			match = theSpeller.bestMatch(nonWord);
			System.out.println("Best match for " + nonWord + " is '" + match
					+ "'.");

			nonWord = "necisary";
			match = theSpeller.bestMatch(nonWord);
			System.out.println("Best match for " + nonWord + " is '" + match
					+ "'.");

			String[] allWords = theSpeller.getDictionary();
			int whichWord = 12345;
			System.out.println("Word at position " + whichWord + " is '"
					+ allWords[whichWord] + "'.");
			whichWord = 123456;
			System.out.println("Word at position " + whichWord + " is '"
					+ allWords[whichWord] + "'.");
			whichWord = 49931;
			System.out.println("Word at position " + whichWord + " is '"
					+ allWords[whichWord] + "'.");

			theSpeller.correctFile("input.txt", "output.txt");
			printFile("output.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prints the contents of a test file to the console. Line breaks are
	 * denoted by "EOL" so that any whitespace at the end of a line can be seen.
	 * 
	 * @param filename
	 *            Name of file to be printed.
	 */
	static void printFile(String filename) {
		try {
			Scanner in = new Scanner(new File(filename));
			System.out.println(filename + " contains:");
			while (in.hasNextLine()) {
				System.out.println(in.nextLine() + "EOL");
			}
			System.out.println("End of " + filename);
		} catch (FileNotFoundException e) {
			System.err.println(filename + " does not exist!");
		}
	}

	/**
	 * Prints the contents of a two dimensional array of integers to console for
	 * debugging purposes.
	 * 
	 * @param arr
	 *            The array to be printed
	 */
	public static void printArray(int[][] arr) {
		if (arr == null) {
			System.out.println("Array is null.");
			return;
		}
		if (arr.length == 0) {
			System.out.println("Zero sized array.");
			return;
		}
		System.out.println(arr.length + " by " + arr[0].length + " array:");
		for (int r = 0; r < arr.length; ++r) {
			for (int c = 0; c < arr[r].length; ++c) {
				System.out.printf("% 6d", arr[r][c]);
			}
			System.out.println();
		}
	}

}
