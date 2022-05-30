package board.bean;

public class BoardDTO {
	
	private long seq;
	private String id;
	private String name;
	private String email;
	private String subject;
	private String content;
	private long ref;
	private long lev;
	private long step;
	private long pseq;
	private long reply;
	private long hit;
	private String logtime;
	public long getSeq() {
		return seq;
	}
	public void setSeq(long seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getRef() {
		return ref;
	}
	public void setRef(long ref) {
		this.ref = ref;
	}
	public long getLev() {
		return lev;
	}
	public void setLev(long lev) {
		this.lev = lev;
	}
	public long getStep() {
		return step;
	}
	public void setStep(long step) {
		this.step = step;
	}
	public long getPseq() {
		return pseq;
	}
	public void setPseq(long pseq) {
		this.pseq = pseq;
	}
	public long getReply() {
		return reply;
	}
	public void setReply(long reply) {
		this.reply = reply;
	}
	public long getHit() {
		return hit;
	}
	public void setHit(long hit) {
		this.hit = hit;
	}
	public String getLogtime() {
		return logtime;
	}
	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}

	
}
