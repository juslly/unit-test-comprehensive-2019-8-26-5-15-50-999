package tw;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import tw.commands.GuessInputCommand;

/**
 * Created by jxzhong on 2017/5/16.
 */
public class Main {
	static int[] answer = new int[4];
	static int[] inputArray = new int[4];
	static int count1 = 0;
	static int count2 = 0;
	static int flag = 1;

    private static final int RUN_TIMES = 6;
   
    public static void main(String[] args) throws Exception {
    	//随机生成答案
    	answer[0] = new Random().nextInt(9);
    	for(int i = 1;i < answer.length;i++) {
    		answer[i] =  new Random().nextInt(9);
    		for(int j = 0 ;j < i;j++) {
    			if(answer[j]==answer[i]) {
    				i = i -1;
    				continue;
    			}
    			
    		}
    		
    	}
    	for(int i :answer) {
    		System.out.print(i+" ");
    	}
    	//获得返回值xAxB
        for (int i = 0; i < RUN_TIMES; i++) {
        	//获得用户输入
           String input = new GuessInputCommand().input();
           //判断输入长度是否合法
        	   if(input.split(" ").length==4) {
        		   Set set = new HashSet();
           		   for(int j = 0;j < inputArray.length;j++) {
        			   inputArray[j] = Integer.parseInt(input.split(" ")[j]);
        			   set.add(inputArray[j]);
        		   }
        		   if(set.size()!=inputArray.length) {
        			   System.out.println("输入中有重复数字，请重新输入");
        			   flag = 0;
        		   }
        	   }else {
        		   System.out.println("输入位数不正确，请重新输入");
        		   flag = 0;
        	   }
        	  	     
           for(int j = 0;j < answer.length;j++) {
        	   //判断A前面的值
        	   if(inputArray[j] == answer[j]) {
        		   count1++; 
        	   }
        	   //判断前面的值
        	   for(int k = 0;k < inputArray.length;k++) {
        		   if(j!=k) {
        			   if(answer[j] == inputArray[k]) {
        				   count2++;
        				   
        			   }
        		   }
        		   
        	   }
        	   
           } 
           if(flag == 1) { 
//        	   if(count1 == 4 && count2 ==0) {
//        		   System.out.println(count1+"A"+count2+"B");
//        		   
//        	   }
        	   System.out.println(count1+"A"+count2+"B"); 
           }
           
           count1 = 0;
           count2 = 0;
           flag = 1;
            
        }  
    }
    
    
}
