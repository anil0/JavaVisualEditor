/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uk.anil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Method
{
    private String methodAccess;
    private String methodReturnType;
    private String methodName;
    //private Map<String, Variable> methodArgs;
    private List<Argument> methodArgs;

    private List<Block> blocksList = new ArrayList<>(); 
    //private List<Logic> methodLogic;
    //private List<Loop> methodLoop;
    //private List<Variable> methodVariable;

    public Method()
    {
        this.methodArgs = new ArrayList<>();
    }

    public Method(String methodAccess, String methodReturnType, String methodName)
    {
        this.methodAccess = methodAccess;
        this.methodReturnType = methodReturnType;
        this.methodName = methodName;
        this.methodArgs = new ArrayList<>();
    }

    public Method(String methodAccess, String methodReturnType, String methodName, List<Argument> methodArgs) 
    {
        this.methodAccess = methodAccess;
        this.methodReturnType = methodReturnType;
        this.methodName = methodName;
        this.methodArgs = methodArgs;
    }

    public String getMethodAccess() {
        return methodAccess;
    }

    public void setMethodAccess(String methodAccess) {
        this.methodAccess = methodAccess;
    }

    public String getMethodReturnType() {
        return methodReturnType;
    }

    public void setMethodReturnType(String methodReturnType) {
        this.methodReturnType = methodReturnType;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public List<Block> getBlocksList() {
        return blocksList;
    }

    public void setBlocksList(List<Block> blocksList) {
        this.blocksList = blocksList;
    }

    public List<Argument> getMethodArgs() {
        return methodArgs;
    }

    public void setMethodArgs(List<Argument> methodArgs) {
        this.methodArgs = methodArgs;
    }
    
    
    
    public static Method copy( Method original ) {
         Method copyMethod = new Method();
         copyMethod.methodAccess = original.methodAccess;
         copyMethod.methodReturnType = original.methodReturnType;
         copyMethod.methodName = original.methodName;
         copyMethod.blocksList = original.blocksList;
         //copyMethod. = original.methodReturnType;
         //... etc. 
         return copyMethod;
    }

    @Override
    public String toString() {
        return "Method{" + "methodAccess=" + methodAccess + ", methodReturnType=" + methodReturnType + ", methodName=" + methodName + ", argsList=" + methodArgs + ", blocksList=" + blocksList + '}';
    }

}
