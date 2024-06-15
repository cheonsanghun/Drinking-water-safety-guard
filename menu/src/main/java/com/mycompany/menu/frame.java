/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menu;

import java.awt.*; // 그래픽 처리를 위한 클래스들의 경로명
import java.awt.event.*; // AWT 이벤트 사용을 위한 경로명
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*; // 스윙 컴포넌트 클래스들의 경로명
import javax.swing.event.*; // 스윙 이벤트
import javax.swing.ImageIcon;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author 천지창조
 */
public class frame extends JFrame {
    frame() throws FileNotFoundException, ParserConfigurationException, IOException, SAXException{
        setTitle("먹는 물 안전 지킴이");
        setSize(980,780);
        Container c = getContentPane();
        c.setLayout(null);
        
        //큰 제목
        JLabel BigTitle = new JLabel("먹는 물 안전 지킴이");
        Font font = new Font("나눔고딕",Font.BOLD,40);
        BigTitle.setFont(font);
        BigTitle.setLocation(315,50);
        BigTitle.setSize(400,100);
        c.add(BigTitle);
        
        //버전 및 수정일
        JLabel la = new JLabel ("ver.0.0.1 / 마지막 수정일 : 2022-12-06");
        la.setLocation(715,720);
        la.setSize(300,20);
        c.add(la);
        c.setBackground(Color.WHITE);
        
        //메인 이미지
        ImageIcon image = new ImageIcon("src/waterflow_640.jpg");
        JLabel imageLabel = new JLabel(image);
        imageLabel.setLocation(170,50);
        imageLabel.setSize(640,640);
        c.add(imageLabel);
        
        
        //버튼 생성 및 버튼 이벤트
        JButton a = new JButton("생수");
        a.setLocation(170,600);
        a.setSize(290,50);
        
        JButton b = new JButton("약수터");
        b.setLocation(520, 600);
        b.setSize(290,50);
        
        c.add(a);
        c.add(b);
        
        //생수 모달.
        DW dw =  new DW(this, "생수");
        a.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dw.setVisible(true);
        }
        });
        
        //약수터 모달.
        WS ws = new WS(this,"약수터");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ws.setVisible(true);
            }
        });
    
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}