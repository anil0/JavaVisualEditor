/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uk.anil;

import com.google.gson.Gson;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private IMyTreeNode root1;
    private IMyTreeNode root2;
    private IMyTreeNode root3;
    private IMyTreeNode selectedNode1;
    private IMyTreeNode selectedNode2;
    private IMyTreeNode selectedNode3;
    
    private String userInput;
    IMyTreeNode item0;
    IMyTreeNode item01;
    IMyTreeNode item02;
     
    @PostConstruct
    public void init() 
    {

        root1 = new MyTreeNodeImpl("Root", null);
        //instead of TreeNode and a type of DefaultTreeNode it is now:
        IMyTreeNode node0 = new MyTreeNodeImpl(System.nanoTime(), "Node 0", root1, Type.DEFAULT); //data, parent
        IMyTreeNode node1 = new MyTreeNodeImpl(System.nanoTime(), "Node 1", root1, Type.DEFAULT);
        IMyTreeNode node2 = new MyTreeNodeImpl(System.nanoTime(), "Node 2", root1, Type.DEFAULT);
        IMyTreeNode method = new MyTreeNodeImpl(System.nanoTime(), "Method Block", root1, Type.METHOD);
        IMyTreeNode forLoop = new MyTreeNodeImpl(System.nanoTime(), "For Loop", root1, Type.LOOP);
         
//        TreeNode node00 = new MyTreeNodeImpl("Node 0.0", node0); //this becomes child of node0 meaning indented list
         
        root2 = new MyTreeNodeImpl("Root2", null);
        //TreeNode item0 = new MyTreeNodeImpl(null, root2);
        item0 = new MyTreeNodeImpl("class HelloWorld", root2);
        item01 = new MyTreeNodeImpl("public static void main( String args[] ) ", item0);
        item02 = new MyTreeNodeImpl("System.out.println( \"Hello World!\" )", item0);
        item0.setExpanded( true );
        
        //creating a seperate root for my own custom elements
        root3 = new MyTreeNodeImpl("Root3", null);
        IMyTreeNode ifStatement = new MyTreeNodeImpl(System.nanoTime(), "if( true )", root3, Type.LOGIC);
        IMyTreeNode elseifStatement = new MyTreeNodeImpl(System.nanoTime(), "else if( true )", root3, Type.LOGIC);
        IMyTreeNode elseStatement = new MyTreeNodeImpl(System.nanoTime(), "else", root3, Type.LOGIC);
    }
 
    public IMyTreeNode getRoot1() 
    {
        return root1;
    }
 
    public IMyTreeNode getRoot2() 
    {
        return root2;
    }
    
    public IMyTreeNode getRoot3() 
    {
        return root3;
    }
 
    public IMyTreeNode getSelectedNode1() 
    {
        return selectedNode1;
    }
 
    public void setSelectedNode1(IMyTreeNode selectedNode1) 
    {
        this.selectedNode1 = selectedNode1;
    }
 
    public IMyTreeNode getSelectedNode2() 
    {
        return selectedNode2;
    }
 
    public void setSelectedNode2(IMyTreeNode selectedNode2) 
    {
        this.selectedNode2 = selectedNode2;
    }
    
    public IMyTreeNode getSelectedNode3() 
    {
        return selectedNode3;
    }

    public void setSelectedNode3(IMyTreeNode selectedNode3) 
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
        IMyTreeNode dragNode2 = (IMyTreeNode) event.getDragNode();
        IMyTreeNode dropNode2 = (IMyTreeNode) event.getDropNode();
        int dropIndex = event.getDropIndex();
        
        //keep list open at all times
        dragNode.setExpanded(true);
        dropNode.setExpanded(true);
        
        //System.out.println(dragNode2.getBlockType());
        
        Iterator<TreeNode> treeNodes = getRoot2().getChildren().iterator();
        while (treeNodes.hasNext()) 
        {
           // Use isLeaf() method to check doesn't have childs.
           TreeNode treeNode = treeNodes.next(); 
           IMyTreeNode selectedBlock = (IMyTreeNode) getSelectedNode2();
           
           if( treeNode.equals(item0) )
            {
                
                final String item01 = "item01";
                final String item02 = "item02";
                
//                for( Iterator<TreeNode>  node = treeNode.getChildren().iterator(); node.hasNext();)
//                {
//                    TreeNode foo = node.next();
//                    
//                    if(foo.equals(this.item01))
//                    {
//                        System.out.println("true");
//                        node.remove();
//                    }
//                    else if(foo.equals(this.item02))
//                    {
//                        System.out.println("true");
//                        node.remove();
//                    }
//                }
                
//                for( Iterator<TreeNode>  node = treeNode.getChildren().iterator(); node.hasNext();)
//                {
//                    TreeNode foo = node.next();
//                    
//                    try 
//                    {
//                        Object foo = new Object();
//                        System.out.printl );
//                        
//                        System.out.println("fieldName: " + objName);
//                        if( objName.equals( item01 ) )
//                        {
//                            System.out.println("TRUE");
//                            node.remove();
//                        }
//                        else if( objName.equals( item02 ) )
//                        {
//                            System.out.println("TRUE");
//                            node.remove();
//                        }                                                               
//                    } 
//                    catch ( Exception ex ) 
//                    {
//                        ex.printStackTrace();
//                    }                                    
//                }
                System.out.println("true");
                treeNodes.remove();
            }
        }
        
        //if box is empty
        if(getRoot2().getChildCount() == 0)
        {
            refreshRoot2();
        }
        
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
        IMyTreeNode node0 = new MyTreeNodeImpl(System.nanoTime(), "Node 0", root1, Type.DEFAULT); //data, parent
        IMyTreeNode node1 = new MyTreeNodeImpl(System.nanoTime(), "Node 1", root1, Type.DEFAULT);
        IMyTreeNode node2 = new MyTreeNodeImpl(System.nanoTime(), "Node 2", root1, Type.DEFAULT);
        IMyTreeNode method = new MyTreeNodeImpl(System.nanoTime(), "Method Block", root1, Type.METHOD);
        IMyTreeNode forLoop = new MyTreeNodeImpl(System.nanoTime(), "For Loop", root1, Type.LOOP);
         
//        TreeNode node00 = new MyTreeNodeImpl("Node 0.0", node0); //this becomes child of node0 meaning indented list

        //creating a seperate root for my own custom elements
        root3 = new MyTreeNodeImpl("Root3", null);
        IMyTreeNode ifStatement = new MyTreeNodeImpl(System.nanoTime(), "if( true )", root3, Type.LOGIC);
        IMyTreeNode elseifStatement = new MyTreeNodeImpl(System.nanoTime(), "else if( true )", root3, Type.LOGIC);
        IMyTreeNode elseStatement = new MyTreeNodeImpl(System.nanoTime(), "else", root3, Type.LOGIC);
    }
    
    public void refreshRoot2()
    {
        root2 = new MyTreeNodeImpl("Root2", null);
        //TreeNode item0 = new MyTreeNodeImpl(null, root2);
        TreeNode item0 = new MyTreeNodeImpl("class HelloWorld", root2);
        TreeNode item01 = new MyTreeNodeImpl("public static void main( String args[] ) ", (IMyTreeNode) item0);
        TreeNode item02 = new MyTreeNodeImpl("System.out.println( \"Hello World!\" )", (IMyTreeNode) item0);
        item0.setExpanded( true );
    }
    
    public void editSelectedBlock()
    {
        System.out.println("EDITED BLOCK " + getSelectedNode2().toString());
        System.out.println("THE USERS DATA " + userInput);
        
        IMyTreeNode editedBLock = (IMyTreeNode) getSelectedNode2();
        editedBLock.updateNode(editedBLock.getData() + "( " + userInput + " )");
        
        //tests to see whether user input is valid and also valid for the type of block
        //do validation here
    }
    
    public void deleteSelectedBlock()
    {
        //only deletes top level parents, needs to do recursion check to children also.
        
        //use of iterator to stop any concurrent modification errors because deleting element within loop
        Iterator<TreeNode> treeNodes = getRoot2().getChildren().iterator();
        while (treeNodes.hasNext()) 
        {
           // Use isLeaf() method to check doesn't have childs.
           TreeNode treeNode = treeNodes.next(); 
           IMyTreeNode selectedBlock = (IMyTreeNode) getSelectedNode2();
           
           
           //treeNode
           if(treeNode.equals(selectedBlock))
            {
                System.out.println("TRUE");
                treeNodes.remove();
            }
           
        }
        
        //if box is empty
        if(getRoot2().getChildCount() == 0)
        {
            refreshRoot2();
        }
    }
    
    private List<TreeNode> nestList = new ArrayList<>();
    Map<TreeNode, Double> structureMap = new HashMap<>();
    //Map<TreeNode, TreeNode> hierarchyMap = new LinkedHashMap<>();
    
    ArrayList<Nest> hierarchyList = new ArrayList<>();
    int level = 0;
    public List<Foo> blockList = new ArrayList<>();
    
    public void showHierarchy()
    {
        //for(TreeNode parent: getRoot2().getChildren())
       // {
            //if(parent.getChildCount() > 0)
            //{
                //getNestedChildren1(parent);
        getNestedChildren1( (List<IMyTreeNode>) (Object) getRoot2().getChildren() );
            //}
            
            //System.out.println("END OF PARENT BLOCK");
            //level++;
       // }
        
        System.out.println("THE ARRAYLIST");
        for(Foo foo: blockList)
        {
            System.out.println(foo);
        }
    }
    
    
    
    public void getNestedChildren1( List<IMyTreeNode> nodesList )
    {
//        Gson gson = new Gson();
//        String json = gson.toJson( node );
//        JsonClassParser.parseJsonClass( json );
        
        ArrayList<IMyTreeNode> allNodes = new ArrayList<>();
        
        //allNodes.add(nodesList.get(0));
        
        for(IMyTreeNode treeNode: nodesList)
        {
            //allNodes.add(treeNode);
            System.out.println("Block Parent: " + "\tparent is: " + treeNode.getParent() + "\t" + treeNode);
            blockList.add(new Foo(treeNode.getParent().getData().toString(), treeNode.getData().toString(), treeNode.getBlockID()));
            getAllChildren( (List<IMyTreeNode>) (Object) treeNode.getChildren() );
        }

        //if node has parentId then it is a child
        //if nodeId is in another nodes parentId then it is also a parent
        
    }

    private void getAllChildren(List<IMyTreeNode> children) 
    {
        for(IMyTreeNode childNode : children)
        {
            System.out.println("\tparent is: " + childNode.getParent() + "\t" +childNode);
            blockList.add(new Foo(childNode.getParent().getData().toString(), childNode.getData().toString(), childNode.getBlockID()));
            getAllChildren( (List<IMyTreeNode>) (Object) childNode.getChildren() );
        } 
    }
    
//        TreeNode parent = node;
//        TreeNode child = null;
//        if(node.getChildCount() > 0)
//        {
//            //has children
//            for(int i = 0; i < node.getChildCount(); i++)
//            {
//                //System.out.println(node.getChildren().get(i));
//                child = node.getChildren().get(i);
//                System.out.println("Parent: " + parent + "\tChild: " +
//                        child);               
//                
//                //hierarchyList.add(new Nest(parent, child));
//                //if node has parentId then it is a child
//                //if nodeId is in another nodes parentId then it is also a parent
//                
//                if(node.getChildren().get(i).getChildCount() > 0)
//                {
//                    getNestedChildren1(node.getChildren().get(i));
//                }
//            }
//        }

 

}


