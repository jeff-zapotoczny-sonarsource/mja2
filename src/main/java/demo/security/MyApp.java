package demo.security;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

public class MyApp {

    private DataManager dataManager;
    private ProprietaryFramework framework;

    /**
     * Start of a basic app implementation.
     */
    public MyApp() {
        dataManager = new DataManager();
        framework = new ProprietaryFramework();
    }

    public void getUser(HttpServletRequest request, Connection connection) {
        // add implementation later
    }

    public void saveData(HttpServletRequest request) throws IOException {
        // add implementation later
    }

    public void processInput() {
        String myInput = framework.getInput("stuff");
        framework.processParam(myInput);
        dataManager.storeData(myInput);
    }

    public void processInputSafely() {
        String myInput = framework.getInput("stuff");
        framework.verifyData(myInput);
        framework.processParam(myInput);
        dataManager.storeData(myInput);
    }
}
