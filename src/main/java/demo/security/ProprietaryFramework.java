package demo.security;

/**
 * Beginnings of a custom app framework implementation to get user input,
 * process, and store it safely.
 */
public class ProprietaryFramework {

    public String getInput(String name) {
        // gets input data from end user
        return "something" + name;
    }

    public void processParam(String input) {
        // does some processing on the supplied param
    }

    public void verifyData(String input) {
        // validates and makes data safe for storage
    }

    public void storeData(String input) {
        // Stores data by running an OS command
    }
}
