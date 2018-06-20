package controller;

import javax.swing.JOptionPane;

import domain.*;
import service.*;
import serviceImpl.*;
public class AccountController {
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
