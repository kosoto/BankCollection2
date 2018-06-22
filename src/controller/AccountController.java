package controller;

import javax.swing.JOptionPane;

import domain.*;
import service.*;
import serviceImpl.*;
public class AccountController {
	private static AccountController instance = new AccountController();
	public static AccountController getInstance() {return instance;}
	
	public void account(AccountBean account) {
		System.out.println("==========계좌 컨트롤러==============");
		System.out.println("화면에서 넘어온 객체:"+account);
		AccountServiceImpl.getInstance().createAccount(account);
	}
	
	public void minusAccount() {
		AccountBean account;
		account = new MinusAccountBean();
		account.setName(JOptionPane.showInputDialog("이름은?"));
		account.setUid(JOptionPane.showInputDialog("아이디?"));
		account.setPass(JOptionPane.showInputDialog("비밀번호?"));
		((MinusAccountBean) account).setLimit(JOptionPane.showInputDialog("대출한도 설정"));
		//service.createAccount(account); 
	}
	
	public void list() {
		//JOptionPane.showMessageDialog(null, service.list());
	}
	
	public void findById() {
		AccountBean account;
		account = new AccountBean();
		account.setUid(JOptionPane.showInputDialog("아이디?"));
		account.setPass(JOptionPane.showInputDialog("비밀번호?"));
		//JOptionPane.showMessageDialog(null, service.findById(account).toString());
	}
	
	public void findByName() {
		AccountBean account;
		/*JOptionPane.showMessageDialog(null,
				service.findByName(
					JOptionPane.showInputDialog("이름은?")
				)
			);*/
	}
	
	public void changePass() {
		AccountBean account;	
	}
	
	public void deleteAccount() {
		AccountBean account;
		account = new AccountBean();
		account.setUid(JOptionPane.showInputDialog("아이디?"));
		account.setPass(JOptionPane.showInputDialog("비밀번호?")
				+"/"+
				JOptionPane.showInputDialog("새비밀번호?")
				);
			//	service.changePass(account);
	}
	
}
