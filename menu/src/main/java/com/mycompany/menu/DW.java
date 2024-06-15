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

/*
 * @name 먹는 샘물 생수
 * @author 천지창조
 */

public class DW extends JFrame {

    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    Vector data1 = new Vector<>();
    Vector data2 = new Vector<>();
    File dw = new File("dw\\dw.txt"); //제조업체 데이터
    File dwout = new File("dw\\dwout.txt");
    File dwtk = new File("dwtk\\dwtk.txt"); //유통업체 데이터
    File dwtkout = new File("dwtk\\dwtkout.txt");
    BufferedWriter dwWriter = new BufferedWriter(new FileWriter("dw\\dw.txt", true));
    BufferedWriter dwtkWriter = new BufferedWriter(new FileWriter("dwtk\\dwtk.txt", true));
    BufferedWriter dwoutWriter = new BufferedWriter(new FileWriter("dw\\dwout.txt", true));
    BufferedWriter dwtkoutWriter = new BufferedWriter(new FileWriter("dwtk\\dwtkout.txt", true));
    BufferedReader dwReader = new BufferedReader(new FileReader("dw\\dw.txt"));
    BufferedReader dwtkReader = new BufferedReader(new FileReader("dwtk\\dwtk.txt"));
    Scanner dwScan = new Scanner(new FileReader(new File("dw\\dw.txt")));
    Scanner dwtkScan = new Scanner(new FileReader(new File("dwtk\\dwtk.txt")));

    Container find = getContentPane();
    JTable ta;
    JTable ta2;

    public DW(JFrame frame, String title) throws FileNotFoundException, IOException {

        //제조업체 columnNames
        Vector columnNames1 = new Vector<>();
        columnNames1.add("분기");
        columnNames1.add("연도");
        columnNames1.add("제조업체");
        columnNames1.add("일반세균적합");
        columnNames1.add("총대장균군적합");
        columnNames1.add("녹농균적합");
        columnNames1.add("살모넬라적합");
        columnNames1.add("수은적합");
        columnNames1.add("염소이온적합");

        while (dwScan.hasNext()) { // 제조업체 테이블 삽입
            Vector sRow = new Vector<>();
            String s = dwScan.nextLine();
            String[] input = s.split("/");
            for (int y = 0; y < input.length; y++) {
                sRow.add(input[y]);
            }
            data1.add(sRow);
        }

        //유통업체 columnNames            
        Vector columnNames2 = new Vector<>();
        columnNames2.add("분기");
        columnNames2.add("유통업체");
        columnNames2.add("제품명");
        columnNames2.add("일반세균적합");
        columnNames2.add("총대장균군적합");
        columnNames2.add("녹농균적합");
        columnNames2.add("살모넬라적합");
        columnNames2.add("수은");
        columnNames2.add("염소이온적합");

        while (dwtkScan.hasNext()) { // 유통업체 테이블 삽입
            Vector sRow = new Vector<>();
            String s = dwtkScan.nextLine();
            String[] input = s.split("/");
            for (int y = 0; y < input.length; y++) {
                sRow.add(input[y]);
            }
            data2.add(sRow);
        }

        //생수 프레임
        find.setSize(880, 720);
        find.setLayout(null);
        setSize(880, 720);
        find.setBackground(Color.WHITE);

        //제조업체 검색 필드
        JLabel jlabel1 = new JLabel("먹는 샘물 수질 검사 확인");
        JLabel jlabel2 = new JLabel("제조업체 검색 : ");
        JTextField jtext1 = new JTextField(); //제조업체 택스트필드
        JButton jbutt1 = new JButton("검색");
        JTextField modiDWtext = new JTextField(); //수정,삽입 텍스트 필드

        //유통업체 검색 필드
        JLabel jlabel3 = new JLabel("유통업체 검색 : ");
        JTextField jtext2 = new JTextField(); //유통업체 택스트필드
        JButton jbutt2 = new JButton("검색");
        JTextField modiDWTKtext = new JTextField();

        Font font1 = new Font("나눔고딕", Font.BOLD, 20);
        jlabel1.setForeground(Color.darkGray);
        jlabel1.setFont(font1);
        jlabel1.setLocation(17, 5);
        jlabel1.setSize(300, 40);
        Font font2 = new Font("0", Font.BOLD, 14);
        jlabel2.setFont(font2);
        jlabel2.setLocation(17, 60);
        jlabel2.setSize(170, 40);
        jtext1.setBounds(130, 72, 500, 22);
        jbutt1.setLocation(657, 68);
        jbutt1.setSize(60, 30);

        jlabel3.setFont(font2);
        jlabel3.setLocation(17, 350);
        jlabel3.setSize(170, 40);
        jtext2.setBounds(130, 360, 500, 22);
        jbutt2.setLocation(657, 360);
        jbutt2.setSize(60, 30);

        //3. 라디오 버튼, 텍스트 및 라벨 생성*/
        find.add(jlabel1);
        find.add(jlabel2);
        find.add(jtext1); //제조업체 텍스트필드
        find.add(jbutt1);
        find.add(jtext2);
        find.add(jbutt2);
        find.add(jlabel3);

        //제조업체 테이블
        DefaultTableModel dtm1 = new DefaultTableModel(data1, columnNames1);
        ta = new JTable(dtm1) {
            @Override
            public boolean isCellEditable(int rowl, int column) {
                return false;
            }
        };
        ta.getTableHeader().setReorderingAllowed(false); //헤더 이동 불가
        ta.getTableHeader().setReorderingAllowed(false); // 컬럼들 이동 불가
        ta.getTableHeader().setResizingAllowed(false); // 컬럼 크기 변경 불가 
        panel.setLayout(new BorderLayout());
        panel.setSize(700, 225);
        panel.setLocation(17, 110);
        panel.add(new JScrollPane(ta));
        find.add(panel);
        ta.setAutoCreateRowSorter(true);
        TableRowSorter sorter1 = new TableRowSorter(ta.getModel());
        ta.setRowSorter(sorter1);

        //유통업체 테이블
        DefaultTableModel dtm2 = new DefaultTableModel(data2, columnNames2);
        ta2 = new JTable(dtm2) {
            @Override
            public boolean isCellEditable(int rowl, int column) {
                return false;
            }
        };
        ta2.getTableHeader().setReorderingAllowed(false); //헤더 이동 불가
        ta2.getTableHeader().setReorderingAllowed(false); // 컬럼들 이동 불가
        ta2.getTableHeader().setResizingAllowed(false); // 컬럼 크기 변경 불가 
        panel1.setLayout(new BorderLayout());
        panel1.setSize(700, 250);
        panel1.setLocation(17, 400);
        panel1.add(new JScrollPane(ta2));
        find.add(panel1);
        ta2.setAutoCreateRowSorter(true);
        TableRowSorter sorter2 = new TableRowSorter(ta2.getModel());
        ta2.setRowSorter(sorter2);

        //제조업체 검색
        jbutt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TableRowSorter<TableModel> sorter1 = new TableRowSorter<TableModel>(((DefaultTableModel) ta.getModel()));
                sorter1.setRowFilter(RowFilter.regexFilter(jtext1.getText()));
                ta.setRowSorter(sorter1);
            }
        });

        //유통업체 검색
        jbutt2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TableRowSorter<TableModel> sorter1 = new TableRowSorter<TableModel>(((DefaultTableModel) ta2.getModel()));
                sorter1.setRowFilter(RowFilter.regexFilter(jtext2.getText()));
                ta2.setRowSorter(sorter1);
            }
        });

        //제조업체 삽입
        JButton insert1 = new JButton("삽입");
        insert1.setSize(100, 30);
        insert1.setLocation(737, 250);
        find.add(insert1);

        insert1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Vector sRow = new Vector<>();
                String s = modiDWtext.getText();
                String[] input = s.split("/");
                for (int y = 0; y < input.length; y++) {
                    sRow.add(input[y]);
                }
                data1.add(sRow);

                if (modiDWtext != null) {
                    try {
                        dwWriter.append(s + "\n");
                        dwWriter.flush();
                    } catch (IOException io) {
                        io.printStackTrace();
                    }
                    if (modiDWtext != null) {
                        modiDWtext.setText("");
                    }
                }

            }
        });

        //제조업체 삭제
        JButton Delete1 = new JButton("삭제");
        Delete1.setSize(100, 30);
        Delete1.setLocation(737, 200);
        find.add(Delete1);

        Delete1.addActionListener(new ActionListener() { // 삭제 버튼 누르면
            public void actionPerformed(ActionEvent e) {

                int index = ta.getSelectedRow(); // 선택 행 인덱스 가져온다. 
                DefaultTableModel model = (DefaultTableModel) ta.getModel();
                model.removeRow(index);

                String str = "";
                String dummy1 = "";
                int i = 0;
                try {
                    BufferedReader dwReader = new BufferedReader(new FileReader("dw\\dw.txt"));
                    BufferedWriter dwoutWriter = new BufferedWriter(new FileWriter("dw\\dwout.txt", true));

                    while ((str = dwReader.readLine()) != null) {
                        if (i == index) {
                            dwoutWriter.append(""); // 오류 발생시 확인용
                            dwoutWriter.flush();
                            dummy1 += ("");
                            i++;
                        } else {
                            dwoutWriter.append(str + "\n"); // 오류 발생시 확인용
                            dwoutWriter.flush();
                            dummy1 += (str + "\r\n");
                            i++;
                        }

                    }

                    FileWriter fw1 = new FileWriter(dw);
                    fw1.write(dummy1);

                    fw1.close();
                    dwReader.close();
                    dwoutWriter.close();

                } catch (IOException ex) {
                    Logger.getLogger(WS.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        //제조업체 수정 및 텍스트필드
        JButton Modifi1 = new JButton("수정");
        Modifi1.setSize(100, 30);
        Modifi1.setLocation(737, 150);
        find.add(Modifi1);

        modiDWtext.setBounds(737, 110, 100, 20);
        find.add(modiDWtext);

        Modifi1.addActionListener(new ActionListener() { // 수정 버튼 누르면
            public void actionPerformed(ActionEvent e) {

                int index = ta.getSelectedRow(); // 선택 행 인덱스 가져온다. 
                
                Vector sRow = new Vector<>();
                String s = modiDWtext.getText();
                String[] input = s.split("/");

                for (int p = 0; p < 9; p++) {
                    dtm1.setValueAt(input[p], index, p);
                }

                String str = "";
                String dummy2 = "";
                int i = 0;
                try {

                    BufferedReader dwReader = new BufferedReader(new FileReader("dw\\dw.txt"));
                    BufferedWriter dwoutWriter = new BufferedWriter(new FileWriter("dw\\dwout.txt", true));

                    while ((str = dwReader.readLine()) != null) {
                        if (i == index) {
                            dwoutWriter.append(s + "\n"); // 오류 발생시 확인용
                            dwoutWriter.flush();
                            dummy2 += (s + "\r\n");
                            i++;
                        } else {
                            dwoutWriter.append(str + "\n"); // 오류 발생시 확인용
                            dwoutWriter.flush();
                            dummy2 += (str + "\r\n");
                            i++;
                        }

                    }
                    if (modiDWtext != null) {
                        modiDWtext.setText("");
                    }

                    FileWriter fw2 = new FileWriter(dw);
                    fw2.write(dummy2);

                    fw2.close();
                    dwReader.close();
                    dwoutWriter.close();

                } catch (IOException ex) {
                    Logger.getLogger(WS.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        //유통업체 삽입
        JButton insert2 = new JButton("삽입");
        insert2.setSize(100, 30);
        insert2.setLocation(737, 540);
        find.add(insert2);

        insert2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Vector sRow = new Vector<>();
                String s = modiDWTKtext.getText();
                String[] input = s.split("/");
                for (int y = 0; y < input.length; y++) {
                    sRow.add(input[y]);
                }
                data2.add(sRow);

                if (modiDWTKtext != null) {
                    try {
                        dwtkWriter.append(s + "\n");
                        dwtkWriter.flush();
                    } catch (IOException io) {
                        io.printStackTrace();
                    }
                    if (modiDWTKtext != null) {
                        modiDWTKtext.setText("");
                    }
                }

            }
        });

        //유통업체 수정 및 텍스트필드
        JButton modiDWTK = new JButton("수정");
        modiDWTK.setSize(100, 30);
        modiDWTK.setLocation(737, 440);
        find.add(modiDWTK);

        modiDWTKtext.setBounds(737, 400, 100, 20);
        find.add(modiDWTKtext);

        modiDWTK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int index = ta2.getSelectedRow(); // 선택 행 인덱스 가져온다. 

                Vector sRow = new Vector<>();
                String s = modiDWTKtext.getText();
                String[] input = s.split("/");

                for (int p = 0; p < 9; p++) {
                    dtm2.setValueAt(input[p], index, p);
                }

                String str = "";
                String dummy3 = "";
                int i = 0;
                try {
                    BufferedReader dwtkReader = new BufferedReader(new FileReader("dwtk\\dwtk.txt"));
                    BufferedWriter dwtkoutWriter = new BufferedWriter(new FileWriter("dwtk\\dwtkout.txt", true));

                    while ((str = dwtkReader.readLine()) != null) {
                        if (i == index) {
                            dwtkoutWriter.append(s + "\n"); // 오류 확인용
                            dwtkoutWriter.flush();
                            dummy3 += (s + "\r\n");
                            i++;
                        } else {
                            dwtkoutWriter.append(str + "\n"); // 오류 확인용
                            dwtkoutWriter.flush();
                            dummy3 += (str + "\r\n");
                            i++;
                        }

                    }
                    if (modiDWtext != null) {
                        modiDWtext.setText("");
                    }

                    FileWriter fw1 = new FileWriter(dwtk);
                    fw1.write(dummy3);

                    fw1.close();
                    dwtkReader.close();
                    dwtkoutWriter.close();

                } catch (IOException ex) {
                    Logger.getLogger(WS.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        //유통업체 삭제
        JButton delDWTK = new JButton("삭제");
        delDWTK.setSize(100, 30);
        delDWTK.setLocation(737, 490);
        find.add(delDWTK);

        delDWTK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int index = ta2.getSelectedRow(); // 선택 행 인덱스 가져온다. 
                DefaultTableModel model = (DefaultTableModel) ta2.getModel();
                model.removeRow(index);

                String str = "";
                String dummy4 = "";
                int i = 0;
                try {
                    BufferedReader dwtkReader = new BufferedReader(new FileReader("dwtk\\dwtk.txt"));
                    BufferedWriter dwtkoutWriter = new BufferedWriter(new FileWriter("dwtk\\dwtkout.txt", true));

                    while ((str = dwtkReader.readLine()) != null) {
                        if (i == index) {
                            dwtkoutWriter.append(""); // 오류 확인 용
                            dwtkoutWriter.flush();
                            dummy4 += ("");
                            i++;
                        } else {
                            dwtkoutWriter.append(str + "\n"); // 오류 확인 용
                            dwtkoutWriter.flush();
                            dummy4 += (str + "\r\n");
                            i++;
                        }

                    }

                    FileWriter fw1 = new FileWriter(dwtk);
                    fw1.write(dummy4);

                    fw1.close();
                    dwtkReader.close();
                    dwtkoutWriter.close();

                } catch (IOException ex) {
                    Logger.getLogger(WS.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }
}
