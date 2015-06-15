import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


class WindowOpen extends JFrame {
	static HashSet<String> set = new HashSet<String>();
	private JPanel P_Menu = new JPanel(); // 상단 메뉴 프레임차
	private JPanel P_Menu_Add = new JPanel();
	private JButton B_Menu_Add = new JButton("학생  추가하기"); 
	private JPanel P_Menu_Mod = new JPanel();
	private JButton B_Menu_Mod = new JButton("학생 수정/삭제하기");
	private JPanel P_Menu_Find = new JPanel();
	private JButton B_Menu_Find = new JButton("학 생 검 색");
	private JPanel P_Menu_TFind = new JPanel();
	private JButton B_Menu_TFind = new JButton("선생님 검색");
	private JPanel P_Menu_s_s = new JPanel();
	private JButton B_Menu_s_s = new JButton(".dat 모두 저장"); 
	private JPanel P_Menu_Exit = new JPanel();
	private JButton B_Menu_Exit = new JButton("프로그램종료"); 
	
	private JPanel P_Update = new JPanel();
	private JButton B_Update = new JButton("목록 갱신"); 
	
	
	private JPanel P_Main = new JPanel();
	
	private JPanel P_Addstudent = new JPanel(); // "추가"클릭시 나타날 패널 (하단 내용 프레임에 들어갈 Sub 패널)
	private JPanel P_Addstudent_1 = new JPanel();
	private JTextField T_Addstudent_Name = new JTextField(9);
	private JPanel P_Addstudent_2 = new JPanel();	
	private JTextField T_Age = new JTextField(9); 
	private JPanel P_Addstudent_3 = new JPanel();	
	private JTextField T_Addstudent_EM = new JTextField(9);
	private JPanel P_Addstudent_4 = new JPanel();	
	private JTextField T_Addstudent_Class = new JTextField(9);
	private JPanel P_Addstudent_5 = new JPanel();	
	private JTextField T_Addstudent_SN = new JTextField(9); 
	private JPanel P_Addstudent_6 = new JPanel();
	private JButton B_Addstudent_Add = new JButton("추          가"); // 추가메뉴
			
	private JPanel P_Modstudent = new JPanel(); // "추가"클릭시 나타날 패널 (하단 내용 프레임에 들어갈 Sub 패널)
	private JPanel P_Modstudent_0 = new JPanel();
	private JTextField T_Modstudent_PersonNO = new JTextField(9);
	private JPanel P_Modstudent_1 = new JPanel();
	private JTextField T_Modstudent_Name = new JTextField(9);
	private JPanel P_Modstudent_2 = new JPanel();	
	private JTextField T_Modstudent_Age = new JTextField(9); 
	private JPanel P_Modstudent_3 = new JPanel();	
	private JTextField T_Modstudent_EM = new JTextField(9);
	private JPanel P_Modstudent_4 = new JPanel();	
	private JTextField T_Modstudent_Class = new JTextField(9);
	private JPanel P_Modstudent_5 = new JPanel();	
	private JTextField T_Modstudent_SN = new JTextField(9); 
	private JPanel P_Modstudent_6 = new JPanel();
	private JButton B_Modstudent_Mod = new JButton("수          정"); // 추가메뉴
	private JPanel P_Modstudent_7 = new JPanel();
	private JButton B_Modstudent_Delete = new JButton("삭         제"); // 추가메뉴
	
	private JPanel P_Find = new JPanel(); 
	private JPanel P_Find_1 = new JPanel();
	private JTextField T_Find_studentFinder = new JTextField(12); // 대출자 입력필드
	private JPanel P_Find_4 = new JPanel();
	private JButton B_Find_Add = new JButton("검           색");
	
	private JPanel P_Find_t = new JPanel(); 
	private JPanel P_Find_t_1 = new JPanel();
	private JTextField T_Find_teacherFinder = new JTextField(12); // 대출자 입력필드
	private JPanel P_Find_t_4 = new JPanel();
	private JButton B_Find_t_Add = new JButton("검           색");
	
	Controller ct = new Controller();
	public WindowOpen(String title){
		
		super("기숙학원관리 프로그램");//상단화면의 타이틀 설정
		ct.loadStudent();
		ct.loadTeacher();
		InitDesign();//화면그리기\
		JMenuBar mb = new JMenuBar();
		JMenu menuFile = new JMenu("File");
		
		JTabbedPaneTest();
		
		JMenuItem menuItemOpen_s = new JMenuItem("학생.dat 불러오기");
		menuFile.add(menuItemOpen_s);
		mb.add(menuFile);
		setJMenuBar(mb);
		menuItemOpen_s.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				File f;
				JFileChooser fc = new JFileChooser();
				int answer = fc.showOpenDialog(null);
				if(answer == JFileChooser.APPROVE_OPTION){
					f = fc.getSelectedFile();
			        try{
					    FileInputStream fis = new FileInputStream(f); //input.txt파일 읽는 스트림 선언
					    ObjectInputStream ois = new ObjectInputStream(fis);
					    ct.s.clear();
					    ct.list_s.clear();
					    String str;
					    ArrayList list_s = (ArrayList)ois.readObject();		
						for(int i = 0; i < list_s.size(); i++){
					    	ct.s.add((Student) list_s.get(i));
					    	ct.list_s.add(ct.s);
					    }
						
						ois.close();
						fis.close();
						JTabbedPaneTest();
					    
					}catch (IOException e1) {
					    	// TODO Auto-generated catch block
					    	e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		JMenuItem menuItemOpen_t = new JMenuItem("선생님.dat 불러오기");
		menuFile.add(menuItemOpen_t);
		mb.add(menuFile);
		setJMenuBar(mb);
		menuItemOpen_t.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				File f;
				JFileChooser fc = new JFileChooser();
				int answer = fc.showOpenDialog(null);
				if(answer == JFileChooser.APPROVE_OPTION){
					f = fc.getSelectedFile();
			        try{
					    FileInputStream fis = new FileInputStream(f); //input.txt파일 읽는 스트림 선언
					    ObjectInputStream ois = new ObjectInputStream(fis);
					    ct.t.clear();
					    ct.list_t.clear();
					    ArrayList list_t = (ArrayList)ois.readObject();		
						for(int i = 0; i < list_t.size(); i++){
					    	ct.t.add((Teacher) list_t.get(i));
					    	ct.list_t.add(ct.t);
					    }
						
						ois.close();
						fis.close();
						JTabbedPaneTest();
					    
					}catch (IOException e1) {
					    	// TODO Auto-generated catch block
					    	e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		JMenuItem menuItemExit = new JMenuItem("Exit");
		menuFile.add(menuItemExit);
		mb.add(menuFile);
		setJMenuBar(mb);
		menuItemExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);					
				}
			}
		);
		B_Menu_s_s.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ct.s_saveFile();
				ct.t_saveFile();
				System.out.println(ct.list_t.size());
				System.out.println(ct.t.size());
				for(int i = 0; i< ct.list_t.size(); i++){
					System.out.println(ct.list_t.get(i));
				}
				for(int i = 0; i<ct.t.size(); i++){
					System.out.println(ct.t.get(i));
				}
				JOptionPane.showMessageDialog(B_Menu_s_s, "정상적으로 저장됐습니다.");
			}
		});
		B_Menu_TFind.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				P_Find_t.setVisible(true);
				P_Find.setVisible(false);
				P_Addstudent.setVisible(false);
				P_Modstudent.setVisible(false);
			}
		});
		B_Menu_Add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == B_Menu_Add){
					P_Find.setVisible(false);
					P_Addstudent.setVisible(true);
					P_Modstudent.setVisible(false);
					P_Find_t.setVisible(false);
				}
			}
		});
		B_Update.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JTabbedPaneTest();
			}
		});
		B_Addstudent_Add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Add_Student();
				JTabbedPaneTest();
			}
			
		});
		B_Modstudent_Mod.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ModifyStudent();
				JTabbedPaneTest();
			}
			
		});
		B_Modstudent_Delete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				DeleteStudent();
				JTabbedPaneTest();
			}
			
		});
		B_Menu_Mod.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Remove_Student();
				
				
			}
		});
		B_Menu_Mod.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				P_Find.setVisible(false);
				P_Addstudent.setVisible(false);
				P_Modstudent.setVisible(true);
				P_Find_t.setVisible(false);
			}
		});
		B_Menu_Find.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				P_Find.setVisible(true);
				P_Addstudent.setVisible(false);
				P_Modstudent.setVisible(false);
				P_Find_t.setVisible(false);
			}
		});
		B_Find_Add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Find_Student();
				JOptionPane.showMessageDialog(B_Find_Add,WindowOpen.set.size()+ "개 검색되었습니다.");
				WindowOpen.set.clear();
				JTabbedPaneTest1();
			}
		});
		B_Find_t_Add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Find_Teacher();
				JOptionPane.showMessageDialog(B_Find_t_Add,WindowOpen.set.size()+ "개 검색되었습니다.");
				WindowOpen.set.clear();
				JTabbedPaneTest2();
			}
		});
		B_Menu_Exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
	}
	private void InitDesign(){
		this.setLayout(null);
		this.add(P_Menu);
		this.add(P_Main);
		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				JTabbedPaneTest();
			}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				JTabbedPaneTest();
			}
		});
		DrawMenu();
		DrawMain();
		DrawAddstudent();
		DrawModify();
		DrawFind();
		DrawTFind();
		this.setSize(1000,700);//프레임 사이즈
        this.setVisible(true);//프레임 창 표시
	}
	
	private void DrawMenu(){
		
		P_Menu.setLayout(new GridLayout(1,7)); // 버튼 5개가 들어가도록 레이아웃을 5개로 쪼갠다.
		P_Menu.setBounds(20, 10, 860, 40);
		P_Menu.add(P_Menu_Add);
			P_Menu_Add.add(B_Menu_Add);
		P_Menu.add(P_Menu_Mod);
			P_Menu_Mod.add(B_Menu_Mod);
		P_Menu.add(P_Menu_Find);
			P_Menu_Find.add(B_Menu_Find);
		P_Menu.add(P_Menu_TFind);
			P_Menu_TFind.add(B_Menu_TFind);
		P_Menu.add(P_Menu_s_s);
			P_Menu_s_s.add(B_Menu_s_s);
		P_Menu.add(P_Menu_Exit);
			P_Menu_Exit.add(B_Menu_Exit);
		P_Menu.add(P_Update);
		P_Update.add(B_Update);
	}
	
	private void DrawFind(){
		P_Find.setBounds(0,0,200,450);
		P_Find.setBorder(BorderFactory.createEtchedBorder());
		P_Find.setLayout(new GridLayout(8,1));
		P_Find.add(P_Find_1);
		P_Find.add(P_Find_4);
		
		P_Find_1.add(new Label("일련번호/ 이름/ 나이/ 반 / 선택과목"));
		P_Find_1.add(T_Find_studentFinder);
		P_Find_4.add(B_Find_Add);
	}
	private void DrawTFind(){
		P_Find_t.setBounds(0,0,200,450);
		P_Find_t.setBorder(BorderFactory.createEtchedBorder());
		P_Find_t.setLayout(new GridLayout(8,1));
		P_Find_t.add(P_Find_t_1);
		P_Find_t.add(P_Find_t_4);
		
		P_Find_t_1.add(new Label("일련번호/ 이름/ 나이/ 반 / 담당과목 "));
		P_Find_t_1.add(T_Find_teacherFinder);
		P_Find_t_4.add(B_Find_t_Add);
	}
	private void DrawModify(){
		P_Modstudent.setBounds(0,0,200,450);
		P_Modstudent.setBorder(BorderFactory.createEtchedBorder());
		P_Modstudent.setLayout(new GridLayout(9,1));
		P_Modstudent.add(P_Modstudent_0);
		P_Modstudent.add(P_Modstudent_1);
		P_Modstudent.add(P_Modstudent_2);
		P_Modstudent.add(P_Modstudent_3);
		P_Modstudent.add(P_Modstudent_4);
		P_Modstudent.add(P_Modstudent_5);
		P_Modstudent.add(P_Modstudent_6);
		P_Modstudent.add(P_Modstudent_7);
		
		P_Modstudent_0.add(new Label("일 련 번 호 "));
		P_Modstudent_0.add(T_Modstudent_PersonNO);
		P_Modstudent_1.add(new Label("이    름  :  "));
		P_Modstudent_1.add(T_Modstudent_Name);
		P_Modstudent_2.add(new Label("나    이  :  "));
		P_Modstudent_2.add(T_Modstudent_Age);
		P_Modstudent_3.add(new Label("문과/이과  :"));
		P_Modstudent_3.add(T_Modstudent_EM);
		P_Modstudent_4.add(new Label("반       :   "));
		P_Modstudent_4.add(T_Modstudent_Class);
		P_Modstudent_5.add(new Label("선택과목  :"));
		P_Modstudent_5.add(T_Modstudent_SN);
		P_Modstudent_6.add(B_Modstudent_Mod);
		P_Modstudent_7.add(B_Modstudent_Delete);
	}
	private void DrawAddstudent(){
		P_Addstudent.setBounds(0,0,200,450);
		P_Addstudent.setBorder(BorderFactory.createEtchedBorder());
		P_Addstudent.setLayout(new GridLayout(8,1));
		P_Addstudent.add(P_Addstudent_1);
		P_Addstudent.add(P_Addstudent_2);
		P_Addstudent.add(P_Addstudent_3);
		P_Addstudent.add(P_Addstudent_4);
		P_Addstudent.add(P_Addstudent_5);
		P_Addstudent.add(P_Addstudent_6);
		
		P_Addstudent_1.add(new Label("이    름  :  "));
		P_Addstudent_1.add(T_Addstudent_Name);
		P_Addstudent_2.add(new Label("나    이  :  "));
		P_Addstudent_2.add(T_Age);
		P_Addstudent_3.add(new Label("문과/이과  :"));
		P_Addstudent_3.add(T_Addstudent_EM);
		P_Addstudent_4.add(new Label("반       :   "));
		P_Addstudent_4.add(T_Addstudent_Class);
		P_Addstudent_5.add(new Label("선택과목  :"));
		P_Addstudent_5.add(T_Addstudent_SN);
		P_Addstudent_6.add(B_Addstudent_Add);
		
	}
	private void DrawMain(){
		JTabbedPaneTest();
		P_Main.setLayout(null);
		P_Main.setBounds(550,85,200,450);
		P_Main.setBorder(BorderFactory.createEtchedBorder());
		P_Main.add(P_Addstudent);
		P_Main.add(P_Modstudent);
		P_Main.add(P_Find);
		P_Main.add(P_Find_t);
		P_Addstudent.setVisible(false);
		P_Modstudent.setVisible(false);
		P_Find.setVisible(false);
		P_Find_t.setVisible(false);
	}
	private void Add_Student() {
		if(T_Age.getText().length() !=0 && T_Addstudent_Name.getText().length() != 0){
			if(T_Addstudent_EM.getText().length() != 0&& T_Addstudent_Class.getText().length() != 0&& T_Addstudent_SN.getText().length() != 0){
			
			T_Age.getText();//Author 저자명 기입
			String t = "S";
			DecimalFormat format = new DecimalFormat("000");
			String a = format.format(ct.list_s.size()+1);
			Student s = new Student(t+a,T_Addstudent_Name.getText(),T_Age.getText(),T_Addstudent_EM.getText(),T_Addstudent_Class.getText(),T_Addstudent_SN.getText());
			ct.s.add(s);
			ct.list_s.add(ct.s);
			}
			T_Age.setText("");
			T_Addstudent_Name.setText("");
			T_Addstudent_EM.setText("");
			T_Addstudent_Class.setText("");
			T_Addstudent_SN.setText("");
		}
	}
	private void Remove_Student() {

		int oldAuthor, oldstudent; // AuthorName, Name을 Indexing한 정수값을 갖는다.
		
		if(T_Age.getText().length() !=0 && T_Addstudent_Name.getText().length() != 0){
			if(T_Addstudent_EM.getText().length() != 0&& T_Addstudent_Class.getText().length() != 0&& T_Addstudent_SN.getText().length() != 0){
			
			}
			
		}
	}
	private void ModifyStudent() {
		if(T_Modstudent_PersonNO.getText().length() !=0 &&T_Modstudent_Age.getText().length() !=0 && T_Modstudent_Name.getText().length() != 0){
			if(T_Modstudent_EM.getText().length() != 0&& T_Modstudent_Class.getText().length() != 0&& T_Modstudent_SN.getText().length() != 0){
				for(int i = 0; i<ct.s.size(); i++){
					if(ct.s.get(i).getPersonNO().equals(T_Modstudent_PersonNO.getText())){
						ct.s.remove(i);
						ct.list_s.remove(ct.s);
						Student s = new Student(T_Modstudent_PersonNO.getText(),T_Modstudent_Name.getText(),T_Modstudent_Age.getText(),T_Modstudent_EM.getText(),T_Modstudent_Class.getText(),T_Modstudent_SN.getText());
						ct.s.add(s);
						ct.list_s.add(ct.s);
					}
				}
			}
			T_Modstudent_PersonNO.setText("");
			T_Modstudent_Age.setText("");
			T_Modstudent_Name.setText("");
			T_Modstudent_EM.setText("");
			T_Modstudent_Class.setText("");
			T_Modstudent_SN.setText("");
		}
	}
	private void DeleteStudent(){
		if(T_Modstudent_PersonNO.getText().length() !=0){
			for(int i = 0; i<ct.s.size(); i++){
				if(ct.s.get(i).getPersonNO().equals(T_Modstudent_PersonNO.getText())){
					ct.s.remove(i);
				}
			}
			T_Modstudent_PersonNO.setText("");
		}
	}
	private void Find_Student() {
		if(T_Find_studentFinder.getText().length() !=0 ){
			
			for(int i = 0; i < ct.s.size(); i++){
				if(ct.s.get(i).getPersonNO().contains(T_Find_studentFinder.getText())){
					WindowOpen.set.add(Integer.toString(i));
				}
				else if(ct.s.get(i).getName().contains(T_Find_studentFinder.getText())){
					WindowOpen.set.add(Integer.toString(i));
				}
				else if(ct.s.get(i).getAge().contains(T_Find_studentFinder.getText())){
					WindowOpen.set.add(Integer.toString(i));
				}
				else if(ct.s.get(i).getEM().contains(T_Find_studentFinder.getText())){
					WindowOpen.set.add(Integer.toString(i));
				}
				else if(ct.s.get(i).getGroup().contains(T_Find_studentFinder.getText())){
					WindowOpen.set.add(Integer.toString(i));
				}
				else if(ct.s.get(i).getSelect_subject().contains(T_Find_studentFinder.getText())){
					WindowOpen.set.add(Integer.toString(i));
				}
			}
			T_Find_studentFinder.setText("");
		}
	}
	private void Find_Teacher() {
		if(T_Find_teacherFinder.getText().length() !=0 ){
			for(int i = 0; i < ct.t.size(); i++){
				if(ct.t.get(i).getPersonNO().contains(T_Find_teacherFinder.getText())){
					WindowOpen.set.add(Integer.toString(i));
				}
				else if(ct.t.get(i).getName().contains(T_Find_teacherFinder.getText())){
					WindowOpen.set.add(Integer.toString(i));
				}
				else if(ct.t.get(i).getAge().contains(T_Find_teacherFinder.getText())){
					WindowOpen.set.add(Integer.toString(i));
				}
				else if(ct.t.get(i).getGroup().contains(T_Find_teacherFinder.getText())){
					WindowOpen.set.add(Integer.toString(i));
				}
				else if(ct.t.get(i).getSubject_Name().contains(T_Find_teacherFinder.getText())){
					WindowOpen.set.add(Integer.toString(i));
				}
			}
			T_Find_teacherFinder.setText("");
		}
	}
	
	public void JTabbedPaneTest(){
		JTabbedPane tab;
		
		String s_colNames[] = {"일련번호","이름","나이","문과/이과","반","선택과목"};
		DefaultTableModel s_model = new DefaultTableModel(s_colNames, 0);
		s_model.setRowCount(0);    
        String[] Data_Printed = { "", "", "","", "", "", ""};
        for(int i = 0; i < ct.s.size();i ++){
        	Data_Printed[0] = (ct.s.get(i).getPersonNO());
			Data_Printed[1] = (ct.s.get(i).getName());
			Data_Printed[2] = (ct.s.get(i).getAge());
			Data_Printed[3] = (ct.s.get(i).getEM());
			Data_Printed[4] = (ct.s.get(i).getGroup());
			Data_Printed[5] = (ct.s.get(i).getSelect_subject());
			s_model.addRow(Data_Printed);
			
        }
        JTable s_table = new JTable(s_model);
        JScrollPane s_sp = new JScrollPane(s_table);
		
        String t_colNames[] = {"일련번호","이름","나이","과목","담임반","핸드폰번호"};
		DefaultTableModel t_model = new DefaultTableModel(t_colNames, 0);
	
        String[] t_Data_Printed = {"", "", "","", "", ""};
        for(int i = 0; i < ct.t.size();i ++){
        	Data_Printed[0] = (ct.t.get(i).getPersonNO());
			Data_Printed[1] = (ct.t.get(i).getName());
			Data_Printed[2] = (ct.t.get(i).getAge());
			Data_Printed[3] = (ct.t.get(i).getSubject_Name());
			Data_Printed[4] = (ct.t.get(i).getGroup());
			Data_Printed[5] = (ct.t.get(i).getNo());
			t_model.addRow(Data_Printed);
        }
        
        JTable t_table = new JTable(t_model);
		JScrollPane t_sp = new JScrollPane(t_table);
		
		tab = new JTabbedPane(JTabbedPane.TOP);
		JPanel panel = new JPanel();

		JPanel jps = new JPanel();
		JPanel jpt = new JPanel();
		s_sp.updateUI();
		s_sp.repaint();
		s_sp.getViewport().repaint();

		jps.add(s_sp);
		jpt.add(t_sp);
		
		tab.addTab("학생메뉴",jps);
		tab.addTab("선생님메뉴",jpt);
		panel.add(tab,BorderLayout.WEST);
		panel.setBounds(-150, 50, 900, 600);
		add(panel);
		setVisible(true);
	}
	public void JTabbedPaneTest1(){
		JTabbedPane tab;
		
		String s_colNames[] = {"일련번호","이름","나이","문과/이과","반","선택과목"};
		DefaultTableModel s_model = new DefaultTableModel(s_colNames, 0);
		

		Find_Student();    
        String[] Data_Printed = { "", "", "","", "", "", ""};
        
        Iterator<String> iterator = WindowOpen.set.iterator();

        while(iterator.hasNext()){
        	String str = iterator.next();
        	Data_Printed[0] = (ct.s.get(Integer.parseInt(str)).getPersonNO());
        	Data_Printed[1] = (ct.s.get(Integer.parseInt(str)).getName());
        	Data_Printed[2] = (ct.s.get(Integer.parseInt(str)).getAge());
        	Data_Printed[3] = (ct.s.get(Integer.parseInt(str)).getEM());
        	Data_Printed[4] = (ct.s.get(Integer.parseInt(str)).getGroup());
        	Data_Printed[5] = (ct.s.get(Integer.parseInt(str)).getSelect_subject());
        	s_model.addRow(Data_Printed);
        }
        JTable s_table = new JTable(s_model);
        JScrollPane s_sp = new JScrollPane(s_table);
		
        String t_colNames[] = {"일련번호","이름","나이","과목","담임반","핸드폰번호"};
		DefaultTableModel t_model = new DefaultTableModel(t_colNames, 0);
	
        String[] t_Data_Printed = {"", "", "","", "", ""};
        for(int i = 0; i < ct.t.size();i ++){
        	t_Data_Printed[0] = (ct.t.get(i).getPersonNO());
			t_Data_Printed[1] = (ct.t.get(i).getName());
			t_Data_Printed[2] = (ct.t.get(i).getAge());
			t_Data_Printed[3] = (ct.t.get(i).getSubject_Name());
			t_Data_Printed[4] = (ct.t.get(i).getGroup());
			t_Data_Printed[5] = (ct.t.get(i).getNo());
			t_model.addRow(t_Data_Printed);
        }
        
        JTable t_table = new JTable(t_model);
		JScrollPane t_sp = new JScrollPane(t_table);
		
		tab = new JTabbedPane(JTabbedPane.TOP);
		JPanel panel = new JPanel();

		JPanel jps = new JPanel();
		
		JPanel jpt = new JPanel();
		jps.add(s_sp);
		jpt.add(t_sp);
		
		tab.addTab("학생메뉴",jps);
		tab.addTab("선생님메뉴",jpt);
		
		panel.add(tab,BorderLayout.WEST);
		panel.setBounds(-150, 50, 900, 600);
		add(panel,new GridLayout(1,1));
		
		setVisible(true);
	}
	public void JTabbedPaneTest2(){
		JTabbedPane tab;
		
		String s_colNames[] = {"일련번호","이름","나이","문과/이과","반","선택과목"};
		DefaultTableModel s_model = new DefaultTableModel(s_colNames, 0);
		Find_Teacher();
		s_model.setRowCount(0);    
        String[] Data_Printed = { "", "", "","", "", "", ""};
        for(int i = 0; i < ct.s.size();i ++){
        	Data_Printed[0] = (ct.s.get(i).getPersonNO());
			Data_Printed[1] = (ct.s.get(i).getName());
			Data_Printed[2] = (ct.s.get(i).getAge());
			Data_Printed[3] = (ct.s.get(i).getEM());
			Data_Printed[4] = (ct.s.get(i).getGroup());
			Data_Printed[5] = (ct.s.get(i).getSelect_subject());
			s_model.addRow(Data_Printed);
			
        }
        JTable s_table = new JTable(s_model);
        JScrollPane s_sp = new JScrollPane(s_table);
		
        String t_colNames[] = {"일련번호","이름","나이","과목","담임반","핸드폰번호"};
		DefaultTableModel t_model = new DefaultTableModel(t_colNames, 0);
	
        String[] t_Data_Printed = {"", "", "","", "", ""};
        Iterator<String> iterator_t = WindowOpen.set.iterator();
        while(iterator_t.hasNext()){
        	String str = iterator_t.next();
        	t_Data_Printed[0] = (ct.t.get(Integer.parseInt(str)).getPersonNO());
			t_Data_Printed[1] = (ct.t.get(Integer.parseInt(str)).getName());
			t_Data_Printed[2] = (ct.t.get(Integer.parseInt(str)).getAge());
			t_Data_Printed[3] = (ct.t.get(Integer.parseInt(str)).getSubject_Name());
			t_Data_Printed[4] = (ct.t.get(Integer.parseInt(str)).getGroup());
			t_Data_Printed[5] = (ct.t.get(Integer.parseInt(str)).getNo());
			t_model.addRow(t_Data_Printed);
        }
        
        JTable t_table = new JTable(t_model);
		JScrollPane t_sp = new JScrollPane(t_table);
		
		tab = new JTabbedPane(JTabbedPane.TOP);
		JPanel panel = new JPanel();

		JPanel jps = new JPanel();
		
		JPanel jpt = new JPanel();
		jps.add(s_sp);
		jpt.add(t_sp);
		
		tab.addTab("선생님메뉴",jpt);
		tab.addTab("학생메뉴",jps);
		
		
		panel.add(tab,BorderLayout.WEST);
		panel.setBounds(-150, 50, 900, 600);
		add(panel,new GridLayout(1,1));
		
		setVisible(true);
	}
	
}
