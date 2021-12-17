package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MutterList;
import model.Sample;

/**
 * Servlet implementation class Mutter
 */
@WebServlet("/Mutter")
public class Mutter extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mutter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		//modeは追加か削除かの選択肢
		int mode =Integer.parseInt(request.getParameter("mode"));

		//main.jspからきた情報をセットしてます。
		String text1 = request.getParameter("text");

		String date1 = request.getParameter("day");


		String id1 =request.getParameter("id");

		//ここで取得した情報で遷移先のメソッドより追加、削除していく

		Sample sample = new Sample();
		MutterList m = new MutterList(id1, text1, date1);
		sample.test(mode, m);
		//遷移先のメソッドよりToDoのリストを取得してきます。
		List<MutterList> mutterList = sample.execute(m);

		request.setAttribute("mutterList", mutterList);



		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dis.forward(request, response);



	}

}
