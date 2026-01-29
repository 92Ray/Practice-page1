package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Board read(Board board) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modify(Board board) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(Board board) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Board> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Board> search(String searchType, String keyword) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
