import org.openqa.selenium.WebElement;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class http {

    public static void main(String[] args) throws Exception {
        showinfo info = new showinfo();
        refresh ref = new refresh();
        ref.refresh();
        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();
            ActionListener listener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        List<WebElement> result = parseSite.parseSite(refresh.url);
                        List<WebElement> result1 = parseSite.allBuild;
                        SimpleDateFormat ft = new SimpleDateFormat("dd.MM  'at' hh:mm:ss");
                        info.showinfo(result,result1);
                        if (info.trig==1){
                            info.trayIcon.displayMessage("PG-BUILD"+ft.format(new Date()),"No updates", TrayIcon.MessageType.INFO);
                        }
                    } catch (Exception l) {
                        System.out.println(l);
                    }
                }
            };
            ActionListener stateAction = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        info.message();
                    } catch (Exception l) {
                        System.out.println(l);
                    }
                }
            };
            PopupMenu popup = new PopupMenu();
            MenuItem defaultItem = new MenuItem("Check");
            defaultItem.addActionListener(listener);
            popup.add(defaultItem);
            info.trayIcon.setPopupMenu(popup);
            info.trayIcon.addActionListener(stateAction);
            try {
                tray.add(info.trayIcon);
            } catch (AWTException e) {
                System.err.println(e);
            }
        }
    }
}