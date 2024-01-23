package Interfaces;

import java.io.IOException;

public interface FileAble {

    /**
     * importObjects takes a filepath from parameters or input by the user and loads data
     * from lines of a .csv into a data structure.
     */
    void importObjects(String filePath) throws IOException;

    /**
     * exportObjects creates a .csv file from a list of objects and their associated fields.
     * Assume the method throws an IOException due to the use of fileReader or BufferedReader.
     * @return a message informing the user if the file was created.
     */
    String exportObjects(String filePath, String header) throws IOException;
    //create string to return
    //create the csv file
    //create the string filepath, specifying a directory path
    //concat the csv file string to filepath
    //using file writer object with the filepath input
    //write the headers separated by commas on line 1
    //for each object in the list,
    //write each line with the variables in order separated by commas
    //after loop runs, close the file writer.
    //update success message informing user file was created.
    //if any error with filename or filepath occurs,
    //throw an IO exception informing the user of the error
    //return the success message

    //adds a file type suffix to a filename, derived from the filepath or passed manually.
    String addFileType(String fileName);
}
