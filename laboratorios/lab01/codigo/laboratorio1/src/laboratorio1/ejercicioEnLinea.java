package laboratorio1;

/**
 *
 * @author ljpalaciom
 */
public class ejercicioEnLinea {

    // Recursion1
    // 1
    public boolean strCopies(String str, String sub, int n) {
        if (str.startsWith(sub)) {
            n--;
        }
        return str.length() == 0 ? n == 0 : strCopies(str.substring(1), sub, n);
    }

    // 2
    public int strCount(String str, String sub) {
        if (str.length() < sub.length()) {
            return 0;
        }
        return str.startsWith(sub) ? 1 + strCount(str.substring(sub.length()), sub)
                : strCount(str.substring(1), sub);
    }

    // 3
    public int array11(int[] nums, int index) {
        int cont = 0; // C1
        if (nums.length == index) {
            return 0; //C2 + C3
        }
        if (nums[index] == 11) {
            cont++; //C4 + C5
        }
        return cont + array11(nums, index + 1); //T(n-1)
    }

    // 4
    public String parenBit(String str) {
        return str.startsWith("(") ? str.substring(0, str.indexOf(")") + 1)
                : parenBit(str.substring(1));
    }

    // 5
    public String stringClean(String str) {
        if (str.length() == 1) {
            return str;
        }
        return str.charAt(0) == str.charAt(1) ? stringClean(str.substring(1))
                : str.charAt(0) + stringClean(str.substring(1));
    }

    //Recursion2
    //6
    public boolean groupSum6(int start, int[] nums, int target) {
        if (start == nums.length) {
            return target == 0;
        }
        return nums[start] == 6 ? groupSum6(start + 1, nums, target - 6)
                : groupSum6(start + 1, nums, target - nums[start])
                || groupSum6(start + 1, nums, target);
    }

    // 7
    public boolean groupSum5(int start, int[] nums, int target) {
        if (start == nums.length) {
            return target == 0;
        }
        if (nums[start] % 5 == 0) {
            if (start < nums.length - 1 && nums[start + 1] == 1) {
                return groupSum5(start + 2, nums, target - nums[start]);
            }
            return groupSum5(start + 1, nums, target - nums[start]);
        }
        return groupSum5(start + 1, nums, target - nums[start])
                || groupSum5(start + 1, nums, target);
    }

    // 8
    public boolean splitArray(int[] nums) {
        return auxiliarSplitArray(0, nums, 0, 0);
    }

    public boolean auxiliarSplitArray(int start, int[] nums, int suma1, int suma2) {
        return nums.length == start ? suma1 == suma2
                : auxiliarSplitArray(start + 1, nums, suma1 + nums[start], suma2)
                || auxiliarSplitArray(start + 1, nums, suma1, suma2 + nums[start]);

    }

    // 9
    public boolean groupSumClump(int start, int[] nums, int target) {
        if (start == nums.length) {
            return target == 0;
        }
        int i = 1;
        while (start < nums.length - 1 && nums[start] == nums[start + 1]) {
            i++;
            start++;
        }
        return groupSumClump(start + 1, nums, target - i * nums[start])
                || groupSumClump(start + 1, nums, target);
    }

    // 10
    public boolean groupNoAdj(int start, int[] nums, int target) {
        if (start >= nums.length) {
            return target == 0;
        }
        return groupNoAdj(start + 2, nums, target - nums[start])
                || groupNoAdj(start + 1, nums, target);

    }

    // 11
    public boolean split53(int[] nums) {
        return splitAux(0, nums, 0, 0);
    }

    public boolean splitAux(int start, int[] nums, int sum1, int sum2) {
        if (start == nums.length) {
            return sum1 == sum2;
        }
        if (nums[start] % 5 == 0) {
            return splitAux(start + 1, nums, sum1 + nums[start], sum2);
        } else if (nums[start] % 3 == 0) {
            return splitAux(start + 1, nums, sum1, sum2 + nums[start]);
        }
        return splitAux(start + 1, nums, sum1 + nums[start], sum2)
                || splitAux(start + 1, nums, sum1, sum2 + nums[start]);

    }

}
