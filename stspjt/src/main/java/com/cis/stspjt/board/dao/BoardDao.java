package com.cis.stspjt.board.dao;

import java.util.ArrayList;

import com.cis.stspjt.board.dto.Board;
import com.cis.stspjt.board.dto.BoardExt;

public interface BoardDao {
	public ArrayList<Board> boardList();
	public ArrayList<BoardExt> boardListExt(BoardExt boardExt);

}
