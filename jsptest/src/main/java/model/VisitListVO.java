package model;

//import java.util.Date;
import java.util.Objects;

public class VisitListVO {

	private int no; // 일련번호
	private String writer; // 글쓴이
	private String memo; // 메모
	private String regdate; // 날짜
	
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(this.no);
	}
	@Override
	public boolean equals(Object obj) {
		VisitListVO visit = null;
		if(!(obj instanceof VisitListVO)) {
			return false;
		}
		visit = (VisitListVO)obj;
		return this.no==visit.no;
	}
	@Override
	public String toString() {
		return "VisitVO [no=" + no + ", writer=" + writer + ", memo=" + memo + ", regdate=" + regdate + "]";
	}
	
	
	
	


}
