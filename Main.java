import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

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

        //define aspect ratio (14:9)
        double aspectRatio = 14.0 / 9.0;

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

        //initial size and position
        frame.setSize(frameWidth, frameHeight); //size
        frame.setLocationRelativeTo(null); //center on screen
        frame.setVisible(true); //make visible

        //resize listener to maintain 14:9 ratio
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent event) {
                int newWidth = frame.getWidth();
                int newHeight = (int) (newWidth / aspectRatio);

                //prevent infinite resize loops by checking the current height
                if (Math.abs(newHeight - frame.getHeight()) > 1) {
                    frame.setSize(newWidth, newHeight);
                }
            }
        });
    }
}
