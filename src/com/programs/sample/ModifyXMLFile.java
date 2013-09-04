package com.programs.sample;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//Source http://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser
public class ModifyXMLFile {
	public static void main(String arg[]){
		File xmlFile = new File("src/com/programs/sample/User.xml");
		
		try{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(xmlFile);
			
			doc.getDocumentElement().normalize();
			
			//Reading from an XML File
			System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());
			
			NodeList nodes = doc.getElementsByTagName("employee");
			
			for(int temp = 0; temp < nodes.getLength(); temp++){
				Node node = nodes.item(temp);
				Element el = (Element)node;
				
				System.out.println("Emp id: " + el.getAttribute("id") );
				System.out.println("Name: "+ el.getElementsByTagName("name").item(0).getTextContent());
				System.out.println("Dept: "+ el.getElementsByTagName("department").item(0).getTextContent());
				System.out.println("Skills: "+ el.getElementsByTagName("skills").item(0).getTextContent());
				System.out.println("Exp: "+ el.getElementsByTagName("experience").item(0).getTextContent());
				System.out.println(); System.out.println();System.out.println();
			}
			
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
