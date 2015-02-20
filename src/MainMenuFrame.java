/**
 * Labs 1011-011
 * Purpose:
 *
 * @author wesolowskitj
 * @version 1.0 Created on 2/4/2015 at 6:48 PM
 */
import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.util.Iterator;

public class MainMenuFrame {
    private JFrame mainMenu = new JFrame();
    private JLabel welcome;
    private JMenuBar mb = new JMenuBar();
    public void configureFrame(){
        welcome = new JLabel("Welcome to a basic JFrame example!!",0);
        mainMenu.add(welcome);
        mainMenu.setJMenuBar(mb);
        mainMenu.setSize(800, 600);
        mainMenu.show();
    }
    public void addParentMenu(String menuName){
        JMenu menuItem = new JMenu(menuName);
        mb.add(menuItem);
        mainMenu.show();

    }
    public void addSubMenu(String itemName, String parentMenu){
        JMenuItem subMenuItem = new JMenuItem(itemName);
        for(int i = 0; i<mb.getMenuCount(); i++){
            if(mb.getMenu(i).getText().equals(parentMenu)){
                mb.getMenu(i).add(subMenuItem);
                mainMenu.show();
            }
        }


    }
    public MainMenuFrame(){
        configureFrame();
    };
}
