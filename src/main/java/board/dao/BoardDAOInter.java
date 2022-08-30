package board.dao;

import java.util.List;

import board.vo.BoardVO;

public interface BoardDAOInter {

public int insert(BoardVO pb);
public int totalCount();
public List<BoardVO> pageList(int startRow, int endRow, int totalPage, int currentPage, int totalCount);
public BoardVO findOne(int idx);
public void readCountUp(int idx);
public int update(BoardVO board);
public int delete(int idx);
public Object replyInfo();
public int replyInsert(BoardVO board);

/*
public List<BoardVO> findAll();
public BoardVO findOne(int idx);
public int update(BoardVO pb);
public int delete(int idx);
public boolean exist(int idx);

*/
}
