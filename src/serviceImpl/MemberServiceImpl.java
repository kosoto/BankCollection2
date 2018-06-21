package serviceImpl;
import java.util.Map;
import java.lang.reflect.Member;
import java.util.HashMap;
import domain.*;
import service.*;

public class MemberServiceImpl implements MemberService{
	Map<String,MemberBean> map;
	
	public MemberServiceImpl() {
		map = new HashMap<>();
	}
	
	@Override
	public void createUser(UserBean user) {
		user.setCreditRating("7등급");
		map.put(user.getUid(),user);
	}

	@Override
	public void createStaff(StaffBean staff) {
		staff.setAccessNum("1234");
		map.put(staff.getUid(),staff);
	}

	@Override
	public Map<String,MemberBean> list() {
		return map;
	}

	@Override
	public Map<String,MemberBean> findByName(String name) {
		Map<String,MemberBean> temp = new HashMap<>();
		for(String key : map.keySet()) {
			if(name.equals(map.get(key).getName())) {
				temp.put(key, map.get(key));
			}
		}
		
		return temp;
	}

	@Override
	public MemberBean findById(MemberBean member) {
		System.out.println("찾는 아이디에 해당하는 이름:"+map.get(member.getUid()).getName());
		return map.get(member.getUid());
	}

	@Override
	public void updatePassword(MemberBean member) {
		String id = member.getUid();
		String pass = member.getPass().split("/")[0];
		String newPass = member.getPass().split("/")[1];
		MemberBean mem = map.get(member.getUid());
		if(mem == null) {
			System.out.println("수정하려는 ID가 없음");
		}else{
			if(pass.equals(mem.getPass())){
				mem.setPass(newPass);
				map.put(id, mem);
				
			}	
		}
		
		//map.get(member.getUid()).setPass(member.getPass());
	}

	@Override
	public void deleteMember(MemberBean member) {
		map.remove(findById(member));
		
	}

	
	
	

}











