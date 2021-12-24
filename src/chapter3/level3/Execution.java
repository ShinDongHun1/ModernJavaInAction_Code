package chapter3.level3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Execution {

    public String processFile(BufferedReaderProcessor p) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
            return p.process(br);
        }
    }
}
