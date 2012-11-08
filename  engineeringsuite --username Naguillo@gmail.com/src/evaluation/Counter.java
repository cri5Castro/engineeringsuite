package evaluation;

import gui.Config;

/**
 * This class is to use with the CalculateThread class. Both are used to control
 * the calculation time.
 * 
 * @author Pablo Salinas
 * 
 */
public class Counter implements Runnable {

	/**
	 * Time in seconds to the count-down.
	 */
	long time = System.currentTimeMillis();

	@SuppressWarnings("static-access")
	/**
	 * Starts the count-down. If the operation does not finish on time it will be interrupted.
	 */
	public void run() {
		try {

			for (int i = 0; i < Config.MaxCalculateTime; i++)
				Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}