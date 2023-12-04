package Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler
{
    public static void convertToTextFile(String fileName, String string) throws
        FileNotFoundException
    {
      write(fileName, string, false);
    }
    public static void appendToTextFile(String fileName, String string) throws FileNotFoundException
    {
      write(fileName, string, true);
    }

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


    public static void convertArrayToTextFile(String fileName, String[] strings) throws FileNotFoundException
    {
      writeText(fileName, strings, false);
    }

    public static void appendArrayToTextFile(String fileName, String[] strings) throws FileNotFoundException
    {
      writeText(fileName, strings, true);
    }

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
