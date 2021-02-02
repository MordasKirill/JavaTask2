package net.epam.study.HouseholdAppliancesTask;

import net.epam.study.HouseholdAppliancesTask.HouseholdAppliances;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        System.out.println("Lowest price element: ");
        System.out.println(HouseholdAppliances.getMinPriceElement(HouseholdAppliances.fileReader(),
                HouseholdAppliances.getMinPrice(HouseholdAppliances.textParser(HouseholdAppliances.fileReader()))) + "\n");
        System.out.println("Kettles: ");
        for (int i = 0; i<HouseholdAppliances.getKettles(HouseholdAppliances.fileReader()).size(); i++){
            System.out.println(HouseholdAppliances.getKettles(HouseholdAppliances.fileReader()).get(i));
        }
    }
}
