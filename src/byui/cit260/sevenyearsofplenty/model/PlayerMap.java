/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.sevenyearsofplenty.model;
import java.io.Serializable;

/**
 *
 * @author Expression DWPaulsen is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
/**
 *
 * @author Expression DWPaulsen is undefined on line 12, column 14 in
 * Templates/Classes/Class.java.
 * @author Expression DWPaulsen is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */

public class PlayerMap implements Serializable {

private int rowCount;
private int colCount;
private Location location = new Location();




public PlayerMap(){

}

    /**
     * @return the rowCount
     */
    public int getRowCount() {
        return rowCount;
    }

    /**
     * @param rowCount the rowCount to set
     */
    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    /**
     * @return the colCount
     */
    public int getColCount() {
        return colCount;
    }

    /**
     * @param colCount the colCount to set
     */
    public void setColCount(int colCount) {
        this.colCount = colCount;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "PlayerMap{" + "rowCount=" + rowCount + ", colCount=" 
                + colCount + ", location=" + location + '}';
    }
    

}
