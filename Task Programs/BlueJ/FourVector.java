import java.io.*;

class FourVector
{
    private double [] vec;

    public FourVector()
    {
	vec = new double[4];
    }

    public double GetElement(int i)
    {
	return vec[i];
    }
    
    public void SetElement(int i, double value)
    {
	vec[i] = value;
    }
    
    public double momentum()
    {
	double p = 0.;
	for (int i = 1; i < 4; i++) {
	    p += vec[i]*vec[i]; // equivalent to p = p + vec[i]*vec[i]
	}
	p = Math.sqrt(p);
	return p;
    }

    public double mass()
    {
	double p = momentum(); // reuse momentum method!
	return Math.sqrt(vec[0]*vec[0] - p*p);
    }

    public FourVector add(FourVector vec2)
    {
	FourVector sum = new FourVector();
	for (int i = 0; i < 4; i++) {
	    sum.SetElement(i, GetElement(i) + vec2.GetElement(i));
	}
	return sum;
    }

    public void Print(PrintWriter screen)
    {
        screen.println("E = " + GetElement(0)
		       + " GeV, px = " + GetElement(1)
		       + " GeV, py = " + GetElement(2)
		       + " GeV, pz = " + GetElement(3));
    }

    public void Input(PrintWriter screen, BufferedReader keyboard) throws IOException
    {
	screen.println("Enter E, px, py, pz in GeV");
	for (int i = 0; i < 4; i++) {
	    SetElement(i, new Double(keyboard.readLine()).doubleValue());
	}
    }
}
