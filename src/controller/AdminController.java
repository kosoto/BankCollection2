package controller;
import javax.swing.JOptionPane;
import domain.*;
import service.*;
import serviceImpl.*;
enum AdminButt{
		EXIT,
		ADD,
		LIST,FIND_BY_ID,FIND_BY_NAME,COUNT,
		UPDATE,
		REMOVE
		};
public class AdminController {
	private static AdminController instance = new AdminController();
	public static AdminController getInstance() {return instance;}
	private AdminController() {};
	

	public void add() {
		MemberBean member;
		member = new StaffBean();
		member.setName(JOptionPane.showInputDialog("이름은?"));
		member.setUid(JOptionPane.showInputDialog("아이디?"));
		member.setPass(JOptionPane.showInputDialog("비밀번호?"));
		member.setSsn(JOptionPane.showInputDialog("주민번호?"));
		member.setPhone(JOptionPane.showInputDialog("전화번호?"));
		member.setAddr(JOptionPane.showInputDialog("집주소?"));
		member.setEmail(JOptionPane.showInputDialog("이메일주소?"));
		//service.createStaff((StaffBean) member);
	}
	
	public void list() {
		MemberBean member;
	}
	
	public void findMemberById() {
		MemberBean member;
	}
	
	public void findMemberByName() {
		MemberBean member;
	}
	
	public void count() {
		MemberBean member;
	}
	
	public void updata() {
		MemberBean member;
	}
	
	public void remove() {
		MemberBean member;
	}
	
}
