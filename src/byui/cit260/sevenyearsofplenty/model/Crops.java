/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Adrian, Dennis, and Vanessa
 */
public class Crops implements Serializable {
    
    // Class instance variables
    private int year;
    private int Population;
    private double growthRate;
    private int acres;
    private int cropYield;
    private int wheatInStore;
    private int harvest;
    private int pharoahsShare;
    private int fed;
    private int planted;
    private int starvedPeople;
    private double productivity;
    private int foodSupplied;
    private ArrayList<Game> games = new ArrayList<>();

    public Crops() {
    }
        

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year += year;
    }
    
    public int setStarvedPeople(int newStarvedPeople) {
        starvedPeople = newStarvedPeople;
        return starvedPeople;
    }
    
    public int getStarvedPeople(){
        return starvedPeople;
    }
    
    public int getPopulation() {
        return Population;
    }

    public void setPopulation(int newPopulation) {
        Population = newPopulation;
    }

    public int getAcres() {
        return acres;
    }

    public void setAcres(int acres) {
        this.acres = acres;
    }

    public int getCropYield() {
        return cropYield;
    }

    public void setCropYield(int cropYield) {
        this.cropYield = cropYield;
    }

    public int getWheatInStore() {
        return wheatInStore;
    }

    public void setWheatInStore(int wheatInStore) {
        this.wheatInStore = wheatInStore;
    }

    public double getProductivity() {
        return productivity;
    }

    public void setProductivity(double productivity) {
        this.productivity = productivity;
    }
    
       public double getGrowthRate() {
        return growthRate;
    }

    public void setGrowthRate(double growthRate) {
        this.growthRate = growthRate;
    }


    public int getHarvest() {
        return harvest;
    }

    public void setHarvest(int harvest) {
        this.harvest = harvest;
    }

    public int getPharoahsShare() {
        return pharoahsShare;
    }

    public void setPharoahsShare(int pharoahsShare) {
        this.pharoahsShare = pharoahsShare;
    }

    public int getFed() {
        return fed;
    }

    public void setFed(int fed) {
        this.fed = fed;
    }
    
    public int getFoodSupplied() {
        return foodSupplied;
    }

    public void setFoodSupplied(int supplied) {
        this.foodSupplied = supplied;
    }

    public int getPlanted() {
        return planted;
    }

    public void setPlanted(int planted) {
        this.planted = planted;
    }
    
    public ArrayList<Game> getGames() {
        return games;
    }
    
    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.year;
        hash = 61 * hash + this.Population;
        hash = 61 * hash + this.acres;
        hash = 61 * hash + this.cropYield;
        hash = 61 * hash + this.wheatInStore;
        hash = 61 * hash + this.harvest;
        hash = 61 * hash + this.pharoahsShare;
        hash = 61 * hash + this.fed;
        hash = 61 * hash + this.planted;
        hash = 61 * hash + this.foodSupplied;
        return hash;
    }


    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Crops other = (Crops) obj;
        if (this.year != other.year) {
            return false;
        }
        if (this.Population != other.Population) {
            return false;
        }
        if (this.acres != other.acres) {
            return false;
        }
        if (this.cropYield != other.cropYield) {
            return false;
        }
        if (this.wheatInStore != other.wheatInStore) {
            return false;
        }

        if (this.harvest != other.harvest) {
            return false;
        }
        if (this.pharoahsShare != other.pharoahsShare) {
            return false;
        }
        if (this.fed != other.fed) {
            return false;
        }
        if (this.planted != other.planted) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Crops{" + "year=" + year + ", population=" + Population
                + ", acres=" + acres + ", cropYield=" + cropYield 
                + ", wheatInStore=" + wheatInStore + ", harvest=" 
                + harvest + ", pharoahsShare=" + pharoahsShare + ", fed=" 
                + fed + ", planted=" + planted + '}';
    }
    
    
    
}
