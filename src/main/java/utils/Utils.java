package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Utils {

    public static String getDateAfterDays(int numberOfDays) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, numberOfDays);

        SimpleDateFormat format1 = new SimpleDateFormat("dd, yyyy");
        String  date = format1.format(c.getTime());
        if(date.charAt(0) == '0')
            date = date.substring(1);

        return c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH ) + " " +  date;
    }
}
