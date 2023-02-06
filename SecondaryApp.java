import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SecondaryApp {
    public static void main(String[] args) throws Exception{
        String baseUrl = "http://isis.unice.fr/~ga103969/ext/saejava/.dump/";
        List<String> todtab = new ArrayList<String>();
        List<String> tomtab = new ArrayList<String>();
        List<String> afttomtab = new ArrayList<String>();
        for (int i = 0; i <= 3; i++) {
            for (int j = 1; j <= 24; j++) {
                String finalUrl = baseUrl + i + "_LastVars/" + j + "h";
                URL u = new URL(finalUrl);
                Scanner s = new Scanner(u.openStream());
                switch(i){
                    case 0:                            
                        todtab.add(s.nextLine());
                        break;
                    case 1:                            
                        tomtab.add(s.nextLine());
                        break;
                    case 2:
                        afttomtab.add(s.nextLine());
                        break;
                        
                }
            }            
        }
               
        System.out.println("Today Tab : " + todtab + " Size : " + todtab.size());
        System.out.println("Tommorow Tab : " + tomtab + " Size : "+ tomtab.size());
        System.out.println("After-Tommorow Tab : " + afttomtab + " Size : "+ afttomtab.size());
    }  
}
