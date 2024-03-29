/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uk.anil;

/**
 *
 * @author anil
 */
public class Argument implements Cloneable{
    private String type;
    private String value;

    public Argument(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Argument{" + "type=" + type + ", value=" + value + '}';
    }
    
     @Override
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
