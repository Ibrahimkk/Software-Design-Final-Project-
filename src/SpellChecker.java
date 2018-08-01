package sdfinal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class SpellChecker implements SpellCheckerHandler {
    @Override
    public boolean getIfCorrect(String name) {
        String data = fetchIfCorrect(name);
        return Boolean.parseBoolean(data);
    }

    public URL createURL(String word) throws IOException {
        return new URL("http://agile.cs.uh.edu/spell?check=" + word);
    }

    public String fetchIfCorrect(String symbol) {
        try {
            URL spellChecker = createURL(symbol);
            URLConnection sc = spellChecker.openConnection();
            BufferedReader namesFile = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            String data = namesFile.readLine();
            namesFile.close();
            return data;
        } catch (IOException e) {
            throw new RuntimeException("Network Error");
        }
    }
}
