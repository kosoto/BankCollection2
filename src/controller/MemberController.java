package controller;
import javax.swing.JOptionPane;
import domain.*;
import serviceImpl.*;
public class MemberController {
	private static MemberController instance = new MemberController();
	public static MemberController getInstance() {return instance;}
	private MemberController() {}

	/*MemberService service;
	public MemberController() {
		service = new MemberServiceImpl();
		
	}*/
	public void join(UserBean member) {
		System.out.println("==========멤버 컨트롤러==============");
		System.out.println("화면에서 넘어온 객체:"+member);
		MemberServiceImpl.getInstance().createUser(member);
	}
	
	
	public void list() {
		MemberBean member;
		//JOptionPane.showMessageDialog(null,service.list());
	}
	
	public void findById() {
		MemberBean member;
		member = new MemberBean();
		member.setUid(JOptionPane.showInputDialog("아이디?"));
		member.setPass(JOptionPane.showInputDialog("비밀번호?"));
		//JOptionPane.showMessageDialog(null, service.findById(member));
	}
	
	public void findByName() {
		MemberBean member;
		//JOptionPane.showMessageDialog(null, 
			//	service.findByName(JOptionPane.showInputDialog("이름은?")));
	}
	
	public void count() {
		MemberBean member;
		/*JOptionPane.showMessageDialog(null, 
				"회원수 : "+service.checkCount());*/
	}
	
	public void update() {
		MemberBean member;
		member = new MemberBean();
		member.setUid(JOptionPane.showInputDialog("아이디는?"));
		member.setPass(JOptionPane.showInputDialog("비밀번호?")
				+"/"+
				JOptionPane.showInputDialog("새 비밀확인")
				);
		//service.changePass(member);
	}
	
	public void withdrawal() {
		MemberBean member;
		member = new MemberBean();
		member.setUid(JOptionPane.showInputDialog("아이디는?"));
		member.setPass(JOptionPane.showInputDialog("비밀번호?")
				+"/"+
				JOptionPane.showInputDialog("비밀번호 재확인")
				);
	    //service.deleteMember(member);
	}
	
}
