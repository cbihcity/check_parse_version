import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 4/15/2016.
 */
public class  beauty {

    public static String dob(List<WebElement> result, List<WebElement> result1)

    {
        ArrayList<String> q = new ArrayList<>();
        for (WebElement el : result) {
            q.add(el.getText());
        }
        String gase = q.toString();

        ArrayList<String> q1 = new ArrayList<>();
        for (WebElement el1 : result1) {
            q1.add(el1.getText());
        }
        String gase1 = q1.toString();

        String z = "";
        int a=0;

        for (int i = 0; i < gase1.length(); i++) {
            int k = gase1.indexOf(",", i + 1);
            if (k != -1 && i == 0) {
                z =z+ gase1.substring(i + 1, k)+" - ";
            } else if (k != -1) {
                z = z+ gase1.substring(i + 1, k)+" - ";
            } else {k=gase1.lastIndexOf(",");
                z=z+gase1.substring(k+2,gase1.length()-1)+" - ";

            }
            i = k;

            for (int j = a; j < gase.length(); j++) {
                int d = gase.indexOf(",", j + 1);
                if (d != -1 && j == 0) {
                    z = z +" " + gase.substring(j + 2, d)+"\n";
                    a = d;
                    break;
                } else if (d != -1) {
                    z = z +" " + gase.substring(j + 3, d)+"\n";
                    a = d;
                    break;
                } else {d=gase.lastIndexOf(",");
                    z=z+" "+ gase.substring(d+3,gase.length()-1);
                    i=gase1.length()+1;
                    break;
                }
            }
        }
        return z;
    }
}
