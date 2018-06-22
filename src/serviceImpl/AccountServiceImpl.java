package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.*;
import domain.*;
import repositoryImpl.AccountDAOImpl;
import service.AccountService;

public class AccountServiceImpl implements AccountService{
	private static AccountService instance = new AccountServiceImpl();
	Map<String,AccountBean> map;
	public static AccountService getInstance() {return instance;}
	private AccountServiceImpl() {}
	
	@Override
	public void createAccount(AccountBean account) {
		System.out.println("==========멤버 서비스==============");
		System.out.println("컨트롤러에서 넘어온 객체:"+account);
		account.setAccountType();
		account.setAccountNo(AdminServiceImpl.getInstance().createAccountNo());
		account.setCreateDate(AdminServiceImpl.getInstance().createDate());
		AccountDAOImpl.getInstance().insertAccount(account);
		//map.put(account.getUid(), account);
	}

	@Override
	public void createMinus(MinusAccountBean minusAccount) {
		minusAccount.setAccountType();
		map.put(minusAccount.getUid(), minusAccount);		
	}

	@Override
	public AccountBean findById(AccountBean account) {
		return map.get(account.getUid());
	}

	@Override
	public void changePass(AccountBean account) {
		String id = account.getUid();
		String pass = account.getPass().split("/")[0];
		String newPass = account.getPass().split("/")[1];
		AccountBean temp = findById(account);
		if(temp == null) {
			System.out.println("수정하려는 ID가 없음");
		}else {
			if(pass.equals(temp.getPass())) {
				temp.setPass(newPass);
				map.put(id, temp);
			}
		}
	}

	@Override
	public void deleteAccount(AccountBean account) {
		map.remove(account.getUid());
	}
		

	
}






