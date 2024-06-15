/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menu;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/*
 * @name 약수터
 * @author 천지창조
 */

public class WS extends JFrame {

    Vector data = new Vector<>();
    Vector columnNames = new Vector<>();
    File ws = new File("ws\\ws.txt"); // 약수터 데이터 텍스트 파일 
    File wsout = new File("ws\\wsout.txt"); // 수정된 데이터 파일
    BufferedWriter wsWriter = new BufferedWriter(new FileWriter("ws\\ws.txt", true));//원래 파일에 쓰기
    BufferedWriter wsWriterr = new BufferedWriter(new FileWriter("ws\\wsout.txt", true));//수정 파일 쓰기
    BufferedReader wsReader = new BufferedReader(new FileReader("ws\\ws.txt"));//원래 파일 읽기
    Scanner wsScan = new Scanner(new FileReader(new File("ws\\ws.txt"))); //원래 파일 스캔
    Scanner wsScann = new Scanner(new FileReader(new File("ws\\wsout.txt"))); //수정 파일 스캔

    JTable ta;
    Container find = getContentPane();

    public WS(JFrame frame, String title) throws FileNotFoundException, ParserConfigurationException, SAXException, IOException {

        JPanel panel = new JPanel();
        columnNames.add("분기");
        columnNames.add("측정년도");
        columnNames.add("측정지역");
        columnNames.add("측정지점");
        columnNames.add("총대장균군");
        columnNames.add("대장균");
        columnNames.add("측정결과");

        while (wsScan.hasNext()) { //파일 JTable 삽입
            Vector sRow = new Vector<>();
            String s = wsScan.nextLine();
            String[] input = s.split("/");
            for (int y = 0; y < input.length; y++) {
                sRow.add(input[y]);
            }
            data.add(sRow);
        }

        find.setLayout(null);
        setSize(860, 720);
        find.setBackground(Color.WHITE);

        JLabel jlabel1 = new JLabel("약수터 수질 검사 확인");
        JLabel jlabel2 = new JLabel("약수터 검색 : ");
        JTextField jtext = new JTextField();
        JButton jbutt = new JButton("검색");

        Font font1 = new Font("나눔고딕", Font.BOLD, 20);
        jlabel1.setForeground(Color.darkGray);
        jlabel1.setFont(font1);
        jlabel1.setLocation(17, 5);
        jlabel1.setSize(400, 40);
        Font font2 = new Font("0", Font.BOLD, 14);
        jlabel2.setFont(font2);
        jlabel2.setLocation(17, 60);
        jlabel2.setSize(100, 40);
        jtext.setBounds(120, 72, 507, 22);
        jbutt.setLocation(637, 68);
        jbutt.setSize(60, 30);

        find.add(jlabel1);
        find.add(jlabel2);
        find.add(jtext);
        find.add(jbutt);

        //테이블 모델
        DefaultTableModel dtm = new DefaultTableModel(data, columnNames);

        //테이블 생성
        ta = new JTable(dtm) {
            @Override
            public boolean isCellEditable(int rowl, int column) {
                return false; //JTable 수정 불가
            }
        };

        ta.getTableHeader().setReorderingAllowed(false); //헤더 이동 불가
        ta.getTableHeader().setReorderingAllowed(false); // 컬럼들 이동 불가
        ta.getTableHeader().setResizingAllowed(false); // 컬럼 크기 변경 불가 
        panel.setLayout(new BorderLayout());
        panel.setSize(680, 550);
        panel.setLocation(17, 110);
        panel.add(new JScrollPane(ta));
        panel.setEnabled(false);
        panel.setRequestFocusEnabled(false);
        find.add(panel);
        ta.setAutoCreateRowSorter(true);
        TableRowSorter sorter = new TableRowSorter(ta.getModel());
        ta.setRowSorter(sorter);

        //검색 버튼 이벤트
        jbutt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TableRowSorter<TableModel> sorter1 = new TableRowSorter<TableModel>(((DefaultTableModel) ta.getModel()));
                sorter1.setRowFilter(RowFilter.regexFilter(jtext.getText()));
                ta.setRowSorter(sorter1);
            }
        });

        //삭제
        JButton Delete = new JButton("삭제");
        Delete.setSize(100, 30);
        Delete.setLocation(720, 200);
        find.add(Delete);

        Delete.addActionListener(new ActionListener() { // 삭제 버튼 누르면
            public void actionPerformed(ActionEvent e) {

                int index = ta.getSelectedRow(); // 선택 행 인덱스 가져온다. 
                DefaultTableModel model = (DefaultTableModel) ta.getModel();
                model.removeRow(index);

                String str = "";
                String dummy = "";
                int i = 0;
                try {

                    BufferedWriter wsWriterr = new BufferedWriter(new FileWriter("ws\\wsout.txt", true));
                    BufferedReader wsReader = new BufferedReader(new FileReader("ws\\ws.txt"));

                    while ((str = wsReader.readLine()) != null) {
                        if (i == index) {
                            wsWriterr.append(""); // 오류 확인 용
                            wsWriterr.flush();
                            dummy += ("");
                            i++;
                        } else {
                            wsWriterr.append(str + "\n"); // 오류 확인 용
                            wsWriterr.flush();
                            dummy += (str + "\r\n");
                            i++;
                        }

                    }
                    if (jtext != null) {
                        jtext.setText("");
                    }

                    FileWriter fw = new FileWriter(ws);
                    fw.write(dummy);

                    fw.close();
                    wsReader.close();
                    wsWriterr.close();

                } catch (IOException ex) {
                    Logger.getLogger(WS.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        //수정
        JButton Modifi = new JButton("수정");
        Modifi.setSize(100, 30);
        Modifi.setLocation(720, 155);
        find.add(Modifi);
        JTextField modiText = new JTextField();
        modiText.setBounds(720, 110, 100, 22);
        find.add(modiText);

        Modifi.addActionListener(new ActionListener() { // 수정 버튼 누르면
            public void actionPerformed(ActionEvent e) {

                int index = ta.getSelectedRow(); // 선택 행 인덱스 가져온다. 

                Vector sRow = new Vector<>();
                String s = modiText.getText();
                String[] input = s.split("/");

                for (int p = 0; p < 7; p++) {
                    dtm.setValueAt(input[p], index, p);
                }

                String str = "";
                String dummy = "";
                int i = 0;
                try {

                    BufferedWriter wsWriterr = new BufferedWriter(new FileWriter("ws\\wsout.txt", true));
                    BufferedReader wsReader = new BufferedReader(new FileReader("ws\\ws.txt"));

                    while ((str = wsReader.readLine()) != null) {
                        if (i == index) {
                            wsWriterr.append(s + "\n"); // 오류 확인 용
                            wsWriterr.flush();
                            dummy += (s + "\r\n");
                            i++;
                        } else {
                            wsWriterr.append(str + "\n"); // 오류 확인 용
                            wsWriterr.flush();
                            dummy += (str + "\r\n");
                            i++;
                        }

                    }
                    if (modiText != null) {
                        modiText.setText("");
                    }

                    FileWriter fw = new FileWriter(ws);
                    fw.write(dummy);

                    fw.close();
                    wsReader.close();
                    wsWriterr.close();

                } catch (IOException ex) {
                    Logger.getLogger(WS.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        //삽입
        JButton insert = new JButton("삽입");
        insert.setSize(100, 30);
        insert.setLocation(720, 245);
        find.add(insert);

        insert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Vector sRow = new Vector<>();
                String s = modiText.getText();
                String[] input = s.split("/");
                for (int y = 0; y < input.length; y++) {
                    sRow.add(input[y]);
                }
                data.add(sRow);

                if (modiText != null) {
                    try {
                        wsWriter.append(s + "\n");
                        wsWriter.flush();
                    } catch (IOException io) {
                        io.printStackTrace();
                    }
                    if (modiText != null) {
                        modiText.setText("");
                    }
                }

            }
        });

    }
}
