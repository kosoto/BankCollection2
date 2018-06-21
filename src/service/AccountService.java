package service;
import java.util.Map;
import domain.*;

public interface AccountService {
	public void creataAccount(AccountBean account);
	public void creataMinus(MinusAccountBean account);
	public Map<String,AccountBean> list();
	public Map<String,AccountBean> findByName(String word);
	public AccountBean findById(AccountBean account);
	public void updatePassword(AccountBean account);
	public void deleteAccount(AccountBean account);
	
}
