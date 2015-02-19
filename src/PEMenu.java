import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
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
    public static void main(String[] args) {
        try {
            File test = new File("C:/Users/Wojo/Desktop/Sandwich.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbFactory.newDocumentBuilder();
            Document doc = builder.parse(test);

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("sandwich");

            Node currentNode = nodeList.item(0);

            Element element = (Element) currentNode;

            System.out.println(element.getElementsByTagName("meat").item(0).getTextContent());
            System.out.println(element.getElementsByTagName("bread").item(0).getTextContent());

        }
        catch (Exception e){

        }
    }
}
