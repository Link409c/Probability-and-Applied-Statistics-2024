package Project2.PlotSaltSmooth.Testers;

import Project2.PlotSaltSmooth.Programs.UserDefinedPrograms.Plotter;
import Project2.PlotSaltSmooth.Programs.UserDefinedPrograms.Salter;
import Project2.PlotSaltSmooth.Programs.UserDefinedPrograms.Smoother;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * tester class for the plotter, salter, and smoother programs.
 */
public class PlotSaltSmoothTester {

    /**
     * add the filename to a directory along with any known identifier and the file type.
     * used specifically in the tester to get accurate file paths for input data created
     * from plotting and salting.
     * @param fileName name of the file
     * @param filePath directory of the file
     * @return the properly formatted absolute filepath
     */
    public static String formatFilePath(String fileName, String filePath){
        String dateTime = String.valueOf(LocalDateTime.now());
        dateTime = dateTime.substring(0, dateTime.indexOf(":"));
        return filePath.concat("\\" + fileName).concat(dateTime).concat(".csv");
    }

    public static void main(String[] args) {
        Plotter plotter = new Plotter();
        String filePath = "E:\\Coding Projects\\Probability-and-Applied-Statistics-2024\\src\\main" +
                "\\java\\Project2\\PlotSaltSmooth\\Results\\OutputFiles";
        //change this value to represent the size of the dataset
        int numPoints = 501;
        try {
            System.out.println(plotter.runProgram(filePath, numPoints));
        }catch(IOException i){
            i.printStackTrace();
            System.exit(-1);
        }
        //import from plotter output file
        Salter salter = new Salter();
        String saltInput = formatFilePath("PlotTest", filePath);
        //check data was imported correctly
        /*
        System.out.println("Import Data from plotter output file:");
        for(Tuple<Double> t : salter.getSaltedPoints()){
            System.out.println(t.getInput() + ", " + t.getOutput());
        }
        */
        //run salter
        try {
            System.out.println(salter.runProgram(saltInput));
        }catch(IOException i){
            i.printStackTrace();
        }
        //import from salter output file
        Smoother smoother = new Smoother();
        String smoothInput = formatFilePath("SaltTest", filePath);
        //check smoothed values
        /*System.out.println("Smoothing points from salter output file:");
        for(Tuple<Double> t : smoother.getSmoothedPoints()){
            System.out.println(t.getInput() + ", " + t.getOutput());
        }*/
        //change this value to determine the area to calculate an average around a point
        int window = 10;
        //run smoother
        try{
            System.out.println(smoother.runProgram(smoothInput, window));
        }catch(IOException i){
            i.printStackTrace();
        }
    }
}
