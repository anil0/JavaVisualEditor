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
class Foo {
    private String parent;
    private String node;
    private long id;

    public Foo(String parent, String node, long id) {
        this.parent = parent;
        this.node = node;
        this.id = id;
    }

    

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Foo{" + "parent=" + parent + ", node=" + node + ", id=" + id + '}';
    }
    
    

    
    
    
}
