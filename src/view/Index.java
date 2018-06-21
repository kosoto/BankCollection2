package view;

import javax.swing.JOptionPane;

//import controller.AdminButt;
import domain.*;
import service.*;
import serviceImpl.*;

public class Index {
	enum AdminButt{
		EXIT,
		ADD,
		LIST,FIND_BY_ID,FIND_BY_NAME,COUNT,
		UPDATE,
		REMOVE
		};
	public static void main(String[] args) {
			
		
	MemberService service = new MemberServiceImpl();
	MemberBean member = null;
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

