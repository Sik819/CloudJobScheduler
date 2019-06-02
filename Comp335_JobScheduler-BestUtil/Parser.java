import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parser {
	
	//store server from XML
	ArrayList<ServerFromXML> xmlServers = new ArrayList();

    public Parser() throws ParserConfigurationException, SAXException, IOException {
    	this.parse();
    }

    public void parse() throws ParserConfigurationException,
            SAXException, IOException {


        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Load the input XML document, parse it and return an instance of the
        // Document class.
        Document document = builder.parse(new File("system.xml"));


        NodeList systems = document.getElementsByTagName("system");
        for (int i = 0; i < systems.getLength(); i++) {
            NodeList servers= ((Element)systems.item(i)).getElementsByTagName("servers");
            NodeList ho= ((Element)systems.item(i)).getElementsByTagName("server");
            for(int  j = 0 ; j < ho.getLength(); j++) {
                Element server = (Element) ho.item(j);
                String type = server.getAttribute("type");
                String limit = server.getAttribute("limit");
                String bootupTime = server.getAttribute("bootupTime");
                String rate = server.getAttribute("rate");
                String coreCount = server.getAttribute("coreCount");
                String memory = server.getAttribute("memory");
                String disk = server.getAttribute("disk");
                String[] temp = {type, limit, bootupTime, rate, coreCount, memory, disk};
                ServerFromXML tempServer = new ServerFromXML(temp);
                xmlServers.add(tempServer);
                
                //System.out.println(" Server Type: " + type + " Limit: " + limit + " BootupTime: " + bootupTime + " rate: " + rate + " CoreCount: "+ coreCount + " Memory: "+ memory + " Disk: " + disk );
            }
        }
    }
//    public static void main (String[] args) throws IOException, ParserConfigurationException, SAXException {
//    	Parser p = new Parser();
//    	System.out.println(p);
//    	
//        File file = new File("system.xml");  
//        if (file.createNewFile()) {  
//            System.out.println("New File is created!");  
//        } else {  
//            System.out.println("File already exists.");  
//        }  
//    }
}