package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Reader {
    String inputPath;
    String outputPath;
    List<String> linesList;

    public String getInputPath() {
        return inputPath;
    }

    public void setInputPath(String path) {
        this.inputPath = path;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String path) {
        this.outputPath = path;
    }

    public List<String> getLinesList() {
        return linesList;
    }

    public Reader(String inputPath, String outputPath){
        this.inputPath = inputPath;
        this.outputPath = outputPath;
        linesList = new ArrayList<>();
    }

    public Reader(String inputPath){
        this.inputPath = inputPath;
        linesList = new ArrayList<>();
    }

    public boolean readFile(){
        try(BufferedReader reader = new BufferedReader(new FileReader(inputPath)))
        {
            linesList.clear();

            Scanner sc = new Scanner(reader);

            while (sc.hasNextLine())
                linesList.add(sc.nextLine());

            return true;
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public boolean writeFile(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));)
        {

            List<String> list =new ArrayList<>(linesList);

            list.sort(new Comparator<String>() {
                @Override
                public int compare(String s, String s1) {
                    return s.length() - s1.length();
                }
            });

            for (String line: list) {
                writer.write(line +"\n");
            }

            writer.close();

            return true;
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
}