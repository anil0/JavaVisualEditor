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
public class NodeRelationship {
    private TreeNode parent;
    private int parentLevel;
    private List<TreeNode> relation;

    public NodeRelationship() {
    }

    
    
    public NodeRelationship(TreeNode parent, int parentLevel) {
        this.parent = parent;
        this.parentLevel = parentLevel;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public int getParentLevel() {
        return parentLevel;
    }

    public void setParentLevel(int parentLevel) {
        this.parentLevel = parentLevel;
    }

    public List<TreeNode> getRelation() {
        return relation;
    }

    public void setRelation(List<TreeNode> relation) {
        this.relation = relation;
    }

    

    
    
    
    @Override
    public String toString() 
    {
        return "NodeRelationship" 
                + "\n\tParent: " + parent 
                //+ "\t\nChild: " + child
                + "\n\tRelations: " + relation;
    }
    
    
}
