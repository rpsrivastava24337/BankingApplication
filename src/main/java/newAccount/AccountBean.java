package newAccount;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AccountBean implements Serializable {

	private String uname, pwd, addr, phone ,accNo;
	private int amt;

	@Override
	public String toString() {
		return "AccountBean [uname=" + uname + ", pwd=" + pwd + ", amt=" + amt + ", addr=" + addr + ", phone=" + phone
				+ ", accNo=" + accNo + "]";
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getAmt() {
		return amt;
	}

	public void setAmt(int amt) {
		this.amt = amt;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public AccountBean() {
		// TODO Auto-generated constructor stub
	}

}
