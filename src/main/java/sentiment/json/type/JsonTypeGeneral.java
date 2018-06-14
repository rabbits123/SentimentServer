package sentiment.json.type;

public class JsonTypeGeneral {
	private int numPos = 0;
	private int numNeu = 0;
	private int numNeg = 0;
	
	private int numLec = 0;
	private int numCur = 0;
	private int numfac = 0;
	private int numOth = 0;
	
	private int CurNeg = 0;
	private int CurNeu = 0;
	private int CurPos = 0;
	private int LecNeg = 0;
	private int LecNeu = 0;
	private int LecPos = 0;
	private int FacNeg = 0;
	private int FacNeu = 0;
	private int FacPos = 0;
	private int OthNeg = 0;
	private int OthNeu = 0;
	private int OthPos = 0;
	
	
	public JsonTypeGeneral(int numPos, int numNeu, int numNeg, int numLec, int numCur, int numfac, int numOth, int curNeg,
			int curNeu, int curPos, int lecNeg, int lecNeu, int lecPos, int facNeg, int facNeu, int facPos, int othNeg,
			int othNeu, int othPos) {
		super();
		this.numPos = numPos;
		this.numNeu = numNeu;
		this.numNeg = numNeg;
		this.numLec = numLec;
		this.numCur = numCur;
		this.numfac = numfac;
		this.numOth = numOth;
		CurNeg = curNeg;
		CurNeu = curNeu;
		CurPos = curPos;
		LecNeg = lecNeg;
		LecNeu = lecNeu;
		LecPos = lecPos;
		FacNeg = facNeg;
		FacNeu = facNeu;
		FacPos = facPos;
		OthNeg = othNeg;
		OthNeu = othNeu;
		OthPos = othPos;
	}

	public JsonTypeGeneral() {
		
	}

	public int getNumPos() {
		return numPos;
	}
	public void setNumPos() {
		this.numPos += 1;
	}
	public int getNumNeu() {
		return numNeu;
	}
	public void setNumNeu() {
		this.numNeu += 1;
	}
	public int getNumNeg() {
		return numNeg;
	}
	public void setNumNeg() {
		this.numNeg += 1;
	}
	public int getNumLec() {
		return numLec;
	}
	public void setNumLec() {
		this.numLec += 1;
	}
	public int getNumCur() {
		return numCur;
	}
	public void setNumCur() {
		this.numCur += 1;
	}
	public int getNumfac() {
		return numfac;
	}
	public void setNumfac() {
		this.numfac += 1;
	}
	public int getNumOth() {
		return numOth;
	}
	public void setNumOth() {
		this.numOth += 1;
	}
	public int getCurNeg() {
		return CurNeg;
	}
	public void setCurNeg() {
		CurNeg +=1 ;
	}
	public int getCurNeu() {
		return CurNeu;
	}
	public void setCurNeu() {
		CurNeu +=1 ;
	}
	public int getCurPos() {
		return CurPos;
	}
	public void setCurPos() {
		CurPos +=1 ;
	}
	public int getLecNeg() {
		return LecNeg;
	}
	public void setLecNeg() {
		LecNeg +=1 ;
	}
	public int getLecNeu() {
		return LecNeu;
	}
	public void setLecNeu() {
		LecNeu += 1;
	}
	public int getLecPos() {
		return LecPos;
	}
	public void setLecPos( ) {
		LecPos += 1;
	}
	public int getFacNeg() {
		return FacNeg;
	}
	public void setFacNeg( ) {
		FacNeg += 1;
	}
	public int getFacNeu() {
		return FacNeu;
	}
	public void setFacNeu( ) {
		FacNeu += 1;
	}
	public int getFacPos() {
		return FacPos;
	}
	public void setFacPos() {
		FacPos += 1;
	}
	public int getOthNeg() {
		return OthNeg;
	}
	public void setOthNeg() {
		OthNeg += 1;
	}
	public int getOthNeu() {
		return OthNeu;
	}
	public void setOthNeu( ) {
		OthNeu += 1;
	}
	public int getOthPos() {
		return OthPos;
	}
	public void setOthPos( ) {
		OthPos += 1;
	}
	
	
}
