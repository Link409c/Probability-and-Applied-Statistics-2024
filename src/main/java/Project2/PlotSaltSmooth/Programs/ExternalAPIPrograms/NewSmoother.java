package Project2.PlotSaltSmooth.Programs.ExternalAPIPrograms;

import Project2.PlotSaltSmooth.Programs.UserDefinedPrograms.Smoother;
import Project2.PlotSaltSmooth.Structures.Tuple;

import java.io.IOException;
import java.util.ArrayList;

public class NewSmoother extends Smoother {
    public void runProgram(String filePath, ArrayList<Tuple<Double>> plottedPoints) throws IOException {
        //if plottedPoints is null,
        if(plottedPoints == null) {
            //if filePath is null or invalid,
            if (filePath == null || filePath.isEmpty()) {
                //throw an exception
                throw new IllegalArgumentException("Passed data to the salter is not valid.");
                //else import the data from a file.
            } else {
                importObjects(filePath);
            }
        }
        //smooth the data
        for(Tuple<Double> t : getSmoothedPoints()){
            //call smoothing function from apache here for each output value
        }
    }
}
