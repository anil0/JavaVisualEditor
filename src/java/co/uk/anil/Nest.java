/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uk.anil;

import java.util.List;
import org.primefaces.model.TreeNode;

/**
 *
 * @author anil
 */
public class Nest
{
    private TreeNode parent;
    private TreeNode child;
    private boolean isParent;
    private boolean isChild;

    public Nest(TreeNode parent, TreeNode child, boolean isParent, boolean isChild) {
        this.parent = parent;
        this.child = child;
        this.isParent = isParent;
        this.isChild = isChild;
    }

    

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getChild() {
        return child;
    }

    public void setChild(TreeNode child) {
        this.child = child;
    }

    public boolean isIsParent() {
        return isParent;
    }

    public void setIsParent(boolean isParent) {
        this.isParent = isParent;
    }

    public boolean isIsChild() {
        return isChild;
    }

    public void setIsChild(boolean isChild) {
        this.isChild = isChild;
    }

    
    
    @Override
    public String toString() {
        return "Nest{" + "parent=" + parent + ", child=" + child + '}';
    }
    
    
}
