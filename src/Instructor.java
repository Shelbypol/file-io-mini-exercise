import java.util.ArrayList;
import java.util.List;

public class Instructor {
    private String name;

    public Instructor(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    Instructor(){};

    /**
     * This method takes in a list of Instructor objects and returns a list of name strings
     * @param instructors is a list of Instructor objects
     * @return a list of String objects based off of the names of the passed in list of Instructor objects
     */
    public static List<String> instructorsToNameStrings(List<Instructor> instructors) {
        List<String> names = new ArrayList<>();
        for (Instructor instructor : instructors) {
            names.add(instructor.getName());
        }
        return names;
    }

    /**
     * This method takes in a list of name strings and returns a list of Instructor objects
     * @param names is a list of name strings
     * @return a list of Instructor objects with matching names to the input list of name strings
     */
    public static List<Instructor> nameStringsToInstructors(List<String> names) {
        List<Instructor> instructors = new ArrayList<>();
        for (String name : names) {
            instructors.add(new Instructor(name));
        }
        return instructors;
    }
}
