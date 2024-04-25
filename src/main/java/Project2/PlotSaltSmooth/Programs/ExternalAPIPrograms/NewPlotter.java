package Project2.PlotSaltSmooth.Programs.ExternalAPIPrograms;

import Project2.PlotSaltSmooth.Programs.UserDefinedPrograms.Plotter;
import Project2.PlotSaltSmooth.Structures.Tuple;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;

import java.util.ArrayList;
import java.util.Random;

public class NewPlotter extends Plotter {
    /**
     * creates a function using apache math commons and plots a list
     * of points using the input and output values, displayed with JFreeChart.
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
        double[] coefficients = new double[2];
        for(int i = 0; i < 1; i++){
            coefficients[i] = r.nextDouble(10);
        }
        PolynomialFunction pf = new PolynomialFunction(coefficients);
        //evaluate the function for each input value
        for(double d : getInputs()){
            //add the result to the output list
            getOutputPoints().add(new Tuple<>(d, pf.value(d)));
        }
        //plot using jfreechart
        //display results using jfreechart
    }
    public NewPlotter(){
        setInputs(new ArrayList<>());
        setOutputPoints(new ArrayList<>());
    }
}
