package controller;
import javax.swing.JOptionPane;
import controller.AccountController.AccountButt;
import domain.*;
import service.*;
import serviceImpl.*;
enum MemberButt{
		//JOIN은 일반유저추가, ADD는 직원추가
		EXIT,
		JOIN, ADD,
		LIST,FIND_BY_ID,FIND_BY_NAME,COUNT,
		UPDATE,
		WITHDRAWAL
		};
public class MemberController {
	public static void main(String[] args) {
		MemberService service = new MemberServiceImpl();
		MemberBean member;
		
		while(true) {
			MemberButt select = (MemberButt)JOptionPane.showInputDialog(
					null,
					"ACCOUNT PAGE",
					"SELECT MENU",
					JOptionPane.QUESTION_MESSAGE,
					null,
					new MemberButt[] {
							MemberButt.EXIT,
							MemberButt.JOIN,
							MemberButt.ADD,
							MemberButt.LIST,
							MemberButt.FIND_BY_ID,
							MemberButt.FIND_BY_NAME,
							MemberButt.COUNT,
							MemberButt.UPDATE,
							MemberButt.WITHDRAWAL
					},
					null
					);
			switch(select) {
			case EXIT : return;
			case JOIN :
				
				break;
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
			case WITHDRAWAL :
				break;
			default : return;
			
			}
		}
	}
}
