/**
 * Labs 1011-011
 * Purpose:
 *
 * @author wesolowskitj
 * @version 1.0 Created on 2/4/2015 at 6:48 PM
 */
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Iterator;

public class PEMenuFrame {
    private JFrame mainMenu = new JFrame();
    private JLabel welcome;
    private JMenuBar mb = new JMenuBar();

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
    public void addMenuAction(JMenu menuItem){
        MenuListener listener = new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                System.out.println("Selected");
            }

            @Override
            public void menuDeselected(MenuEvent e) {
                System.out.println("De-selected");
            }

            @Override
            public void menuCanceled(MenuEvent e) {
                System.out.println("Cancelled");
            }
        };
        menuItem.addMenuListener(listener);
        mainMenu.show();
    }
    public void addMenuAction(JMenuItem menuItem, final String filePath){
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Test");
                try {
                    Process proc = Runtime.getRuntime().exec(filePath);
                }
                catch(IOException ex){
                    JOptionPane.showMessageDialog(mainMenu,e.paramString() + " Could not load executable.");
                }
            }
        });
    }
    public JMenu getParentMenu(String menuName){
        for(int i=0; i<mb.getMenuCount(); i++) {
            if(mb.getMenu(i).getText().equals(menuName)){
                return mb.getMenu(i);
            }
        }
        return null;
    }
    public JMenuItem getSubMenu(String itemName, JMenu parentMenu){
        boolean found = false;
        int i = 0;
        JMenuItem item = null;
        while(!found){
            if(parentMenu.getItem(i).getText().equals(itemName)){
                found = true;
                item = parentMenu.getItem(i);
            }
            i++;
        }
        return item;
    }
    public PEMenuFrame(){
        welcome = new JLabel("Welcome to a basic JFrame example!!",0);
        mainMenu.add(welcome);
        mainMenu.setJMenuBar(mb);
        mainMenu.setSize(800, 600);
        mainMenu.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        mainMenu.show();
    };
}
