/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uk.anil;
//

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.primefaces.context.RequestContext;
import org.primefaces.model.TreeNode;

/**
 *
 * @author anil
 */

class ClassCreator
{
    String output = "";
    StringBuilder sb = new StringBuilder();
    String tabs = "\t";
    String parentTabs = "";
    String currentTabs = "\t";
    int level = 1;
    int countBlocks = 0;
    
    
    public String createClass( String className, List<Method> methodsList, List<Variable> globalVariables )
    {
        System.out.println("Class Creator----------------------------------------");
        
        String methodTabs = "\t";
        
        sb.append("public class ");
        sb.append(className).append("\n{\n");
        
        //GLOBAL VARIABLES
        for( Variable variable: globalVariables )
        {
            sb.append( variable.getVariableAccess() ).append(" ");
            sb.append( variable.getVariableType()).append(" ");
            sb.append( variable.getVariableName()).append(";\n");
        }
        //METHODS
        for( Method method: methodsList )
        {
            if( method.getMethodName().equals("main") )
            {
                //main method
                sb.append( method.getMethodAccess() ).append(" ");
                sb.append( method.getMethodReturnType() ).append(" ");
                sb.append( method.getMethodName() );//.append("()\n");
            }
            else
            {
                //sb.append(methodTabs);
                sb.append( BlockBean.getAccessor( method.getMethodAccess()) != null ? BlockBean.getAccessor( method.getMethodAccess()) : "public" ).append(" ");
                sb.append("static").append(" ");
                sb.append( method.getMethodReturnType() ).append(" ");
                sb.append( method.getMethodName() );//.append("()\n");
            }
            
            String args = "( ";
            Iterator<Argument> arguments = method.getMethodArgs().iterator();
            while (arguments.hasNext()) 
            {
                // Use isLeaf() method to check doesn't have childs.
                Argument a = arguments.next(); 
                if(arguments.hasNext())
                {
                    args += a.getType() + " " + a.getValue() + ", ";
                }
                else
                {
                    args += a.getType() + " " + a.getValue();
                }
            }
            args += " )";
            
            sb.append(args).append("\n");

            sb.append("{\n");
            
            //method blocks and their children handling
            
            //CHILDREN OF METHOD
            for( Block block: method.getBlocksList() )
            {
                if(block.getBlock().getBlockType().equals( Type.IF ))
                {
                    sb.append(block.getBlock().getData()).append(" \n");
                    sb.append("{\n");
                    
                    //get all children of the inner block such as everything within an if block
                    if(block.getBlock().getChildCount() > 0)
                    {
                        getAllHierarchy(block.getBlock().getChildren(), block.getBlock().getChildren());          
                    }
     
                    sb.append("}\n");
                }
                else if(block.getBlock().getBlockType().equals( Type.ELSEIF ))
                {
                    sb.append(block.getBlock().getData()).append(" \n");
                    sb.append("{\n");
                    
                    //get all children of the inner block such as everything within an if block
                    if(block.getBlock().getChildCount() > 0)
                    {
                        getAllHierarchy(block.getBlock().getChildren(), block.getBlock().getChildren());          
                    }
     
                    sb.append("}\n");
                }
                else if(block.getBlock().getBlockType().equals( Type.ELSE ))
                {
                    sb.append(block.getBlock().getData()).append(" \n");
                    sb.append("{\n");
                    
                    //get all children of the inner block such as everything within an if block
                    if(block.getBlock().getChildCount() > 0)
                    {
                        getAllHierarchy(block.getBlock().getChildren(), block.getBlock().getChildren());          
                    }
     
                    sb.append("}\n");
                }
                else if(block.getBlock().getBlockType().equals( Type.PRINT ))
                {
                    //sb.append(block.getBlock().getData()).append("\n");
                    String parsedBetweenParentheses = block.getBlock().getData().toString()
                            .substring(block.getBlock().getData().toString()
                                    .indexOf("(")+1,block.getBlock().getData().toString()
                                            .indexOf(")")).trim();
                    sb.append("System.out.println( ").append(parsedBetweenParentheses).append(" )").append(";\n");
                    
                    //get all children of the inner block such as everything within an if block
                    if(block.getBlock().getChildCount() > 0)
                    {
                        getAllHierarchy(block.getBlock().getChildren(), block.getBlock().getChildren());          
                    }
                }
                else if(block.getBlock().getBlockType().equals( Type.FOR ))
                {
                    sb.append(block.getBlock().getData()).append("\n{\n");
                    
                    //get all children of the inner block such as everything within an if block
                    if(block.getBlock().getChildCount() > 0)
                    {
                        getAllHierarchy(block.getBlock().getChildren(), block.getBlock().getChildren());          
                    }
                    
                    sb.append("}\n");
                }
                else if(block.getBlock().getBlockType().equals( Type.METHODCALL ))
                {
                    sb.append(block.getBlock().getData()).append(";");
                    
                    //get all children of the inner block such as everything within an if block
                    if(block.getBlock().getChildCount() > 0)
                    {
                        getAllHierarchy(block.getBlock().getChildren(), block.getBlock().getChildren());          
                    }
                    
                    sb.append("\n");
                }
                
            }
            
            //end method
            sb.append("}");
                    
        }
        
        //end class
        sb.append("\n}");
        
        //System.out.println(sb.toString());
        
        /**
         * Pass the user generated class string to a formatter webpage and retrieve the new string
         **/
        Elements doc = null;
        try
        {
            doc = Jsoup.connect("http://prettyprinter.de/index.php")
                    .data("source", sb.toString() )
                    .data("css", "on") //trying to add the css checkbox name so it ticks it

                    .post().getElementsByTag("code");

        }
        catch (IOException ex)
        {
            System.out.println("error");
        }

        output = doc.toString();
        
//        output = output.replace("&nbsp;"," ");
//        output = output.replace("<br>","\n");
        output = output.replace("<code><span style=\"color: #000000\"> ","");
        output = output.replace("</span> </code>","");

        //print formatted class
        System.out.println(output);

        //reset stringbuilder
        sb = new StringBuilder();
        sb.setLength(0);
        
        return output;
    }
    
   
    public void getAllHierarchy( List<TreeNode> list, List<TreeNode> methodBlocks )
    {
       //CHILDREN OF METHOD
        for( IMyTreeNode m: (List<IMyTreeNode>)(Object) list )
        {
            
            //System.out.println(m + " - " + m.getBlockType());
            if(m.getBlockType().equals( Type.IF ))
            {
                //currentTabs
                sb.append(m).append("\n");
                sb.append("{\n");

                getAllHierarchy(m.getChildren(), methodBlocks); //keep going until all children are done

                //end if
                sb.append("}\n");

            }
            else if(m.getBlockType().equals( Type.ELSEIF ))
            {
                //currentTabs
                sb.append(m).append("\n");
                sb.append("{\n");

                getAllHierarchy(m.getChildren(), methodBlocks); //keep going until all children are done

                //end if
                sb.append("}\n");

            }
            else if(m.getBlockType().equals( Type.ELSE ))
            {
                //currentTabs
                sb.append(m).append("\n");
                sb.append("{\n");

                getAllHierarchy(m.getChildren(), methodBlocks); //keep going until all children are done

                //end if
                sb.append("}\n");

            }
            else if(m.getBlockType().equals( Type.PRINT ))
            {
                //sb.append(m).append("\n");
                String parsedBetweenParentheses = m.getData().toString()
                            .substring(m.getData().toString()
                                    .indexOf("(")+1,m.getData().toString()
                                            .indexOf(")")).trim();
                sb.append("System.out.println( ").append(parsedBetweenParentheses).append(" )").append(";\n");

                getAllHierarchy(m.getChildren(), methodBlocks);
            }
            else if(m.getBlockType().equals( Type.FOR ))
            {
                //currentTabs
                sb.append(m).append("\n");
                sb.append("{\n");

                getAllHierarchy(m.getChildren(), methodBlocks); //keep going until all children are done

                //end for
                sb.append("}\n");

            }
        }
    }

    private String viewClass() 
    {
        return output;
    }
}
