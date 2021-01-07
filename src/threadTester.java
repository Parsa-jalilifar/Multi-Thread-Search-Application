
/**
 * @author Parsa Jalilifar
 */

import java.util.ArrayList;

public class threadTester {

	static String WORD = "java";
	static int counter = 0;

	public static void main(String[] args) throws InterruptedException {

		// 2D data array

		String[][] data = { { "java", "I love java", "c++", "python" },
				{ "c programs", "cookies", "java developers", "oops" }, { "john", "doe", "mary", "mark holmes" },
				{ "hello java java", "byebye", "java again?", "java what?" },
				{ "toronto", "montreal", "quebec city", "calgary" } };

		int numOfRows = data.length;

		Search[] searchObjs = new Search[numOfRows];
		Thread[] threads = new Thread[numOfRows];

		// initilizing search objs and giving them to thread (start is working with
		// thread and not working objs of search class)

		for (int i = 0; i < numOfRows; i++) {
			searchObjs[i] = new Search(data[i]);
			threads[i] = new Thread(searchObjs[i]);
			threads[i].start();
		}

		ArrayList<ArrayList<String>> resultArray = new ArrayList<ArrayList<String>>();

		// closing threads and adding results to array list

		for (int i = 0; i < numOfRows; i++) {

			threads[i].join();
			resultArray.add(searchObjs[i].GetResults());
		}

		System.out.println("+ search word: " + WORD);
		System.out.println("+ summary");

		for (int i = 0; i < numOfRows; i++) {

			if (resultArray.get(i).size() == 0)
				System.out.println("row " + (i + 1) + ": " + "***");
			else
				System.out.println("row " + (i + 1) + ": " + resultArray.get(i));

		}

		System.out.println("+ total number of strings found: " + counter);

	}

}
