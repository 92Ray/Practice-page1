package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.board.domain.Board;
import com.board.repository.BoardRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepository boardRepository;

	@Override
	@jakarta.transaction.Transactional
	public int register(Board b) throws Exception {
		Board board = boardRepository.save(b);
		return (board != null) ? 1: 0;
		
	}

	@Override
	@Transactional(readOnly = true) //트랜잭션 처리 하지 말고 읽기만 하라는 뜻
	public Board read(Board b) throws Exception {
		return boardRepository.getReferenceById(b.getNo());
	}

	@Override
	@Transactional
	public int modify(Board b) throws Exception {
		Board board = boardRepository.getReferenceById(b.getNo());
		board.setContent(b.getContent());
		board.setTitle(b.getTitle());
		board.setWriter(b.getWriter());
		return board != null ? 1 : 0;
	}

	@Override
	public int remove(Board board) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Board> list() throws Exception {
		List<Board> boardList = boardRepository.findAll(Sort.by(Direction.DESC, "no"));
		return boardList;
	}

	@Override
	public List<Board> search(String searchType, String keyword) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
