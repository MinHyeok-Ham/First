
public class Main {
	LoginView loginView;
	WindowOpen WO;
	public static void main(String[] arg){
		Main main = new Main();
		main.loginView = new LoginView(); // �α���â ���̱�
        main.loginView.setMain(main); // �α���â���� ���� Ŭ����������
	}
	

	public void showFrameTest(){
	loginView.dispose(); // �α���â�ݱ�
	this.WO = new WindowOpen(null); // �׽�Ʈ������ ����
   }


}
