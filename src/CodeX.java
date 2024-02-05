import com.sun.org.apache.xpath.internal.operations.Bool;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CodeX {
    public static void main(String args[]) {
        System.out.println("Welcome to Mathematics");
        int a[] = {1, 1, 2, 2, 3, 3, 3, 3, 5, 145};
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < a.length; i++)
            arr.add(a[i]);
        System.out.println(twoOddOccuring(arr));
    }

    static int countDigit(int num) {
        int count = 0;
        while (num != 0) {
            num = num / 10;
            count++;
        }
        return count;
    }

    static boolean isPalindrome(int num) {
        int originalNum = num;
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + (num % 10);
            num = num / 10;
        }
        return rev == originalNum;
    }

    static BigInteger factorial(Integer num) {
        BigInteger res = BigInteger.ONE;
        for (int i = 1; i <= num; i++)
            res = res.multiply(BigInteger.valueOf(Integer.valueOf(i)));

        return res;
    }

    static int trailingZeroes(int num) {
        int res = 0;
        BigInteger fact = factorial(num);
        System.out.println(fact);
        while (fact.remainder(BigInteger.TEN).equals(BigInteger.ZERO)) {
            fact = fact.divide(BigInteger.TEN);
            res++;
        }
        return res;
    }

    static boolean isPrime(int n) {
        if (n == 2 || n == 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i * i <= n; i += 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        return true;
    }

    static boolean[] sieveOfErasthosthenes(int n) {
        boolean A[] = new boolean[n + 1];
        int i;
        for (i = 0; i < n + 1; i++)
            A[i] = true;

        for (i = 2; i <= Math.sqrt(n); i++) {
            if (A[i] == true)
                for (int j = i * 2; j < n; j += i)
                    A[j] = false;
        }
        return A;
    }

    // Power Set Using Bitwise
    static ArrayList<ArrayList<Character>> powerSet(String a) {
        ArrayList<ArrayList<Character>> res = new ArrayList<>();
        int n = (int) Math.pow(2, a.length());
        for (int i = 0; i < n; i++)   //8
        {
            res.add(new ArrayList<Character>());
            for (int j = 0; j < a.length(); j++) {
                if (((i >> j) & 1) == 1) {
                    res.get(i).add(a.charAt(j));
                }
            }
        }
        return res;
    }

    static ArrayList<Integer> twoOddOccuring(ArrayList<Integer> arr) {
        // I/O = { 1,1,2,2,3,3,3,3,5,7 } , O/P = {5,7}
        // XOR of Input
        // lsb of above ( that is one )
        // finding in list --> having lsb set & not set
        int allXor = 0;
        for (int i = 0; i < arr.size(); i++)
            allXor ^= arr.get(i);  // 5 --> 0101  , 7 --> 0111    >> - 0010
        System.out.println("allXOR "+allXor);
        int k = 1;  // position of first set bit from right
        while (allXor > 0) {
            if ((allXor & 1) == 0) {
                k = k << 1;
                allXor = allXor >> 1;
            }
            else {
                break;
            }
        }
        int num1 =0, num2=0;
        for(int i=0;i<arr.size();i++){
           if((arr.get(i)&k)!=0)
               num1 = num1^arr.get(i);
           else
               num2 =num2^arr.get(i);
        }
        ArrayList<Integer> pair = new ArrayList<>();
        pair.add(num1);
        pair.add(num2);
        return pair;
    }
}