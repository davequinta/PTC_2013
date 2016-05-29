/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package circuito_riego;

/**
 *
 * @author Carlos_Cornejo
 */
public class Lista {
    Object value, display;
    public Lista(Object value, Object display)
    {
        this.value = value;
        this.display = display;
    }
    public Object getValue ()
    {
        return value;
    }
    @Override
    public String toString()
    {
        return display.toString();
    }
}
