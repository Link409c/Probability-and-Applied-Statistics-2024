package Project2.PlotSaltSmooth.Programs.UserDefinedPrograms;

import Project1.InterfacesAbstracts.FileAble;
import Project2.PlotSaltSmooth.Structures.Tuple;

import java.io.*;
import java.util.ArrayList;

/**
* Plotter plots a number of points using a defined function. The program then outputs
* these values to a .csv file users can view in Excel or similar software.
*/

public class Plotter implements FileAble{
  /**
   * plots output points using a simple function. In this case a parabola was chosen.
   * @param input the input value to pass to the function.
   * @return an associated output value.
   */

  public void runProgram(){
    //plot a number of points

  }
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
   * @param header the header describing each column of the file.
   * @return a message informing the user the file was created.
   */
  public String exportObjects(String filePath, String header) throws IOException{
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
