package service;

import java.util.List;
import domain.*;
import java.util.Map;

public interface MemberService {
	public void createUser(UserBean user);
	public void createStaff(StaffBean staff);
	public Map<String,MemberBean> list();
	public Map<String,MemberBean> findByName(String name);
	public MemberBean findById(MemberBean member);
	public void updatePassword(MemberBean member);
	public void deleteMember(MemberBean member);
	
}
