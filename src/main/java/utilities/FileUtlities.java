package utilities;

import entities.Student;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class FileUtlities {

    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    public List<Student> readDataFromCSV(String fileName){
        List<Student> students = new ArrayList<>();
        ClassLoader classLoader = getClass().getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(fileName);
             InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");
                Student student = parseToStudent(attributes);
                students.add(student);
            }
        }catch (IOException ioe){
            System.out.println("File not found!");
        }
        students.remove(0);
        return students;
    }

    private static Student parseToStudent(String[] attributes) {
        int id = 0;
        double bonus = 0,reportMark = 0,appMark= 0,theoryMark = 0;
        if(attributes.length < 6){
            System.out.println("Missing rows! Please recheck the data");
        }
        if(isNumeric(attributes[0])) {
            id = Integer.parseInt(attributes[0]);
        }
        String name = attributes[1];
        String email = attributes[2];
        if(isNumeric(attributes[3])) {
            bonus = Double.parseDouble(attributes[3]);
        }
        if(isNumeric(attributes[4])) {
            reportMark = Double.parseDouble(attributes[4]);
        }
        if(isNumeric(attributes[5])) {
            appMark = Double.parseDouble(attributes[5]);
        }
        if(isNumeric(attributes[6])) {
            theoryMark = Double.parseDouble(attributes[6]);
        }
        return new Student(id, name, email, bonus,reportMark, appMark, theoryMark);
    }

    public void writeDataToFile(List<Student> students, String fileName){
        ClassLoader classLoader = getClass().getClassLoader();
        try{
            try (OutputStream os = new FileOutputStream(fileName);
                 OutputStreamWriter oos = new OutputStreamWriter(os, "UTF-8");) {
                oos.write("ID,Name,Email,Bonus,Report,App,LT,TD");
                oos.write("\n");
                for (int i = 0; i < students.size(); i++) {
                    oos.write(students.get(i).toString());
                }
                oos.flush();
            }
        }catch (IOException e) {
            System.out.println("File not found!");
        }
    }

    public void printDataToConsole(String fileName){
        List<Student> students = new ArrayList<>();
        File file = new File(fileName);
        if(file.exists() && file.canRead()){
            String line = null;
            BufferedReader in = null;
            try {
                in = new BufferedReader(new FileReader(file));
                while((line = in.readLine()) != null)
                {
                    System.out.println(line);
                }
                in.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            } catch (IOException e) {
                System.out.println("File not found!");
            }

        }
    }

}
