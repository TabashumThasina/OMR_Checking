package sheetchecking;
import java.awt.image.BufferedImage; //This interface describes single-input/single-output operations performed on BufferedImage objects
import java.io.*;
import javax.imageio.ImageIO;//A class containing static convenience methods for locating ImageReaders and ImageWriters, and performing simple encoding and decoding.
import java.awt.Color;

public class Pixl {
   private BufferedImage image;
   private int width;			// width of the Image
   private int height;
   private int count=0;
    public Pixl(){
	    try{
		File input = new File("C:\\Users\\Tabashum\\Documents\\NetBeansProjects\\SheetChecking\\src\\sheetchecking\\OMR ANS SHEET MORN B.jpg");// Image input
		image = ImageIO.read(input);
		width = image.getWidth();
		height = image.getHeight();
            }
            catch(Exception e){
			System.out.println("not found");
                }
	}
    public BufferedImage getimage(){
       return image;
   }
   
   
    public void ImageScann(AnswerSet answer) {
        try {
            int intialx=160,x=160;
            int intialy=675,y=675;
            int k=0,a=0,b=50,c=100,d=150,i=0;  // a ,b,c,d stands for accordingly answer A,B,C,D;
            while(k<25){ //for first 25 answer checking loop
                y=y+(k*35);
		if ((answer.getAnswers(k+i)).equals("A")){
                    if(check(x+a,y)==true){ // if answer has been marked then checking any other option are marked or not
                        if(check(x+b,y)==false&&check(x+c,y)==false&&check(x+d,y)==false) // if other option are not marked then number will be added
                            count++;
                            }
                }
                if ((answer.getAnswers(k+i)).equals("B")){
                    if(check(x+b,y)==true){
                        if(check(x+a,y)==false&&check(x+c,y)==false&&check(x+d,y)==false)
                            count++;
                            }
                }
                 if((answer.getAnswers(k+i)).equals("C")){
                    if(check(x+c,y)==true){
                        if(check(x+b,y)==false&&check(x+a,y)==false&&check(x+d,y)==false)
                        count++;
                        }
                 }
                 else{
                    if(check(x+d,y)==true){
                        if(check(x+b,y)==false&& check(x+c,y)==false &&check(x+a,y)==false)
                            count++;
                    }
                 }
		k++;
                if(k>24 && i==0){ // after 25 check till 50
                    i=25;
                    k=0;
                    intialx=430;
                }
		else if(k>24&&i==25){// after 50 check till 75
                    i=50;
                    k=0;
                    intialx=705;
                }
		else if(k>24 &&i==50){// after 75 checki till 100
                    i=75;
                    k=0;
                    intialx=980;
		}
		y=intialy;
                x=intialx;
	
            }
    //System.out.println(count);
        }	
	catch (Exception e) {}
   }
   public int getnumber(){ // number in the exam
	   return count;
   }
   public int setSet(){
	   if(check(1081,550) ==true)
		   return 1;
	   else if(check(1081,585)==true)
		   return 2;
	   else
	      return 0;
   }
	   
  public boolean check(int x, int y ){    // checking the answer in pixel
	   int intensity=0;
	   for(int i=x;i<x+25;i++){
		   for(int j=y; j<y+20;j++){
				Color c = new Color(getimage().getRGB(i,j));
				int r=c.getRed();
				int g=c.getGreen();
				int b=c.getBlue();
				if(r<150&&g<150&&b<150)
					intensity++;
				}
			}
		if(intensity>=120)
				return true;
       return false;
    }
public boolean imagePosition(){  // the scanned omr sheet is in right position or not
	int x=26,k=0,intensity=0,counter=0;
	int y=114;
	while(k<2){
		for(int i=x;i<x+30;i++){
			for(int j=y;j<y+20;j++){
				Color c = new Color(getimage().getRGB(i,j));
				int r=c.getRed();
				int g=c.getGreen();
				int b=c.getBlue();
				if(r<150&&g<150&&b<150)
					intensity++;
				
			}
		}
			//System.out.println(intensity);
			if(intensity>=150)
					counter++;
			k++;
			x=26;
			y=1629;
			intensity=0;
		
		
	}
	//System.out.println(counter);
	if (counter==2)
				return true;
		else 
			return false;
    }
}
