/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio1;

/**
 *
 * @author ljpalaciom
 */
public class coding {

    // Recursion1
    public boolean strCopies(String str, String sub, int n) {
        if (str.startsWith(sub)) {
            n--;
        }
        return str.length() == 0 ? n == 0 : strCopies(str.substring(1), sub, n);
    }

    public int strCount(String str, String sub) {
        if (str.length() < sub.length()) {
            return 0;
        }
        return str.startsWith(sub) ? 1 + strCount(str.substring(sub.length()), sub)
                : strCount(str.substring(1), sub);
    }

    public boolean nestParen(String str) {
        if (str.length() == 0) {
            return true;
        }
        return str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')'
                ? nestParen(str.substring(1, str.length() - 1)) : false;
    }

    public String parenBit(String str) {
        return str.startsWith("(") ? str.substring(0, str.indexOf(")") + 1)
                : parenBit(str.substring(1));
    }

    public String stringClean(String str) {
        if (str.length() == 1) {
            return str;
        }
        return str.charAt(0) == str.charAt(1) ? stringClean(str.substring(1))
                : str.charAt(0) + stringClean(str.substring(1));
    }
    
    //Recursion2
    public boolean groupSum6(int start, int[] nums, int target) {
        if (start == nums.length) {
            return target == 0;
        }
        return nums[start] == 6 ? groupSum6(start + 1, nums, target - 6)
                : groupSum6(start + 1, nums, target - nums[start])
                || groupSum6(start + 1, nums, target);
    }
}
