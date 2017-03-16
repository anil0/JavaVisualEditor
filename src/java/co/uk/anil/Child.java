/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uk.anil;

import java.util.List;

/**
 *
 * @author anil
 */
public class Child {
    private String data;
    private List<Child> children;

    public Child(String data, List<Child> children) {
        this.data = data;
        this.children = children;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Child{" + "data=" + data + ", children=" + children + '}';
    }
    
    
}
