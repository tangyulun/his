package com.ssh.vo.instrument;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Id;

public class LingyongHuizonXqVo {
	
	private long qxUseqxId;

	
	private String qxUseqxBeizu;

	
	private BigDecimal qxUseqxJcshul;

	
	private BigDecimal qxUseqxLyshul;

	
	private BigDecimal qxUseqxPihao;
	
	private InstrumentVo instrument;
	
	private LingyongVo Use;

	public long getQxUseqxId() {
		return qxUseqxId;
	}

	public void setQxUseqxId(long qxUseqxId) {
		this.qxUseqxId = qxUseqxId;
	}

	public String getQxUseqxBeizu() {
		return qxUseqxBeizu;
	}

	public void setQxUseqxBeizu(String qxUseqxBeizu) {
		this.qxUseqxBeizu = qxUseqxBeizu;
	}

	public BigDecimal getQxUseqxJcshul() {
		return qxUseqxJcshul;
	}

	public void setQxUseqxJcshul(BigDecimal qxUseqxJcshul) {
		this.qxUseqxJcshul = qxUseqxJcshul;
	}

	public BigDecimal getQxUseqxLyshul() {
		return qxUseqxLyshul;
	}

	public void setQxUseqxLyshul(BigDecimal qxUseqxLyshul) {
		this.qxUseqxLyshul = qxUseqxLyshul;
	}

	public BigDecimal getQxUseqxPihao() {
		return qxUseqxPihao;
	}

	public void setQxUseqxPihao(BigDecimal qxUseqxPihao) {
		this.qxUseqxPihao = qxUseqxPihao;
	}

	public InstrumentVo getInstrument() {
		return instrument;
	}

	public void setInstrument(InstrumentVo instrument) {
		this.instrument = instrument;
	}

	public LingyongVo getUse() {
		return Use;
	}

	public void setUse(LingyongVo use) {
		Use = use;
	}

	public LingyongHuizonXqVo(long qxUseqxId, String qxUseqxBeizu, BigDecimal qxUseqxJcshul, BigDecimal qxUseqxLyshul,
			BigDecimal qxUseqxPihao) {
		super();
		this.qxUseqxId = qxUseqxId;
		this.qxUseqxBeizu = qxUseqxBeizu;
		this.qxUseqxJcshul = qxUseqxJcshul;
		this.qxUseqxLyshul = qxUseqxLyshul;
		this.qxUseqxPihao = qxUseqxPihao;
	}

	public LingyongHuizonXqVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
