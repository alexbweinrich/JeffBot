import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class MainframeModel {

    private int currentJeffImageIndex = -1;

    private final ArrayList<String> jeffLocationArray;
    private final ArrayList<ImageIcon> jeffImageArray;
    private ArrayList<String> jeffQuoteArray;
    private final ArrayList<String> jeffQuoteArrayOrigin;

    public MainframeModel() {
        jeffLocationArray = new ArrayList<>();
        jeffImageArray = new ArrayList<>();
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
     * @author Alex Weinrich
     * @since 9/2/2020
     **/
    public ImageIcon getJeffImage() {
        int newInt;
        do {
            newInt = (int)(Math.random() * jeffImageArray.size());
        } while (currentJeffImageIndex == newInt);
        currentJeffImageIndex = newInt;
        return jeffImageArray.get(currentJeffImageIndex);
    }

    public String getJeffQuote() { //after cycling, it can hit the same quote
        if (jeffQuoteArray.isEmpty()) {
            jeffQuoteArray.addAll(jeffQuoteArrayOrigin);
        }

        int randQuoteLocation = (int)(Math.random() * jeffQuoteArray.size());

        return jeffQuoteArray.remove(randQuoteLocation);
    }

}
