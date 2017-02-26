/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uk.anil;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.TreeDragDropEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author anil
 */

//http://www.primefaces.org/showcase/ui/data/tree/dragdrop.xhtml
//This site contains the basic code for showing how to start with drag and drop and treenodes within the primefaces framework

@ManagedBean(name="blockBean")
@ViewScoped
public class BlockBean implements Serializable 
{
    private TreeNode root1;
    private TreeNode root2;
    private TreeNode root3;
    private TreeNode selectedNode1;
    private TreeNode selectedNode2;
    private TreeNode selectedNode3;
    
    private String userInput;
     
    @PostConstruct
    public void init() 
    {
        root1 = new MyTreeNodeImpl("Root", null);
        //instead of TreeNode and a type of DefaultTreeNode it is now:
        IMyTreeNode node0 = new MyTreeNodeImpl("Node 0", root1); //data, parent
        //test an update node data from new method functionality
        node0.updateNode("it changed");
        
        TreeNode node1 = new MyTreeNodeImpl("Node 1", root1);
        TreeNode node2 = new MyTreeNodeImpl("Node 2", root1);
         
//        TreeNode node00 = new MyTreeNodeImpl("Node 0.0", node0); //this becomes child of node0 meaning indented list
         
        root2 = new MyTreeNodeImpl("Root2", null);
        TreeNode item0 = new MyTreeNodeImpl("Item 0", root2);
        TreeNode item1 = new MyTreeNodeImpl("Item 1", root2);
        TreeNode item2 = new MyTreeNodeImpl("Item 2", root2);
        
        //creating a seperate root for my own custom elements
        root3 = new MyTreeNodeImpl("Root3", null);
        IMyTreeNode ifStatement = new MyTreeNodeImpl("if", root3);
        TreeNode elseifStatement = new MyTreeNodeImpl("else if", root3);
        TreeNode elseStatement = new MyTreeNodeImpl("else", root3);
    }
 
    public TreeNode getRoot1() 
    {
        return root1;
    }
 
    public TreeNode getRoot2() 
    {
        return root2;
    }
    
    public TreeNode getRoot3() 
    {
        return root3;
    }
 
    public TreeNode getSelectedNode1() 
    {
        return selectedNode1;
    }
 
    public void setSelectedNode1(TreeNode selectedNode1) 
    {
        this.selectedNode1 = selectedNode1;
    }
 
    public TreeNode getSelectedNode2() 
    {
        return selectedNode2;
    }
 
    public void setSelectedNode2(TreeNode selectedNode2) 
    {
        this.selectedNode2 = selectedNode2;
    }
    
    public TreeNode getSelectedNode3() 
    {
        return selectedNode3;
    }

    public void setSelectedNode3(TreeNode selectedNode3) 
    {
        this.selectedNode3 = selectedNode3;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }
        
    
    
    public void onDragDrop(TreeDragDropEvent event) 
    {
        TreeNode dragNode = event.getDragNode();
        TreeNode dropNode = event.getDropNode();
        int dropIndex = event.getDropIndex();
         
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dragged " + dragNode.getData(), "Dropped on " + dropNode.getData() + " at " + dropIndex);
        FacesContext.getCurrentInstance().addMessage(null, message);
        
        refreshRoots(); // refresh initial drag list so you can re drag that element
        RequestContext.getCurrentInstance().update("form"); // update tree from reloading form
    }

    /**
     * This method will recreate the first two trees so that once a block is dragged over it will be recreated, ready to be dragged again
     */
    private void refreshRoots() 
    {
        root1 = new MyTreeNodeImpl("Root", null);
        //instead of TreeNode and a type of DefaultTreeNode it is now:
        IMyTreeNode node0 = new MyTreeNodeImpl("Node 0", root1); //data, parent
        TreeNode node1 = new MyTreeNodeImpl("Node 1", root1);
        TreeNode node2 = new MyTreeNodeImpl("Node 2", root1);
         
//        TreeNode node00 = new MyTreeNodeImpl("Node 0.0", node0); //this becomes child of node0 meaning indented list

        //creating a seperate root for my own custom elements
        root3 = new MyTreeNodeImpl("Root3", null);
        IMyTreeNode ifStatement = new MyTreeNodeImpl("if( true )", root3);
        TreeNode elseifStatement = new MyTreeNodeImpl("else if( true )", root3);
        TreeNode elseStatement = new MyTreeNodeImpl("else", root3);
    }
    
    public void editSelectedBlock()
    {
        System.out.println("EDITED BLOCK " + getSelectedNode2().toString());
        System.out.println("THE USERS DATA " + userInput);
        
        IMyTreeNode editedBLock = (IMyTreeNode) getSelectedNode2();
        editedBLock.updateNode(editedBLock.getData() + "( " + userInput + " )");
        
        //tests to see whether user input is valid and also valid for the type of block
    }
    
}
