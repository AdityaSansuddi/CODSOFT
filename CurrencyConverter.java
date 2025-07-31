import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import org.json.JSONObject;

public class CurrencyConverter {

    private static double getExchangeRate(String base, String target) throws Exception {
        String apiUrl = "https://api.exchangerate-api.com/v4/latest/" + base;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject json = new JSONObject(response.body());
        JSONObject rates = json.getJSONObject("rates");
        return rates.getDouble(target);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("!! Currency Converter !!");
        boolean again = true;

        while (again) {
            try {
                System.out.print("Enter base currency (e.g., USD): ");
                String base = scanner.next().toUpperCase();

                System.out.print("Enter target currency (e.g., INR): ");
                String target = scanner.next().toUpperCase();

                System.out.print("Enter amount in " + base + ": ");
                double amount = scanner.nextDouble();

                double rate = getExchangeRate(base, target);
                double convertedAmount = amount * rate;

                System.out.printf("\n%.2f %s = %.2f %s\n",
                        amount, base, convertedAmount, target);

            } catch (Exception e) {
                System.out.println("Error: Could not fetch exchange rate. Check internet connection or currency codes.");
            }

            System.out.print("\nDo you want to convert again? (yes/no): ");
            String choice = scanner.next().trim().toLowerCase();
            again = choice.equals("yes");
        }

        
        scanner.close();
    }
}
