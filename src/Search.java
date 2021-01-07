
/**
 * @author Parsa Jalilifar
 */

import java.util.ArrayList;
import java.util.Random;

public class Search implements Runnable {

	private String[] arrayOfRows;
	private ArrayList<String> resultList;

	// constructor with one argument

	public Search(String[] str) {

		this.arrayOfRows = str;
		this.resultList = new ArrayList<String>();

	}

	// it returns list of results that had been found

	public ArrayList<String> GetResults() {

		return resultList;

	}

	@Override
	public void run() {

		// it checks rows to find same word and then if that rows has it row will be
		// added to results list and counter holds number of founded cases

		for (int i = 0; i < this.arrayOfRows.length; i++) {

			if (this.arrayOfRows[i].contains(threadTester.WORD)) {
				resultList.add(this.arrayOfRows[i]);
				threadTester.counter++;
			}

		}

		// Each thread should have a random amount of sleeping time (between 100 ms and
		// 2000 ms).

		Random rand = new Random();
		int first = 100;
		int last = 2000;

		int result = rand.nextInt(last - first) + first;

		try {
			Thread.sleep(result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
