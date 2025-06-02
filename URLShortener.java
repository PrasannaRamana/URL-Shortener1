import java.util.HashMap;

public class URLShortener {
    private HashMap<String, String> urlMap = new HashMap<>();
    private static final String BASE_URL = "https://short.ly/";
    private int counter = 1000;

    // Shorten a given URL
    public String shortenURL(String longURL) {
        String shortCode = Integer.toString(counter, 36); // Convert counter to Base36
        urlMap.put(shortCode, longURL);
        counter++;
        return BASE_URL + shortCode;
    }

    // Retrieve the original URL
    public String getOriginalURL(String shortURL) {
        String shortCode = shortURL.replace(BASE_URL, "");
        return urlMap.getOrDefault(shortCode, "URL not found");
    }

    public static void main(String[] args) {
        URLShortener shortener = new URLShortener();

        // Example usage
        String longURL = "https://www.example.com/my-long-url";
        String shortURL = shortener.shortenURL(longURL);
        System.out.println("Shortened URL: " + shortURL);

        // Retrieve original URL
        String originalURL = shortener.getOriginalURL(shortURL);
        System.out.println("Original URL: " + originalURL);
    }
}
