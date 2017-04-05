/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uk.anil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.model.TreeNode;
import org.primefaces.model.TreeNodeChildren;

/**
 *
 * @author anil
 * This class is my own implementation of the TreeNode class provided by the primefaces library, this was done to add functionality that was needed but not provided
 */
public class MyTreeNodeImpl implements IMyTreeNode, Serializable {
	
    public transient static final String DEFAULT_TYPE = "default";

    private transient String type;

    private Object data;

    private List<TreeNode> children;

    private transient TreeNode parent;

    private transient boolean expanded;

    private transient boolean selected;
    
    private transient boolean selectable = true;
    
    private transient String rowKey;
    
    private Type blockType;
    
    private List<IMyTreeNode> hierarchy;
    
    private transient long blockID;
    
    private String accessorType;
    
    private String returnType;
    
    private String value;
    
    private String name;
    
    private List<Argument> arguments;
	
	public MyTreeNodeImpl() {
        this.type = DEFAULT_TYPE;
        this.children =  new TreeNodeChildren(this);
        this.hierarchy = new ArrayList<>();
    }
    
    public MyTreeNodeImpl(Object data) {
        this.type = DEFAULT_TYPE;
        this.children = new TreeNodeChildren(this);
        this.data = data;
        this.hierarchy = new ArrayList<>();
    }

    public MyTreeNodeImpl(Object data, TreeNode parent) 
    {
		this.type = DEFAULT_TYPE;
		this.data = data;
		this.children = new TreeNodeChildren(this);
		if(parent != null) 
                {
			parent.getChildren().add(this);
                }
                this.hierarchy = new ArrayList<>();
    }
        
    public MyTreeNodeImpl(long id, Object data, TreeNode parent, Type t ) 
    {       
            this.blockID = id;
            this.blockType = t;
            this.type = DEFAULT_TYPE;
            this.data = data;
            this.children = new TreeNodeChildren(this);
            if(parent != null) 
            {
                    parent.getChildren().add(this);
            }
            this.hierarchy = new ArrayList<>();
    }
	
    public MyTreeNodeImpl(String type, Object data, TreeNode parent) 
    {
            this.type = type;
            this.data = data;
            this.children = new TreeNodeChildren(this);
            if(parent != null) 
            {
                    parent.getChildren().add(this);
            }
            this.hierarchy = new ArrayList<>();
    }

    public String getType() {
            return type;
    }

    public void setType(String type) {
            this.type = type;
    }

    public Object getData() {
            return data;
    }

    public void setData(Object data) {
            this.data = data;
    }

    public void setChildren(List<TreeNode> children) {
            this.children = children;
    }

    public TreeNode getParent() {
            return parent;
    }

//    public void setIMyTreeNodeParent(IMyTreeNode parent) {
//        this.parent = parent;
//    }

    public boolean isExpanded() {
            return expanded;
    }

    public void setExpanded(boolean expanded) {
            this.expanded = expanded;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean value) {
        this.selected = value;
    }

    public boolean isSelectable() {
        return selectable;
    }

    public void setSelectable(boolean selectable) {
        this.selectable = selectable;
    }
    
    public int getChildCount() {
            return children.size();
    }

    public boolean isLeaf() {
            if(children == null)
                    return true;

            return children.isEmpty();
    }

    public String getRowKey() {
        return rowKey;
    }

    public void setRowKey(String rowKey) {
        this.rowKey = rowKey;
    }

    @Override
    public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((data == null) ? 0 : data.hashCode());
            return result;
    }

    @Override
    public boolean equals(Object obj) {
            if(this == obj)
                    return true;
            if(obj == null)
                    return false;
            if(getClass() != obj.getClass())
                    return false;

            MyTreeNodeImpl other = (MyTreeNodeImpl) obj;
            if (data == null) {
                    if (other.data != null)
                            return false;
            } else if (!data.equals(other.data))
                    return false;

            return true;
    }

    @Override
    public String toString() {
            if(data != null)
                    return data.toString();
            else
                    return super.toString();
    }	

    public boolean isPartialSelected() {
        return false;
    }

    public void setPartialSelected(boolean value) {
        //nothing
    }

    //new method implementation
    @Override
    public void updateNode(String data) {
        setData(data);
    }
    
    @Override
    public Type getBlockType() {
        return blockType;
    }

    @Override
    public void setBlockType(Type blockType) {
        this.blockType = blockType;
    }
    
    @Override
    public long getBlockID() 
    {
        return blockID;
    }

    @Override
    public void setBlockID(long blockID) 
    {
        this.blockID = blockID;
    }    

    
//    @Override
//    public List<IMyTreeNode> getChildren() {
//        return children;
//    }

    //composite design pattern, create a hierarchy/group of objects
    @Override
    public void add(IMyTreeNode node) {
        hierarchy.add(node);
    }

    @Override
    public void remove(IMyTreeNode node) {
        hierarchy.remove(node);
    }

    @Override
    public List<IMyTreeNode> getHierarchy() {
        return hierarchy;
    }

    @Override
    public String getAccessorType() {
        return accessorType;
    }

    @Override
    public void setAcessorType(String accessor) {
        this.accessorType = accessor;
    }

    @Override
    public List<Argument> getArguments() {
        return arguments;
    }

    @Override
    public void setArguments(List<Argument> arguments) {
        this.arguments = arguments;
    }

    @Override
    public String getReturnType() {
        return returnType;
    }

    @Override
    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

   
    @Override
    public List<TreeNode> getChildren() 
    {
        return children;
    }

//    @Override
//    public List<IMyTreeNode> getAllChildren() {
//        return children;
//    }

    @Override
    public void setParent(TreeNode tn) {
        this.parent = tn;
    }

    @Override
    public void setValue(String variableValue) {
        this.value = variableValue;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
    
    
    
    
    
   
    
    
}
