package Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for creating files and binary files.
 *
 * @author Alexandria Hansen, Sergiu Chirap
 * @version 1.5
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
     * Adds a string to a text file of a given name.
     *
     * @param fileName the name and path of the file
     * @param text     String to be added to the text file
     * @throws FileNotFoundException exception if a file with the name and path given in FileName doesn't exist
     */
    public static void addToTextFile(String fileName, String text) throws FileNotFoundException {
        writeText(fileName, text, true);
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
     * Write strings array in a text file with the given name.
     *
     * @param fileName the name and path of the file
     * @param text     String array to be written to a text file
     * @throws FileNotFoundException exception if a file with the name and path given in FileName doesn't exist
     */
    public static void writeArrayToTextFile(String fileName, String[] text) throws FileNotFoundException {
        writeText(fileName, text, false);
    }

    /**
     * Adds strings array in a text file with the given name.
     *
     * @param fileName the name and path of the file
     * @param text     String array to be added to the text file
     * @throws FileNotFoundException exception if a file with the name and path given in FileName doesn't exist
     */
    public static void addsArrayToTextFile(String fileName, String[] text) throws FileNotFoundException {
        writeText(fileName, text, true);
    }

    /**
     * Method to write strings from an array to text file, used by convertArrayToTextFile and appendArrayToTextFile
     *
     * @param fileName the name and path of the file
     * @param text     String array to be appended to the text file
     * @param append   boolean for whether the text should be appended or not
     * @throws FileNotFoundException exception if a file with the name and path given in FileName doesn't exist
     */
    private static void writeText(String fileName, String[] text, boolean append) throws FileNotFoundException {
        PrintWriter convertToFile = null;

        try {
            FileOutputStream fileOutStream = new FileOutputStream(fileName, append);
            convertToFile = new PrintWriter(fileOutStream);

            for (String s : text) {
                convertToFile.println(s);
            }
        } finally {
            if (convertToFile != null) {
                convertToFile.close();
            }
        }
    }

    /**
     * Reads the first line of a text file.
     *
     * @param fileName name and path of the file
     * @return a string with the line read from the file
     * @throws FileNotFoundException exception if a file with the name and path given in FileName doesn't exist
     */
    public String readTextFile(String fileName) throws FileNotFoundException {
        Scanner readFile = null;
        String text;

        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            readFile = new Scanner(fileIn);
            text = readFile.nextLine();
        } finally {
            if (readFile != null) {
                readFile.close();
            }
        }
        return text;
    }

    /**
     * Reads full text file.
     *
     * @param fileName name and path of the file
     * @return an array containing every line from the file
     * @throws FileNotFoundException exception if a file with the name and path given in FileName doesn't exist
     */
    public static String[] readArrayFromTextFile(String fileName) throws FileNotFoundException {
        Scanner readFile = null;
        ArrayList<String> text = new ArrayList<>();

        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            readFile = new Scanner(fileIn);

            while (readFile.hasNext()) {
                text.add(readFile.nextLine());
            }
        } finally {
            if (readFile != null) {
                readFile.close();
            }
        }

        String[] stringsArray = new String[text.size()];
        return text.toArray(stringsArray);
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
     * Converts an array of objects into a binary file
     *
     * @param fileName name and path of the file
     * @param objects  object array tob e converted into file
     * @throws FileNotFoundException exception if a file with the name and path given in FileName doesn't exist
     * @throws IOException           exception if there was an error converting the array
     */
    public static void convertArrayToBinaryFile(String fileName, Object[] objects) throws FileNotFoundException, IOException {
        ObjectOutputStream convertToFile = null;

        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            convertToFile = new ObjectOutputStream(fileOut);

            for (int i = 0; i < objects.length; i++) {
                convertToFile.writeObject(objects[i]);
            }
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

    /**
     * Retrieves all objects from a file and creates an object array
     *
     * @param fileName name and path of the file
     * @return an object array with all the objects from the file
     * @throws FileNotFoundException  exception if a file with the name and path given in FileName doesn't exist
     * @throws IOException            exception if there was an error reading the file
     * @throws ClassNotFoundException exception if the class of the object cannot be found
     */
    public static Object[] getArrayFromBinaryFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<Object> objects = new ArrayList<Object>();

        ObjectInputStream getFromFile = null;
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            getFromFile = new ObjectInputStream(fileIn);
            while (true) {
                try {
                    objects.add(getFromFile.readObject());
                } catch (EOFException eof) {
                    //Done reading
                    break;
                }
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

        return objects.toArray();
    }

}
