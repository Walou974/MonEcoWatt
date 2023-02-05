import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String host = "http://isis.unice.fr/~ga103969/ext/saejava";
        HashMap<String, StringBuilder> data = new HashMap<>();

        for (int i = 0; i <= 3; i++) {
            String folder = i + "_LastVars";
            try {
                URL ldateUrl = new URL(host + "/.dump/" + folder + "/Ldate");
                BufferedReader ldateIn = new BufferedReader(new InputStreamReader(ldateUrl.openStream()));
                String ldateInputLine;
                StringBuilder ldateData = new StringBuilder();
                while ((ldateInputLine = ldateIn.readLine()) != null) {
                    ldateData.append(ldateInputLine).append("\n");
                }
                ldateIn.close();
                data.put(folder + "/Ldate", ldateData);

                URL lmessUrl = new URL(host + "/.dump/" + folder + "/Lmess");
                BufferedReader lmessIn = new BufferedReader(new InputStreamReader(lmessUrl.openStream()));
                String lmessInputLine;
                StringBuilder lmessData = new StringBuilder();
                while ((lmessInputLine = lmessIn.readLine()) != null) {
                    lmessData.append(lmessInputLine).append("\n");
                }
                lmessIn.close();
                data.put(folder + "/Lmess", lmessData);

                for (int j = 1; j <= 24; j++) {
                    URL hUrl = new URL(host + "/.dump/" + folder + "/" + j + "h");
                    BufferedReader hIn = new BufferedReader(new InputStreamReader(hUrl.openStream()));
                    String hInputLine;
                    StringBuilder hData = new StringBuilder();
                    while ((hInputLine = hIn.readLine()) != null) {
                        hData.append(hInputLine).append("\n");
                    }
                    hIn.close();
                    data.put(folder + "/" + j + "h", hData);
                }
            } catch (IOException e) {
                System.out.println("Erreur lors de la lecture de l'URL " + folder + " : " + e.getMessage());
            }
        }
        System.out.println(data);
        // Ajout de la lecture du dossier tipss
        String tipsFolder = "tips";
        try {
            URL tipsUrl = new URL(host + "/.dump/tipss/" + tipsFolder);
            BufferedReader tipsIn = new BufferedReader(new InputStreamReader(tipsUrl.openStream()));
            String tipsInputLine;
            StringBuilder tipsData = new StringBuilder();
            while ((tipsInputLine = tipsIn.readLine()) != null) {
                tipsData.append(tipsInputLine).append("\n");
            }
            tipsIn.close();
            data.put(tipsFolder, tipsData);
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture de l'URL " + tipsFolder + " : " + e.getMessage());
        }
        System.out.println(data);
    }
}
