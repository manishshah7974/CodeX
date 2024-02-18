public class CodeA {
    public static void main(String args[]) {
        System.out.println(palindrome("0011101",0,6));
    }

    static int sumNum(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumNum(n - 1);
    }
    static boolean palindrome(String str,int i,int j){
        if(i>=j)
            return true;
         return (str.charAt(i)==str.charAt(j) && palindrome(str,i+1,j-1));
    }
}


