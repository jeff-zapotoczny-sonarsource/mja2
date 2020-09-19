package demo.security;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MyApp {

    private DataManager dataManager;
    private Logger logger;

    public MyApp() {
        dataManager = new DataManager();
        logger = Logger.getLogger("myapp");
    }

    public void makeNewUser(HttpServletRequest request, Connection connection) {
        String user = request.getParameter("user");
        try {
            dataManager.taintedSQL(connection, user);
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, ex.getMessage());
        }
    }

    public void badFunction(HttpServletRequest request) throws IOException {
        String obj = request.getParameter("data");
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        mapper.readValue(obj, String.class);
        File tempDir;
        tempDir = File.createTempFile("", ".");
        tempDir.delete();
        tempDir.mkdir();
        Files.exists(Paths.get("/tmp/", obj));
    }

    public void customFrameworkInput(String name) {
        // TODO
    }

    public void doSomething() {
        //String myInput = getInput("Olivier"); // Get data from a source
        //processParam(myInput);
        //storeData(myInput); // store data w/o sanitizing --> Injection vulnerability
    }

    public void doSomethingSanitized() {
        //String myInput = getInput("Cameron"); // Get data from a source
        //verifyData(myInput); // Sanitize data
        //processParam(myInput);
        //storeData(myInput); // store data after sanitizing --> No injection vulnerability
    }
}
