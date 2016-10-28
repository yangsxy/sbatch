package cn.yuan.http;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/http")
public class HttpResponseHeaderController implements CommandLineRunner,Ordered {

	@RequestMapping("/refresh")
	public void randCodeImage(HttpServletResponse response) throws IOException{
		
		response.setHeader("refresh", "5;url=http://www.baidu.com");
		BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
		
		  Graphics2D g = (Graphics2D)image.getGraphics();
		   g.setColor(Color.WHITE);//设置图片的背景色
		   g.fillRect(0, 0, 80, 20);//填充背景色
		   //3.向图片上写数据
		   g.setColor(Color.BLUE);//设置图片上字体的颜色
		   g.setFont(new Font(null, Font.BOLD, 20));
		   g.drawString(makeNum(), 0, 20);
		   //4.设置响应头控制浏览器浏览器以图片的方式打开
		   response.setContentType("image/jpeg");//等同于response.setHeader("Content-Type", "image/jpeg");
		   //5.设置响应头控制浏览器不缓存图片数据
		   response.setDateHeader("Expries", -1);
		   response.setHeader("Cache-Control", "no-cache");
		   response.setHeader("Pragma", "no-cache");
		   //6.将图片写给浏览器
		   ImageIO.write(image, "jpg", response.getOutputStream());
	}
	@RequestMapping("/down")
	public void downSomething(HttpServletResponse response) throws IOException{
		response.setHeader("content-disposition", "attachment;filename=hell.txt");
		PrintWriter writer = response.getWriter();
		writer.write("你好，啦啦啦");
	}
	@RequestMapping("/print")
	public void printContent(HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
//		ServletOutputStream out = response.getOutputStream();
//		out.write("你好，啦啦啦鸡".getBytes("UTF-8"));
		response.setContentType("text/html;charset=UTF-8");
//		或out.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'/>");
		out.write("你好，啦啦啦鸡");
	}
	 /**
	 * 生成随机数字
	 * @return
	 */
	private String makeNum(){
	    Random random = new Random();
	    String num = random.nextInt(9999999)+"";
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < 7-num.length(); i++) {
	        sb.append("0");
	    }
	    num = sb.toString()+num;
	    return num;
	}
	/**
	 * 项目启动时执行
	 */
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("~~~~~~~~~~~~~~~~hello,I'm commandLineRunner!!-order  10~~~");
	}
	/**
	 * 项目启动时执行顺序
	 */
	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@RequestMapping("/velocity")
	public String velocityTest(Model model){
		System.out.println("____________velocity Test_________");
		model.addAttribute("status", 500);
		model.addAttribute("msg","出错啦啦啦！！！！");
		return "velocityHello";
	}
	
	
}
