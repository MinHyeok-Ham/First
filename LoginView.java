import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class LoginView extends JFrame{
	private Main main;
	private WindowOpen WO;
	private JButton btnLogin;
	private JButton btnInit;
	private JPasswordField passText;
    private JTextField userText;
    private boolean bLoginCheck;
   
    public LoginView() {
    	// setting
        setTitle("login");
        setSize(280, 150);
        setResizable(false);
        setLocation(500, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
  
        // panel
        JPanel panel = new JPanel();
        placeLoginPanel(panel);
        // add
        add(panel);
        // visiible
        setVisible(true);
        }

    public void placeLoginPanel(JPanel panel){

        panel.setLayout(null);     
        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(10, 10, 80, 25);
        panel.add(userLabel);
        JLabel passLabel = new JLabel("Pass");
        passLabel.setBounds(10, 40, 80, 25);
        panel.add(passLabel);
        userText = new JTextField(20);
        userText.setBounds(100, 10, 160, 25);
        panel.add(userText);
        passText = new JPasswordField(20);
        passText.setBounds(100, 40, 160, 25);
        panel.add(passText);
        passText.addActionListener(new ActionListener() {          
            @Override
            public void actionPerformed(ActionEvent e) {
                isLoginCheck();        
            }
        });
       btnInit = new JButton("�ʱ�ȭ");
       btnInit.setBounds(160, 80, 100, 25);
       panel.add(btnInit);
        btnInit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                userText.setText("");
                passText.setText("");
           }
        });
       
        btnLogin = new JButton("�α���");
        btnLogin.setBounds(10, 80, 100, 25);
        
        panel.add(btnLogin);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	isLoginCheck();
            }
        });
   }
  
    public void isLoginCheck(){
        if(userText.getText().equals("test") && new String(passText.getPassword()).equals("1234")){

            JOptionPane.showMessageDialog(null, "����");
            bLoginCheck = true;
         
            // �α��� �����̶�� �Ŵ���â �ٿ��
            if(isLogin()){
               main.showFrameTest(); // ����â �޼ҵ带 �̿��� â�ٿ��

           }                  

        }else{

            JOptionPane.showMessageDialog(null, "���̵�� ��й�ȣ�� Ȯ�����ּ���.");


        }

    }
    public void setMain(Main main) {

        this.main = main;
   }

    public boolean isLogin() {     
        return bLoginCheck;

	}



}