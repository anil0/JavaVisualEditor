/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uk.anil;

import java.util.Iterator;
import java.util.List;
import org.primefaces.model.TreeNode;

/**
 *
 * @author anil
 */
public class NodeRelationship {
    private IMyTreeNode node;
    private int hierarchyLevel;

    public NodeRelationship(IMyTreeNode node, int hierarchyLevel) {
        this.node = node;
        this.hierarchyLevel = hierarchyLevel;
    }

    public IMyTreeNode getNode() {
        return node;
    }

    public void setNode(IMyTreeNode node) {
        this.node = node;
    }

    public int getHierarchyLevel() {
        return hierarchyLevel;
    }

    public void setHierarchyLevel(int hierarchyLevel) {
        this.hierarchyLevel = hierarchyLevel;
    }
    
    public static boolean contains(List<NodeRelationship> list)
    {
        Iterator<NodeRelationship> nodes = list.iterator();
        while (nodes.hasNext()) 
        {
            NodeRelationship treeNode = nodes.next(); 
            
            if(treeNode.getNode().getBlockType().equals( Type.METHOD ))
            {
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean containsMain(List<NodeRelationship> list)
    {
        Iterator<NodeRelationship> nodes = list.iterator();
        while (nodes.hasNext()) 
        {
            NodeRelationship treeNode = nodes.next(); 
            
            if(treeNode.getNode().getBlockType().equals( Type.MAIN ))
            {
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public String toString() {
        return "NodeRelationship{" + "node=" + node + ", hierarchyLevel=" + hierarchyLevel + '}';
    }

    
   
}
