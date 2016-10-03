import org.openqa.selenium.WebElement;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 4/15/2016.
 */
public class showinfo {
    public static String state ="";
    public static int trig=0;
    public static Date dateState;
    static Image image = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\icon.jpg");
    static TrayIcon trayIcon = new TrayIcon(image, "Builds");

    public static void showInfo (List<WebElement> result, List<WebElement> result1)throws Exception{

        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("dd.MM  'at' hh:mm:ss");
        String z=beauty.dob(result,result1);
        dateState =dNow;
        if (!state.contentEquals(z)){
            trayIcon.displayMessage("PG-BUILD"+" "+ft.format(dateState), z, TrayIcon.MessageType.INFO);
            state=z;
            trig=0;
       } else {trig=1;}
    }

    public void message (){
        SimpleDateFormat ft = new SimpleDateFormat("dd.MM  'at' hh:mm:ss");
        trayIcon.displayMessage("PG-BUILD"+" "+ft.format(dateState), state, TrayIcon.MessageType.INFO);
    }

}
