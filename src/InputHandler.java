import java.awt.Component;
import java.awt.event.*;

/**
 * InputHandler.java
 *
 *
 *
 * @author Brandon Nguyen
 *         Github @ lrbn
 *         Email: lrbn86@gmail.com
 *
 * @version January 07, 2017
 *
 */
public class InputHandler implements KeyListener {

    boolean[] keys;

    /**
     *  Assigns the newly created InputHandler to a Component
     *
     * @param c Component to get input from
     */
    public InputHandler(Component c) {
        c.addKeyListener(this);
        keys = new boolean [256];
    }

    /**
     *  Checks whether a specific key is down
     *
     * @param keyCode The key to check
     * @return Whether the key is pressed or not
     */
    public boolean isKeyDown(int keyCode) {

        if (keyCode > 0 && keyCode < 256) {
            return keys[keyCode];
        }

        return false;
    }

    /**
     *  Called when a key is pressed while the component is focused
     *
     * @param e KeyEvent sent by the component
     */
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() > 0 && e.getKeyCode() < 256) {
            keys[e.getKeyCode()] = true;
        }

    }

    /**
     *  Called when a key is released while the component is focused
     *
     * @param e KeyEvent sent by the component
     */
    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode() > 0 && e.getKeyCode() < 256) {
            keys[e.getKeyCode()] = false;
        }

    }

    /**
     * Not used
     * @param e
     */
    public void keyTyped(KeyEvent e) {}
}