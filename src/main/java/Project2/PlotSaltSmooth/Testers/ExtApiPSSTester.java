package Project2.PlotSaltSmooth.Testers;

import Project2.PlotSaltSmooth.Programs.ExternalAPIPrograms.ChartTool;
import Project2.PlotSaltSmooth.Programs.ExternalAPIPrograms.NewPlotter;
import Project2.PlotSaltSmooth.Programs.ExternalAPIPrograms.NewSalter;
import Project2.PlotSaltSmooth.Programs.ExternalAPIPrograms.NewSmoother;

public class ExtApiPSSTester {
    public static void main(String[] args) {

        //plotting

        //make plotter
        NewPlotter newPlotter = new NewPlotter();
        //amount to plot
        int numPoints = 500;
        //run plotter
        newPlotter.runProgram(numPoints);
        //make chart builder to display plot
        ChartTool chartBuilder = new ChartTool();
        String[] axisLabels = {"Input Values", "Function Output"};
        String theTitle = newPlotter.getTheFunction().replace(" x", "x");
        System.out.println(theTitle);
        //run chart builder
        chartBuilder.runProgram(newPlotter.getOutputPoints(), theTitle, axisLabels);

        //salting
        NewSalter newSalter = new NewSalter(newPlotter.getOutputPoints());
        try {
            newSalter.runProgram(null, newSalter.getSaltedPoints());
        }catch(Exception e){
            e.printStackTrace();
            }
        axisLabels[1] = "Salted Data Points";
        chartBuilder.runProgram(newSalter.getSaltedPoints(), theTitle, axisLabels);

        //smoothing
        NewSmoother newSmoother = new NewSmoother(newSalter.getSaltedPoints());
        int window = 10;
        try {
            newSmoother.runProgram(null, newSmoother.getSmoothedPoints(), window);
        }catch(Exception e){
            e.printStackTrace();
        }
        axisLabels[1] = "Smoothed Data Points";
        chartBuilder.runProgram(newSmoother.getSmoothedPoints(), theTitle, axisLabels);
    }
}
