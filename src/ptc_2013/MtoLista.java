/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ptc_2013;

/**
 *
 * @author laboratorio 3
 */
public class MtoLista {
    Object value, display;
    public MtoLista(Object value, Object display)
    {
        this.value = value;
        this.display = display;
    }
    public Object getValue()
    {
        return value;
    }
    
    @Override
    public String toString()
    {
        return display.toString();
    }
}
