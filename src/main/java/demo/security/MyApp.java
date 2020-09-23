package demo.security;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyApp {

    private DataManager dataManager;
    private Logger logger;
    private ProprietaryFramework framework;

    public MyApp() {
        dataManager = new DataManager();
        framework = new ProprietaryFramework();
        logger = Logger.getLogger("myapp");
    }

    public void getUser(HttpServletRequest request, Connection connection) {
        String user = request.getParameter("user");
        try {
            dataManager.getUser(connection, user);
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, ex.getMessage());
        }
    }

    public void saveData(HttpServletRequest request) throws IOException {
        String data = request.getParameter("data");
        File tempDir;
        tempDir = File.createTempFile("", ".");
        tempDir.delete();
        tempDir.mkdir();
        Files.exists(Paths.get("/tmp/", data));
        // incomplete implementation
    }

    public void modResponse(HttpServletResponse response) {
        Cookie c = new Cookie("SECRET", "SECRET");
        response.addCookie(c);
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
