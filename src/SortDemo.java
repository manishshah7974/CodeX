import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortDemo {
    public static void main(String args[]){
        ArrayList<Doc> doc =new ArrayList<Doc>();
        doc.add(new Doc("1","abcd"));
        doc.add(new Doc("1","bcd"));
        doc.add(new Doc("1","d"));
        doc.add(new Doc("1","m1"));
        Collections.sort(doc,new MySort());
       for( Doc i : doc ){
           System.out.print(i.toString()+" ");
       }
    }
    static class Doc{
        String a;
        String b;
        Doc(String a,String b){
            this.a=a;
            this.b=b;
        }
        @Override
        public String toString(){
            return this.a + " " + this.b;
        }
    }
    static class MySort implements Comparator<Doc>
    {
        @Override
        public int compare(Doc a,Doc b){
            return (b.b).compareTo(a.b);
        }
    }


}
