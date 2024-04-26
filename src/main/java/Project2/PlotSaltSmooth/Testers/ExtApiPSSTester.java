package Project2.PlotSaltSmooth.Testers;

import Project2.PlotSaltSmooth.Programs.ExternalAPIPrograms.ChartTool;
import Project2.PlotSaltSmooth.Programs.ExternalAPIPrograms.NewPlotter;

public class ExtApiPSSTester {
    public static void main(String[] args) {

        //plotting

        //make plotter
        NewPlotter newPlotter = new NewPlotter();
        //amount to plot
        int numPoints = 5001;
        //run plotter
        newPlotter.runProgram(numPoints);
        //make chart builder to display plot
        ChartTool chartBuilder = new ChartTool();
        String[] axisLabels = {"Input Values", "Output"};
        String theTitle = newPlotter.getTheFunction();
        //run chart builder
        chartBuilder.runProgram(newPlotter.getOutputPoints(), theTitle, axisLabels);

        //salting

        //smoothing
    }
}
