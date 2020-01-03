/**
 * The class  <b>LinearRegression</b> implements gradient
 * descent with 1 variable.
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */

public class LinearRegression {


	/**
     * Number of samples (usually "m" in litterature)
     */
	private int nbreOfSamples;


	/**
     * the sample vector
     */
	private double[] samples;

	/**
     * the samples target values
     */
	private double[] samplesValues;

	/**
     * the current hypthesis function: theta0 + theta1 x
     */
	private double theta0, theta1;


	/**
     * used to ensure that the object is ready
     */
	private int currentNbreOfSamples;



	/**
     * counts how many iterations have been performed
     */
	private int iteration;


	/**
     * Object's contructor. The constructor initializes the instance
     * variables. The starting hypthesis is y = 0;
     *
     *
     * @param m the number of samples that we will have
	 *
     */
 	public LinearRegression(int m){

 		// your code goes there
		nbreOfSamples = m;
		samples = new double[m];
		samplesValues = new double[m];
		theta0 = 0;
		theta1 = 0;
		currentNbreOfSamples = 0;
		iteration = 0;

	}

	/**
     * Adds a new sample to sample and to samplesValues. This
     * method must be iteratively called with all the samples
     * before the gradient descent can be started
     *
     * @param x the new sample
     * @param y the corresponding expected value
     *
	 */
	public void addSample(double x, double y){

		// your code goes there
		samples[currentNbreOfSamples] = x;
		samplesValues[currentNbreOfSamples] = y;
		currentNbreOfSamples++;
	}

	/**
     * Returns the current hypothesis for the value of the input
     * @param x the input for which we want the current hypothesis
     *
	 * @return theta0 + theta1 x
	 */
	private double hypothesis(double x){
		// your code goes there
		return this.theta0 + (theta1*x);
	}

	/**
     * Returns a string representation of hypthesis function
     *
	 * @return the string "theta0 + theta1 x"
	 */
	public String currentHypothesis(){

		// your code goes there
		return this.theta0 + " " + this.theta1 + "x";
	}

	/**
     * Returns the current cost
     *
	 * @return the current value of the cost function
	 */
	public double currentCost(){
		// your code goes there
		double cost = 0;

		for(int i=0; i < nbreOfSamples; i++){
			cost = hypothesis(samples[i]) - samplesValues[i];
			cost = java.lang.Math.pow(cost,2);
		}
		return cost;
	}

	/**
     * runs several iterations of the gradient descent algorithm
     *
     * @param alpha the learning rate
     *
     * @param numberOfSteps how many iteration of the algorithm to run
     */
	public void gradientDescent(double alpha, int numberOfSteps) {


		// your code goes there
		for(int i = 0; i < numberOfSteps; i++) {
			double sumTheta0 = 0;
			double sumTheta1 = 0;
			for(int k = 0; k < nbreOfSamples; k++) {
				sumTheta1 += (samplesValues[k] - hypothesis(samples[k])) * samples[k];
			}
			for(int j = 0; j < nbreOfSamples; j++) {
				sumTheta0 += samplesValues[j] - hypothesis(samples[j]);
			}

			sumTheta0 = -2 * sumTheta0 / nbreOfSamples;
			sumTheta1 = -2 * sumTheta1 / nbreOfSamples;
			theta0 -= (alpha * sumTheta0);
			theta1 -= (alpha * sumTheta1);
			iteration++;
		}

	}



	/**
     * Getter for theta0
     *
	 * @return theta0
	 */

	public double getTheta0(){
		// your code goes there
		return this.theta0;
	}

	/**
     * Getter for theta1
     *
	 * @return theta1
	 */

	public double getTheta1(){
		// your code goes there
		return this.theta1;
	}

	/**
     * Getter for samples
     *
	 * @return samples
	 */

	public double[] getSamples(){
		// your code goes there
		return this.samples;
	}

	/**
     * Getter for getSamplesValues
     *
	 * @return getSamplesValues
	 */

	public double[] getSamplesValues(){
		// your code goes there
		return this.samplesValues;
	}

	/**
     * Getter for iteration
     *
	 * @return iteration
	 */

	public int getIteration(){
		// your code goes there
		return this.iteration;
	}
}
