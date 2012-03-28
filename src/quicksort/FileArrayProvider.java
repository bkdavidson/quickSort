/*

* To change this template, choose Tools | Templates

* and open the template in the editor.

*/

package quicksort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileArrayProvider {
     public static List<Integer> readLines(String filename) throws IOException {

        FileReader fileReader = new FileReader(filename);
        List<Integer> lines;
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            lines = new ArrayList<>();
            String stringline = null;
            while ((stringline = bufferedReader.readLine()) != null) {
                int line = Integer.parseInt(stringline);
                lines.add(line);
            }
        }
         return lines;
     }

}

