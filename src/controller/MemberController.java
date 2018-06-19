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
				member = new UserBean();
				member.setName(JOptionPane.showInputDialog("이름은?"));
				member.setUid(JOptionPane.showInputDialog("아이디?"));
				member.setPass(JOptionPane.showInputDialog("비밀번호?"));
				member.setSsn(JOptionPane.showInputDialog("주민번호?"));
				member.setPhone(JOptionPane.showInputDialog("전화번호?"));
				member.setAddr(JOptionPane.showInputDialog("집주소?"));
				member.setEmail(JOptionPane.showInputDialog("이메일주소?"));
				service.createUser(member);
				break;
			case ADD :
				member = new StaffBean();
				member.setName(JOptionPane.showInputDialog("이름은?"));
				member.setUid(JOptionPane.showInputDialog("아이디?"));
				member.setPass(JOptionPane.showInputDialog("비밀번호?"));
				member.setSsn(JOptionPane.showInputDialog("주민번호?"));
				member.setPhone(JOptionPane.showInputDialog("전화번호?"));
				member.setAddr(JOptionPane.showInputDialog("집주소?"));
				member.setEmail(JOptionPane.showInputDialog("이메일주소?"));
				service.createStaff(member);
				break;
			case LIST : // 두 종류 모두 리스트
				JOptionPane.showMessageDialog(null,service.list());
				break;
			case FIND_BY_ID : 
				member = new MemberBean();
				member.setUid(JOptionPane.showInputDialog("아이디?"));
				member.setPass(JOptionPane.showInputDialog("비밀번호?"));
				JOptionPane.showMessageDialog(null, service.findById(member));
				break;
			case FIND_BY_NAME : 
				JOptionPane.showMessageDialog(null, 
						service.findByName(JOptionPane.showInputDialog("이름은?")));
				break;
			case COUNT : 
				JOptionPane.showMessageDialog(null, 
						"회원수 : "+service.checkCount());
				break;
			case UPDATE: //일단 비밀번호만 바꾸는거
				member = new MemberBean();
				member.setUid(JOptionPane.showInputDialog("아이디는?"));
				member.setPass(JOptionPane.showInputDialog("비밀번호?")
						+"/"+
						JOptionPane.showInputDialog("새 비밀확인")
						);
				JOptionPane.showMessageDialog(null, 
						service.changePass(member));
				break;
			case WITHDRAWAL :
				member = new MemberBean();
				member.setUid(JOptionPane.showInputDialog("아이디는?"));
				member.setPass(JOptionPane.showInputDialog("비밀번호?")
						+"/"+
						JOptionPane.showInputDialog("비밀번호 재확인")
						);
				JOptionPane.showMessageDialog(null, service.withdraw(member));
				break;
			default : return;
			
			}
		}
	}
}
