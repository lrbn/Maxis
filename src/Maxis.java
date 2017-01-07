import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 * Maxis.java
 *
 *
 *
 * @author Brandon Nguyen
 *         Github @ lrbn
 *         Email: lrbn86@gmail.com
 *
 * @version January 06, 2017
 *
 */
public class Maxis extends JFrame {

    boolean isRunning = true;
    int fps = 30;
    int windowWidth = 600;
    int windowHeight = 480;

    BufferedImage backBuffer;
    Insets insets;
    InputHandler input;

    int x = 0;

    public static void main(String[] args) {

        Maxis game = new Maxis();
        game.run();
        System.exit(0);

    }

    /**
     *  This method stsarts the game and runs it in a loop
     */
    public void run() {

        initialize();

        while (isRunning) {
            long time = System.currentTimeMillis();

            update();
            draw();

            // delay each frame - time it took for one frame
            time = (1000 / fps) - (System.currentTimeMillis() - time);

            if (time > 0) {

                try {
                    Thread.sleep(time);
                } catch (Exception e) {

                }

            }
        }

        setVisible(false);
    }

    /**
     *  This method will set up everything needed for the game to run
     */
    void initialize() {

        setTitle("Maxis");
        setSize(windowWidth, windowHeight);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        insets = getInsets();
        setSize(insets.left + windowWidth + insets.right, insets.top + windowHeight + insets.bottom);

        backBuffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB);

        input = new InputHandler(this);

    }

    /**
     *  This method will check for input, move things
     *  around and check for win conditions, etc
     */
    void update() {

        if (input.isKeyDown(KeyEvent.VK_RIGHT)) {
            x += 5;
        }

        if (input.isKeyDown(KeyEvent.VK_LEFT)) {
            x -= 5;
        }

    }

    /**
     *  This method will draw everything
     */
    void draw() {
        Graphics g = getGraphics();
        Graphics bbg = backBuffer.getGraphics();

        bbg.setColor(Color.WHITE);
        bbg.fillRect(0, 0, windowWidth, windowHeight);

        bbg.setColor(Color.BLACK);
        bbg.drawOval(x, 10, 20, 20);

        g.drawImage(backBuffer, 0, 0, this);
    }
}