package net.epam.study.lesson2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HouseholdAppliances {
    public static List<String> fileReader() throws IOException{
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Kirill\\Desktop\\appliances_db.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String strLine;
        List<String> list = new ArrayList<String>();
        while ((strLine = bufferedReader.readLine()) != null)   {
            list.add(strLine);
        }
        return list;
    }
    public static List<String> textParser(List<String> text){
        List<String> list = new ArrayList<String>();
        List<String> matchedList = new ArrayList<String>();
        for (int i = 0; i<text.size(); i++) {
            Pattern pattern = Pattern.compile("PRICE =\\s\\d+");
            Matcher matcher = pattern.matcher(text.get(i));
            if (matcher.find()) {
                list.add(matcher.group());
            }
        }
        for (int j = 0; j<list.size(); j++) {
            Pattern finalePattern = Pattern.compile("\\d+");
            Matcher finaleMatcher = finalePattern.matcher(list.get(j));
            if (finaleMatcher.find()) {
                matchedList.add(finaleMatcher.group());
            }
        }
        return matchedList;
    }
    public static int getMinPrice (List<String> price){
        List<Integer> priceList = new ArrayList<Integer>();
        for(int i = 0; i<price.size(); i++){
            priceList.add(Integer.parseInt(price.get(i)));
        }
        return Collections.min(priceList);
    }
    public static StringBuilder getMinPriceElement (List<String> text, int minPrice){
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("PRICE = " + minPrice);
        for (int i = 0; i<text.size(); i++) {
            Matcher matcher = pattern.matcher(text.get(i));
            if (matcher.find()) {
                stringBuilder.append(text.get(i));
            }
        }
        return stringBuilder;
    }
    public static List<String> getKettles(List<String> text){
        List<String> kettleList = new ArrayList<String>();
        Pattern pattern = Pattern.compile("Kettle");
        for (int i = 0; i<text.size(); i++) {
            Matcher matcher = pattern.matcher(text.get(i));
            if (matcher.find()){
                kettleList.add(text.get(i));
            }
        }
        return kettleList;
    }
}
