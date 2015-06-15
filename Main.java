
public class Main {
	LoginView loginView;
	WindowOpen WO;
	public static void main(String[] arg){
		Main main = new Main();
		main.loginView = new LoginView(); // 로그인창 보이기
        main.loginView.setMain(main); // 로그인창에게 메인 클래스보내기
	}
	

	public void showFrameTest(){
	loginView.dispose(); // 로그인창닫기
	this.WO = new WindowOpen(null); // 테스트프레임 오픈
   }


}
