import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args){
        //create GUI
        JFrame frame = new JFrame("Idle Bunny Tycoon"); //create frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set exit opperation
        ImageIcon windowIcon = new ImageIcon(Images.WINDOW_ICON); //create window icon
        frame.setIconImage(windowIcon.getImage()); //set window icon

        //get screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        //define aspect ratio (16:9)
        double aspectRatio = 16.0 / 9.0;

        //scaling factor (adjust this for different window sizes)
        double scaleFactor = 0.7; //70% of the screen size

        //determine the best fit size while maintaining 16:9
        int frameWidth = (int) (screenWidth * scaleFactor);
        int frameHeight = (int) (frameWidth / aspectRatio);

        //if the calculated height is too big, scale it down
        if(frameHeight > screenHeight * scaleFactor){
            frameHeight = (int) (screenHeight * scaleFactor);
            frameWidth = (int) (frameHeight * aspectRatio);
        }

        frame.setSize(frameWidth, frameHeight); //size
        frame.setLocationRelativeTo(null); //center on screen
        frame.setVisible(true); //make visible
    }
}
