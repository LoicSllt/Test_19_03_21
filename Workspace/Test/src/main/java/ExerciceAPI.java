import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Objectif de cet exercice : récupérer une information depuis une API.
 * @author Loïc
 *
 */
public class ExerciceAPI {
	
	public static void main(String[] args) throws ParseException {
		
		try {
			
			URL url = new URL("https://restcountries.eu/rest/v2/alpha/FR");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			//conn.setRequestProperty("Accept", "application/json");			//?
			
			//Lorsqu'on envoie une requête, on reçoit un code de réponse 200.
			//On s'assure donc que la requête fonctionne.
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "+ conn.getResponseCode());
			}
			
			//On lit ce que la connexion nous renvoie.
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			
			/*Permet de récupérer les données au format JSon.
			 * Ensuite, récupère en string la données appelé "capital".
			 */
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(br);
			String capital = (String) json.get("capital");
			
			System.out.println(capital);
			
			/* Code pour voir l'ensemble du JSon : 
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				System.out.println(capital);
			}
			*/
			conn.disconnect();
		} 
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}	
}