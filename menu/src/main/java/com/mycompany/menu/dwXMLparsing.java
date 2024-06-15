/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menu;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author sogo0
 */
public class dwXMLparsing {
    public static String getTagValue(String tag, Element eElement) {
        String result = "";
        NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
        result = nlList.item(0).getTextContent();
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
    
    public dwXMLparsing(JFrame frame, String title) throws FileNotFoundException, IOException {
        String key = "p6hJ4G2EQTBiPROm2a34/B78odVpWd45ZVTjOV7QQP8O5bBdeLFYOlYESg7IBC3pq3vaYdG2E0IJccxsRwXSjA==";
        String key2 = "p6hJ4G2EQTBiPROm2a34/B78odVpWd45ZVTjOV7QQP8O5bBdeLFYOlYESg7IBC3pq3vaYdG2E0IJccxsRwXSjA==";
        int page=0;     
        try{
          
            String value;
            int i=0;
            int a = 2020;
            String[] b = {"01","02"};
            String[] c = {"01","02","03","04"};
            for(i=0;i<5;i++){
                for(int z=0;z<b.length;z++){
                    String url = "http://apis.data.go.kr/1480523/Dwqualityservice/getDrinkWaterORGWATR?serviceKey="+key+"&pageNo="+i+"&search_year="+a+"&search_ht="+b[z];
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.parse("xml_1\\DW.xml");
                    doc.getDocumentElement().normalize();
                    Element root = doc.getDocumentElement();
                   // System.out.println(root.getNodeName());
                   
                   
                    NodeList nList = doc.getElementsByTagName("item");
                    for (int temp = 0; temp < nList.getLength(); temp++) {
                        Node nNode = nList.item(temp);
                        if(nNode.getNodeType()==Node.ELEMENT_NODE){
                        Element eElement = (Element) nNode;
                        System.out.println(temp);            
                        
                    
                        /*System.out.println("반기 : " + getTagValue("ht", eElement));
                        System.out.println("연도 : " + getTagValue("mgc", eElement));
                        System.out.println("업체명 : " + getTagValue("entrpsNm", eElement));
                        System.out.println("호정명 : " + getTagValue("wellNm", eElement));                        
                        System.out.println("검사여부 : " + getTagValue("chckAt", eElement));
                        System.out.println("검사년도 : " + getTagValue("year", eElement));
                        System.out.println("채수일자 : " + getTagValue("wtrsmpleDe", eElement));
                        System.out.println("일반세균(저온) 적합여부 : " + getTagValue("pcbacStbltAt", eElement));
                        System.out.println("일반세균(중온) 적합여부 : " + getTagValue("msbacStbltAt", eElement));
                        System.out.println("총대장균군 적합여부 : " + getTagValue("tcoliStbltAt", eElement));
                        System.out.println("살모넬라 적합여부 : " + getTagValue("smnlaStbltAt", eElement));
                        System.out.println("불소 적합여부 : " + getTagValue("flrnStbltAt", eElement));
                        System.out.println("비소 적합여부 : " + getTagValue("asStbltAt", eElement));
                        System.out.println("셀레늄 적합여부 : " + getTagValue("slnumStbltAt", eElement));
                        System.out.println("수은 적합여부 : " + getTagValue("mrcStbltAt", eElement));
                        System.out.println("암모니아성 질소 적합여부 : " + getTagValue("nh4nStbltAt", eElement));
                        System.out.println("질산성 질소 적합여부 : " + getTagValue("no3nStbltAt", eElement));
                        System.out.println("카드뮴 적합여부 : " + getTagValue("cdmmStbltAt", eElement));
                        System.out.println("페놀 적합여부 : " + getTagValue("phnlStbltAt", eElement));
                        System.out.println("벤젠 적합여부 : " + getTagValue("c6h6StbltAt", eElement));
                        System.out.println("냄새 적합여부 : " + getTagValue("smellStbltAt", eElement));
                        System.out.println("동 적합여부 : " + getTagValue("copprStbltAt", eElement));
                        System.out.println("세제 적합여부 : " + getTagValue("anosurStbltAt", eElement));
                        System.out.println("수소이온농도 적합여부 : " + getTagValue("phStbltAt", eElement));
                        System.out.println("아연 적합여부 : " + getTagValue("zincStbltAt", eElement));
                        System.out.println("염소이온 적합여부 : " + getTagValue("chloionStbltAt", eElement));
                        System.out.println("탁도 적합여부 : " + getTagValue("turStbltAt", eElement));
                        System.out.println("황산이온 적합여부 : " + getTagValue("slftionStbltAt", eElement));
                        System.out.println("알루미늄 적합여부 : " + getTagValue("almnmStbltAt", eElement));
                        */



                        } 
          
           }
        }
               
    }}catch(Exception e) {e.printStackTrace();} 
        
         try{
            int i=0;
            int a = 2020;
            String[] c = {"01","02","03","04"};
            for(i=0;i<5;i++){
                for(int z=0;z<c.length;z++){
                    //String url = "http://apis.data.go.kr/1480523/Dwqualityservice/getDrinkWaterTKAWY?serviceKey="+key2+"&pageNo="+i+"&search_year="+a+"&search_qu="+c[z];
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.parse("xml_1\\DWTK.xml");
                    doc.getDocumentElement().normalize();
                    Element root = doc.getDocumentElement();
                    //System.out.println(root.getNodeName());
                    NodeList nList = doc.getElementsByTagName("item");
                    for (int temp = 0; temp < nList.getLength(); temp++) {
                        Node nNode = nList.item(temp);
                        if(nNode.getNodeType()==Node.ELEMENT_NODE){
                        Element eElement = (Element) nNode;
                        System.out.println(temp);
                        
                        //NodeList dataTime = fstElmnt.getElementsByTagName("dataTime");
                        //dataTime.item(0).getChildNodes().item(0).getNodeValue()

                    NodeList nList2 = doc.getElementsByTagName("qu");        
                    Node nNode2 = nList.item(temp);
                   

                        
                        //System.out.println("분기 : " + zs);
                        /*System.out.println("분기 : " + getTagValue("qu", eElement));
                        System.out.println("관리기간명 : " + getTagValue("mgc", eElement));
                        System.out.println("업체명 : " + getTagValue("entrpsNm", eElement));
                        System.out.println("제품명 : " + getTagValue("prductNm", eElement));
                        System.out.println("검사기관 : " + getTagValue("chckInstt", eElement));
                        System.out.println("검사여부 : " + getTagValue("chckAt", eElement));
                        System.out.println("검사결과 년도 : " + getTagValue("year", eElement));
                        System.out.println("검사일자 : " + getTagValue("chckDe", eElement));
                        System.out.println("수거일자 : " + getTagValue("tkawyDe", eElement));
                        System.out.println("일반세균(저온) 적합여부 : " + getTagValue("pcbacStbltAt", eElement));
                        System.out.println("일반세균(중온) 적합여부 : " + getTagValue("msbacStbltAt", eElement));
                        System.out.println("총대장균군 적합여부 : " + getTagValue("tcoliStbltAt", eElement));
                        System.out.println("분원성연쇄상구균 적합여부 : " + getTagValue("fcstrStbltAt", eElement));
                        System.out.println("녹농균 적합여부 : " + getTagValue("psaerStbltAt", eElement));
                        System.out.println("살모넬라 적합여부 : " + getTagValue("smnlaStbltAt", eElement));
                        System.out.println("납 적합여부 : " + getTagValue("pbStbltAt", eElement));
                        System.out.println("불소 적합여부 : " + getTagValue("flrnStbltAt", eElement));
                        System.out.println("비소 적합여부 : " + getTagValue("asStbltAt", eElement));
                        System.out.println("셀레늄 적합여부 : " + getTagValue("slnumStbltAt", eElement));
                        System.out.println("수은 적합여부 : " + getTagValue("mrcStbltAt", eElement));
                        System.out.println("시안 적합여부 : " + getTagValue("cynStbltAt", eElement));
                        System.out.println("크롬 적합여부 : " + getTagValue("crStbltAt", eElement));
                        System.out.println("질산성 질소 적합여부 : " + getTagValue("nh4nStbltAt", eElement));
                        System.out.println("카드뮴 적합여부 : " + getTagValue("cdmmStbltAt", eElement));
                        System.out.println("페놀 적합여부 : " + getTagValue("phnlStbltAt", eElement));
                        System.out.println("벤젠 적합여부 : " + getTagValue("c6h6StbltAt", eElement));
                        System.out.println("크실렌 적합여부 : " + getTagValue("zylnStbltAt", eElement));
                        System.out.println("사염화탄소 적합여부 : " + getTagValue("cbttcStbltAt", eElement));
                        System.out.println("경도 적합여부 : " + getTagValue("hdnswatStbltAt", eElement));
                        System.out.println("냄새 적합여부 : " + getTagValue("smellStbltAt", eElement));
                        System.out.println("동 적합여부 : " + getTagValue("copprStbltAt", eElement));
                        System.out.println("색도 적합여부 : " + getTagValue("chmaStbltAt", eElement));
                        System.out.println("세제 적합여부 : " + getTagValue("anosurStbltAt", eElement));
                        System.out.println("수소이온농도 적합여부 : " + getTagValue("phStbltAt", eElement));
                        System.out.println("아연 적합여부 : " + getTagValue("zincStbltAt", eElement));
                        System.out.println("염소이온 적합여부 : " + getTagValue("chloionStbltAt", eElement));
                        System.out.println("철 적합여부 : " + getTagValue("seasnStbltAt", eElement));
                        System.out.println("망간 적합여부 : " + getTagValue("mangStbltAt", eElement));
                        System.out.println("탁도 적합여부 : " + getTagValue("turStbltAt", eElement));
                        System.out.println("황산이온 적합여부 : " + getTagValue("slftionStbltAt", eElement));
                        System.out.println("알루미늄 적합여부 : " + getTagValue("almnmStbltAt", eElement));*/
                        }
                
                    }
                }}}
            catch(Exception e) {e.printStackTrace();}
    }
}
