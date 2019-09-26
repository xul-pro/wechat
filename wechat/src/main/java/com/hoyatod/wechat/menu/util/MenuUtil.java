package com.hoyatod.wechat.menu.util;

import java.io.IOException;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.hoyatod.util.commom.GsonUtil;
import com.hoyatod.util.commom.HTTPUtil;
import com.hoyatod.util.commom.OkhttpUtil;
import com.hoyatod.util.commom.State;
import com.hoyatod.util.commom.WeiXinSDK;
import com.hoyatod.wechat.menu.entity.Button;
import com.hoyatod.wechat.menu.entity.ComplexButton;
import com.hoyatod.wechat.menu.entity.Menu;
import com.hoyatod.wechat.menu.entity.ViewButton;

public class MenuUtil {
	/**
	 * 封装菜单数据
	 */
	public static Menu getMenu() {
		// 首先创建二级菜单 CommonButton 类型
		ViewButton cb_1 = new ViewButton();
		cb_1.setName("理财专区");
		cb_1.setType("view");
		cb_1.setUrl("http://xyyh.inrice.cn/Wealth/index.aspx");
		ViewButton cb_2 = new ViewButton();
		cb_2.setName("兴油卡");
		cb_2.setType("view");
		cb_2.setUrl("http://xyyh.inrice.cn/XingBao/index.aspx");
		ViewButton cb_3 = new ViewButton();
		cb_3.setName("礼仪存单");
		cb_3.setType("view");
		cb_3.setUrl("https://e.cib.com.cn/app/mobile/depositProduct/depositProduct.do");
		ViewButton cb_4 = new ViewButton();
		cb_4.setName("多元金融");
		cb_4.setType("view");
		cb_4.setUrl("https://g.cib.com.cn/mobile?from=B9");
		
		// 创建第一个一级菜单
		ComplexButton cx_1 = new ComplexButton();
		cx_1.setName("财富增值区");
		cx_1.setSub_button(new Button[] { cb_1, cb_2 ,cb_3,cb_4});

		
		ViewButton cb_5 = new ViewButton();
		cb_5.setName("安愉人生");
		cb_5.setType("view");
		cb_5.setUrl("https://xpension.cibfintech.com/xpension");
		ViewButton cb_6 = new ViewButton();
		cb_6.setName("寰宇人生");
		cb_6.setType("view");
		cb_6.setUrl("https://www.cib.com.cn/cn/minipage/sdrs/UniversalLife.html");
		ViewButton cb_7 = new ViewButton();
		cb_7.setName("信用卡专区");
		cb_7.setType("view");
		cb_7.setUrl("https://wm.cib.com.cn/html/webapp/entrance/home.html?id=cd02abdc8a964cc2b587b64087dc5344");
		ViewButton cb_8 = new ViewButton();
		cb_8.setName("童兴俱乐部");
		cb_8.setType("view");
		cb_8.setUrl("http://xyyh.inrice.cn/txjlb/index.aspx");
		ViewButton cb_9 = new ViewButton();
		cb_9.setName("兴业商城");
		cb_9.setType("view");
		cb_9.setUrl("https://shop.cib.com.cn");
		
		// 创建第二个一级菜单
		ComplexButton cx_2 = new ComplexButton();
		cx_2.setName("兴动心地带");
		cx_2.setSub_button(new Button[] { cb_5,cb_6,cb_7,cb_8,cb_9});

		
		
		ViewButton cb_10 = new ViewButton();
		cb_10.setName("在线预约");
		cb_10.setType("view");
		cb_10.setUrl("https://e.cib.com.cn/app/mobile/mobileHome.do");
		ViewButton cb_11 = new ViewButton();
		cb_11.setName("网点查询");
		cb_11.setType("view");
		cb_11.setUrl("https://e.cib.com.cn/app/mobile/public/queue/queue.do?ver=1.0");
		ViewButton cb_12 = new ViewButton();
		cb_12.setName("招聘精英");
		cb_12.setType("view");
		cb_12.setUrl("http://cibgd.net-building.com/#/index");
		ViewButton cb_13 = new ViewButton();
		cb_13.setName("我有话说");
		cb_13.setType("view");
		cb_13.setUrl("http://xyyh.inrice.cn/lyadd/index.aspx");
		
		// 创建第三个一级菜单
		ComplexButton cx_3 = new ComplexButton();
		cx_3.setName("贴兴服务站");
		cx_3.setSub_button(new Button[] {cb_10,cb_11,cb_12,cb_13 });
		
		
		// 封装菜单数据
		Menu menu = new Menu();
		menu.setButton(new ComplexButton[] { cx_1, cx_2 ,cx_3});

		return menu;
	}

	/**
	 * 创建自定义菜单(每天限制1000次)
	 * @throws IOException 
	 */
	public static State createMenu(Menu menu) throws IOException {
		String doPostHttpRequest = OkhttpUtil.doPostHttpRequest(WeiXinSDK.MENU.replace("TOKEN", HTTPUtil.getToken().getAccess_token()),JSON.toJSONString(menu));
		State gsonToBean = GsonUtil.GsonToBean(doPostHttpRequest, State.class);
		return gsonToBean;
	}
	public static void main(String[] args) throws IOException {
		System.out.println(createMenu(getMenu()).getErrmsg());
	}
}






