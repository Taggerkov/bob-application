package Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for creating files and binary files
 * @author Alexandria Hansen
 * @version 1.0
 */
public class FileHandler
{
  /**
   * Converts a string into text in a file with a given name
   * @param fileName  the name and path of the file
   * @param string    String to be converted to a text file
   * @throws FileNotFoundException exception if a file with the name and path given in FileName doesn't exist
   */
    public static void convertToTextFile(String fileName, String string) throws
        FileNotFoundException
    {
      write(fileName, string, false);
    }

  /**
   * Appends a string to a text file of a given name
   * @param fileName    the name and path of the file
   * @param string      String to be appended to the text file
   * @throws FileNotFoundException exception if a file with the name and path given in FileName doesn't exist
   */
    public static void appendToTextFile(String fileName, String string) throws FileNotFoundException
    {
      write(fileName, string, true);
    }

  /**
   * Method to convert a string to text file, used by convertToTextFile and appendToTextFile
   * @param fileName  the name and path of the file
   * @param string    String to be appended to the text file
   * @param append    boolean for whether the text should be appended or not
   * @throws FileNotFoundException exception if a file with the name and path given in FileName doesn't exist
   */
    private static void write(String fileName, String string, boolean append) throws FileNotFoundException
    {
      PrintWriter convertToFile = null;

      try
      {
        FileOutputStream fileOut = new FileOutputStream(fileName, append);
        convertToFile = new PrintWriter(fileOut);
        convertToFile.println(string);
      }
      finally
      {
        if (convertToFile != null)
        {
          convertToFile.close();
        }
      }
    }

  /**
   *    Converts strings from array into text in a file with a given name
   *    @param fileName  the name and path of the file
   *    @param strings    String array to be converted to a text file
   *    @throws FileNotFoundException exception if a file with the name and path given in FileName doesn't exist
   */
    public static void convertArrayToTextFile(String fileName, String[] strings) throws FileNotFoundException
    {
      writeText(fileName, strings, false);
    }
  /**
   * Appends strings from an array to a text file of a given name
   * @param fileName    the name and path of the file
   * @param strings      String array to be appended to the text file
   * @throws FileNotFoundException exception if a file with the name and path given in FileName doesn't exist
   */
    public static void appendArrayToTextFile(String fileName, String[] strings) throws FileNotFoundException
    {
      writeText(fileName, strings, true);
    }
  /**
   * Method to convert strings from an array to text file, used by convertArrayToTextFile and appendArrayToTextFile
   * @param fileName  the name and path of the file
   * @param strings   String array to be appended to the text file
   * @param append    boolean for whether the text should be appended or not
   * @throws FileNotFoundException exception if a file with the name and path given in FileName doesn't exist
   */
    private static void writeText(String fileName, String[] strings, boolean append) throws FileNotFoundException
    {
      PrintWriter convertToFile = null;

      try
      {
        FileOutputStream fileOutStream = new FileOutputStream(fileName, append);
        convertToFile = new PrintWriter(fileOutStream);

        for (int i = 0; i < strings.length; i++)
        {
          convertToFile.println(strings[i]);
        }
      }
      finally
      {
        if (convertToFile != null)
        {
          convertToFile.close();
        }
      }
    }

  /**
   * 
   * @param fileName
   * @return
   * @throws FileNotFoundException
   */
    public String readTextFile(String fileName) throws FileNotFoundException
    {
      Scanner readFile = null;
      String string = "";

      try
      {
        FileInputStream fileIn = new FileInputStream(fileName);
        readFile = new Scanner(fileIn);
        string = readFile.nextLine();
      }
      finally
      {
        if (readFile != null)
        {
          readFile.close();
        }
      }
      return string;
    }

    public static String[] getArrayFromTextFile(String fileName) throws FileNotFoundException
    {
      Scanner readFile = null;
      ArrayList<String> strings = new ArrayList<String>();

      try
      {
        FileInputStream fileIn = new FileInputStream(fileName);
        readFile = new Scanner(fileIn);

        while (readFile.hasNext())
        {
          strings.add(readFile.nextLine());
        }
      }
      finally
      {
        if (readFile != null)
        {
          readFile.close();
        }
      }

      String[] stringsArray = new String[strings.size()];
      return strings.toArray(stringsArray);
    }

    public static void convertToBinaryFile(String fileName, Object obj) throws FileNotFoundException,
        IOException
    {
      ObjectOutputStream convertToFile = null;

      try
      {
        FileOutputStream fileOut = new FileOutputStream(fileName);
        convertToFile = new ObjectOutputStream(fileOut);

        convertToFile.writeObject(obj);
      }
      finally
      {
        if (convertToFile != null)
        {
          try
          {
            convertToFile.close();
          }
          catch (IOException e)
          {
            System.out.println("IO encountered error trying to close file " + fileName);
          }
        }
      }
    }

    public static void convertArrayToBinaryFile(String fileName, Object[] objects) throws FileNotFoundException, IOException
    {
      ObjectOutputStream convertToFile = null;

      try
      {
        FileOutputStream fileOut = new FileOutputStream(fileName);
        convertToFile = new ObjectOutputStream(fileOut);

        for (int i = 0; i < objects.length; i++)
        {
          convertToFile.writeObject(objects[i]);
        }
      }
      finally
      {
        if (convertToFile != null)
        {
          try
          {
            convertToFile.close();
          }
          catch (IOException e)
          {
            System.out.println("IO encountered error trying to close file " + fileName);
          }
        }
      }
    }

    public static Object getFromBinaryFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException
    {
      Object obj = null;
      ObjectInput getFromFile = null;
      try
      {
        FileInputStream fileIn = new FileInputStream(fileName);
        getFromFile = new ObjectInputStream(fileIn);
        try
        {
          obj = getFromFile.readObject();
        }
        catch (EOFException eof)
        {
        }
      }
      finally
      {
        if (getFromFile != null)
        {
          try
          {
            getFromFile.close();
          }
          catch (IOException e)
          {
            System.out.println("IO encountered error trying to close file " + fileName);
          }
        }
      }

      return obj;
    }

    public static Object[] getArrayFromBinaryFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException
    {
      ArrayList<Object> objects = new ArrayList<Object>();

      ObjectInputStream getFromFile = null;
      try
      {
        FileInputStream fileIn = new FileInputStream(fileName);
        getFromFile = new ObjectInputStream(fileIn);
        while (true)
        {
          try
          {
            objects.add(getFromFile.readObject());
          }
          catch (EOFException eof)
          {
            //Done reading
            break;
          }
        }
      }
      finally
      {
        if (getFromFile != null)
        {
          try
          {
            getFromFile.close();
          }
          catch (IOException e)
          {
            System.out.println("IO encountered error trying to close file " + fileName);
          }
        }
      }

      return objects.toArray();
    }

}
