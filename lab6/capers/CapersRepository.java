package capers;

import java.io.File;
import static capers.Utils.*;

/** A repository for Capers 
 * @author TODO
 * The structure of a Capers Repository is as follows:
 *
 * .capers/ -- top level folder for all persistent data in your lab12 folder
 *    - dogs/ -- folder containing all of the persistent data for dogs
 *    - story -- file containing the current story
 *
 * TODO: change the above structure if you do something different.
 */
public class CapersRepository {
    /** Current Working Directory. */
    static final File CWD = new File(System.getProperty("user.dir"));

    /** Main metadata folder. */
    static final File CAPERS_FOLDER = join(CWD, ".capers"); // TODO Hint: look at the `join`
                                            //      function in Utils

    /** Folder that dogs live in. */
    static final File DOG_FOLDER = join(CWD, ".capers", "dogs"); // TODO (hint: look at the `join`
                                         //      function in Utils)
    /**
     * Does required filesystem operations to allow for persistence.
     * (creates any necessary folders or files)
     * Remember: recommended structure (you do not have to follow):
     *
     * .capers/ -- top level folder for all persistent data in your lab12 folder
     *    - dogs/ -- folder containing all of the persistent data for dogs
     *    - story -- file containing the current story
     */
    public static void setupPersistence() {
        // TODO
        // System.out.println("dir" + ":" + DOG_FOLDER);
        if (!CAPERS_FOLDER.exists()) {
            CAPERS_FOLDER.mkdir();
        }
        if (!DOG_FOLDER.exists()) {
            DOG_FOLDER.mkdir();
        }
        else {
            return;
        }
    }

    /**
     * Appends the first non-command argument in args
     * to a file called `story` in the .capers directory.
     * @param text String of the text to be appended to the story
     */
    public static void writeStory(String text) {
        // TODO
        // create a new story file if it doesn't exist        
        File story = join(CWD, ".capers", "story");
        if (story.exists()) {
            writeContents(story, readContentsAsString(story) + "\n" + text);
        }
        else {
            writeContents(story, text);
        }
    }

    public static String readStory() {
        File story = join(CWD, ".capers", "story");
        return readContentsAsString(story);
    }

    /**
     * Creates and persistently saves a dog using the first
     * three non-command arguments of args (name, breed, age).
     * Also prints out the dog's information using toString().
     */
    public static void makeDog(String name, String breed, int age) {
        // TODO
        Dog newDoggy = new Dog(name, breed, age);
        newDoggy.saveDog();        
        System.out.print(newDoggy.toString());
    }

    /**
     * Advances a dog's age persistently and prints out a celebratory message.
     * Also prints out the dog's information using toString().
     * Chooses dog to advance based on the first non-command argument of args.
     * @param name String name of the Dog whose birthday we're celebrating.
     */
    public static void celebrateBirthday(String name) {
        // TODO           
        File[] listOfFiles = DOG_FOLDER.listFiles();
  
        // Display the names of the files
        for (int i = 0; i < listOfFiles.length; i++) {
            String fileName = listOfFiles[i].getName();
            if (name.equals(fileName)) {                
                // TODO: clarify the correct format for saving the doggy 
                Dog doggyObj = Dog.fromFile(name);
                doggyObj.haveBirthday();
            }
        }
    }
}
