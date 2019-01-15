package com.ktds.notice.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.ktds.notice.vo.NoticeCommentVO;
import com.ktds.notice.vo.NoticeVO;

@Repository
public class NoticeDaoServiceImpl implements NoticeDaoService {

	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;

	@Override
	public int getArticleCount() {
		// 글의 개수가 얼마나 있는지 넘겨줌
		return (int) sqlMapClientTemplate.queryForObject("notice_getArticleCount");
		// ktds_bbs.xml에서 해당 id를 갖는 것을 찾아 쿼리문을 실행시킨다.
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NoticeVO> getArticles(int startRow, int endRow) {
		// 리스트에 보여줄 모든 항목들을 넘겨주는 메서드(ArrayList를 넘겨준다)
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("startRow", startRow);
		hm.put("endRow", endRow);
		return sqlMapClientTemplate.queryForList("notice_getArticles", hm);
	}

	@Override
	public void insertArticle(NoticeVO article) {
		// 데이터 삽입 메서드
		sqlMapClientTemplate.insert("notice_insertArticle", article);
	}

	@Override
	public NoticeVO getArticle(int article_num) {
		// 글번호에 맞는 글 내용을 가져오는 메서드
		return (NoticeVO) sqlMapClientTemplate.queryForObject("notice_getArticle", article_num);
	}

	@Override
	public void reply(NoticeVO article) {
		// 답글을 달았을 때 답글이 달리는 글의 position값 1 증가 및 재정렬
		sqlMapClientTemplate.update("notice_replyUpdate", article);

		// 댓글도 글을 넣는 것과 같은 형태(depth와 pos는 1씩 증가된다)
		sqlMapClientTemplate.insert("notice_reply", article);
	}

	@Override
	public NoticeVO getUpdateArticle(int article_num) {
		// 글 수정을 위한 메서드
		return (NoticeVO) sqlMapClientTemplate.queryForObject("notice_getUpdateArticle", article_num);
	}

	@Override
	public void UpdateArticle(int article_num, String title, String content) {
		// 글수정을 한 뒤 해당 레코드를 갱신해주는 메서드
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("article_num", article_num);
		hm.put("title", title);
		hm.put("content", content);
		sqlMapClientTemplate.update("notice_UpdateArticle", hm);
	}

	@Override
	public void deleteArticle(int article_num) {
		// 글 삭제를 위한 메서드(게시판 테이블과 게시판을 위한 댓글 테이블에 해당 글번호를 갖는 모든 레코드를 삭제한다)
		sqlMapClientTemplate.delete("notice_deleteArticle", article_num);
//			smct.delete("deleteComment", article_num);
	}

	@Override
	public int getCommentNum(int article_num) {
		// 댓글 개수를 가져오는 메서드
		return (int) sqlMapClientTemplate.queryForObject("notice_getCommentNum", article_num);
	}

	@Override
	public void addHit(int article_num) {
		// 조회수를 늘려주는 메서드(접속한 아이디와 글쓴이가 다르면 hit를 1추가한다)
		sqlMapClientTemplate.update("notice_addHit", article_num);
	}

	@Override
	public List<NoticeCommentVO> insertComment(int article_num, String comment_content, String id) {
		// 댓글을 입력할 때 댓글 관리 테이블에 값을 입력하는 메서드
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("article_num", article_num);
		hm.put("comment_content", comment_content);
		hm.put("id", id);
		sqlMapClientTemplate.insert("notice_insertComment", hm);
		return getAllComment(article_num);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NoticeCommentVO> getAllComment(int article_num) {
		// 모든 댓글을 자바스크립트로 보여주는 메서드
		return sqlMapClientTemplate.queryForList("notice_getAllComment", article_num);
	}
}
