package board.bean;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
	
}
