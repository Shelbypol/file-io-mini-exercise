import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class FileIoMiniExercise extends Instructor {
    public static void main(String[] args) {

        // TODO: define the path to the instructor-names.txt file
        Path instructorNames = Paths.get("src", "instructor-names.txt");

        // TODO: uncomment the following variable declarations
        // TODO: read the contents of the instructor-names.txt file and store the list of strings into the 'names' variable
        // TODO: assign the 'instructors' variable a list of Instructor objects with names matching the list of strings/names from the text file (the Instructor class has a helpful method for this)

        String[] indName = {"Sophie", "Justin", "Fred", "Trant", "Vivian"};
        List<String> names = Arrays.asList(indName);
        List<Instructor> instructors = nameStringsToInstructors(names);

        // TODO: greet all instructors by their names
//        for (String name : names) {
//            System.out.println("Hello, " + name);
//        }
        greetInstructors(instructors);
//        System.out.println(instructors);

        // TODO: change "Fred" to "David" in the list of Instructor objects
        List<String> newList = new ArrayList<>();
        for(String name : names){
            if(name.equals("Fred")){
                newList.add("David");
                continue;
            }try{
                Files.write(instructorNames, newList);
            }catch(IOException e){
                e.printStackTrace();
            }
            newList.add(name);
        }
        changeFredToDavid(instructors);

        // TODO: update the list of strings/names ('names' variable) to the latest names from the Instructor objects (the Instructor class has a helpful method for this)

        names = instructorsToNameStrings(instructors);
        System.out.println(names);

        // TODO: overwrite the instructors-names.txt file with the latest list of names
        try{
            List<String> overwrite = Files.readAllLines(instructorNames);
            System.out.println(overwrite);
        }catch(IOException e){
            e.printStackTrace();
        }
//        System.out.println(names);


        // TODO: uncomment the following line
        System.out.println("============== after name change...");

        // TODO: greet instructors again (no need to reread the text file again; just use the existing list of instructors in memory)
        greetInstructors(instructors);

    }

    /**
     * This method takes in a list of Instructor objects and prints out "Hello, NAME!" for each Instructor object's name
     *
     * @param instructors is a list of Instructor objects
     */
    public static void greetInstructors(List<Instructor> instructors) {
        for (Instructor instructor : instructors) {
            System.out.printf("Hello, %s!%n", instructor.getName());
        }
    }

    /**
     * This method takes in a list of Instructor objects and changes the name of the Instructor with a name of "Fred" to "David"
     *
     * @param instructors is a list of Instructor objects
     */
    public static void changeFredToDavid(List<Instructor> instructors) {
        for (Instructor instructor : instructors) {
            if (instructor.getName().equals("Fred")) {
                instructor.setName("David");
            }
        }
    }

}
