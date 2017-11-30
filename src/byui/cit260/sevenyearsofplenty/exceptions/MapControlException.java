/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.sevenyearsofplenty.exceptions;

/**
 *
 * @Author AjLane, Dennis, Vanessa 
 * 
 */
public class MapControlException extends Exception {

    public MapControlException() {
    }

    public MapControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public MapControlException(Throwable cause) {
        super(cause);
    }

    public MapControlException(String message, Throwable cause, boolean 
            enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public MapControlException(String message) {
        super(message);
    }

}
