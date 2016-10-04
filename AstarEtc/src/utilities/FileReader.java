

package utilities;

import datastructures.MyArrayList;
import java.io.File;
import java.util.Scanner;

public class FileReader {
    
    
    public static MyArrayList readNetFromFile(File file) {
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
