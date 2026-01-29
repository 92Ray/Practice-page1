package com.board.domain;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
// Entity와 Oracle을 연속성 연결
@SequenceGenerator(
		name="JPABOARD_SEQ_GEN",
		sequenceName = "JPABOARD_SEQ",
		initialValue = 1,
		allocationSize = 1)

@Table(name="JPABOARD")
public class Board {
	@Id //프라이머리 키
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JPABOARD_SEQ_GEN")
	// 제네레이터의 시퀀스를 쓸 것이며, 시퀀스를 써서 1씩 증가시키겠다는 선언.
	
	@Column(name = "NO")
	private Long no;
	
	@Column(name = "TITLE")
	private String title;
	@Column(name = "CONTENT")
	private String content;
	@Column(name = "WRITER")
	private String writer;

	//SYSDATE
	@CreationTimestamp
	@Column(name = "REGDATE")
	private Date regDate;
	
	
}
