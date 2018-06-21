package controller;

import javax.swing.JOptionPane;

import domain.*;
import service.*;
import serviceImpl.*;
public class AccountController {
	public void account() {
		AccountService service = new AccountServiceImpl();
		AccountBean account;
		account = new AccountBean();
		account.setName(JOptionPane.showInputDialog("이름은?"));
		account.setUid(JOptionPane.showInputDialog("아이디?"));
		account.setPass(JOptionPane.showInputDialog("비밀번호?"));
		service.createAccount(account);
	}
	
	public void minusAccount() {
		AccountService service = new AccountServiceImpl();
		AccountBean account;
		account = new MinusAccountBean();
		account.setName(JOptionPane.showInputDialog("이름은?"));
		account.setUid(JOptionPane.showInputDialog("아이디?"));
		account.setPass(JOptionPane.showInputDialog("비밀번호?"));
		((MinusAccountBean) account).setLimit(JOptionPane.showInputDialog("대출한도 설정"));
		service.createAccount(account); 
	}
	
	public void list() {
		AccountService service = new AccountServiceImpl();
		JOptionPane.showMessageDialog(null, service.list());
	}
	
	public void findById() {
		AccountService service = new AccountServiceImpl();
		AccountBean account;
		account = new AccountBean();
		account.setUid(JOptionPane.showInputDialog("아이디?"));
		account.setPass(JOptionPane.showInputDialog("비밀번호?"));
		JOptionPane.showMessageDialog(null, service.findById(account).toString());
	}
	
	public void findByName() {
		AccountService service = new AccountServiceImpl();
		AccountBean account;
		JOptionPane.showMessageDialog(null,
				service.findByName(
					JOptionPane.showInputDialog("이름은?")
				)
			);
	}
	
	public void changePass() {
		AccountService service = new AccountServiceImpl();
		AccountBean account;	
	}
	
	public void deleteAccount() {
		AccountService service = new AccountServiceImpl();
		AccountBean account;
		account = new AccountBean();
		account.setUid(JOptionPane.showInputDialog("아이디?"));
		account.setPass(JOptionPane.showInputDialog("비밀번호?")
				+"/"+
				JOptionPane.showInputDialog("새비밀번호?")
				);
				service.changePass(account);
	}
	
	enum AccountButt{
		EXIT,ACCOUNT,MINUS_ACCOUNT,LIST,FIND_BY_ID,DEPOSIT,WITHDRAW,
		FIND_BY_NAME,MINUS_LIST,CHANGE_PASS,DELETE_ACCOUNT
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
							AccountButt.MINUS_LIST,
							AccountButt.CHANGE_PASS,
							AccountButt.DELETE_ACCOUNT
							
					},
					null
					);
			switch(select) {
			case EXIT : return;
			case ACCOUNT :
				break;
			case MINUS_ACCOUNT :
				break;
			case LIST : // 두 종류 모두 리스트
				break;
			case FIND_BY_ID : 
				break;
			case FIND_BY_NAME : 
				break;
			case MINUS_LIST : //마이너스 통장 리스트 
				break;
			case CHANGE_PASS: 
				break;
			case DELETE_ACCOUNT : 
				break;
			case DEPOSIT :  
				break;
			case WITHDRAW :
				break;
			
			}
		}
	}
}
