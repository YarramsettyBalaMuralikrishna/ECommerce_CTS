package inClass;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public  static  void  main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println("List after adding items:"+ list);
        list.remove("Banana");
        System.out.println("List after removing Banana:"+ list);
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("Size of List:"+ list.size());

    }
}
