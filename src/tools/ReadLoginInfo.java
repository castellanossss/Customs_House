package tools;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadLoginInfo {
    private FileReader fileReader;
    private BufferedReader reader;
    private ArrayList<String> usernames;
    private ArrayList<String> passwords;

    public ReadLoginInfo(String path) throws FileNotFoundException {
        fileReader = new FileReader(path);
        reader = new BufferedReader(fileReader);
        usernames = new ArrayList<>();
        passwords = new ArrayList<>();
    }

    public void readFile() throws IOException {
        String line = "";
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("username")) {
                String[] parts = line.split(" = ");
                usernames.add(parts[1]);
            } else if (line.startsWith("password")) {
                String[] parts2 = line.split(" = ");
                passwords.add(parts2[1]);
            }
        }
    }

    public void closeFile() throws IOException {
        reader.close();
        fileReader.close();
    }

    public ArrayList<String> getUsernames() {
        return usernames;
    }

    public ArrayList<String> getPasswords() {
        return passwords;
    }

}
