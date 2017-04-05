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
    private IMyTreeNode parent;
    private IMyTreeNode node;

    public Foo(IMyTreeNode parent, IMyTreeNode node) {
        this.parent = parent;
        this.node = node;
        
    }

    public IMyTreeNode getParent() {
        return parent;
    }

    public void setParent(IMyTreeNode parent) {
        this.parent = parent;
    }

    public IMyTreeNode getNode() {
        return node;
    }

    public void setNode(IMyTreeNode node) {
        this.node = node;
    }


    @Override
    public String toString() {
        return "Foo{" + "parent=" + parent + " parentID=" + parent.getBlockID() + ", node=" + node + " nodeID=" + node.getBlockID() + '}';
    }
    
    

    
    
    
}
