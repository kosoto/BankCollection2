package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import domain.*;
import service.AccountService;

public class AccountServiceImplTest implements AccountService{
	AccountBean[] list;
	int count;
	
	
	public AccountServiceImplTest() {
		list = new AccountBean[10];
		count=0;
	}
	
	@Override
	public void createAccount(AccountBean account) {
		account.setAccountType();
		account.setAccountNo(createAccountNum());
		account.setCreateDate(createDate());
		addList(account);
	}
	
	@Override
	public AccountBean findById(AccountBean privateAccount) {
		AccountBean searchedAccount = new AccountBean();
		// 배열 list를 looping하면서 ID가 일치하고 비번이 일치한 값을 찾아서
		// 그 객체를 리턴한다.
		// 일단 일치하는 값이 없는 상황은 나중에 처리
		for(int i=0;i<count;i++) {
			if(privateAccount.getUid().equals(list[i].getUid())&&
			   privateAccount.getPass().equals(list[i].getPass())) {
				searchedAccount = list[i]; break;
			}
		}
		return searchedAccount;
	}
	
	@Override
	public AccountBean[] findByName(String name) {
		int count = countSameWord(name);
		AccountBean[] arrAccount = 
				new AccountBean[count];
		for(int i=0,j=0;i<count&& j<count;i++) {
			if(name.equals(list[i].getName()) ) {
				arrAccount[j++] = list[i]; 
			}
		}
		return arrAccount;
	}
	
	@Override
	public int countSameWord(String word) {
		int number=0;
		for(int i=0;i<count;i++) {
			number += (word.equals(list[i].getName()))?1:0;
		}
		return number;
	}
	
	public AccountBean[] findMinusAccounts() {
		int countMinusAccounts = countMinusAccounts();
		AccountBean[] minusAccounts = new AccountBean[countMinusAccounts];
		int j=0;
		for(int i=0;i<count && j<countMinusAccounts;i++) {
			if("마이너스통장".equals(list[i].getAccountType())) {
				minusAccounts[j++]= list[i];
			}  
		}
		return minusAccounts; 
	}
	
	public int countMinusAccounts() {
		int countMinusAccounts = 0;
		for(int i=0;i<count;i++) {
			if("마이너스통장".equals(list[i].getAccountType())) {
				countMinusAccounts++;
			}
		}
		return countMinusAccounts;
	}
	
	@Override
	public void addList(AccountBean account) {
		list[count++] = account;
	}

	@Override
	public AccountBean[] list() {
		System.out.println("배열의 카운트 : "+count);
		String res= "";
		for(int i=0;i<list.length;i++) {
			res += list[i] +"\n";
		}
		System.out.println("배열 내부 : "+res);
		return list;
	}

	@Override
	public int deposit(int restMoney, String money) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int withdraw(int restMoney, String money) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String createAccountNum() {
		String accountNum="";
		for(int i=0;i<11;i++) {
			accountNum += (i%4!=3)?createRandom(0,9):"-";
		}
		return accountNum;
	}

	@Override
	public String createRandom(int start, int end) {
		return String.valueOf((int)(Math.random()*(end+1-start))+start);
	}

	@Override
	public String createDate() {
		return new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date());
	}

	@Override
	public String changePass(AccountBean account) {
		String msg = "";
		String pass = account.getPass().split("/")[0];
		String newPass = account.getPass().split("/")[1];
		account.setPass(pass);
		account = findById(account);
		if(!(account.getUid()==null)&&
				!(pass.equals(newPass))) {
			msg = "변경완료";
			account.setPass(newPass);
			rewriteAccount(account);
		}else {
			msg = "변경실패";
		}
		return msg;
	}
	
	@Override
	public void rewriteAccount(AccountBean account) {
		for(int i=0;i<count;i++) {
			if(account.getUid().equals(list[i].getUid())&&
				account.getPass().equals(list[i].getPass())) {
				account.setPass(account.getNewPass());
				account.setNewPass(null);
				list[i] = account;
				break;
			}
		}
		
	}

	@Override
	public String deleteAccount(AccountBean account) {
		String msg = "";
		int index = 0;
		String pass = account.getPass().split("/")[0];
		String confirmpass = account.getPass().split("/")[1];
		if(pass.equals(confirmpass)) {
			account.setPass(pass);	
			for(int i=0;i<count;i++) {
				if(account.getUid().equals(list[i].getUid())&&
				   account.getPass().equals(list[i].getPass())) {
					account = list[i]; 
					index = i;
					break;
				}
			}
			
			if(account.getName() == null) {
				msg = "ID 혹은 비번 틀림";
			}else {
				 list[index] = list[--count];
				 list[count] = null;
				msg = "삭제 성공";
			}
			
		}else {
			msg = "비밀번호 불일치";
		}
		return msg;
	}
}






