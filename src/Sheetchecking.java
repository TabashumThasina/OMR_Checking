import sheetchecking.AnswerSet;
import sheetchecking.Pixl;
import sheetchecking.Idset;
import sheetchecking.DataAccess;
import sheetchecking.test;
public class Sheetchecking{
	static public void main(String args[]) throws Exception 
   {
           
	   AnswerSet a=new AnswerSet();
	   Pixl obj = new Pixl();      
	   a.setAnswers();
           DataAccess da=new DataAccess();
            
 
            if(obj.imagePosition()==true){
                     Idset id=new Idset(obj.getimage());
                     id.SetID();
                     obj.ImageScann(a);
                     int marks=obj.getnumber();
                     System.out.println(marks);
                     
                     String student_id=id.getId();
                     test t=new test(da,marks,student_id);
                     
                     
	   }
            else
                System.out.println("Image position is not correct");
   }

}