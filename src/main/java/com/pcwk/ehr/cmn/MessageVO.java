package com.pcwk.ehr.cmn;

public class MessageVO extends DTO {
	private String msgId;//메시지 id
	private String msgContents; //세미지
	
	public MessageVO() {}

	public MessageVO(String megId, String msgContents) {
		super();
		this.msgId = megId;
		this.msgContents = msgContents;
	}

	public String getMegId() {
		return msgId;
	}

	public void setMegId(String megId) {
		this.msgId = megId;
	}

	public String getMsgContents() {
		return msgContents;
	}

	public void setMsgContents(String msgContents) {
		this.msgContents = msgContents;
	}

	@Override
	public String toString() {
		return "MessageVO [megId=" + msgId + ", msgContents=" + msgContents + "]";
	}
	
	
}
