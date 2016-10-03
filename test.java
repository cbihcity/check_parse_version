import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Admin on 4/22/2016.
 */
public class test {

    public static void main(String[] args) {

        GregorianCalendar now = new GregorianCalendar();

        int today = now.get(Calendar.DAY_OF_MONTH);
        int month = now.get(Calendar.MONTH);

        now.set(Calendar.DAY_OF_MONTH,1);

        int weekday = now.get(Calendar.DAY_OF_WEEK);

        int firstDayOfWeek = now.getFirstDayOfWeek();

        int indent = 0;
        while (weekday!=firstDayOfWeek){
            indent++;
            now.add(Calendar.DAY_OF_MONTH,-1);
            weekday = now.get(Calendar.DAY_OF_WEEK);
        }

        String [] weekdayNames = new DateFormatSymbols().getShortWeekdays();

        do {
            System.out.printf("%s", weekdayNames[weekday]+" ");
            now.add(Calendar.DAY_OF_MONTH,1);
            weekday = now.get(Calendar.DAY_OF_WEEK);
        }
        while (weekday!=firstDayOfWeek);

        System.out.println();
         for (int i = 1; i <= indent; i++)
         System.out.print("");
        now.set(Calendar.DAY_OF_MONTH, 1);
         do
             {
             // вывести день недели
             int day = now.get(Calendar.DAY_OF_MONTH);
             System.out.printf("%3d", day);
            if (day == today) System.out.print ("*");
             else System.out.print(" ");
             now.add(Calendar.DAY_OF_MONTH, 1);
            weekday = now.get(Calendar.DAY_OF_WEEK);
             if (weekday == firstDayOfWeek) System.out.println ();
             }
         while (now.get(Calendar.MONTH) == month);
         if (weekday != firstDayOfWeek) System.out.println ();

    }
}
