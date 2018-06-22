package repositoryImpl;

import java.util.List;

import domain.AccountBean;
import repository.AccountDAO;

public class AccountDAOImpl implements AccountDAO{
	private static AccountDAO instance = new AccountDAOImpl();
	public static AccountDAO getInstance() {return instance;}
	private AccountDAOImpl() {};

	@Override
	public void insertAccount(AccountBean account) {
		System.out.println("==========DAO 서비스==============");
		System.out.println("서비스에서 넘어온 객체:"+account);
		
	}

	@Override
	public List<AccountBean> selectAccountList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountBean> selectAccountByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountBean selectAccountById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countAccounts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateAccount(AccountBean account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccount(AccountBean account) {
		// TODO Auto-generated method stub
		
	}

}
