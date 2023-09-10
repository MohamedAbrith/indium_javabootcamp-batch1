import javax.swing.*;
import java.util.ArrayList;

public class ArrayListDemo {
        public static void main(String[] args) {
            ArrayList skills = new ArrayList();
            skills.add("java");
            skills.add("python");
            skills.add("Node JS");
            skills.add(100);
            skills.add(200);
            skills.add(300);

            for (Object skill:skills){
                if(skill instanceof S)
                System.out.println((String)skill).toUpperCase();
            }else{


            }
            System.out.println(skills);
        }

    }
