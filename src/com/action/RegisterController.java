package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.entity.GridData;
import com.entity.Register;
import com.service.IRegisterService;

/**
 * @version 时间：2018年7月26日 上午10:09:42
 *
 */
@Controller
public class RegisterController {
	private IRegisterService irs;

	public RegisterController() {
		super();
	}

	public IRegisterService getIrs() {
		return irs;
	}
	@Autowired
	public void setIrs(IRegisterService irs) {
		this.irs = irs;
	}
//	@ResponseBody
	@RequestMapping("/RegisterAction")
	public void registerAction(HttpServletResponse response,String uname,String upwd,Byte sex,String cardNo,String email,Long mobile ) throws IOException{
		PrintWriter out = response.getWriter();
		Register  register = new Register();
		register.setUname(uname);
		register.setUpwd(upwd);
		register.setSex(sex);
		register.setCardNo(cardNo);
		register.setEmail(email);
		register.setMobile(mobile);
		int num = irs.insert(register);
		out.print("true");
		
		out.flush();
		out.close();
	}
//	@RequestMapping("/allDemo2")
//	public ModelAndView allDemo(ModelAndView mvo){
//		
//		List<Register> list = irs.selectAll();
//		Map map = new HashMap();
//		map.put("list", list);
//		mvo.addAllObjects(map);
//		mvo.addObject("list", list);
//		mvo.setViewName("editor");
//		return mvo;
//	}
	@ResponseBody
	@RequestMapping(value="/allAction",produces={"application/json;chart=UTF-8"})
	public Object allAction(String page,String rows,String sort,String order){
		List<Register> list = irs.selectAll();
		
		GridData dt = new GridData();
		dt.setTotal(list.size());// 如果是分页要放总记录数
		dt.setRows(list);
		
		String json = JSON.toJSONString(dt);
		System.out.println(" json = "+json);
		
		return json;
	}
	@ResponseBody
	@RequestMapping(value="/delRegister",produces={"application/json;chart=UTF-8"})
	public Object delRegister(Integer usidint){
		int num  = irs.deleteByPrimaryKey(usidint.intValue());
		
		String json = JSON.toJSONString(true);
		System.out.println(" json = "+json);
		
		return json;
	}
////	@ResponseBody
//	@RequestMapping("/AllAction")
//	public void allAction(HttpServletRequest request,HttpServletResponse response,Integer page,Integer rows,String sort,String order) throws IOException{
////        String pno = request.getParameter("page");
////        String psize = request.getParameter("rows");
////        System.out.println(" pno = "+pno);
////        System.out.println(" psize = "+psize);
//        
//        System.out.println("---------------------");
////        String sort = request.getParameter("sort");
////        String order = request.getParameter("order");
//        System.out.println(" sort = "+sort);
//        System.out.println(" order = "+order);
//        
//        int no = 1;
//        try {
////			no = Integer.parseInt(pno);
//			no = page.intValue();
//		} catch (Exception e) {
//			no = 1;
//		}
//        int pagesize = 10 ;
//        try {
////			pagesize = Integer.parseInt(psize);
//			pagesize = page.intValue();
//		} catch (Exception e) {
//			pagesize = 10 ;
//		}
//         
//		PrintWriter out = response.getWriter();
//		
//		GridData  gd = new GridData();
//		          gd.setTotal(30);
//		
//		List<Register> ulist = new ArrayList<Register>(); 
//		
//		if(order== null){
//			order = "asc";
//		}
//		
//		if("asc".equals(order)){
//			for(int i=(no-1)*pagesize;i<no*pagesize;i++){
//				Register temp = new Register(i, "tom"+i, "password"+i, Byte.valueOf("1"), "123456789123456789", "tom@236.com.cn", Long.valueOf("12312345678"));
//			    ulist.add(temp);
//			}
//		}else{
//			for(int i=no*pagesize;i>=(no-1)*pagesize;i--){
//				Register temp = new Register(i, "tom"+i, "password"+i, Byte.valueOf("1"), "123456789123456789", "tom@236.com.cn", Long.valueOf("12312345678"));
//			    ulist.add(temp);
//			}
//		}
//		
//		gd.setRows(ulist);
//		          
//		String js = JSON.toJSONString(gd);
//		System.out.println(" json = "+js);
//		
//		out.print(js);
//		
//		out.flush();
//		out.close();
//	}
}
