/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uk.anil;

/**
 *
 * @author anil
 */
public class Block {
    private IMyTreeNode block;
    
    public Block()
    {
        
    }

    public Block(IMyTreeNode block) {
        this.block = block;
    }
    

    public IMyTreeNode getBlock() {
        return block;
    }

    public void setBlock(IMyTreeNode block) {
        this.block = block;
    }

    @Override
    public String toString() {
        return "Block{" + "block=" + block + '}';
    }
    
    
}
