package serviceImpl;
import domain.*;
import service.*;

import java.text.SimpleDateFormat;
import java.util.*;
public class AdminServiceImpl implements AdminService{
	private static AdminService instance = new AdminServiceImpl();
	public static AdminService getInstance() {return instance;}
	private AdminServiceImpl() {}

	List<MemberBean> memberList;
	List<AccountBean> accountList;
	
	@Override
	public void createStaff(StaffBean staff) {
		staff.setAccessNum("1234");
		memberList.add(staff);
		
	}

	@Override
	public List<MemberBean> memberList() {
		return memberList;
	}

	@Override
	public List<MemberBean> findMemberByName(String name) {
		List<MemberBean> temp = new ArrayList<>();
		Set<MemberBean> set = new HashSet<>();
		for(MemberBean e : memberList) {
			if(name.equals(e.getName())) {
				set.add(e);
			}
		}
		Iterator<MemberBean> it = set.iterator();
		while(it.hasNext()) {
			temp.add(it.next());
		}
		
		return temp;
	}

	@Override
	public MemberBean findMemberById(MemberBean member) {
		MemberBean temp = new MemberBean();
		for(MemberBean e : memberList) {
			if(member.getUid().equals(e.getUid())) {
				temp = e; break;
			}
		}
		return temp;
	}

	@Override
	public List<AccountBean> accountList() {
		return accountList;
	}

	@Override
	public List<AccountBean> findAccountByName(String name) {
		List<AccountBean> searchedList = new ArrayList<>();
		Set<AccountBean> set = new HashSet<>();
		for(AccountBean e : accountList) {
			if(name.equals(e.getName())) {
				set.add(e);
			}
		}
		Iterator<AccountBean> it = set.iterator();
		while(it.hasNext()) {
			searchedList.add(it.next());
		}
		return searchedList;
	}

	@Override
	public String createRandom(int start, int end) {
		return String.valueOf((int)(Math.random()*(end-start))+start);
	}

	@Override
	public String createDate() {
		return new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date());
	}

	@Override
	public String createAccountNo() {
		String temp = "";
		for(int i=0;i<11;i++) {
			if(i%4!=3) {
				temp += createRandom(0, 10);
			}else {
				temp += "-";
			}
		}
		return temp;
	}

	@Override
	public AccountBean findAccountById(AccountBean member) {
		AccountBean temp = new AccountBean();
		for(AccountBean e : accountList) {
			if(member.getUid().equals(e.getUid())) {
				temp = e; break;
			}
		}
		return temp;
	}

}
 