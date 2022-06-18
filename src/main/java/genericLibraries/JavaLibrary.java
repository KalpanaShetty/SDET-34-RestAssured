package genericLibraries;

import java.util.Random;

/**
 * This class contains java specific generic methods
 * @author Chaitra M
 *
 */
public class JavaLibrary {
	
	/**
	 * This method will generate random number
	 * @return
	 */
	public int getRandomNum()
	{
		Random r = new Random();
		return(r.nextInt(100));
	}

}
