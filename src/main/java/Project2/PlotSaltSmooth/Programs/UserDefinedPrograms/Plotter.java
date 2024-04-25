package Project2.PlotSaltSmooth.Programs.UserDefinedPrograms;

import Project1.InterfacesAbstracts.FileAble;
import Project2.PlotSaltSmooth.Structures.Tuple;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

/**
* Plotter plots a number of points using a defined function. The program then outputs
* these values to a .csv file users can view in Excel or similar software.
*/

public class Plotter implements FileAble{

  /**
   * run the program by either creating or reading a list of input values
   * and plotting them with the associated function, and then creating an
   * output of the results.
   * @param numPoints the number of points to plot if no inputs exist in the list.
   */
  public String runProgram(String filePath, int numPoints) throws IOException{
    //if the input list has no values,
    if(getInputs() == null || getInputs().size() == 0) {
      Random r = new Random();
      //populate the list with random doubles
      for(int i = 0; i < numPoints; i++){
        double d = r.nextDouble(1, 5);
        getInputs().add(d);
      }
    }
    //plot every value in the input array
    plotFunction();
    //once plotting is finished, create output file
    filePath = filePath.concat("\\PlotTest");
    filePath = addIdentifier(filePath);
    filePath = addFileType(filePath);
    String header = "Input,Output";
    return exportObjects(filePath, header);
  }

  /**
   * plots output points using a simple function. In this case a parabola was chosen.
   * @param input the input value to pass to the function.
   * @return an associated output value.
   */
  public double calculateFunction(Double input){
    return Math.pow(input, 2);
  }
  /**
   * populates a list of pairs of associated inputs and outputs of a chosen function.
   */
  public void plotFunction() {
    int bound = getInputs().size();
    //pointCount times,
    for (int i = 0; i < bound; i++){
      //run the calculate function method using each input
      double input = getInputs().get(i);
      //add the input and output to a tuple
      double output = calculateFunction(input);
      //add that tuple to the list of points
      Tuple<Double> t = new Tuple<>(input, output);
      getOutputPoints().add(t);
    }
  }

  /**
   * imports a list of input points to be used with the plotter.
   * @param filePath the file path to be accessed.
   * @throws IOException if file path is null or path is invalid.
   */
  public void importObjects(String filePath) throws IOException {
    //TODO: add exception handling here  
    FileReader fr = new FileReader(filePath);
    BufferedReader bfr = new BufferedReader(fr);
    //skip the header
    bfr.readLine();
    ArrayList<Double> inputPoints = new ArrayList<>();
    //get all points in the .csv file
    String next = bfr.readLine();
    while (next != null) {
      inputPoints.add(Double.parseDouble(next));
      next = bfr.readLine();
    }
    setInputs(inputPoints);
  }

  /**
   * exports the tuples of input and output points to a .csv file.
   * @param filePath the desired name of the file.
   * @return a message informing the user the file was created.
   */
  @Override
  public String exportObjects(String filePath, String header) throws IOException {
    //string to return
    String successMsg;
    if(filePath != null){
      //create file writer object with the file path input
      BufferedWriter csvWriter = getBufferedWriter(filePath, header);
      //after loop runs, close the file writer.
      csvWriter.close();
      //update success message informing user file was created.
      successMsg = "File created in the specified directory: \n " + filePath;
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

  /**
   * adds the .csv filetype to the file name.
   * @param fileName the name of the file to be created
   * @return the
   */
  @Override
  public String addFileType(String fileName) {
    return fileName.concat(".csv");
  }

  /**
   * add the date to the filename.
   * @param fileName name of the file to be created
   * @return the filename with the date added.
   */
  @Override
  public String addIdentifier(String fileName) {
    //get the date and time
    String dateTime = String.valueOf(LocalDateTime.now());
    dateTime = dateTime.substring(0, dateTime.indexOf(":"));
    //add the date and time to the filename
    return fileName.concat(dateTime);
  }

  /**
   * helper method for output objects method. Handles Buffered Writer method calls.
   * @param filePath the filePath to write to.
   * @param header the header for the CSV file
   * @return a success message informing the user the write was successful.
   * @throws IOException if file path is bad.
   */
  private BufferedWriter getBufferedWriter(String filePath, String header) throws IOException {
    FileWriter toCsv = new FileWriter(filePath);
    BufferedWriter csvWriter = new BufferedWriter(toCsv);
    //write the headers separated by commas on line 1
    csvWriter.write(header);
    //for each object in the list,
    for (Tuple<Double> t : getOutputPoints()) {
      //write each line with the variables in order separated by commas
      csvWriter.newLine();
      csvWriter.write(t.getInput() + "," + t.getOutput());
    }
    return csvWriter;
  }

  public Plotter(){
    setInputs(new ArrayList<>());
    setOutputPoints(new ArrayList<>());
  }
  public ArrayList<Double> getInputs() {
    return inputs;
  }

  public void setInputs(ArrayList<Double> inputs) {
    this.inputs = inputs;
  }

  public ArrayList<Tuple<Double>> getOutputPoints() {
    return outputPoints;
  }

  public void setOutputPoints(ArrayList<Tuple<Double>> outputPoints) {
    this.outputPoints = outputPoints;
  }

  /**
   * A List of input values.
   */
  private ArrayList<Double> inputs;
  /**
   * List of output values from the given function.
   */
  private ArrayList<Tuple<Double>> outputPoints;
}
