package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import domain.*;
import service.AccountService;

public class AccountServiceImpl implements AccountService{
	Map<String,AccountBean> map;

	public AccountServiceImpl() {
		map = new HashMap<>();
	}
	@Override
	public void creataAccount(AccountBean account) {
		account.setAccountType();
		map.put(account.getUid(), account);
	}

	@Override
	public void creataMinus(MinusAccountBean minusAccount) {
		minusAccount.setAccountType();
		map.put(minusAccount.getUid(), minusAccount);		
	}

	@Override
	public Map<String, AccountBean> list() {
		return map;
	}

	@Override
	public Map<String, AccountBean> findByName(String name) {
		Map<String, AccountBean> searchedList= new HashMap<>();
		for(String key : map.keySet()) {
			if(name.equals(map.get(key).getName())) {
				searchedList.put(key, map.get(key));
			}
		}
		return searchedList;
	}

	@Override
	public AccountBean findById(AccountBean account) {
		return map.get(account.getUid());
	}

	@Override
	public void updatePassword(AccountBean account) {
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






