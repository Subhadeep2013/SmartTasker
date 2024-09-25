import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class MotivationService {
    private static final String API_URL = "https://api.quotable.io/random";

    public static void getDailyMotivation() {
        try {
            // Create a URL object
            URL url = new URL(API_URL);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Check the response code
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // HTTP_OK = 200
                // Read the response
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();

                // Parse JSON response
                JSONObject quoteJson = new JSONObject(content.toString());
                String quote = quoteJson.getString("content");
                String author = quoteJson.getString("author");

                // Display the motivational quote
                System.out.println("Motivational Quote: \"" + quote + "\" - " + author);
            } else {
                System.out.println("Failed to retrieve the quote. Response Code: " + responseCode);
            }
        } catch (Exception e) {
            System.out.println("An error occurred while fetching the motivational quote.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getDailyMotivation();
    }
}
