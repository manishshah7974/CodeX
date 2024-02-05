import com.sun.org.apache.xpath.internal.operations.Bool;

import java.math.BigInteger;
import java.util.ArrayList;

class CodeX {
    public static void main(String args[]){
        System.out.println("Welcome to Mathematics");
        System.out.println(powerSet("abc"));
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
        int i;
        for(i=0;i<n+1;i++)
            A[i]=true;

        for(i =2;i<=Math.sqrt(n);i++)
        {
            if(A[i]==true)
            for(int j=i*2;j<n;j+=i)
                A[j]=false;
        }
        return A;
    }
    // Power Set Using Bitwise
    static ArrayList<ArrayList<Character>> powerSet(String a){
        ArrayList<ArrayList<Character>> res = new ArrayList<>();
        int n = (int)Math.pow(2,a.length());
        for(int i=0;i<n;i++)   //8
        {
            res.add(new ArrayList<Character>());
            for(int j=0;j<a.length();j++)
            {
                if( ((i>>j) & 1 ) == 1){
                    res.get(i).add(a.charAt(j));
                }
            }
        }
        return res;
    }
} //8421
// 0
// 1
// 4