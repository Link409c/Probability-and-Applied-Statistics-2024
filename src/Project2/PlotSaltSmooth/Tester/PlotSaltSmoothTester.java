package Project2.PlotSaltSmooth.Tester;

import Project2.PlotSaltSmooth.Programs.UserDefinedPrograms.Plotter;
import Project2.PlotSaltSmooth.Programs.UserDefinedPrograms.Salter;
import Project2.PlotSaltSmooth.Programs.UserDefinedPrograms.Smoother;

import java.io.IOException;
import java.util.Random;

/**
 * tester class for the plotter, salter, and smoother programs.
 */
public class PlotSaltSmoothTester {
    public static void main(String[] args) {
        Plotter plotter = new Plotter();
        Random r = new Random();
        //populate the list with random doubles
        for(int i = 0; i < 5001; i++){
            double d = r.nextDouble(1, 5);
            plotter.getInputs().add(d);
        }
        //plot some values
        plotter.plotFunction();
        //export
        String fileName = "plotterTest";
        String header = "Input,Output";
        try {
            System.out.println(plotter.exportObjects(fileName, header));
        }catch(IOException i){
            i.printStackTrace();
        }
        //import from plotter output file
        Salter salter = new Salter();
        fileName = fileName.concat(".csv");
        try{
            salter.importObjects(fileName);
        }catch(IOException i){
            i.printStackTrace();
        }
        //check data was imported correctly
        /*
        System.out.println("Import Data from plotter output file:");
        for(Tuple<Double> t : salter.getSaltedPoints()){
            System.out.println(t.getInput() + ", " + t.getOutput());
        }
        */
        //salt the values
        salter.salt();
        //export
        fileName = "saltTest";
        try {
            System.out.println(salter.exportObjects(fileName, header));
        }catch(IOException i){
            i.printStackTrace();
        }
        //import from salter output file
        Smoother smoother = new Smoother();
        fileName = fileName.concat(".csv");
        try{
            smoother.importObjects(fileName);
        }catch(IOException i){
            i.printStackTrace();
        }
        int theWindow = 10;
        //smooth the values
        smoother.smooth(theWindow);
        //check smoothed values
        /*System.out.println("Smoothing points from salter output file:");
        for(Tuple<Double> t : smoother.getSmoothedPoints()){
            System.out.println(t.getInput() + ", " + t.getOutput());
        }*/
        //export
        fileName = "smoothTest";
        try{
            System.out.println(smoother.exportObjects(fileName, header));
        }catch(IOException i){
            i.printStackTrace();
        }
    }
}
