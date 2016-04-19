import java.util.Random;

public class SimulatorUtility {
	private static Random generator = new Random();
	public static int randomGenerator() {
	        return ((generator.nextInt()%100)+100)%10;
	}
}
