package solver;

import gui.Config;

/**
 * Count-down for the LaunchOperations
 * 
 * @author pablo
 * 
 */
public class OperationCounter implements Runnable {
	/**
	 * Time in seconds allowed
	 */
	long time = System.currentTimeMillis();

	@SuppressWarnings("static-access")
	/**
	 * Initiates the count-down
	 */
	public void run() {
		try {

			for (int i = 0; i < Config.MaxOperationsTime; i++)
				Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}