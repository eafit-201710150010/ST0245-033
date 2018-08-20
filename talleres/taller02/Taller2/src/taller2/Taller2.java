

/**
 *
 * @author ljpalaciom
 */
public class Taller2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(gcd(345, 150));

        int[] arr = {2, 4, 8};
        System.out.println(groupSum(0, arr, 10));

        combinatoria("", "abc");
    }

    public static int gcd(int dividendo, int divisor) {
        if (divisor == 0) {
            return dividendo;
        }
        return gcd(divisor, dividendo % divisor);
    }

    public static boolean groupSum(int start, int[] nums, int target) {
        if (start >= nums.length) {
            return target == 0;
        }
        return groupSum(start + 1, nums, target - nums[start])
                || groupSum(start + 1, nums, target);
    }

    public static void combinatoria(String base, String s) {
        if (s.length() == 0) {
            System.out.println(base);
        } else {
            combinatoria(base + s.charAt(0), s.substring(1));
            combinatoria(base, s.substring(1));
        }
    }
}
