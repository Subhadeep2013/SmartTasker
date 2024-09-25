import java.util.Random;

public class MotivationService {
    // List of predefined motivational quotes
    private static final String[] QUOTES = {
            "Believe you can and you're halfway there.",
            "Don't watch the clock; do what it does. Keep going.",
            "The only way to do great work is to love what you do.",
            "You are never too old to set another goal or to dream a new dream.",
            "Success is not final, failure is not fatal: It is the courage to continue that counts.",
            "Your time is limited, don't waste it living someone else's life.",
            "The harder you work for something, the greater you’ll feel when you achieve it."
    };

    // Method to display a random motivational quote
    public static void getDailyMotivation() {
        // Randomly pick a quote from the list
        Random random = new Random();
        int index = random.nextInt(QUOTES.length);

        // Display the selected quote
        System.out.println("Motivational Quote: " + QUOTES[index]);
    }
}
