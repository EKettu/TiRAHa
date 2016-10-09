

package utilities;

import datastructures.MyArrayList;
import java.io.File;
import java.util.Scanner;

public class FileReader {
    
    /**
     * Method to read a net of nodes from a file
     * @param file File, received as a parameter, contains the net
     * @return MyArrayList containing the net as strings
     */   
    public MyArrayList readNetFromFile(File file) {
        MyArrayList stringArray = new MyArrayList();
        
        try {
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()) {
            stringArray.add(scanner.nextLine());
        }
        scanner.close();
        }
        catch(Exception e) {
            System.out.println("Error in reading the file");
        }
        
        return stringArray;
    }
    
}
