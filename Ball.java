// Hallie Dunham
// Assignment 4
// bouncing ball
// M750
// Version 1  
// 10/29/13

import java.util.*;
import java.awt.*;
public class Ball
{   
   /**
     *class constant for radius of ball
     */
   public static final int RADIUS=10;
   /**
     *class constant for number of frames per sec
     */
   public static final int FRAMERATE=40;
   /**
     *class constant for number of frames drawn
     */
   public static final int STEPS=1000;
   /**
     *class constant for wether to print debug
     */
   public static final boolean DEBUG=false;
   
   /**
     *this is the main method that calls the other methods
     *@param args  the command line arguments that are passed into the program
     */
   public static void main (String[] args)
   {
      System.out.println("This program will simulate a ball bouncing in a window");
      Scanner console=new Scanner(System.in);
      int iwidth=request(console, "How wide would you like the panel (in pixels)? ");
      int iheight=request(console, "How tall would you like the panel (in pixels)? ");
      int ixpos=request(console, "What is the initial X position of the ball? ");
      int iypos=request(console, "What is the initial Y position of the ball? ");
      int ixvel=request(console, "What is the initial X velocity of the ball? ");
      int iyvel=request(console, "What is the initial Y velocity of the ball? ");
      makeBall(iwidth, iheight, ixpos, iypos, ixvel, iyvel);
   }
     
   /**
     *this method asks for input (initial position and velosity) from the user
     *@param input  this scanner gets passed into the method to collect the user's input
     *@param question  this is a string that is printed to ask the user for an input
     *@return response  the answer that the user gives to the question
     */
   public static int request(Scanner input, String question)
   {
      System.out.print(question);
      int response=input.nextInt();
      return response;
   }
     
   /**
     *this method erases previous ball and draws the ball in its next position
     *@param width  passed in to determine width of panel
     *@param height  passed in to determine height of panel
     *@param xpos  used as the initial x position of the left side of the ball
     *@param ypos  used as the initial y position of the top of the ball
     *@param xvel  is initial velocity in x direction and is multiplied by -1 when ball hits sides
     *@param yvel  is initial velocity in y direction and is multiplied by -1 when ball hits top or bottom
     */
   public static void makeBall(int width, int height, int xpos, int ypos, int xvel, int yvel)
   {
      DrawingPanel panel=new DrawingPanel(width,height);
      Graphics g=panel.getGraphics();     
      for(int ii=0;ii<STEPS;ii++)
      {
         printDebug("xpos: "+xpos+", ypos: "+ypos+", xvel: "+xvel+", yvel: "+yvel);
         g.setColor(Color.BLUE);
         g.fillRect(0,0,width,height);
         g.setColor(Color.PINK);
         g.fillOval(xpos,ypos,2*RADIUS,2*RADIUS);//2*radius is diameter
         if((xpos+2*RADIUS+xvel)>=width||(xpos+xvel)<0)
         {
            xvel=-xvel;
         }
         else if((ypos+2*RADIUS+yvel)>=height||(ypos+yvel)<0)
         {
            yvel=-yvel;
         }
         xpos+=xvel;
         ypos+=yvel;
         panel.sleep( 1000 / FRAMERATE);
      }
   }
     
   /**
     *debug method
     *@param s  this is the string that the method prints
     */
   public static void printDebug(String s)
   {
      if (DEBUG)
      {
         System.out.println(s);
      }
   }
  
}