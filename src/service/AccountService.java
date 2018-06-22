package service;
import java.util.Map;
import java.util.List;
import domain.*;

public interface AccountService {
	public void createAccount(AccountBean account);
	public void createMinus(MinusAccountBean account);
	public AccountBean findById(AccountBean account);
	public void changePass(AccountBean account);
	public void deleteAccount(AccountBean account);
}
