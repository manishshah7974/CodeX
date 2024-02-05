import com.sun.org.apache.xpath.internal.operations.Bool;

import java.math.BigInteger;
import java.util.ArrayList;

class CodeX {
    public static void main(String args[]){
        System.out.println("Welcome to Mathematics");
        boolean result [] = sieveOfErasthosthenes(200);
        for(int i=2;i<200;i++) {
            if(result[i])
                System.out.print(i+" ");
        }
    }
    static int countDigit(int num){
        int count =0;
        while(num!=0)
        {
            num = num/10;
            count++;
        }
        return count;
    }
    static boolean isPalindrome(int num){
        int originalNum = num;
        int rev = 0;
        while(num>0){
            rev = rev *10 + (num%10);
            num=num/10;
        }
        return rev == originalNum;
    }
    static BigInteger factorial(Integer num) {
        BigInteger res = BigInteger.ONE;
        for (int i = 1; i <= num; i++)
            res = res.multiply(BigInteger.valueOf(Integer.valueOf(i)));

        return res;
    }
    static int trailingZeroes(int num){
        int res= 0;
        BigInteger fact = factorial(num);
        System.out.println(fact);
        while(fact.remainder(BigInteger.TEN).equals(BigInteger.ZERO)){
            fact=fact.divide(BigInteger.TEN);
            res++;
        }
        return res;
    }
    static boolean isPrime(int n)
    {
        if(n==2 || n==3)
            return true;
        if(n%2==0 || n%3 ==0)
            return false;
        for(int i =5;i*i<=n;i+=6)
            if(n%i==0 || n%(i+2) == 0 )
                return false;
        return true;
    }
    static boolean[] sieveOfErasthosthenes(int n){
        boolean A[]=new boolean[n+1];
        for(int i=0;i<n+1;i++)
            A[i]=true;

        for(int i =2;i<=Math.sqrt(n);i++)
        {
            if(A[i]==true)
            for(int j=i*2;j<n;j+=i)
                A[j]=false;
        }
        return A;
    }
}
