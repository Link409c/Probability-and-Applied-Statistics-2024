package Project2.OtherPrograms;

import Project1.InterfacesAbstracts.FileAble;
import Project2.PlotSaltSmooth.Structures.Tuple;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class CSVMaker<E> implements FileAble {

    /**
     * Import data from a csv and return a list of some type to be used by another program.
     * @param filePath the absolute filepath to access the file from
     * @return a list of data to be used by a program.
     * @throws IOException
     */
    @Override
    public E importObjects(String filePath) throws IOException {

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
