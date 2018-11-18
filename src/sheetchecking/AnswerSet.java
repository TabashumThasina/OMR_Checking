package sheetchecking;

import java.util.Scanner;
import java.io.*;
import java.util.*;
public class AnswerSet{
	private String []ans=new String[200];
	public AnswerSet(){
	}
	public void setAnswers()
        {
		
		for(int i=0;i<100;i++){
			System.out.println("Question "+(i+1)+" : Answer"); // seting answers
			Scanner s=new Scanner(System.in);
			String n=s.nextLine();
			ans[i]=n;
		}
	}
	public String getAnswers(int x){ // 
		return ans[x];
	}
	/*public static void main(String arg[]){
		AnswerSet a=new AnswerSet();
		a.setAnswers();
	}*/
}