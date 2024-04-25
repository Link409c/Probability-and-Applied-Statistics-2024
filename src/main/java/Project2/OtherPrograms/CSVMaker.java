package Project2.OtherPrograms;

import Project1.InterfacesAbstracts.FileAble;
import Project2.PlotSaltSmooth.Structures.Tuple;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class CSVMaker<E> implements FileAble {

    public int getColumns(String aLine){
        //will always be at least 1 column if no commas
        int columns = 1;
        //if there are commas,
        if(aLine.contains(",")) {
            //count the amount
            while (aLine.contains(",")) {
                aLine = aLine.substring(aLine.indexOf(',') + 1);
                columns++;
            }
        }
        return columns;
    }

    public int getNumVariables(E dataContainer){
        int count = 0;
        //make a new instance of the passed class
        //count each of its variables
        //return the number
        return count;
    }

    /**
     * populates a list with objects populated using imported data from a .csv file,
     * mapping each column to a global variable of the passed data structure.
     * @param filePath the path to import the file from.
     * @return a list of objects to be used by some program.
     * @throws IOException if the filepath is invalid or no file exists.
     */
    @Override
    public E importObjects(String filePath, ) throws IOException {
        //TODO: add exception handling here
        FileReader fr = new FileReader(filePath);
        BufferedReader bfr = new BufferedReader(fr);
        //skip the header
        bfr.readLine();
        //get the number of columns
        String aLine = bfr.toString();
        int columns = getColumns(aLine);
        //get the number of global parameters of the structure to import data into
        int numVariables = getNumVariables();
        //map each parameter to each column value
        E struct = getData().newInstance();
        //get all points in the .csv file
        String next = bfr.readLine();
        //break up lines into the associated values
        while (next != null) {
            //map the values to each associated parameter
            //get each variable
            //move to next line
            next = bfr.readLine();
        }
        return struct;
    }

    /**
     * add the file type suffix to the filename.
     * @param fileName name of the file to create
     * @return the file name + .csv
     */
    @Override
    public String addFileType(String fileName) {
        return fileName.concat(".csv");
    }

    /**
     * adds the date as a unique identifier to an output filename.
     * @param fileName the name of the file to create
     * @return the file name + date in YYYY-MM-DD format
     */
    @Override
    public String addIdentifier(String fileName) {
        //get the date and time
        String dateTime = String.valueOf(LocalDateTime.now());
        dateTime = dateTime.substring(0, dateTime.indexOf("T"));
        //add the date and time to the filename
        return fileName.concat(dateTime);
    }

    @Override
    public String exportObjects(String filePath, String header) throws IOException {
        String successMsg;
        //error handling
        if(filePath != null && (!header.equals("") || header != null)){
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
        return null;
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
        //get the list of data to export
        //count its global variables
        //count the number of commas + 1 in header
        //these 2 should match
        //for each data point in the list,
        for (E e : getData()) {
            //write each line with the variables in order separated by commas
            csvWriter.newLine();
            csvWriter.write(t.getInput() + "," + t.getOutput());
        }
        return csvWriter;
    }

    public E getData(){
        return data;
    }

    /**
     * List of data to export into a .csv file
     */
    private E data;
}
