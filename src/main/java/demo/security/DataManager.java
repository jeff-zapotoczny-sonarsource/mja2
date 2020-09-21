package demo.security;

public class DataManager {

    ProprietaryFramework framework;

    public DataManager() {
        framework = new ProprietaryFramework();
    }

    public void storeData(String data) {
        framework.storeData(data);
    }
}
