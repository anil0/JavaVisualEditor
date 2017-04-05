/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uk.anil;

public class Variable
{
    private String variableAccess;
    private String variableType;
    private String variableName;
    private String variableValue;

    public Variable()
    {
        
    }
    
    public Variable(String variableAccess, String variableType, String variableName, String variableValue) 
    {
        this.variableAccess = variableAccess;
        this.variableType = variableType;
        this.variableName = variableName;
        this.variableValue = variableValue;
    }        

    public String getVariableType() {
        return variableType;
    }

    public void setVariableType(String variableType) {
        this.variableType = variableType;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public String getVariableValue() {
        return variableValue;
    }

    public void setVariableValue(String variableValue) {
        this.variableValue = variableValue;
    }

    public String getVariableAccess() {
        return variableAccess;
    }

    public void setVariableAccess(String variableAccess) {
        this.variableAccess = variableAccess;
    }

    
}
