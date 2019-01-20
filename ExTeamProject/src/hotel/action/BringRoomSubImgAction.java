package hotel.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import hotel.dto.Room_imgDTO;
import hotel.service.BringRoomSubImgService;


@WebServlet("/whyare.hotellllllll")
public class BringRoomSubImgAction extends HttpServlet{

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		execute(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
		// TODO Auto-generated method stub
		
		try {
			resp.setContentType("text/html;charset=UTF-8");
			resp.getWriter().write(execute(req,resp));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 서브이미지를 들고옴 (ajax)
	public String execute(HttpServletRequest request, HttpServletResponse response)  {
		
		StringBuffer values = new StringBuffer("");
		int h_rno = Integer.parseInt(request.getParameter("h_rno"));
		System.out.println(h_rno);
		BringRoomSubImgService service = new BringRoomSubImgService();
		Room_imgDTO subimg = service.bringSubImg(h_rno);
		
		System.out.println("잘들어왔습니다");
		if(subimg == null){
			values.append("{\"imgname\":\"" +"왜안될까?" +"\"}");
		}else{
		values.append("{\"imgname\":\"" +subimg.getImgname() +"\",");
		values.append("\"imgpath\":\"" +subimg.getImgpath() +"\"}");
		}
		System.out.println(values);
		return values.toString();
	}

}
