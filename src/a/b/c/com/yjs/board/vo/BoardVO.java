package a.b.c.com.yjs.board.vo;

public class BoardVO {

	/*
	 BoardVO property 이름은!
	 = Client Side Script form tag name
	 = DB table's column name
	 	단, property 이름은 소문자, column 이름은 대문자!
	*/
	private String bnum;
	private String bsubject;
	private String bwriter;
	private String bcontents;
	private String bpw;
	private String bphoto;
	private String deleteyn;
	private String insertdate;
	private String updatedate;
	
	public BoardVO(){}
	
	public BoardVO(String bnum, String bsubject, String bwriter
				 , String bcontents, String bpw, String bphoto
				 , String deleteyn, String insertdate, String updatedate) {
		this.bnum = bnum;
		this.bsubject = bsubject;
		this.bwriter = bwriter;
		this.bcontents = bcontents;
		this.bpw = bpw;
		this.bphoto = bphoto;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
	}

	// setter()
	public String getBnum() {
		return bnum;
	}

	public String getBsubject() {
		return bsubject;
	}

	public String getBwriter() {
		return bwriter;
	}

	public String getBcontents() {
		return bcontents;
	}

	public String getBpw() {
		return bpw;
	}

	public String getBphoto() {
		return bphoto;
	}

	public String getDeleteyn() {
		return deleteyn;
	}

	public String getInsertdate() {
		return insertdate;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	// setter()
	public void setBnum(String bnum) {
		this.bnum = bnum;
	}

	public void setBsubject(String bsubject) {
		this.bsubject = bsubject;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public void setBcontents(String bcontents) {
		this.bcontents = bcontents;
	}

	public void setBpw(String bpw) {
		this.bpw = bpw;
	}

	public void setBphoto(String bphoto) {
		this.bphoto = bphoto;
	}

	public void setDeleteyn(String deleteyn) {
		this.deleteyn = deleteyn;
	}

	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	
	public static void printBoardVO(BoardVO bvo){
		System.out.print(bvo.getBnum() + " : ");
		System.out.print(bvo.getBsubject() + " : ");
		System.out.print(bvo.getBwriter() + " : ");
		System.out.print(bvo.getBcontents() + " : ");
		System.out.print(bvo.getBpw() + " : ");
		System.out.print(bvo.getDeleteyn() + " : ");
		System.out.print(bvo.getInsertdate() + " : ");
		System.out.print(bvo.getUpdatedate() + " : ");
	}
	
	public static void printlnBoardVO(BoardVO bvo){
		System.out.println(bvo.getBnum() + " : ");
		System.out.println(bvo.getBsubject() + " : ");
		System.out.println(bvo.getBwriter() + " : ");
		System.out.println(bvo.getBcontents() + " : ");
		System.out.println(bvo.getBpw() + " : ");
		System.out.println(bvo.getDeleteyn() + " : ");
		System.out.println(bvo.getInsertdate() + " : ");
		System.out.println(bvo.getUpdatedate() + " : ");		
	}
} // end of BoardVO
