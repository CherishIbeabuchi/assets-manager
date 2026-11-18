package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class MainProgram {
    public static void main(String[] args) {

        //? Create a List to store all my assets
        ArrayList<Asset> cherishAssets = new ArrayList<>();

        //? My Houses we do it big over here
        cherishAssets.add(new House("Cherish's Vineyard", "01-25-26",
                new BigDecimal("450000"), "500 Brooklyn Street Los Angeles, California",
                1, 5000, 2000));
        cherishAssets.add(new House("Cherish's Mansion", "11-12-26",
                new BigDecimal("50000000"), "708 Landmark Street Las Vegas, Nevada",
                2, 250000, 650000));

        //? My Vehicles
        cherishAssets.add(new Vehicle("Cherish's Car", "01/13/2021",
                new BigDecimal("5500"), "Hyundai Accent", 143125, 2021));

        //? I had to get an upgrade Whew
        cherishAssets.add(new Vehicle("Cherish's Brand new car", "01/13/2027",
                new BigDecimal("47000"), "Tesla Model Y", 0, 2027));

        //? Fancy Header
        System.out.println("""
                \n═══════════════════════════════════════════════════════════
                                🏡 CHERISH'S ASSETS 🚗
                ═══════════════════════════════════════════════════════════
                       Properties • Vehicles • Luxury Living • Success
                ═══════════════════════════════════════════════════════════
                """);
        //* Loop through each asset in the list
        for (Asset asset : cherishAssets) {

            //? Display all outputs
            System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓\n");
            System.out.println(asset.getDescription());

            System.out.printf("Acquired: %s%n", asset.getDateAcquired());
            System.out.printf("Paid:     $%,.2f%n", asset.getOriginalCost());
            System.out.printf("Value:    $%,.2f%n", asset.getValue());

            //? Determine if the asset is a house or Vehivle
            if (asset instanceof House) {

                //* Convert the asset to a House so House methods can be used
                House myHouse = (House) asset;

                //? Display the house Address
                System.out.println("Address:  " + myHouse.getAddress());

                //* Check if the asset is a vehicle
            } else if (asset instanceof Vehicle) {

                //? Convert Assest into a Vehicle so Vehicle methods can be used
                Vehicle myVehicle = (Vehicle) asset;

                //? Display the vehicle year and make/model
                System.out.println("Vehicle:  " + myVehicle.getYear() + " " + myVehicle.getMakeModel());

                System.out.println("\n▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓\n");

            }
            System.out.println();
        }


    }
}


