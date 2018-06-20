package service;
import java.util.List;
import domain.*;

public interface AccountService {
	public void creataAccount(AccountBean account);
	public List<AccountBean> list();
	public List<AccountBean> search(String word);
	public AccountBean search(AccountBean account);
	public void update(AccountBean account);
	public void delete(AccountBean account);
	
}
