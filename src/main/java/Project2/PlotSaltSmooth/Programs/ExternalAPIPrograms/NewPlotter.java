package Project2.PlotSaltSmooth.Programs.ExternalAPIPrograms;

import Project2.PlotSaltSmooth.Programs.UserDefinedPrograms.Plotter;
import Project2.PlotSaltSmooth.Structures.Tuple;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;

import java.util.ArrayList;
import java.util.Random;

public class NewPlotter extends Plotter {
    /**
     * creates a function using apache math commons and creates a list
     * of points using the input and output values.
     * @param numPoints the number of points to plot.
     */
    public void runProgram(int numPoints){
        //object for function generation
        Random r = new Random();
        //create inputs if no imported data
        if(this.getInputs().isEmpty()){
            for(int i = 0; i < numPoints; i++){
                getInputs().add(r.nextDouble(5));
                }
            }
        //create polynomial using math commons
        PolynomialFunction pf = new PolynomialFunction(makeCoefficients(r));
        //set string literal to global variable for identification
        setTheFunction(pf.toString());
        setTheFunction(getTheFunction());
        //evaluate the function for each input value
        for(double d : getInputs()){
            //add the result to the output list
            getOutputPoints().add(new Tuple<>(d, pf.value(d)));
        }
    }

    /**
     * create coefficients with 2 significant figures for use in initializing polynomial.
     * @param random the random object used in generating values
     * @return an array of double values.
     */
    public double[] makeCoefficients(Random random){
        //array to return
        //number of coefficients determines degree of polynomial
        double[] coefficients = new double[3];
        //create values
        for(int i = 0; i < 3; i++){
            //value before decimal
            int theInput = random.nextInt(-5,6);
            String units = ".";
            //2 significant digits after decimal
            for(int j = 0; j < 2; j++){
                int sigUnit = random.nextInt(10);
                units = units.concat(String.valueOf(sigUnit));
            }
            units = theInput + units;
            coefficients[i] = Double.parseDouble(units);
        }
        return coefficients;
    }

    public NewPlotter(){
        setInputs(new ArrayList<>());
        setOutputPoints(new ArrayList<>());
        setTheFunction("");
    }

    public String getTheFunction() {
        return theFunction;
    }

    public void setTheFunction(String theFunction) {
        this.theFunction = theFunction;
    }

    /**
     * String representation of the function generated using Apache.
     */
    private String theFunction;
}
