package com.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.board.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

	List<Board> findByContentContaining(String keyword);
	// Board 임포트 시키고 Long은 ID의 타입을 기입.(이 경우 long이라는 정수형 연산자)

	List<Board> findByWriterContaining(String keyword);

	List<Board> findByTitleContaining(String keyword);

}
