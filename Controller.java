import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Controller {
	ArrayList list_s = new ArrayList();
	ArrayList list_t = new ArrayList();
	ArrayList<Student> s = new ArrayList<Student>();
	ArrayList<Teacher> t = new ArrayList<Teacher>();
	public void loadStudent(){
		FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        
		try{
			
		    FileInputStream fis = new FileInputStream("student.txt"); //input.txt파일 읽는 스트림 선언
		    BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		    String str;
		    while((str = br.readLine()) != null){  //라인의 끝까지 loop돌림
		    	String[] tokens= str.split(",");
		    	s.add(new Student(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5]));
		    	list_s.add(s);
		    }
		    
		}catch (IOException e1) {
		    	// TODO Auto-generated catch block
		    	e1.printStackTrace();
		}
            
	}
	public void loadTeacher(){
		FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        
		try{
			
		    FileInputStream fis = new FileInputStream("teacher.txt"); //input.txt파일 읽는 스트림 선언
		    BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		    String str;
		    while((str = br.readLine()) != null){  //라인의 끝까지 loop돌림
		    	String[] tokens= str.split(",");
		    	t.add(new Teacher(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5]));
		    	list_t.add(t);
		    }
		}catch (IOException e1) {
		    	// TODO Auto-generated catch block
		    	e1.printStackTrace();
		}
	}
	public void s_saveFile() {
		// TODO Auto-generated method stub
		FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        try{
        	fout = new FileOutputStream("studentlist.dat");
            oos = new ObjectOutputStream(fout);
            
            oos.writeObject(s);
            oos.reset();
            
        }catch(Exception ex){
        }finally{
            try{
                oos.close();
                fout.close();
            }catch(IOException ioe){}
        } // finally
		
	}
	public void t_saveFile() {
		// TODO Auto-generated method stub
		FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        try{
        	fout = new FileOutputStream("teacherlist.dat");
            oos = new ObjectOutputStream(fout);
            
            oos.writeObject(t);
            oos.reset();
            
        }catch(Exception ex){
        }finally{
            try{
                oos.close();
                fout.close();
            }catch(IOException ioe){}
        } // finally
		
	}
}
