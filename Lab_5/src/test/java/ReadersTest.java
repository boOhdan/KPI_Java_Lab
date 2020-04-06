package test.java;

import main.Reader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadersTest {
    @Test
    public void TestReadFile() throws IOException {
        Reader readersTest =new Reader("D:\\Junk\\input.txt");
        readersTest.readFile();

        File file = new File("D:\\Junk\\input.txt");
        Scanner sc = new Scanner(file);

        List<String> expectList= new ArrayList<>();

        while (sc.hasNextLine())
            expectList.add(sc.nextLine());

        assertEquals(expectList, readersTest.getLinesList());
    }
    @Test
    public void TestWrongInputPath(){
        String wrongPath= "D:\\input.txt";

        Reader readersTest =new Reader(wrongPath);

        boolean actual =readersTest.readFile();

        assertEquals(false, actual);
    }
    @Test
    public void TestWriteText(){
        Reader reader =new Reader("D:\\Junk\\input.txt" ,"D:\\Junk\\output.txt");
        reader.readFile();

        List<String> expectedList =new ArrayList<>(reader.getLinesList());

        expectedList.sort(new Comparator<String>() {
            @Override
            public int compare(String s, String s1) {
                return s.length() - s1.length();
            }
        });
        reader.writeFile();

        reader.setInputPath("D:\\Junk\\output.txt");
        reader.readFile();

        List<String> actualList =new ArrayList<>(reader.getLinesList());

        assertEquals(expectedList, actualList);
    }
}

