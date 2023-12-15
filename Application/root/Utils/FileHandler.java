package Utils;

import java.io.*;

/**
 * Class for creating text files and binary files.
 *
 * @author Alexandria Hansen, Sergiu Chirap
 * @version 2.0
 */
public class FileHandler {
    /**
     * Converts a string into text in a file with a given name.
     *
     * @param fileName the name and path of the file
     * @param text     String to be written to a text file
     * @throws FileNotFoundException exception if a file with the name and path given in FileName doesn't exist
     */
    public static void writeToTextFile(String fileName, String text) throws FileNotFoundException {
        writeText(fileName, text, false);
    }

    /**
     * Method to write a string to text file, used by convertToTextFile and appendToTextFile.
     *
     * @param fileName the name and path of the file
     * @param text     String to be appended to the text file
     * @param append   boolean for whether the text should be appended or not
     * @throws FileNotFoundException exception if a file with the name and path given in FileName doesn't exist
     */
    private static void writeText(String fileName, String text, boolean append) throws FileNotFoundException {
        PrintWriter convertToFile = null;

        try {
            FileOutputStream fileOut = new FileOutputStream(fileName, append);
            convertToFile = new PrintWriter(fileOut);
            convertToFile.println(text);
        } finally {
            if (convertToFile != null) {
                convertToFile.close();
            }
        }
    }

    /**
     * Converts object into binary file
     *
     * @param fileName name and path of the file
     * @param obj      object being converted into binary file
     * @throws FileNotFoundException exception if a file with the name and path given in FileName doesn't exist
     * @throws IOException           exception if there was an error converting the object
     */
    public static void saveAsBinaryFile(String fileName, Object obj) throws FileNotFoundException,
            IOException {
        ObjectOutputStream convertToFile = null;

        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            convertToFile = new ObjectOutputStream(fileOut);

            convertToFile.writeObject(obj);
        } finally {
            if (convertToFile != null) {
                try {
                    convertToFile.close();
                } catch (IOException e) {
                    System.out.println("IO encountered error trying to close file " + fileName);
                }
            }
        }
    }

    /**
     * Retrieves an object from binary file and converts to a string
     *
     * @param fileName name and path of the file
     * @return the object read from the file
     * @throws FileNotFoundException  exception if a file with the name and path given in FileName doesn't exist
     * @throws IOException            exception if there was an error reading the file
     * @throws ClassNotFoundException exception if the class of the objet cannot be found
     */
    public static Object getFromBinaryFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
        Object obj = null;
        ObjectInput getFromFile = null;
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            getFromFile = new ObjectInputStream(fileIn);
            try {
                obj = getFromFile.readObject();
            } catch (EOFException eof) {
            }
        } finally {
            if (getFromFile != null) {
                try {
                    getFromFile.close();
                } catch (IOException e) {
                    System.out.println("IO encountered error trying to close file " + fileName);
                }
            }
        }

        return obj;
    }
}