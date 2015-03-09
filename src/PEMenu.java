import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import com.sun.xml.internal.ws.util.xml.NodeListIterator;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

/**
 * Labs 1011-011
 * Purpose:
 *
 * @author wesolowskitj
 * @version 1.0 Created on 2/18/2015 at 11:51 PM
 */
public class PEMenu {
    //change xmlPath based on compilation for production or development
    //production: "programlist.xml"
    //development: "src\\programlist.xml"
    private static final String xmlPath = "Programs\\programlist.xml";
    
    public static PEMenuFrame readXML(){
        PEMenuFrame menu = new PEMenuFrame();
        String parentMenu;
        String subMenu;
        String filePath;

        try {
            File test = new File(xmlPath);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbFactory.newDocumentBuilder();
            Document doc = builder.parse(test);

            doc.getDocumentElement().normalize();

            NodeList progGroups = doc.getElementsByTagName("programGroup");
            for (int i=0; i<progGroups.getLength(); i++) {
                Node groupNode = progGroups.item(i);

                //System.out.println("\nCurrent Element :" + groupNode.getNodeName());
                Element currentElement = (Element) groupNode;
                parentMenu = currentElement.getAttribute("id");
                menu.addParentMenu(parentMenu);

                NodeList programs = currentElement.getElementsByTagName("program");
                for (int j = 0; j < programs.getLength(); j++) {
                    Element progElem = (Element) programs.item(j);
                    subMenu = progElem.getElementsByTagName("name").item(0).getTextContent();
                    filePath = progElem.getElementsByTagName("path").item(0).getTextContent();
                    menu.addSubMenu(subMenu, parentMenu);
                    menu.addMenuAction(menu.getSubMenu(subMenu, menu.getParentMenu(parentMenu)), filePath);

                }
            }
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return menu;
    }
    public static void main(String[] args) {
        PEMenuFrame mainMenuFrame = readXML();

    }
}
