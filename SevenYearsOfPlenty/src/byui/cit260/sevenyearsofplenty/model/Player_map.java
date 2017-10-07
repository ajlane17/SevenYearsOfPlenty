/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.sevenyearsofplenty.model;
import java.io.Serializable;
import java.util.Objects;
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

public class Player_map implements Serializable {

private int rowCount;
private int colCount;




public Player_map(){

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


}
