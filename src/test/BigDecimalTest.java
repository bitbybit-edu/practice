import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BigDecimalTest {

    public static void main(String[] args) {
        List<String> aList = new ArrayList<>(1 << 2);
        aList.add("1");
        aList.add("2");
        aList.add("3");
        aList.add("4");
        List<String> collect = aList.stream().filter(item -> item.equals("1")).collect(Collectors.toList());
        System.out.println(collect);
    }
}
