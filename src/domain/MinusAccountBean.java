package domain;

public class MinusAccountBean extends AccountBean{
	public final static String ACCOUNT_TYPE="마이너스통장";
	public int limit; //대출한도
	
	public void setLimit(String limit) {
		this.limit=Integer.parseInt(limit);
	}
	
	public int getLimit() {
		return limit;
	}
	
	public String toString() {
		return String.format(
				"%s \n %s \n 계좌번호 : %s \n 이름 : %s \n ID : %s \n 비밀번호 : %s \n "
				+ "생성일 : %s \n 잔액 : %s 원 \n 대출한도 : %s ",
				BANK_NAME,
				ACCOUNT_TYPE,
				accountNo,
				name,
				uid,
				"****",
				createDate,
				money,
				limit
				); 
	}
}
