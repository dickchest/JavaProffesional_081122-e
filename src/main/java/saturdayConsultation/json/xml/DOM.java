package saturdayConsultation.json.xml;
// обрабатывает весь документ сразу

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOM {
    static void print(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i) instanceof Element) {
                System.out.println(((Element) nodeList.item(i)).getTagName());
                if (nodeList.item(i).hasChildNodes()) {
                    print(nodeList.item(i).getChildNodes());
                }
            }
        }
    }

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File("src\\main\\java\\saturdayConsultation\\json\\xml\\1.xml"));
        Element element = document.getDocumentElement();

        System.out.println(element.getTagName());

        NodeList nodeList = element.getChildNodes();
        print(nodeList);


    }
}
