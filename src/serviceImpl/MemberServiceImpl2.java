package serviceImpl;
import java.util.List;
import java.lang.reflect.Member;
import java.util.ArrayList;
import domain.MemberBean;
import domain.StaffBean;
import domain.UserBean;
import service.*;

public class MemberServiceImpl2 implements MemberService2{
	List<MemberBean> list;
	
	public MemberServiceImpl2() {
		list = new ArrayList<MemberBean>();
	}
	
	@Override
	public void createUser(UserBean user) {
		user.setCreditRating("7등급");
		System.out.println("실행결과" + ((list.add(user))?"등록성공":"등록실패"));
	}

	@Override
	public void createStaff(StaffBean staff) {
		staff.setAccessNum("1234");
		System.out.println("실행결과" + ((list.add(staff))?"등록성공":"등록실패"));
	}

	@Override
	public List<MemberBean> list() {
		return list;
	}

	@Override
	public List<MemberBean> search(String param) {
		List<MemberBean> temp = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			if(param.equals(list.get(i).getName())) {
				temp.add(list.get(i));
			}
		}
		return temp;
	}

	@Override
	public MemberBean search(MemberBean member) {
		MemberBean temp = new MemberBean();
		for(int i=0;i<list.size();i++) {
			if(member.getUid().equals(list.get(i).getUid())) {
				temp = list.get(i);break;
			}
		}
		return temp;
	}

	@Override
	public void update(MemberBean member) {
		//search(member).setPass(member.getPass());
		MemberBean temp = new MemberBean();
		temp = search(member);
		list.remove(temp);
		temp.setPass(member.getPass());
		list.add(temp);
		//list.get(list.indexOf(search(member))).setPass(member.getPass());
	}

	@Override
	public void delete(MemberBean member) {
		//list.remove(list.indexOf(search(member)));
		list.remove(search(member));
		
	}

	
	
	

}











