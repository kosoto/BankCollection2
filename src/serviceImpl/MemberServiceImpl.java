package serviceImpl;
import java.util.*;
import domain.*;
import repository.*;
import repositoryImpl.*;
import service.*;

public class MemberServiceImpl implements MemberService{
	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getInstance() {return instance;}
	private MemberServiceImpl() {}
	
	Map<String,MemberBean> map;
	
	@Override
	public void createUser(UserBean member) {
		System.out.println("==========멤버 서비스==============");
		System.out.println("컨트롤러에서 넘어온 객체:"+member);
		member.setCreditRating("7등급");
		MemberDAOImpl.getInstance().insertMember(member);

	}

	



	@Override
	public String login(MemberBean user) {
		//System.out.println("찾는 아이디에 해당하는 이름:"+map.get(member.getUid()).getName());
		return "";
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
	//	map.remove(findById(member));
		
	}


	
	
	

}











