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
     
    @PostConstruct
    public void init() 
    {
        root1 = new DefaultTreeNode("Root", null);
        TreeNode node0 = new DefaultTreeNode("Node 0", root1); //data, parent
        TreeNode node1 = new DefaultTreeNode("Node 1", root1);
        TreeNode node2 = new DefaultTreeNode("Node 2", root1);
         
        TreeNode node00 = new DefaultTreeNode("Node 0.0", node0); //this becomes child of node0 meaning indented list
        TreeNode node01 = new DefaultTreeNode("Node 0.1", node0);
         
        TreeNode node10 = new DefaultTreeNode("Node 1.0", node1);
        TreeNode node11 = new DefaultTreeNode("Node 1.1", node1);
         
        TreeNode node000 = new DefaultTreeNode("Node 0.0.0", node00);
        TreeNode node001 = new DefaultTreeNode("Node 0.0.1", node00);
        TreeNode node010 = new DefaultTreeNode("Node 0.1.0", node01);
         
        TreeNode node100 = new DefaultTreeNode("Node 1.0.0", node10);
         
        root2 = new DefaultTreeNode("Root2", null);
        TreeNode item0 = new DefaultTreeNode("Item 0", root2);
        TreeNode item1 = new DefaultTreeNode("Item 1", root2);
        TreeNode item2 = new DefaultTreeNode("Item 2", root2);
         
        TreeNode item00 = new DefaultTreeNode("Item 0.0", item0);
        
        //creating a seperate root for my own custom elements
        root3 = new DefaultTreeNode("Root3", null);
        TreeNode ifStatement = new DefaultTreeNode("if", root3);
        TreeNode elseifStatement = new DefaultTreeNode("else if", root3);
        TreeNode elseStatement = new DefaultTreeNode("else", root3);
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
        root1 = new DefaultTreeNode("Root", null);
        TreeNode node0 = new DefaultTreeNode("Node 0", root1); //data, parent
        TreeNode node1 = new DefaultTreeNode("Node 1", root1);
        TreeNode node2 = new DefaultTreeNode("Node 2", root1);
         
        TreeNode node00 = new DefaultTreeNode("Node 0.0", node0); //this becomes child of node0 meaning indented list
        TreeNode node01 = new DefaultTreeNode("Node 0.1", node0);
         
        TreeNode node10 = new DefaultTreeNode("Node 1.0", node1);
        TreeNode node11 = new DefaultTreeNode("Node 1.1", node1);
         
        TreeNode node000 = new DefaultTreeNode("Node 0.0.0", node00);
        TreeNode node001 = new DefaultTreeNode("Node 0.0.1", node00);
        TreeNode node010 = new DefaultTreeNode("Node 0.1.0", node01);
         
        TreeNode node100 = new DefaultTreeNode("Node 1.0.0", node10);
        
        //creating a seperate root for my own custom elements
        root3 = new DefaultTreeNode("Root3", null);
        TreeNode ifStatement = new DefaultTreeNode("if", root3);
        TreeNode elseifStatement = new DefaultTreeNode("else if", root3);
        TreeNode elseStatement = new DefaultTreeNode("else", root3);
    }
    
}
