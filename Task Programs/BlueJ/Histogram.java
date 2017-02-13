import java.io.*;

class Histogram
{	
    private double binlow, binhigh;
    private double binsize;
    private int SIZE;  

    // integer array to store the actual histogram data
    private int[] hist;
    private long underflow, overflow;

    // constructor for the class Histogram
    public Histogram(int size, double low, double high)
    {
	// store the parameters and setup the histogram
	// note that parameters need to have different names than class variables
	SIZE = size;
	binlow = low;
	binhigh = high;

	binsize = (binhigh - binlow) / (double) SIZE;
	hist = new int[SIZE];
	underflow = 0;
	overflow = 0;
    }

    //-------------------------------------
    // instance methods start here
    //-------------------------------------

    public int getSize()
    {
	return SIZE;
    }

    //----------------------------------------
    public void fill(double value)
    {
	if (value < binlow) {
	    underflow++;
	} else if (value >= binhigh) {
	    overflow++;
	} else {
	    // add 1 to the correct bin
	    int bin = (int) ( (value - binlow)/binsize);
	    hist[bin]++;
	}
    }

    //-------------------------------------
    public int getContent(int nbin)
    {
	// returns the contents on bin 'nbin' to the user
	return hist[nbin];
    }
}
