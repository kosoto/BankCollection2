package service;

import java.util.List;
import domain.*;
import java.util.Map;

public interface MemberService {
	public void createUser(UserBean user);
	public String login(MemberBean user);
	public void changePass(MemberBean member);
	public void deleteMember(MemberBean member);
	
}
