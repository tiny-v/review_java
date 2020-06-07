package com.my.basic.breakloop;

/**
 * @author mayue
 */
public class BreakLoop {

    public static void main(String[] args){
        int loopSize = 4;
        break1:
        for(int i=0; i<loopSize; i++){
            for(int j=0; j<loopSize; j++){
                for(int k=0; k<loopSize; k++){
                    System.out.println("break loop test: i:"+   i   + ", j:"+j+", k:"+k);
                    if(j == 2){
                        break break1;
                    }
                }
            }
        }
        System.out.println("loop finish");
    }

}
