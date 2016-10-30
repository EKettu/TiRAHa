package utilities;

import datastructures.MyArrayList;
import java.io.File;
import java.util.Scanner;

/**
 * Reads .txt-files containing maps and mazes
 *
 * @author ekettu
 */
public class FileReader {

    /**
     * Method to read a net of nodes from a file
     *
     * @param file File, received as a parameter, contains the net
     * @return MyArrayList containing the net as strings
     */
    public MyArrayList readNetFromFile(File file) {
        MyArrayList stringArray = new MyArrayList();

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String string = scanner.nextLine();
                stringArray.add(string);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error in reading the file");
            return null;
        }
        return stringArray;
    }
}
