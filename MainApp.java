import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.io.*;
import java.net.*; 
import javax.xml.crypto.dsig.spec.HMACParameterSpec;
import requests;
import org.json.simple.JSONObject;

public class MainApp{
    public static void main(String[] args) throws Exception{
        URL url = new URL("http://isis.unice.fr/~ga103969/ext/saejava/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        URLConnection urlConnection = url.openConnection();
        System.out.println(urlConnection.getContent());
        connection.setRequestMethod("GET");
        connection.connect();
        InputStream stream = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = reader.readLine()) != null) {
        result.append(line);
        }
        reader.close();
        // utilisez la bibliothèque JSON de votre choix pour parser le contenu de la réponse en objet Java
        Gson gson = new Gson();
        MyObject object = gson.fromJson(result.toString(), MyObject.class);
   
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))){
            String line;
            while((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        }
}
}

