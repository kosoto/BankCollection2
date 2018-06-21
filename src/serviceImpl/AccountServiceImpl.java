package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.*;
import domain.*;
import service.AccountService;

public class AccountServiceImpl implements AccountService{
	Map<String,AccountBean> map;

	public AccountServiceImpl() {
		map = new HashMap<>();
	}
	@Override
	public void createAccount(AccountBean account) {
		account.setAccountType();
		map.put(account.getUid(), account);
	}

	@Override
	public void createMinus(MinusAccountBean minusAccount) {
		minusAccount.setAccountType();
		map.put(minusAccount.getUid(), minusAccount);		
	}

	@Override
	public Map<String, AccountBean> list() {
		return map;
	}

	@Override
	public List<AccountBean> findByName(String name) {
		List<AccountBean> searchedList = new ArrayList<>();
		Set<AccountBean> set = new HashSet<>();
		for(Map.Entry<String, AccountBean> e : map.entrySet()) {
			
		}
		
		
		return searchedList;
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






