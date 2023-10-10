package DB;

public class Member {
	private String id=null;
	private String pwd=null;
	private String tel=null;
	private String name=null;
	private String showtype=null;
	private int month=0;
	private int day=0;
	private int inning=0;
	private String area=null;
	private String payment=null;
	private String bank=null;
	private int amount=0;
	private int seatnum=0;
	public String getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}
	public String getTel() {
		return tel;
	}
	public String getName() {
		return name;
	}
	public String getShowtype() {
		return showtype;
	}
	public int getMonth() {
		return month;
	}
	public int getDay() {
		return day;
	}
	public int getInning() {
		return inning;
	}
	public String getArea() {
		return area;
	}
	public String getPayment() {
		return payment;
	}
	public int getAmount() {
		return amount;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setShowtype(String showtype) {
		this.showtype = showtype;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public void setInning(int inning) {
		this.inning = inning;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}	
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getBank() {
		return bank;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getSeatnum() {
		return seatnum;
	}
	public void setSeatnum(int seatnum) {
		this.seatnum = seatnum;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", tel=" + tel + ", name="
				+ name + ", showtype=" + showtype + ", month=" + month
				+ ", day=" + day + ", inning=" + inning + ", area=" + area
				+ ", payment=" + payment + ", bank=" + bank + ", amount="
				+ amount + ", seatnum=" + seatnum + "]";
	}
	
}
