package Project2.PlotSaltSmooth.Programs.UserDefinedPrograms;

import Project1.InterfacesAbstracts.FileAble;
import Project2.PlotSaltSmooth.Structures.Tuple;

import java.io.*;
import java.util.ArrayList;

/**
 * Smoother takes a list of data points, and using averages, "smooths" the scattering of the plot
 * to create a clearer, observable trend in a graph of sample points.
 */
public class Smoother implements FileAble {

    /**
     * using a moving average, "smooths" a list of data points to
     * clearly illustrate trends in the data.
     * @param window the size of the window to smooth values around.
     */
    public void smooth(int window) {
        //TODO: test with point being averaged as part of average as well
        // as excluding as is already done
        ArrayList<Tuple<Double>> points = getSmoothedPoints();
        int bound = points.size();
        double sum, movingAvg;
        for(int i = 0; i < bound; i++) {
            sum = 0;
            //set window bounds
            int lowBound = i - window;
            int upperBound = i + window;
            //set bounds to limits if outside range for list size
            if(lowBound < 0){
                lowBound = 0;
            }
            if(upperBound > bound){
                upperBound = bound;
            }
            //get number of points in moving average window
            int pointsAveraged = 0;
            //get sum of points in window behind i
            while(lowBound < i){
                sum += points.get(lowBound).getOutput();
                lowBound++;
                pointsAveraged++;
            }
            int j = i + 1;
            //get sum of points in window after i
            while(j < upperBound){
                sum += points.get(j).getOutput();
                j++;
                pointsAveraged++;
            }
            //calculate moving average
            movingAvg = sum / pointsAveraged;
            //set this average as points[i]
            points.get(i).setOutput(movingAvg);
        }
        setSmoothedPoints(points);
    }

    /**
     * gets a list of input and output points from a .csv file
     * and adds them as tuples to the global list variable of the
     * salter.
     * @param fileName the name of the file to import values from.
     * @throws IOException if the fileName is null or invalid.
     */
    public void importObjects(String fileName) throws IOException {
        String filePath = "E:\\Coding Projects\\Probability and Applied Statistics" +
                "\\src\\Project_2_Final\\Plot_Salt_Smooth\\Files";
        //check for valid filetype (.csv)
        int fileTypeIndex = fileName.indexOf(".");
        //if invalid inform user
        if (!fileName.substring(fileTypeIndex).equalsIgnoreCase(".csv")) {
            String errMsg = "importObjects: Passed file type is not valid. " +
                    "Pass a .csv file to the method.";
            throw new IOException(errMsg);
        }
        //else add file to path and read in data
        else {
            filePath = filePath.concat("\\" + fileName);
            //TODO: add check here for file existing in the specified path
            FileReader fr = new FileReader(filePath);
            BufferedReader bfr = new BufferedReader(fr);
            //skip the header
            bfr.readLine();
            ArrayList<Tuple<Double>> plottedPoints = new ArrayList<>();
            String next = bfr.readLine();
            while (next != null && !next.equals("")) {
                //split the string to get both points
                int regex = next.indexOf(',');
                //parse substrings to doubles
                double x = Double.parseDouble(next.substring(0, regex));
                double y = Double.parseDouble(next.substring(regex + 1));
                //add points to list in a tuple
                plottedPoints.add(new Tuple<>(x, y));
                //get next line in file
                next = bfr.readLine();
            }
            setSmoothedPoints(plottedPoints);
        }
    }

    /**
     * exports the tuples of input and output points to a .csv file.
     * @param fileName the desired name of the file.
     * @param header the header describing each column of the file.
     * @return a message informing the user the file was created.
     */
    public String exportObjects(String fileName, String header) throws IOException {
        //string to return
        String successMsg;
        if(fileName != null){
            //create file writer object with the filename input
            fileName = fileName.concat(".csv");
            //specify an absolute path for file
            //change this if testing on your own PC
            String filePath = "E:\\Coding Projects\\Probability and Applied Statistics\\" +
                    "src\\Project_2_Final\\Plot_Salt_Smooth\\Files";
            filePath = filePath.concat("\\" + fileName);
            FileWriter toCsv = new FileWriter(filePath);
            BufferedWriter csvWriter = new BufferedWriter(toCsv);
            //write the headers separated by commas on line 1
            csvWriter.write(header);
            //for each object in the list,
            for (Tuple<Double> t : getSmoothedPoints()) {
                //write each line with the variables in order separated by commas
                csvWriter.newLine();
                csvWriter.write(t.getInput() + "," + t.getOutput());
            }
            //after loop runs, close the file writer.
            csvWriter.close();
            //update success message informing user file was created.
            successMsg = fileName + " created in the specified directory: \n " + filePath;
        }
        //if any error with filename or path occurs,
        else {
            //throw an IO exception informing the user of the error
            String errMsg = "Error in file name or path specified in export method.";
            throw new IOException(errMsg);
        }
        //return the success message
        return successMsg;
    }

    public Smoother(){
        setSmoothedPoints(new ArrayList<>());
    }

    public ArrayList<Tuple<Double>> getSmoothedPoints() {
        return smoothedPoints;
    }

    public void setSmoothedPoints(ArrayList<Tuple<Double>> smoothedPoints) {
        this.smoothedPoints = smoothedPoints;
    }

    /**
     * The list of points whose outputs will be smoothed.
     */
    ArrayList<Tuple<Double>> smoothedPoints;
}
