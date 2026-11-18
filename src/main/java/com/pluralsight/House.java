package com.pluralsight;

import java.math.BigDecimal;

//! The House class inherits common asset infromation from Asset
public class House extends Asset{

    private String address; //* Stores the house address
    private int condition; //* The  Condition of the house
    private int squareFoot; //* Size of the house in square feet
    private int lotSize; //* Size of the property's lot

    public House(String description, String dateAcquired, BigDecimal originalCost, String address, int condition, int lotSize, int squareFoot) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.lotSize = lotSize;
        this.squareFoot = squareFoot;

    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    @Override
    //? Calculate the house value based on condition and lot size
    public BigDecimal getValue() {

        //? Convert square foot to BigDecimal for calculations
        BigDecimal houseSize = BigDecimal.valueOf(squareFoot);


        //? Calculate additional value from the lot size
        BigDecimal lotAmount = new BigDecimal("0.25").multiply(BigDecimal.valueOf(getLotSize()));

       //* Stores the dollar amount per square foot based on the house condition
        BigDecimal conditionRate = BigDecimal.ZERO;
        switch (condition) {
            case 1:
                conditionRate = BigDecimal.valueOf(180);
                break;
            case 2:
                conditionRate = BigDecimal.valueOf(130);
                break;
            case 3:
                conditionRate = BigDecimal.valueOf(90);
                break;
            case 4:
                conditionRate = BigDecimal.valueOf(80);
                break;

        }
        return conditionRate.multiply(houseSize).add(lotAmount);
    }
}

