package sheetchecking;
import java.awt.image.BufferedImage; //This interface describes single-input/single-output operations performed on BufferedImage objects
import java.awt.Color;

public class Idset {
   private BufferedImage image;
   private int width;			// width of the Image
   private int height;
   private int count=0;
   private String Id=new String();
   public Idset(BufferedImage i){
	   try{
		image=i;
	    }
            catch(Exception e){
                System.out.println("not set");
            }
	}
   
   
   public void SetID() {
        try {
	    int x=202;
	    int y=270;
	    int k=0;
            while(k<9){
                String temp = String.valueOf(checkId(x,y));
                Id=Id.concat(temp);
		k++;
		x=x+50;
		y=270;
		 
            }
        //System.out.println(Id);
        }
	catch (Exception e) {
            System.out.println("id not found");
        }
    }
   public String getId(){
       return Id;
    }
   
   public int checkId(int intialx,int intialy){
	   int k=0;
	   int x=intialx;
	   int y=intialy;
	   int intensity=0;
	   while(k<9){
		   
	   for(int i=x;i<x+30;i++){
			for(int j=y;j<y+15;j++){
				Color c = new Color(image.getRGB(i,j));
				int r=c.getRed();
				int g=c.getGreen();
				int b=c.getBlue();
				if(r<150&&g<150&&b<150)
					intensity++;
			}
		}
		if(intensity>=120)
			return k;
		x=intialx;
		y=y+35;
		k++;
	}
	return -1;
    }
}

