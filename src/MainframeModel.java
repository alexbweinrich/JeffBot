import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainframeModel {

    private final ArrayList<String> jeffLocationArray;
    private final ArrayList<ImageIcon> jeffImageArray;
    private final ArrayList<Boolean> jeffImageUsedTracker;
    private ArrayList<String> jeffQuoteArray;
    private final ArrayList<String> jeffQuoteArrayOrigin;

    public MainframeModel() {
        jeffLocationArray = new ArrayList<>();
        jeffImageArray = new ArrayList<>();
        jeffImageUsedTracker = new ArrayList<>();
        jeffQuoteArray = new ArrayList<>();
        jeffQuoteArrayOrigin = new ArrayList<>();
        initiateJeffArrays();
    }

    private void initiateJeffArrays() {
        jeffLocationArray.add("src/resources/images/jeff/Jeff_winger_season_one.jpg");
        jeffLocationArray.add("src/resources/images/jeff/Jeff_Winger_Season_Two.jpg");
        jeffLocationArray.add("src/resources/images/jeff/Jeff_Pillows_and_Blanket_portrait.jpg");
        jeffLocationArray.add("src/resources/images/jeff/4x13_Promotional_photo_1.jpg");
        jeffLocationArray.add("src/resources/images/jeff/5X1_Promo_pic8.jpg");
        jeffLocationArray.add("src/resources/images/jeff/Jeff_Season_Six_smug.jpg");

        for (String filename : jeffLocationArray) {
            jeffImageArray.add(new ImageIcon(filename));
        }

        for (ImageIcon icon : jeffImageArray) {
            jeffImageUsedTracker.add(Boolean.FALSE);
        }

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/resources/text/jeffQuotes.txt"));
            String line = reader.readLine();
            while (line != null) {
                jeffQuoteArrayOrigin.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (final Exception e) {
            e.printStackTrace();
        }

        jeffQuoteArray.addAll(jeffQuoteArrayOrigin);
    }

    /**
     * Pulls a random new Jeff Image from the Jeff Image array, such that it will cycle through all
     * Jeff images before reloading the same image twice.
     *
     * @author Marko Gidej
     * @since 12/14/2021
     **/
    public ImageIcon getJeffImage() {
        int newInt;
        boolean imageUsed;
        do {
            newInt = (int)(Math.random() * jeffImageArray.size());
            imageUsed = jeffImageUsedTracker.get(newInt);
        } while (imageUsed);
        jeffImageUsedTracker.set(newInt, true);
        if (!jeffImageUsedTracker.contains(false)) {
            Collections.fill(jeffImageUsedTracker, false);
        }
        return jeffImageArray.get(newInt);
    }

    public String getJeffQuote() { //after cycling, it can hit the same quote
        if (jeffQuoteArray.isEmpty()) {
            jeffQuoteArray.addAll(jeffQuoteArrayOrigin);
        }

        int randQuoteLocation = (int)(Math.random() * jeffQuoteArray.size());

        return jeffQuoteArray.remove(randQuoteLocation);
    }

}
