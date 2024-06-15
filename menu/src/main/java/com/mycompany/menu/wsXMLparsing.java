/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menu;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author sogo0
 */
public class wsXMLparsing {
     public static String getTagValue(String tag, Element eElement) {
        String result = "";
        for (int i=0; i< eElement.getElementsByTagName(tag).getLength(); i++ ) {
        NodeList nlList = eElement.getElementsByTagName(tag).item(i).getChildNodes();
        result = nlList.item(i).getTextContent();
        }
        return result;
        }
        
        public static String getTagValue(String tag, String childTag, Element eElement) {
        String result = "";
        NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
        for(int i = 0; i< eElement.getElementsByTagName(childTag).getLength(); i++) {
            result += nlList.item(i).getChildNodes().item(0).getTextContent() + " ";
        }
        return result;
    }
 public wsXMLparsing(JFrame frame, String title) throws FileNotFoundException, ParserConfigurationException, SAXException, IOException{
    try{
        int page=0;
        for(int i=0; i < 1; i++) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("xml_1\\data1.xml");
                        
            doc.getDocumentElement().normalize();
            Element root = doc.getDocumentElement(); // root 요소 가져오기
            //System.out.println(root.getNodeName()); // root 요소 확인
            NodeList nList = doc.getElementsByTagName("item");
           
                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp); // temp 배열 0~item 길이까지 차례로 받는거
                    if(nNode.getNodeType()==Node.ELEMENT_NODE){ // 해당 노드의 종류로 판정
                        Element eElement = (Element) nNode;
                        
                      
                           }
            }}} catch (Exception e) {e.printStackTrace();}}}
      