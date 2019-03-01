import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.Border;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Robot;

public class Desktop_Prank extends JFrame
{
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private JLabel backpic;
    private BufferedImage img;
    
    public Desktop_Prank(){
        try
        {
            img = ImageIO.read(new File("Screenshot.jpg"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        ImageIcon imageIcon = new ImageIcon(img);
        backpic = new JLabel("",SwingConstants.CENTER);
        backpic.setIcon(imageIcon);
        backpic.setBounds(0,0,screenSize.width,screenSize.height);
        
        Container Fullscreen = getContentPane();
        Fullscreen.setLayout(null);
        Fullscreen.add(backpic);
        
        this.setIconImage(new ImageIcon(getClass().getResource("Deskicon.png")).getImage());
        
        setSize(screenSize.width,screenSize.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    public static void main(String args[]){
        try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException ex)
                {
                
                }      
        try{
            getScreenshot(0);
        }catch(Exception e){
            
        }
        int framenum = 400;
        
        Desktop_Prank go = new Desktop_Prank();
        JFrame gos[] = new JFrame[framenum - 1];
        for(int x = 0; x < framenum-1; x++){
            gos[x] = new Desktop_Prank();
        }
    }
    public static BufferedImage resize(BufferedImage image, int width, int height) 
    {
         BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
         Graphics2D g2d = (Graphics2D) bi.createGraphics();
         g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
         g2d.drawImage(image, 0, 0, width, height, null);
         g2d.dispose();
         return bi;
    }
    public static void getScreenshot(int timeToWait) throws Exception {
        Rectangle rec = new Rectangle(
          Toolkit.getDefaultToolkit().getScreenSize());
        Robot robot = new Robot();
        BufferedImage image = robot.createScreenCapture(rec);
        File file = new File("Screenshot.jpg");
        ImageIO.write(image, "jpg", file);
    }
}
