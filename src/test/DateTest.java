import java.util.Calendar;
import java.util.Date;

public class DateTest {

    public static void main(String[] args) {
        Date time = Calendar.getInstance().getTime();
        System.out.println(time.getTime());
        Date date = new Date();
        System.out.println(date.getTime());

    }
}
