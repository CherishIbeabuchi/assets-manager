package com.pluralsight;

//! Import BigDecimal to store money values accurately

import java.math.BigDecimal;

//? My Parent class that stores information common to all assets
public class Asset {
    private String description;  //* Description of the asset
    private String dateAcquired; //* Date the asset was acquired
    private BigDecimal originalCost; //* Original purchase price of the asset

    //! Constructor used to create a new asset
    public Asset(String description, String dateAcquired, BigDecimal originalCost) {
          this.dateAcquired = dateAcquired;
          this.description = description;
          this.originalCost = originalCost;
    }
    //* Returns a current value of the asset
    public BigDecimal getValue() {
        return originalCost;
    }

    public String getDateAcquired() {
        return dateAcquired;
    }

    public void setDateAcquired(String dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getOriginalCost() {
        return originalCost;
    }

    public void setOriginalCost(BigDecimal originalCost) {
        this.originalCost = originalCost;
    }

}
