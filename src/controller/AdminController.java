package controller;
import javax.swing.JOptionPane;
import controller.AccountController.AccountButt;
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
	
	public void add() {
		MemberService service = new MemberServiceImpl();
		MemberBean member;
	}
	
	public void list() {
		MemberService service = new MemberServiceImpl();
		MemberBean member;
	}
	
	public void findById() {
		MemberService service = new MemberServiceImpl();
		MemberBean member;
	}
	
	public void findByName() {
		MemberService service = new MemberServiceImpl();
		MemberBean member;
	}
	
	public void count() {
		MemberService service = new MemberServiceImpl();
		MemberBean member;
	}
	
	public void updata() {
		MemberService service = new MemberServiceImpl();
		MemberBean member;
	}
	
	public void remove() {
		MemberService service = new MemberServiceImpl();
		MemberBean member;
	}
	
	public static void main(String[] args) {
		MemberService service = new MemberServiceImpl();
		MemberBean member;
		while(true) {
			switch((AdminButt)JOptionPane.showInputDialog(
					null,
					"ACCOUNT PAGE",
					"SELECT MENU",
					JOptionPane.QUESTION_MESSAGE,
					null,
					new AdminButt[] {
							AdminButt.EXIT,
							AdminButt.ADD,
							AdminButt.LIST,
							AdminButt.FIND_BY_ID,
							AdminButt.FIND_BY_NAME,
							AdminButt.COUNT,
							AdminButt.UPDATE,
							AdminButt.REMOVE
					},
					null
					)) {
			case EXIT : return;
			case ADD :
				break;
			case LIST : // 두 종류 모두 리스트
				break;
			case FIND_BY_ID : 
				break;
			case FIND_BY_NAME : 
				break;
			case COUNT : 
				break;
			case UPDATE: //일단 비밀번호만 바꾸는거
				break;
			case REMOVE :
				break;
			default : return;
			
			}
		}
	}
}
