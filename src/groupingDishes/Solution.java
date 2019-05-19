package groupingDishes;

import java.util.*;

public class Solution{

    static String[][] groupingDishes(String[][] dishes) {

        Map<String, TreeSet<String>> map = new TreeMap<>();
        for (String[] s: dishes){

            for (int i =1;i<s.length;i++){

                TreeSet<String> set = map.get(s[i]);
                if(set!=null){
                    set.add(s[0]);
                    map.put(s[i],set);
                }
                set=new TreeSet<>();
                set.add(s[0]);
                map.putIfAbsent(s[i],set);

            }
        }
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for(String s: map.keySet()){
            if(map.get(s).size()>1) {
                ArrayList<String> list = new ArrayList<>(map.get(s));
                list.add(0,s);
                result.add(list);
            }
        }
        ArrayList<String[]> tempList= new ArrayList<>();
        for(ArrayList<String> s: result)
            tempList.add(s.toArray(new String[s.size()]));

        String [][] ans = tempList.toArray(new String[result.size()][]);
        return ans;


    }



    public static void main(String[] args) {


        String[][]dishes={{"Salad","Tomato","Cucumber","Salad","Sauce"},
                {"Pizza","Tomato","Sausage","Sauce","Dough"},
            {"Quesadilla","Chicken","Cheese","Sauce"},
        {"Sandwich","Salad","Bread","Tomato","Cheese"}};

        String [][] idngredients= groupingDishes(dishes);

        for(String []s: idngredients){
            for(String s1: s) {
                System.out.print(s1 + ",");
            }
            System.out.println();
        }


    }
}
