package controller;

import javax.swing.JOptionPane;

import domain.*;
import service.*;
import serviceImpl.*;
public class AccountController {
	enum AccountButt{
		EXIT,ACCOUNT,MINUS_ACCOUNT,LIST,FIND_BY_ID,DEPOSIT,WITHDRAW,
		FIND_BY_NAME,MINUS_LIST
		};
	public static void main(String[] args) {
		AccountService service = new AccountServiceImpl();
		AccountBean account;
		while(true) {
			AccountButt select = (AccountButt)JOptionPane.showInputDialog(
					null,
					"ACCOUNT PAGE",
					"SELECT MENU",
					JOptionPane.QUESTION_MESSAGE,
					null,
					new AccountButt[] {
							AccountButt.EXIT,
							AccountButt.ACCOUNT,
							AccountButt.MINUS_ACCOUNT,
							AccountButt.LIST,
							AccountButt.FIND_BY_ID,
							AccountButt.DEPOSIT,
							AccountButt.WITHDRAW,
							AccountButt.FIND_BY_NAME,
							AccountButt.MINUS_LIST
							
					},
					null
					);
			switch(select) {
			case EXIT : return;
			case ACCOUNT :
				account = new AccountBean();
				account.setName(JOptionPane.showInputDialog("이름은?"));
				account.setUid(JOptionPane.showInputDialog("아이디?"));
				account.setPass(JOptionPane.showInputDialog("비밀번호?"));
				service.createAccount(account);
				break;
			case MINUS_ACCOUNT :
				account = new MinusAccountBean();
				account.setName(JOptionPane.showInputDialog("이름은?"));
				account.setUid(JOptionPane.showInputDialog("아이디?"));
				account.setPass(JOptionPane.showInputDialog("비밀번호?"));
				((MinusAccountBean) account).setLimit(JOptionPane.showInputDialog("대출한도 설정"));
				service.createMinusAccount((MinusAccountBean) account); 
				break;
			case LIST : // 두 종류 모두 리스트
				JOptionPane.showMessageDialog(null, service.list());
				break;
			case FIND_BY_ID : 
				account = new AccountBean();
				account.setUid(JOptionPane.showInputDialog("아이디?"));
				account.setPass(JOptionPane.showInputDialog("비밀번호?"));
				JOptionPane.showMessageDialog(null, service.findById(account).toString());
				break;
			case FIND_BY_NAME : 
				JOptionPane.showMessageDialog(null,
					service.showResult(
							service.findByName(
									JOptionPane.showInputDialog("이름은?")
							)
					).toString()
					
				);
				break;
			case MINUS_LIST : //마이너스 통장 리스트 
				JOptionPane.showMessageDialog(null, service.showResult(service.findMinusAccounts()));
				break;
			case DEPOSIT :  
				break;
			case WITHDRAW :
				break;
			
			}
		}
	}
}
