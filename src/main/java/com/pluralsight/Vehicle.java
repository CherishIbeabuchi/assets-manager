package com.pluralsight;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Vehicle extends Asset {
    private String makeModel; //* Stores the vehicle make and model
    private int year; //* Stores the year the vehicle was made
    private int odometer; //* Store the vehicle odometer

    public Vehicle(String description, String dateAcquired, BigDecimal originalCost, String makeModel, int odometer, int year) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.odometer = odometer;
        this.year = year;

    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;

    }

    @Override
    public BigDecimal getValue() {

        //* Calculating How old the Vehicle is
        int vehicleAge = LocalDate.now().getYear() - year;

        //? Start with the original purchase price
        BigDecimal currentValue = getOriginalCost();

        //*Reduce value by 3% for each year if the vehicle is 3 years old or newer

        if (vehicleAge <= 3) {
            //? Calculate the discount amount
            BigDecimal discount = BigDecimal.valueOf(vehicleAge).multiply(new BigDecimal("0.03"));

            //? Apply the discount to the vehicle value
            currentValue = currentValue.multiply(BigDecimal.ONE.subtract(discount));

         //* Reduce value by 6% for each year if the vehicle is 4-6 years old
        } else if (vehicleAge <= 6) {

            //? Calculate discount amount
            BigDecimal discount = BigDecimal.valueOf(vehicleAge).multiply(new BigDecimal("0.06"));

            //? Apply the discount to the vehicle value
            currentValue = currentValue.multiply(BigDecimal.ONE.subtract(discount));

         //* Reduce value by 8% for each year if the vehicle is 7-10 years old
        } else if (vehicleAge <= 10) {

            //? Calculate the discount amount
            BigDecimal discount = BigDecimal.valueOf(vehicleAge).multiply(new BigDecimal("0.08"));

            //* Apply the discount to the vehicle value
            currentValue = currentValue.multiply(BigDecimal.ONE.subtract(discount));
        } else {

            //? Vehicles older than 10 years are worth a flat $1000
            currentValue = new BigDecimal("1000");
        }
        //* Convert the make and model to lowercase
        String carName = makeModel.toLowerCase();

         //? Apply an additional 25% reduction for high-mileage vehicles,
         //* unless the vehicle is a Honda or Toyota

        if (odometer > 100000 && !carName.contains("honda") && !carName.contains("toyota")) {
            //! Reduce vehicle value by 25%
            currentValue = currentValue.multiply(new BigDecimal(0.75));

        }
        return currentValue;

    }
}
