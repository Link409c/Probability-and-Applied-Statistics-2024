package Project2.PlotSaltSmooth.Programs.UserDefinedPrograms;

import Project1.InterfacesAbstracts.FileAble;
import Project2.PlotSaltSmooth.Structures.Tuple;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

/**
 * Salter takes a csv file input and "salts" the data by adding or subtracting from
 * each value to change the plot, effectively scattering the information on an observable graph.
 **/

public class Salter implements FileAble {

  /**
   * gets a list of input and output points from a .csv file
   * and adds them as tuples to the global list variable of the
   * salter.
   * @param filePath the name of the file to import values from.
   * @throws IOException if the fileName is null or invalid.
   */
  public void importObjects(String filePath) throws IOException {
    //check for valid filetype (.csv)
    int fileTypeIndex = filePath.indexOf(".");
    //if invalid inform user
    if(!filePath.substring(fileTypeIndex).equalsIgnoreCase(".csv")){
      String errMsg = "importObjects: Passed file type is not valid. " +
              "Pass a .csv file to the method.";
      throw new IOException(errMsg);
    }
    //else add file to path and read in data
    else {
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
      setSaltedPoints(plottedPoints);
    }
  }

  /**
   * changes the values of each output point by adding some value.
   * if the passed value is null, salt the points by randomly adding
   * or subtracting from them.
   */
  public void salt(){
    ArrayList<Tuple<Double>> points = getSaltedPoints();
    Random r = new Random();
    int rand;
    //get each point from the list
    for(Tuple<Double> t : points) {
      rand = r.nextInt(1, 3);
      double saltValue = r.nextDouble(21);
      //check for non null input
      if (saltValue < 0 || saltValue >= 0) {
        //randomly choose negative or positive salt
        if(rand % 2 == 0) {
          t.setOutput(t.getOutput() + saltValue);
        }
        else{
          t.setOutput(t.getOutput() - saltValue);
        }
      }
      //if saltValue was null, randomly apply a value
      else {
        if (rand <= 50) {
          t.setOutput(t.getOutput() + r.nextInt((int) (t.getOutput() * 2.0)));
        } else {
          t.setOutput(t.getOutput() - r.nextInt((int) (t.getOutput() * 2.0)));
        }
      }
    }
    setSaltedPoints(points);
  }

  @Override
  public String addFileType(String fileName) {
    return fileName.concat(".csv");
  }

  @Override
  public String addIdentifier(String fileName) {
    //get the date and time
    String dateTime = String.valueOf(LocalDateTime.now());
    dateTime = dateTime.substring(0, dateTime.indexOf(":"));
    //add the date and time to the filename
    return fileName.concat(dateTime);
  }

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

  private BufferedWriter getBufferedWriter(String filePath, String header) throws IOException {
    FileWriter toCsv = new FileWriter(filePath);
    BufferedWriter csvWriter = new BufferedWriter(toCsv);
    //write the headers separated by commas on line 1
    csvWriter.write(header);
    //for each object in the list,
    for (Tuple<Double> t : getSaltedPoints()) {
      //write each line with the variables in order separated by commas
      csvWriter.newLine();
      csvWriter.write(t.getInput() + "," + t.getOutput());
    }
    return csvWriter;
  }

  public String runProgram(String filePath) throws IOException{
    //import the values
    importObjects(filePath);
    //if list is null, throw an exception
    if(getSaltedPoints() == null){
      String errMsg = "Imported values list is null.";
      throw new IOException(errMsg);
    }
    else {
      //else, run the salt
      salt();
    }
    //remove the plot filename from passed filepath
    String regex = "PlotTest";
    filePath = filePath.substring(0, filePath.indexOf(regex));
    //format the output filename
    filePath = filePath.concat("SaltTest");
    filePath = addIdentifier(filePath);
    filePath = addFileType(filePath);
    String header = "Input,Output";
    //export the values
    return exportObjects(filePath, header);
  }
  public Salter(){
    setSaltedPoints(new ArrayList<>());
  }

  public Salter(ArrayList<Tuple<Double>> data){
    setSaltedPoints(data);
  }
  public ArrayList<Tuple<Double>> getSaltedPoints() {
    return saltedPoints;
  }

  public void setSaltedPoints(ArrayList<Tuple<Double>> saltedPoints) {
    this.saltedPoints = saltedPoints;
  }

  //the plot data created with salt
  private ArrayList<Tuple<Double>> saltedPoints;
}
