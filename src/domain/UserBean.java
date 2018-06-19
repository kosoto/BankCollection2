package domain;

public class UserBean extends MemberBean{
	protected String creditRating;

	public String getCreditRating() {
		return creditRating;
	}

	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
	}
	
	@Override
	public String toString() {
		return "회원정보 \n 아이디:" + uid + "\n "
				+ "비밀번호: **** \n 이름:" + name + "\n "
				+ "주민번호:" + ssn + "\n 집주소:" + addr
				+ "\n 전화번호:" + phone + "\n 이메일:" + email +"\n"+ 
				"신용등급:"+creditRating;
	}
}
