import java.io.*;
import java.util.Random;

class MakeHistograms
{
    static BufferedReader keyboard = new BufferedReader (new InputStreamReader(System.in)) ;
    static PrintWriter screen = new PrintWriter(System.out, true);
    static Random randGen = new Random();

    private static double nearGauss(double mean, double sigma)
    {
	// add up 12 random numbers
	double sum = 0.;
	for (int n = 0 ; n < 12; n++) {
	    sum = sum + randGen.nextDouble();
	}
	return (mean + sigma*(sum - 6.0));
    }

    public static void main (String [] args ) throws IOException
    {       
	// create an instance of the Class Histogram: 20 bins from 0.0 to 1.0
	Histogram hist = new Histogram(20, 0.0, 1.0);      
	
	screen.println( "Input the number of random numbers to generate");
	int trials = new Integer(keyboard.readLine()).intValue();
	for (int i = 0; i < trials; i++) {
	    double value = randGen.nextDouble();
	    hist.fill(value);
	}

	long sum = 0;
	for (int bin = 0; bin < hist.getSize(); bin++) {
	    screen.println("Bin " + bin + " = " + hist.getContent(bin));
	    sum = sum + hist.getContent(bin);
	}
	screen.println("The number of trials = " + trials
		       + " , the sum of the contents = " + sum );
	
	// hist.writeToDisk("test.csv"); // method does not exist yet
    }
}
       	
