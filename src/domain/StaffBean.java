package domain;

public class StaffBean extends MemberBean{
	private String accessNum;

	public String getAccessNum() {
		return accessNum;
	}

	public void setAccessNum(String accessNum) {
		this.accessNum = accessNum;
	}
	
	@Override
	public String toString() {
		return "직원정보 \n 아이디:" + uid + "\n "
				+ "비밀번호: **** \n 이름:" + name + "\n "
				+ "주민번호:" + ssn + "\n 집주소:" + addr
				+ "\n 전화번호:" + phone + "\n 이메일:" + email +"\n"+ 
				"접근번호:"+accessNum;
	}
}
