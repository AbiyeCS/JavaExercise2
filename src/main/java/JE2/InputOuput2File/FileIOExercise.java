package JE2.InputOuput2File;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Scanner;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class FileIOExercise {
    private static final Path STUDENTS = Path.of("students.txt");

    public static void main(String[] args) {
        // How to create a file
        try {
            File myObj = new File("TestFile.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // TODO: Write a list of names to "students.txt"
        try {
            FileWriter myWriter = new FileWriter("TestFile.txt");
            // This above line will create a new file automatically, if can't find one meaning you don't need to actually.
            // go through the process of adding code to create the file
            myWriter.write("Abz, Charlie");
            myWriter.write("John");
            myWriter.write("Matthew");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // How to do it using BufferedWriter which seems to be the better way
        try (BufferedWriter w = Files.newBufferedWriter(STUDENTS, StandardCharsets.UTF_8)) {
            // Created a PATH url at the top and just refers to it here
            // Also did it using try-with resources so as soon as your done it closes. I rememeber Miki teaching me about this
            w.write("Abz"); w.newLine();
            w.write("Charlie"); w.newLine();
            w.write("John"); w.newLine();
            w.write("Matthew"); w.newLine();
        } catch (IOException e) {
            System.err.println("Write failed: " + e.getMessage());
            return;
        }

        // TODO: Read the file and print each line
        try {
            File myObj = new File("TestFile.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()){
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        }catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // Another way to read the file
        try (var lines = Files.lines(STUDENTS, StandardCharsets.UTF_8)) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Read failed: " + e.getMessage());
        }

        // TODO: Count how many lines are in the file
        int num = 0;
        try {
            File myObj = new File("TestFile.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()){
                String data = myReader.nextLine();
                num++;
            }
            myReader.close();
        }catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("No of Lines in File: "+num);

        // TODO: Use NIO Files API to copy the file
        Path source = Paths.get("TestFile.txt");
        Path nwdir = Paths.get("/Users/abiye/Documents/Coding/JavaExercise2/src/main/resources/");
        try
        {
            Files.copy(source, nwdir.resolve(source.getFileName()), REPLACE_EXISTING);
            System.out.println("File Copied");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
