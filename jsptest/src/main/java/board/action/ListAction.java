package board.action;

import java.text.SimpleDateFormat;
import java.util.List;

import board.model.BoardDAO;
import board.model.BoardVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int pageSize = 10;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		// <수정2>
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		// 시작글번호
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;

		int count = 0;
		int number = 0;

		List<BoardVO> articleList = null;
		BoardDAO dbPro = BoardDAO.getInstance();
		count = dbPro.getArticleCount();// 전체글 수
		if (count > 0) {
			articleList = dbPro.getArticles(startRow, endRow);// 수정<3>
		}
		number = count - (currentPage - 1) * pageSize;// 수정<4>
		// 해당 뷰에서 사용할 속성 new Integer(currentpage) deprecated
		// new Integer(currentPage)=>currentPage 적어도 된다.
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("startRow", startRow);
		request.setAttribute("endRow", endRow);
		request.setAttribute("count", count);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("number", number);
		request.setAttribute("articleList", articleList);
		return "/board/list.jsp"; // 해당뷰
	}
}
