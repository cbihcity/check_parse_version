import org.openqa.selenium.WebElement;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Admin on 4/15/2016.
 */
public class refresh {
    public static String url = "";
    TimerTask tt = new TimerTask() {
        @Override
        public void run() {
            try {
                List<WebElement> result = parseSite.parseSite(url);
                List<WebElement> result1 = parseSite.allBuild;

                showinfo.showInfo(result,result1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    public  void refresh()throws Exception{
        Timer timer = new Timer();
        timer.schedule(tt, new Date(),60000);
    }

}
