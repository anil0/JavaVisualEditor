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
 * This interface was created to add an extra piece of functionality on top of what the TreeNode class currently provides
 */
public interface IMyTreeNode extends TreeNode {
    //new functionality methods
    void updateNode(String data);
    
    Type getBlockType();
    
    void setBlockType(Type blockType);
    
    long getBlockID();
    
    void setBlockID(long blockID);
    
    void add(IMyTreeNode node);
    
    void remove(IMyTreeNode node);
    
    List<IMyTreeNode> getHierarchy();
    
    String getAccessorType();
    
    void setAcessorType(String accessor);
    
    List<Argument> getArguments();
    
    void setArguments(List<Argument> argument);
     
    String getReturnType();
    
    void setReturnType(String returnType);
    
}
