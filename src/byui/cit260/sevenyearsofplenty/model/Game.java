/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.model;

import java.util.Objects;

/**
 *
 * @author Adrian, Dennis, Vanessa
 */
public class Game {
    
    // Define instance variables
    private Crops crops;
    
    public Game() {
    }
    

    public Crops getCrops() {
        return crops;
    }

    public void setCrops(Crops crops) {
        this.crops = crops;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.crops);
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
        final Game other = (Game) obj;
        if (!Objects.equals(this.crops, other.crops)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Game{" + "crops=" + crops + '}';
    }

    
}
