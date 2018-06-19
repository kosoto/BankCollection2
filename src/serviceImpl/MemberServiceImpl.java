package serviceImpl;
import domain.MemberBean;
import domain.StaffBean;
import domain.UserBean;
import service.*;

public class MemberServiceImpl implements MemberService{
	public MemberBean[] list;
	public int count;
	public MemberServiceImpl() {
		list = new MemberBean[10];
		count = 0;
	}
	
	@Override
	public void createUser(MemberBean member) {
		((UserBean) member).setCreditRating("7");
		list[count++] = member;
	}
	
	@Override
	public void createStaff(MemberBean member) {
		((StaffBean) member).setAccessNum("1234");
		list[count++] = member;
	}

	@Override
	public MemberBean[] list() {
		return list;
	}

	@Override
	public MemberBean findById(MemberBean member) {
		String id = member.getUid();
		String pass = member.getPass();
		MemberBean serchedMember = new MemberBean();
		for(int i=0;i<count;i++) {
			if(id.equals(list[i].getUid())
					&&
				pass.equals(list[i].getPass())
					) {
				serchedMember = list[i];
				break;
			}
		}
		return serchedMember;
	}

	@Override
	public MemberBean[] findByName(String name) {
		int num = 0;
		for(int i=0;i<count;i++) {
			if(name.equals(list[i].getName())) {
				num++;
			}
		}
		MemberBean[] members = new MemberBean[num];
		
		for(int i=0,j=0;i<count&&j<num;i++) {
			if(name.equals(list[i].getName())) {
				members[j++] = list[i];
			}
		}
		return members;
	}

	@Override
	public int checkCount() {
		return count;
	}

	@Override
	public String withdraw(MemberBean member) {
		String msg = "";
		String id = member.getUid();
		String pass = member.getPass().split("/")[0];
		String confirmPass = member.getPass().split("/")[1];
		member.setPass(pass);
		if(pass.equals(confirmPass)) {
			for(int i=0;i<count;i++) {
				if(id.equals(list[i].getUid()) &&
					pass.equals(list[i].getPass())
							){
						list[i] = list[--count];
						list[count]=null;
						msg = "삭제완료";
						break;
					}else {
						msg = "일치하는 정보가 없음";
					}	
			}
		}else {
			msg = "비밀번호가 일치하지 않음";
		}
		return msg;
	}

	@Override
	public String changePass(MemberBean member) {
		String msg = "";
		String id = member.getUid();
		String pass = member.getPass().split("/")[0];
		String newPass = member.getPass().split("/")[1];
		member.setPass(pass);
		if(!pass.equals(newPass)) {
			for(int i=0;i<count;i++) {
				if(id.equals(list[i].getUid()) &&
					pass.equals(list[i].getPass())
						) {
					list[i].setPass(newPass);
					msg = "비밀번호 변경 성공";
					break;
				}else {
					msg = "정보가 없습니다.";
				}
			}
			
		}else {
			msg = "새로운 비밀번호가 아닙니다.";
		}
		return msg;
	}

	
	
	

}











