/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uk.anil;

import org.primefaces.model.TreeNode;

/**
 *
 * @author anil
 * This interface was created to add an extra piece of functionality on top of what the TreeNode class currently provides
 */
public interface IMyTreeNode extends TreeNode {
    //new functionality methods
    void updateNode(String data);
}
