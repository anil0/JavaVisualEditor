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
    private IMyTreeNode root4;
    private IMyTreeNode root5;
    private IMyTreeNode selectedNode1;
    private IMyTreeNode selectedNode2;
    private IMyTreeNode selectedNode3;
    private IMyTreeNode selectedNode4;
    private IMyTreeNode selectedNode5;
    
    private String className;
    private String userInput;
    private String methodParams;
    private String methodName;
    private String methodReturnType;
    private String methodAccessorType;
    
    private String argumentType;
    private String argumentValue;
    private List<Argument> arguments = new ArrayList<>();
    private List<IMyTreeNode> methodsList = new ArrayList<>();
    
    boolean isSameMethod = false;
    Object sameMethod = null;
    IMyTreeNode item0;
    IMyTreeNode item01;
    IMyTreeNode item02;
    IMyTreeNode dragNode2;
    IMyTreeNode tempNode = null;
     
    @PostConstruct
    public void init() 
    {

        root1 = new MyTreeNodeImpl("Root", null);
        //instead of TreeNode and a type of DefaultTreeNode it is now:
        IMyTreeNode node0 = new MyTreeNodeImpl(System.nanoTime(), "Node 0", root1, Type.DEFAULT); //data, parent
        IMyTreeNode node1 = new MyTreeNodeImpl(System.nanoTime(), "Node 1", root1, Type.DEFAULT);
        IMyTreeNode node2 = new MyTreeNodeImpl(System.nanoTime(), "Node 2", root1, Type.DEFAULT);

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
        
        root4 = new MyTreeNodeImpl("Root4", null);
        IMyTreeNode mainMethod = new MyTreeNodeImpl(System.nanoTime(), "Main Method", root4, Type.METHOD);
        IMyTreeNode method = new MyTreeNodeImpl(System.nanoTime(), "Method Block", root4, Type.METHOD);
        IMyTreeNode forLoop = new MyTreeNodeImpl(System.nanoTime(), "For Loop", root4, Type.LOOP);
        IMyTreeNode print = new MyTreeNodeImpl(System.nanoTime(), "Print Line", root4, Type.PRINT);
        
        root5 = new MyTreeNodeImpl("Root5", null);
        
        for(IMyTreeNode m: methodsList)
        {
            String value = m.getData().toString();
            
            IMyTreeNode newNode = new MyTreeNodeImpl(System.nanoTime(), value, root5, Type.METHODCALL);
        }
        
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('classDialogVar').show();"); 
        
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

    public IMyTreeNode getRoot4() 
    {
        return root4;
    }

    public IMyTreeNode getRoot5() {
        return root5;
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

    public IMyTreeNode getSelectedNode4() 
    {
        return selectedNode4;
    }

    public void setSelectedNode4(IMyTreeNode selectedNode4) 
    {
        this.selectedNode4 = selectedNode4;
    }

    public IMyTreeNode getSelectedNode5() {
        return selectedNode5;
    }

    public void setSelectedNode5(IMyTreeNode selectedNode5) {
        this.selectedNode5 = selectedNode5;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodReturnType() {
        return methodReturnType;
    }

    public void setMethodReturnType(String methodReturnType) {
        this.methodReturnType = methodReturnType;
    }

    public String getMethodAccessorType() {
        return methodAccessorType;
    }

    public void setMethodAccessorType(String methodAccessorType) {
        this.methodAccessorType = methodAccessorType;
    }

    public List<Argument> getArguments() {
        return arguments;
    }

    public void setArguments(List<Argument> arguments) {
        this.arguments = arguments;
    }

    public String getArgumentType() {
        return argumentType;
    }

    public void setArgumentType(String argumentType) {
        this.argumentType = argumentType;
    }

    public String getArgumentValue() {
        return argumentValue;
    }

    public void setArgumentValue(String argumentValue) {
        this.argumentValue = argumentValue;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) 
    {
        if(className != null)
        {
            if(Character.isUpperCase(className.charAt(0)))
            {
                this.className = className;
            }
            else
            {
                System.out.println("was invalid class name try again");
                RequestContext context = RequestContext.getCurrentInstance();
                context.execute("PF('classDialogVar').show();"); 
            }
        }

    }

    public String getMethodParams() {
        return methodParams;
    }

    public void setMethodParams(String methodParams) {
        this.methodParams = methodParams;
    }
    
    
    
    public void printClassName()
    {
        System.out.println("class name: " + className);
        RequestContext.getCurrentInstance().update("form"); // update tree from reloading form
    }

    public void onDragDrop(TreeDragDropEvent event) 
    {       
        System.out.println("started");
        TreeNode dragNode = event.getDragNode();
        TreeNode dropNode = event.getDropNode();
        dragNode2 = (IMyTreeNode) event.getDragNode();
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

                System.out.println("true");
                treeNodes.remove();
           }
           
            System.out.println("hit the if");
           if( dragNode2.getBlockType().equals( Type.METHOD ) )//if method
           {
               if(dragNode2.getData().equals("Main Method"))
               {
                   System.out.println("its the main");
                   dragNode2.setReturnType("main");
                   //deleteMainBlock(); //do if check on refresh to say is deleted if yes then show it if it was dragged on screen dont showit 
                   
               }
               else
               {
                   System.out.println("updated");
                   updateMethod(dragNode2);

               }
                
           }
           else if( dragNode2.getBlockType().equals( Type.METHODCALL ) ) //type of method call
           {
               updateMethodCall(dragNode2);
           }
        }
        
        //is same method exists remove it from screen
        if(isSameMethod)
        {
            //delete from view
            Iterator<TreeNode> tree = getRoot2().getChildren().iterator();
            while (tree.hasNext()) 
            {
               // Use isLeaf() method to check doesn't have childs.
               TreeNode treeNode = tree.next(); 
               IMyTreeNode selectedBlock = (IMyTreeNode) getSelectedNode2();


               //treeNode
               if(treeNode.getData().equals( sameMethod ))
               {
                    System.out.println("TRUE DELETE Duplicate");
                    tree.remove();
                    methodsList.remove(sameMethod);
                    RequestContext.getCurrentInstance().update("form");
                    refreshRoots();
                    break;
               }
            }
        }
        
        RequestContext.getCurrentInstance().update("form");
        //if box is empty
        if(getRoot2().getChildCount() == 0)
        {
            refreshRoot2();
        }
        
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dragged " + dragNode.getData(), "Dropped on " + dropNode.getData() + " at " + dropIndex);
        FacesContext.getCurrentInstance().addMessage(null, message);

        System.out.println("refreshed roots");
        refreshRoots(); // refresh initial drag list so you can re drag that element
        RequestContext.getCurrentInstance().update("form"); // update tree from reloading form
        
        //quick check
        
        
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
         
        //creating a seperate root for my own custom elements
        root3 = new MyTreeNodeImpl("Root3", null);
        IMyTreeNode ifStatement = new MyTreeNodeImpl(System.nanoTime(), "if( true )", root3, Type.LOGIC);
        IMyTreeNode elseifStatement = new MyTreeNodeImpl(System.nanoTime(), "else if( true )", root3, Type.LOGIC);
        IMyTreeNode elseStatement = new MyTreeNodeImpl(System.nanoTime(), "else", root3, Type.LOGIC);
        
        root4 = new MyTreeNodeImpl("Root4", null);
        IMyTreeNode mainMethod = new MyTreeNodeImpl(System.nanoTime(), "Main Method", root4, Type.METHOD);
        IMyTreeNode method = new MyTreeNodeImpl(System.nanoTime(), "Method Block", root4, Type.METHOD);
        IMyTreeNode forLoop = new MyTreeNodeImpl(System.nanoTime(), "For Loop", root4, Type.LOOP);
        IMyTreeNode print = new MyTreeNodeImpl(System.nanoTime(), "Print Line", root4, Type.PRINT);
        
        RequestContext.getCurrentInstance().update("form");
        root5 = new MyTreeNodeImpl("Root5", null);
        //IMyTreeNode newNode = new MyTreeNodeImpl(System.nanoTime(), "hi", root5, Type.METHODCALL);
        //IMyTreeNode newNode1 = new MyTreeNodeImpl(System.nanoTime(), "hiiiiii", root5, Type.METHODCALL);
        for(IMyTreeNode m: methodsList)
        {
            String value = m.getData().toString();
            value = value.substring(0, value.length() - 3) + "( ";
            Iterator<Argument> arguments = m.getArguments().iterator();
            while (arguments.hasNext()) 
            {
                // Use isLeaf() method to check doesn't have childs.
                Argument a = arguments.next(); 
                if(arguments.hasNext())
                {
                    value += a.getType() + " " + a.getValue() + ", ";
                }
                else
                {
                    value += a.getType() + " " + a.getValue();
                }
            }
            value += " )";
            
            IMyTreeNode newNode = new MyTreeNodeImpl(System.nanoTime(), value, root5, Type.METHODCALL);
            
        }
        
        
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
    
    public void showMe()
    {
        
        RequestContext.getCurrentInstance().update("form");
        refreshRoots();
//        root5 = new MyTreeNodeImpl("Root5", null);
//        
//        for(IMyTreeNode m: methodsList)
//        {
//            String value = m.getData().toString();
//            
//            IMyTreeNode newNode = new MyTreeNodeImpl(System.nanoTime(), value, root5, Type.METHODCALL);
//        }
    }
    
    public void updateMethod(IMyTreeNode node)
    {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('methodDialogVar').show();"); 
    }
    
    public void updateMethodCall(IMyTreeNode node)
    {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('methodCallDialogVar').show();"); 
    }
    
    public void editMethodCall()
    {
        //remove all characters until ( add the users entered params, then )
        
        String[] data = dragNode2.getData().toString().split("\\("); 
        String newData = data[0] + "( " + methodParams + " )";
        
        dragNode2.updateNode(newData);
        
        RequestContext.getCurrentInstance().update("form");
    }
    
    public void editMethod()
    {
        
        dragNode2.updateNode(methodName + "( )");
        
        dragNode2.setAcessorType(methodAccessorType);
        dragNode2.setReturnType(methodReturnType);
        
        //pass values to a copy and clear the original so all methods have seperate args
        ArrayList listCopy = new ArrayList(arguments);
        dragNode2.setArguments(listCopy);
        arguments.clear();
        
        for (int i = 0; i < methodsList.size(); i++) 
        {
            if(dragNode2.getData().equals(methodsList.get(i).getData()))
            {
                System.out.println("TWO OF THE SAME METHODSSSSSS");
                isSameMethod = true;
                //dragNode2 = null;
                break;
            }
        }
        
//        if(isSameMethod) //two of the same methods check
//        {
//            sameMethod = dragNode2.getData();
//            System.out.println("sorry already have this method");
//            
//            RequestContext context = RequestContext.getCurrentInstance();
//            context.execute("PF('duplicateMethodVar').show();");
//            
//            refreshRoots();
//        }
//        else
//        {
            methodsList.add(dragNode2);
//        }
        
        
        refreshRoots(); //refresh here because the popup window appears after initial refresh
        
    }
    
    public void addArgument()
    {
        System.out.println("argumentType: " + argumentType);
        System.out.println("argumentValue: " + argumentValue);
        
        if( argumentType != null && (!argumentValue.equals("")) )
        { 
            arguments.add( new Argument(argumentType, argumentValue) ); //type, value
            
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('argsDlg').show();"); 
            
            //will only show message when form is refreshed but that closes the dialog box
            //FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Argument was added!" , "Successful!");
            //FacesContext.getCurrentInstance().addMessage(null, message);
            
            //RequestContext.getCurrentInstance().update("form"); // update tree from reloading form
        }   
    }
    
    
    private List<Argument> cloneArgsList()
    {
        try
        {
            final List<Argument> cloneArgsList = new LinkedList<>();
            for( Argument arg : arguments )
            {
                Argument a = (Argument) arg.clone();
                cloneArgsList.add( a );
            }

            return cloneArgsList;
        }
        catch( CloneNotSupportedException e )
        {
            e.printStackTrace();
        }

        return null;
    }
    
    public void editSelectedBlock()
    {
        System.out.println("EDITED BLOCK " + getSelectedNode2().toString());
        System.out.println("THE USERS DATA " + userInput);
        
       
//        RequestContext context = RequestContext.getCurrentInstance();
//        context.execute("PF('methodDialogVar').show();");
//

        IMyTreeNode editedBLock = (IMyTreeNode) getSelectedNode2();
        
        if(editedBLock.getBlockType().equals( Type.LOGIC ))
        {
            editedBLock.updateNode("if( " + userInput + " )");
        }
        else if(editedBLock.getBlockType().equals( Type.PRINT ))
        {
            editedBLock.updateNode(userInput);
        }
        else
        {
            System.out.println("was a method");
            System.out.println("Method name: " + methodName);
        }
        
        RequestContext.getCurrentInstance().update("form"); // update tree from reloading form
        //tests to see whether user input is valid and also valid for the type of block
        //do validation here
    }
    
    public void deleteMainBlock()
    {
        Iterator<TreeNode> treeNodes = getRoot4().getChildren().iterator();
        while (treeNodes.hasNext()) 
        {
           // Use isLeaf() method to check doesn't have childs.
           TreeNode treeNode = treeNodes.next(); 
           IMyTreeNode selectedBlock = (IMyTreeNode) getSelectedNode2();
           
           //check to see if a method block deleted is in root5 method list, if it is then delete from root 5 aswell
           //treeNode
           if(treeNode.getData().equals( "Main Method" ))
            {
                System.out.println("TRUE DELETE MAIN");
                treeNodes.remove();
                break;
            }
        }
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
                break;
            }
           
           getAllChildrenRemove((List<IMyTreeNode>) (Object) treeNode.getChildren(), selectedBlock ); //get all children and repeat
           
        }
        
        //if box is empty
        if(getRoot2().getChildCount() == 0)
        {
            refreshRoot2();
        }
    }
    
    private void getAllChildrenRemove(List<IMyTreeNode> children, IMyTreeNode selectedBlock) 
    {
        
        Iterator<IMyTreeNode> treeNodes = (Iterator<IMyTreeNode>) children.iterator();
        while (treeNodes.hasNext()) 
        {
           
           IMyTreeNode treeNode = treeNodes.next(); 
           
           if(treeNode.equals(selectedBlock))
           {
               System.out.println("Found and removed");
               treeNodes.remove();
           }
           
           getAllChildrenRemove((List<IMyTreeNode>) (Object) treeNode.getChildren(), selectedBlock );
        }
        
//        for(IMyTreeNode childNode : children)
//        {
//            getAllChildrenRemove((List<IMyTreeNode>) (Object) childNode.getChildren(), selectedBlock );
//        } 
    }
    
    private List<TreeNode> nestList = new ArrayList<>();
    Map<TreeNode, Double> structureMap = new HashMap<>();
    //Map<TreeNode, TreeNode> hierarchyMap = new LinkedHashMap<>();
    
    ArrayList<Nest> hierarchyList = new ArrayList<>();
    int level = 0;
    public List<Foo> blockList = new ArrayList<>();
    
    public void showHierarchy()
    {
        getNestedChildren1( (List<IMyTreeNode>) (Object) getRoot2().getChildren() );
    }
    
    List<String> finalBlockHierarchy = new ArrayList<>();
    List<NodeRelationship> blockHierarchy = new ArrayList<>();
    
    public void getNestedChildren1( List<IMyTreeNode> nodesList )
    {
//        Gson gson = new Gson();
//        String json = gson.toJson( node );
//        JsonClassParser.parseJsonClass( json );
        
        ArrayList<IMyTreeNode> allNodes = new ArrayList<>();
        
        for(IMyTreeNode treeNode: nodesList)
        {
            //allNodes.add(treeNode);
            //System.out.println("Block Parent: " + "\tparent is: " + treeNode.getParent() + "\t" + treeNode);
            System.out.println("Parent Block: " + treeNode);
            //blockList.add(new Foo(treeNode.getParent().getData().toString(), treeNode.getData().toString(), ((IMyTreeNode)treeNode.getParent()).getBlockID() ));
            getAllChildren( (List<IMyTreeNode>) (Object) treeNode.getChildren() );
        }
        
        formatBlockList( blockList );
        blockList.clear();

        //
        
        createClass( blockHierarchy );
        blockHierarchy.clear();
      
    }
    
    
    private class Result
    {
        private Integer elementIndex;
        private NodeType nodeType;
        private IMyTreeNode block;

        public Result(Integer elementNumber, NodeType nodeType, IMyTreeNode block) {
            this.nodeType = nodeType;
            this.elementIndex = elementNumber;            
            this.block = block;
        }

        @Override
        public String toString() {
            return "Result{" + "elementIndex=" + elementIndex + ", nodeType=" + nodeType + ", block=" + block + '}';
        }                  
    }
    
    public enum NodeType
    {
        PARENT,
        CHILD;
    }
    
        
    
    private Result checkForBlock( IMyTreeNode block )
    {
        for( Foo f : blockList ) 
        {
            final IMyTreeNode parent = f.getParent();
            final IMyTreeNode child = f.getNode();
            
            if( parent.getBlockID() == block.getBlockID() && parent.getBlockType().equals( block.getBlockType() ) )
            {
                return new Result( blockList.indexOf(f), NodeType.PARENT, parent );
            }
            
            if( child.getBlockID() == block.getBlockID() && child.getBlockType().equals( block.getBlockType() ) )
            {
                return new Result( blockList.indexOf(f), NodeType.CHILD, child );
            }
        }
        
        return null;
    }
    
    private void formatBlockList(List<Foo> blockList) 
    {           
        int count=0;
        String dash = "";
        IMyTreeNode lastParentBlock = new MyTreeNodeImpl();
        IMyTreeNode lastChildBlock = new MyTreeNodeImpl();
        IMyTreeNode lastMethodBlock = null;
        IMyTreeNode currentMethodBlock = null;

        
        
        System.out.println("FORMAT BLOCKS CHECK");
        
        //counters
        for (Foo foo : blockList)
        {
            IMyTreeNode parent = foo.getParent();

            //next method block
            if( foo.getParent().getBlockType().equals( Type.METHOD ) )
            {
                currentMethodBlock = foo.getParent();
            }
            
            if( lastMethodBlock == null)
            {
                //if the block is a method
                
                System.out.println(foo.getParent());
                finalBlockHierarchy.add(foo.getParent().toString());
                blockHierarchy.add( new NodeRelationship(foo.getParent(), 0 ) );
                
            }

            //if parent is same method then reset the count so we know it is child of method
            if( lastMethodBlock != null )
            {
                //wait till next method is shown
                if( foo.getParent().getBlockType().equals( Type.METHOD ) ) // still on if when gets here so cant reset count
                {
                    count = 2;
                    dash = "-";
                }
            }
            
            //if there is a parent anywhere in the list with the same id as another element parent in the list then put count to 1 and dash to 1
            List<Long> tempIds = new ArrayList<>();
            for(Foo f : blockList)
            {
                //look for all ids of current looped element foo
                //add them all to an arraylist
                //if the arraylist size is > 1 then redo count and dash
                
                
                if( !foo.getParent().getBlockType().equals( Type.METHOD ) )
                {
                    if(foo.getParent().getBlockID() == f.getParent().getBlockID())
                    {
                        tempIds.add(f.getParent().getBlockID());
                    }
                }
            }
            
            if(tempIds.size() > 1)
            {
                count = 2;
                dash = "-";
            }
            
            if(lastMethodBlock != null)
            {
                if (!(lastMethodBlock.getBlockID() == currentMethodBlock.getBlockID()))
                {
                    //if last method != new method
                    System.out.println("\n---------- new method here -----------");
                    System.out.println(foo.getParent());
                    finalBlockHierarchy.add(foo.getParent().toString());
                    blockHierarchy.add( new NodeRelationship(foo.getParent(), 0 ) );
                    count=1;
                    dash="";
                }
            }

            if(parent.getBlockType().equals( Type.METHOD ))
            {
                count = 1;
                dash = "";
            }

            //logic dependent on leaf or child
            if (parent.getBlockID() == lastChildBlock.getBlockID())
            {
                //then nest such as if == if
                System.out.println(dash + foo.getNode().getData());
                finalBlockHierarchy.add(dash + foo.getNode().getData());
                blockHierarchy.add( new NodeRelationship(foo.getNode(), count ) );
            }
            else if (parent.getBlockID() == lastParentBlock.getBlockID())
            {
                //method == method so method has if and else if
                count--;
                if(dash.length() > 1)
                {
                    dash = dash.substring(0, dash.length()-1);
                }
                System.out.println(dash + foo.getNode().getData());
                finalBlockHierarchy.add(dash + foo.getNode().getData());
                blockHierarchy.add( new NodeRelationship(foo.getNode(), count ) );
            }
            else if ( !(parent.getBlockID() == lastChildBlock.getBlockID()) && !(parent.getBlockID() == lastParentBlock.getBlockID()) )
            {
                //parent != lastChild && parent != lastParent
                //nested in its parent with no more childen so node0 inside an if
                System.out.println(dash + foo.getNode().getData());
                finalBlockHierarchy.add(dash + foo.getNode().getData());
                blockHierarchy.add( new NodeRelationship(foo.getNode(), count ) );
            }

            count++;
            dash += "-";

            if( foo.getParent().getBlockType().equals( Type.METHOD ) )
            {
                lastMethodBlock = foo.getParent();
            }

            lastParentBlock = foo.getParent();
            lastChildBlock = foo.getNode();
        }
    }

    private void getAllChildren(List<IMyTreeNode> children) 
    {
        for(IMyTreeNode childNode : children)
        {
            ((IMyTreeNode)childNode.getParent()).add(childNode);
            
            //blockList.add( ((IMyTreeNode)childNode.getParent()) );
            showCurrentBlockHierarchy(((IMyTreeNode)childNode.getParent()));
            
            //System.out.println("\tparent is: " + childNode.getParent() + "\t" +childNode);
            //blockList.add(new Foo(childNode.getParent().getData().toString(), childNode.getData().toString(), ((IMyTreeNode)childNode.getParent()).getBlockID() ));
            getAllChildren( (List<IMyTreeNode>) (Object) childNode.getChildren() );
        } 

    }
    
    

    private void showCurrentBlockHierarchy(IMyTreeNode iMyTreeNode) 
    {
        for(IMyTreeNode node: iMyTreeNode.getHierarchy() )
        {
            System.out.println("hierarchy Parent: " + node.getParent() +
                    "\t hierarchy node: " + node);
            
            //turn parent and its child into algorithm
            //it follows the way the data is shown on screen, the same layout is in the hierarchy
            
            blockList.add( new Foo( (IMyTreeNode) node.getParent(), node ) );
          
        }
        iMyTreeNode.getHierarchy().clear();                 
    }
    
    private void createClass(  List<NodeRelationship> blockList)
    {
        System.out.println("PRINTING HIERARCHY LIST");
        
        for(NodeRelationship node: blockList)
        {
            System.out.println(node);
        }
        
        int currentHierarchyLevel = 0;
        IMyTreeNode lastMethodNode = null;
        int lastLogicLevel = -1;
        boolean insideLogic = false;
        String tabs = "";
        String methodTabs = "\t";
        
        StringBuilder strBuilder = new StringBuilder();
        
        strBuilder.append("...\n");
        strBuilder.append( "public class " + getClassName() + " \n{ \n" ); //class name from tab

        Iterator<NodeRelationship> nodes = blockList.iterator();
        while (nodes.hasNext()) 
        {
            NodeRelationship s = nodes.next(); 
           
            currentHierarchyLevel = s.getHierarchyLevel();
            currentHierarchyLevel++;
            tabs = "";
            for(int i = 0; i < currentHierarchyLevel; i++)
            {
                tabs += "\t";
            }
            
            System.out.println("level: " + currentHierarchyLevel);
            System.out.println("tabs: " + tabs);
            
            //if brace logic
            if(lastLogicLevel != -1)
            {
                if(lastLogicLevel >= currentHierarchyLevel)
                {
                    tabs = "";
                    for(int i = 0; i < lastLogicLevel; i++)
                    {
                        tabs += "\t";
                    }
                   
                    //System.out.println("Logic Level from check: " + lastLogicLevel);
                    strBuilder.append(tabs).append("}\n");
                    insideLogic = false;
                }
            }
            
            
            if(checkType(s.getNode()) instanceof Logic)
            {              
                strBuilder.append(tabs).append(s.getNode().getData()).append(" \n "+ tabs +"{\n");
                lastLogicLevel = (s.getHierarchyLevel() + 1);
                //System.out.println("Logic Level: " + lastLogicLevel);
                insideLogic = true;
            }
            else if(checkType(s.getNode()) instanceof Loop)
            {
               
            }
            else if(checkType(s.getNode()) instanceof Method)
            {
                lastLogicLevel = -1; //reset logic when new method
                
                if( lastMethodNode != null )
                {
                    if(s.getNode().getBlockID() != lastMethodNode.getBlockID()) //lastmethod != current method, end first method brace //null
                    {
                        strBuilder.append(methodTabs).append("}\n\n"); //new method so end brace
                    }
                }
                
                //System.out.println( "s" + getAccessor(s.getNode().getAccessorType()) );
                //System.out.println("s" + s.getNode().getReturnType());
                if(s.getNode().getReturnType().equals("main"))//main
                {
                    //main method
                    strBuilder.append(methodTabs).append( "public static void main( String[] args ) \n" ).append(methodTabs).append("{\n");
                }
                else
                {
                    strBuilder.append(methodTabs).append( getAccessor(s.getNode().getAccessorType()) ).append(" ");
                    strBuilder.append(s.getNode().getReturnType()).append(" ");
                    strBuilder.append(s.getNode().getData().toString().substring(0, s.getNode().getData().toString().length() - 3)).append("( ");
                    //add arguments, loop through
                    Iterator<Argument> args = s.getNode().getArguments().iterator();
                    while (args.hasNext()) 
                    {
                        Argument arg = args.next(); 
                        if(args.hasNext())
                        {
                            strBuilder.append( arg.getType() + " " + arg.getValue() + ", ");
                        }
                        else
                        {
                            strBuilder.append( arg.getType() + " " + arg.getValue());
                        }

                        //arguments.remove(arg);
                    }

                    strBuilder.append(" )"); 
                    strBuilder.append("\n " + methodTabs + "{\n" );
                }
                
                
                nodes.remove();//remove method from list
            }
            else if(checkType(s.getNode()) instanceof Print)
            {
                Print object = (Print) checkType(s.getNode());
                strBuilder.append(tabs).append("System.out.println( \""+ object.getPrintStatement() +"\" );\n " );
            }
            else if(checkType(s.getNode()) instanceof MethodCall)
            {
                //method call
                MethodCall object = (MethodCall) checkType(s.getNode());
                strBuilder.append(tabs).append(object.getMethodStatment() + ";\n");
            }
            
            //if no more blocks check to end any ifs or loops
            if( !nodes.hasNext() )
            {
                if(insideLogic) //if still inside a logic block
                {
                    tabs = ""; //reset tabs count to the amount needed for the logic block
                    for(int i = 0; i < lastLogicLevel; i++)
                    {
                        tabs += "\t";
                    }
                    
                    strBuilder.append(tabs).append("}\n"); //no more logic block so end brace
                }
            } 
            
            if(s.getNode().getBlockType().equals( Type.METHOD ))
            {
                lastMethodNode = s.getNode();
            }
        }
        
        //if no more methods left
        if( !NodeRelationship.contains( blockList ) ) //no methods left
        {
            strBuilder.append(methodTabs).append("}\n");
        }
        
        
        //end class
        strBuilder.append( "\n}\n" );
        System.out.println( strBuilder.toString() );
    }
    
    public String getAccessor(String accessor)
    {
        if(accessor.equals("+"))
        {
            return "public";
        }
        else if(accessor.equals("-"))
        {
            return "private";
        }
        else if(accessor.equals("#"))
        {
            return "protected";
        }
        
        return null;
    }
    
    private Object checkType( final IMyTreeNode block )
    {
        final Type blockType = block.getBlockType();     
        
        Method newMethod; 
        Loop newLoop;
        Logic newLogic;
        Variable newVariable;
        Object object = null;
           
        if( blockType.equals( Type.METHOD ) )
        {
            object = (Method) buildMethod( block );
        }       
        else if( blockType.equals( Type.DEFAULT ) )
        {
            //nodes atm
        }
        else if( blockType.equals( Type.LOOP ) )
        {
            object = (Loop) buildLoop(block);
        }
        else if( blockType.equals( Type.LOGIC ) )
        {
            object = (Logic) buildLogic(block);
        }
        else if( blockType.equals( Type.PRINT ) )
        {
            object = new Print(block.getData().toString());
        }
        else if( blockType.equals( Type.MAIN ) )
        {
            object = new Main();
        }
        else if( blockType.equals( Type.METHODCALL ) )
        {
            object = new MethodCall(block.getData().toString());
        }
        
        return object; //dont know the type of object until assigned by build methods
    }
    
    
    private Method buildMethod( final IMyTreeNode block )
    {
        final String name = String.valueOf( block.getData() );
        
        return new Method( "public","String","methodname",null );
        
        
        //return null;           
    }
    
    
    private Logic buildLogic( final IMyTreeNode block )
    {
        //get type such as if, everything before (
        //get condition, everything between (  )
        return new Logic("if","condition");
        //return null;           
    }
        
    private Loop buildLoop( final IMyTreeNode block )
    {
        return new Loop( "for","condition" );
        //return null;           
    }
            
    private Variable buildVariable( final IMyTreeNode block )
    {
        
        return null;           
    }
    
    private class MethodCall
    {
        private String methodStatment;
        
        public MethodCall(String statement) 
        {
            this.methodStatment = statement;
        }

        public String getMethodStatment() 
        {
            return methodStatment;
        }
        
        
    }
    
    private class Main
    {
        public Main()
        {
            
        }
    }
    
    private class Method
    {
        private String methodAccess;
        private String methodReturnType;
        private String methodName;
        private Map<String, Variable> methodArgs;
        
        private List<Logic> methodLogic;
        private List<Loop> methodLoop;
        private List<Variable> methodVariable;

        public Method(String methodAccess, String methodReturnType, String methodName, Map<String, Variable> methodArgs) 
        {
            this.methodAccess = methodAccess;
            this.methodReturnType = methodReturnType;
            this.methodName = methodName;
            this.methodArgs = methodArgs;
        }

        public void setMethodLogic(List<Logic> methodLogic) {
            this.methodLogic = methodLogic;
        }

        public void setMethodLoop(List<Loop> methodLoop) {
            this.methodLoop = methodLoop;
        }

        public void setMethodVariable(List<Variable> methodVariable) {
            this.methodVariable = methodVariable;
        }                
    }
    
    
    private class Loop
    {
        private String loopType;
        private String loopParameters;

        public Loop(String loopType, String loopParameters) 
        {
            this.loopType = loopType;
            this.loopParameters = loopParameters;
        }               
    }
    
    
    private class Logic
    {
        private String logicType;
        private String logicParameters;

        public Logic(String logicType, String logicParameters) 
        {
            this.logicType = logicType;
            this.logicParameters = logicParameters;
        }
    }
    
    private class Print
    {
        private String printStatement;

        public Print(String statement) 
        {
            this.printStatement = statement;
        }

        public String getPrintStatement() {
            return printStatement;
        }
        
        
    }
    
    private class Variable
    {
        private String variableAccess;
        private String variableType;
        private String variableName;
        private String variableValue;

        public Variable(String variableAccess, String variableType, String variableName, String variableValue) 
        {
            this.variableAccess = variableAccess;
            this.variableType = variableType;
            this.variableName = variableName;
            this.variableValue = variableValue;
        }        
    }
    
    
    private class Clazz
    {
        private String classAccess = "public";
        private String className;
        private List<Method> methodList;
        private List<Variable> variableList;

        public Clazz(String className, List<Method> methodList, List<Variable> variableList) 
        {
            this.className = className;
            this.methodList = methodList;
            this.variableList = variableList;
        }                    
    }
}