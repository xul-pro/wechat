<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="alipaysubmit" method="post" action="https://www.alipay.com/cooperate/gateway.do?_input_charset=utf-8">  
    <input type="hidden" name="subject" value="${order.subject}">     <!--商品名称-->  
    <input type="hidden" name="price" value="${order.price}">         <!--订单总价-->  
    <input type="hidden" name="quantity" value="${order.quantity}">       <!--支付类型-->  
    <input type="hidden" name="discount" value="${order.discount}">       <!--数量-->  
    <input type="hidden" name="show_url" value="${order.show_url}">       <!--商品展示网址-->  
    <input type="hidden" name="body" value="${order.body}">               <!--商品描述-->  
    <input type="hidden" name="out_trade_no" value="${order.out_trade_no}">   <!--订单号-->  
    <input type="hidden" name="partner" value="${order.partner}">     <!--支付宝合作伙伴id-->  
    <input type="hidden" name="payment_type" value="${order.payment_type}"><!--支付类型-->  
    <input type="hidden" name="seller_email" value="${order.seller_email}">   <!--卖家支付宝帐户-->  
    <input type="hidden" name="service" value="${order.service}">     <!--接口名称-->  
    <input type="hidden" name="sign" value="${order.sign}">           <!--签名认证-->  
    <input type="hidden" name="sign_type" value="${order.sign_type}">             <!--签名方式-->  
    <input type="hidden" name="return_url" value="${order.return_url}">       <!--支付完成后跳转返回的网址URL-->  
    <input type="button" name="v_action" value="支付宝网上安全即时支付平台" onClick="document.alipaysubmit.submit()">  
</form>  
</body>
</html>