package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import domain.*;
import service.AccountService;

public class AccountServiceImpl implements AccountService{
	AccountBean[] list;
	int count;
	
	
	public AccountServiceImpl() {
		list = new AccountBean[10000];
		count=0;
	}
	
	@Override
	public void createAccount(AccountBean account) {
		account.setAccountType(account.ACCOUNT_TYPE);
		account.setAccountNo(createAccountNum());
		account.setCreateDate(createDate());
		addList(account);
	}
	
	@Override
	public void createMinusAccount(MinusAccountBean minusAccount) {
		createAccount(minusAccount);
		minusAccount.setAccountType(minusAccount.ACCOUNT_TYPE);
		/*minusAccount.setAccountNo(createAccountNum());
		minusAccount.setCreateDate(createDate());*/
		//addList(minusAccount);
		
		
		minusAccount.setAccountType(minusAccount.ACCOUNT_TYPE);
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
		for(int i=0,j=0;i<count&& j+1<count;i++) {
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
			if(word.equals(list[i].getName())) {
				number++; 
			}
		}
		return number;
	}
	
	public AccountBean[] findMinusAccounts() {
		int countMinusAccounts = countMinusAccounts();
		AccountBean[] minusAccounts = new MinusAccountBean[countMinusAccounts];
		int j=0;
		for(int i=0;i<count && j+1<countMinusAccounts;i++) {
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
	public String showResult(AccountBean[] list) {
		String result="";
		for(int i=0;i<Math.min(count, list.length);i++) {
			result += list[i].toString()+"\n";
		}
		return result;
	}
	 
/*	@Override
	public String toString(AccountBean account) {
		return String.format(
				"%s \n %s \n 계좌번호 : %s \n 이름 : %s \n 생성일 : %s \n 잔액 : %s 원 ",
				account.BANK_NAME,
				account.getAccountType(),
				account.getAccountNo(),
				account.getName(),
				account.getCreateDate(),
				account.getMoney() 
				);
	}
*/
}
