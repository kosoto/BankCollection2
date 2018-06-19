package service;

import domain.MemberBean;

public interface MemberService {

	public void createUser(MemberBean member);

	public MemberBean[] list();

	public MemberBean findById(MemberBean member);

	public MemberBean[] findByName(String name);

	public int checkCount();

	public void createStaff(MemberBean member);

	public String withdraw(MemberBean member);

	public String changePass(MemberBean member);

}
