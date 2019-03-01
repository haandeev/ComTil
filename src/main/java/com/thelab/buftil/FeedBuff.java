/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thelab.buftil;

import java.nio.ByteBuffer;

/**
 *
 * @author pohan
 */
public class FeedBuff {
    private byte buffer[];
    private int size;
    private ByteBuffer bobo;

    public FeedBuff(int size) {
        buffer = new byte[size];
        this.size = size;
        bobo = ByteBuffer.wrap(buffer);
        //bobo = ByteBuffer.allocate(size);
    }
    
    public void put(byte chunk[], int length){
        bobo.put(chunk, 0, length);
    }
    
    public int readalldata(byte chunk[]){
        int p = bobo.position();
        bobo.position(0);
        bobo.get(chunk, 0, p);
        bobo.position(p);
        return p;
    }
    
    public int readData(byte chunk[]){
        if (bobo.position() > 2) {
            int sz = bobo.getShort(0);
            if (sz > 0) {
                if ((sz + 2) <= bobo.position()) {
                    int p = bobo.position();
                    bobo.position(2);
                    bobo.get(chunk, 0, sz);
                    bobo.compact();
                    bobo.position(p - sz - 2);
                    return sz;
                }
            }
        }
        return 0;
    }
}
