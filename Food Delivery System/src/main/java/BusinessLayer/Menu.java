package BusinessLayer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import PrezentationLayer.Interfata;

public class Menu {

    public static int stringCompare(String str1, String str2)
    {

        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);

        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int)str1.charAt(i);
            int str2_ch = (int)str2.charAt(i);

            if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }

        if (l1 != l2) {
            return l1 - l2;
        }

        else {
            return 0;
        }
    }

    public static LinkedList<MenuItem> menuList = new LinkedList<>() ;
    public static int[] noOfTimesOrder = new int[1024];
    public static int[] checkOrder = new int[1024];

    private Interfata interfata;

    public Menu(Interfata interfata){

       // menuList =  new LinkedList<>();
        this.interfata = interfata;

    }


    public LinkedList<MenuItem> getList(){
        return menuList;
    }

    public static void readDataFromCSV(){
        String path= "C:/Laboratoare_TP/TheLastTest/products.csv";
        String line= "";
        int count =0;
        int ok = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while((line = br.readLine()) != null){
                if(count == 0){
                    count++;
                    continue;
                }
                String [] values = line.split(",");
                ////!!!
                ////DE vazut ce id pun
                MenuItem p = new BaseProduct(count-1,Double.parseDouble(values[6]), values[0],Double.parseDouble(values[1]),Double.parseDouble(values[2]),Double.parseDouble(values[3]),Double.parseDouble(values[4]), Double.parseDouble(values[5]));
                for(MenuItem i : menuList){
                    if(i.getTitle() != null) {
                        if (stringCompare(i.getTitle(), p.getTitle()) == 0) {
                            ok = 1;
                            break;
                        }
                    }
                }
                if(ok == 0) {
                    menuList.add(p);
                    count++;
                    if(count == 701){
                        break;
                    }
                } else{
                    ok = 0;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void addItem(MenuItem p){

        this.menuList.add(p);

    }

    public MenuItem getElement(int index){
        return menuList.get(index);
    }

    public static <T> LinkedList<T> removeDuplicates(LinkedList<T> list){

        Set<T> set = new LinkedHashSet<>();
        set.addAll(list);
        list.clear();

        list.addAll(set);

        return list;
    }

    public int getSize(){
        return menuList.size();
    }

    public LinkedList<MenuItem> removeDup(){
        return removeDuplicates(menuList);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuList=" + menuList +
                '}';
    }
}

