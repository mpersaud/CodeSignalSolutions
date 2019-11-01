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

    static List<List<Integer>> permutation(List<Integer> nums) {

        if (nums.isEmpty()) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        for (Integer i : nums) {
            List<Integer> other = new ArrayList<>();
            other.addAll(nums);
            other.remove(i);
            List<List<Integer>>o = permutation(other);
            if(o.isEmpty()) {
                other.add(0, i);
                o.add(other);
            }else{
                for (List<Integer> l : o) {
                    l.add(0, i);
                }
            }
            list.addAll(o);
        }
        return list;
    }


    public static void main(String[] args) {

//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        List<List<Integer>>result =permutation(list);
//        for(List<Integer> i : result){
//            System.out.println(i);
//        }

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
