package serviceImpl;
import java.util.Map;
import java.util.*;
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
	public List<MemberBean> findByName(String name) {
		List<MemberBean> temp = new ArrayList<>();
		Set<MemberBean> set = new HashSet<>();
		for(Map.Entry<String, MemberBean> e : map.entrySet()) {
			if(name.equals(e.getValue().getName())) {
				set.add(e.getValue());	
			}
		}
		Iterator<MemberBean> it = set.iterator();
		while(it.hasNext()) { // 다음이 있으면 true 없으면 false
			temp.add(it.next());	
			
		}
		
		return temp;
	}

	@Override
	public MemberBean findById(MemberBean member) {
		System.out.println("찾는 아이디에 해당하는 이름:"+map.get(member.getUid()).getName());
		return map.get(member.getUid());
	}

	@Override
	public void changePass(MemberBean member) {
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

	@Override
	public int checkCount() {
		return map.size();
	}

	
	
	

}











