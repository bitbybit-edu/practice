import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ATest {
    public static final Logger logger = LogManager.getLogger(ATest.class);

    public static void main(String[] args) {
        int[] a = new int[]{1, 2};
//        rotate(a, 3);
        rotate2(a, 3);
    }

    public static void rotate(int[] nums, int k) {
        int[] tmpArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmpArray[(i + 3) % (nums.length)] = nums[i];
        }
        nums = tmpArray;
        logger.info("result = {}", nums);
    }

    public static void rotate2(int[] nums, int k) {
        int length = nums.length;
        if (k >= length)
            k = k % length;
        if (k == 0) return;
        int[] tmpArray = new int[k];
        for (int i = 0; i < length; i++) {
            int tmp = tmpArray[i % k];
            tmpArray[i % k] = nums[(i + k) % length];
            if (i < k) {
                nums[(i + k) % length] = nums[i];
            } else {
                nums[(i + k) % length] = tmp;
            }
        }

        logger.info("result = {}", nums);
    }
}
