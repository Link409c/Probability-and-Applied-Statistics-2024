package Project1.InterfacesAbstracts;

import java.io.IOException;

/**
* FileAble is an interface designed to be implemented in programs which users want to 
* import and export data.
**/

public interface FileAble {

    /**
     * importObjects takes a filepath from parameters or input by the user and loads data
     * from lines of a file into a data structure.
     */
    void importObjects(String filePath) throws IOException;

    /**
     * adds a file type suffix to a filename, derived from the filepath or passed manually.
     */
    String addFileType(String fileName);

    /**
     * add some unique identifier to the fileName to help user identify exported files
     */
    String addIdentifier(String fileName);

    /**
     * exportObjects creates a file from a list of objects and their associated fields.
     * Assume the method throws an IOException due to the use of fileReader or BufferedReader.
     * @return a message informing the user if the file was created.
     */
    String exportObjects(String filePath, String header) throws IOException;
}
