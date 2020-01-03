/**
 * The class  <b>Assignment</b> is used to
 * test our LinearRegression class. It uses the
 * provided class <b>Display</b> to show the results
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */
import java.util.Random;
public class Assignment {


	/**
     * Random generator
     */
	private static java.util.Random generator = new java.util.Random();

		/**
     * In this second method, we will select a line at random.
     * 	1) we select a line y = ax + b, with a randomly selected
     * between -100 and +100 and b randomly selected between
     * -250 and +250
     * 	2) we add 500 samples randomly selected on the line
     * between -100 and +300. For each sample we add a "noise"
     * randomly selected between -1000 and +1000 (that is, for
     * each randomly selected x, we add the sample (x, ax+b+noise).
     * where "noise" is randomly selected between -1000 and 1000
     *  3) We create an instance of Display
     *  4) we iterate gradient descent (find a number of iterations,
     * a number of updates to the instance of Display, and a
     * step alpha that seems to work
     */
	private static void randomLine(){
		// your code goes there
		LinearRegression lr = new LinearRegression(500);
		Random rand = new Random();
		int a = rand.nextInt(201) -100;
		int b = rand.nextInt(501) - 250;
		for(int i = 0; i < 500; i++) {

			int randx = rand.nextInt(401)-100;

			lr.addSample(randx, ((a*randx)+b+rand.nextInt(2000)-1000));
		}

		Display graph = new Display(lr);
		graph.setTarget(a,b);

		for(int i=0; i <= 50; i++){
			graph.update();
			lr.gradientDescent(0.00000002, 100);

		}

	}


	public static void main(String[] args) {

	    StudentInfo.display();

		System.out.println("randomLine");
		randomLine();

	}

}
