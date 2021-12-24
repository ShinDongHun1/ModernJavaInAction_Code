package chapter3.level4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Execution {

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
            return p.process(br);
        }
    }

    public static void main(String[] args) throws IOException {
        processFile((BufferedReader br) -> br.readLine());                  //한 행을 처리하는 코드
        processFile((BufferedReader br) -> br.readLine() +  br.readLine()); //두 행을 처리하는 코드
    }
}
