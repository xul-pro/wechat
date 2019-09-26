<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分享页面</title>
</head>
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
<body>
	Hello World!----<h2>测试页面分享,和获取地理位置！</h2>
</body>
<script type="text/javascript">
	var appId = '';
	
	
	var title = '百度即将倒闭';
	var desc = '马云要收购百度产业';
	var link = '${config.url}';
	var imgUrl = 'https://www.baidu.com/img/bd_logo1.png';
	
	wx.config({
	    debug: true,    // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
	    appId: '${config.appId}',     // 必填，公众号的唯一标识
	    timestamp: '${config.timestamp}',   // 必填，生成签名的时间戳
	    nonceStr: '${config.nonceStr}',  // 必填，生成签名的随机串
	    signature: '${config.signature}', // 必填，签名，见附录1
	    jsApiList: ['checkJsApi', 'openLocation', 'getLocation','onMenuShareTimeline','onMenuShareAppMessage','onMenuShareQQ','onMenuShareWeibo','onMenuShareQZone']  // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
	});
	
	wx.checkJsApi({  
        jsApiList: ['getLocation'], // 需要检测的JS接口列表，所有JS接口列表见附录2,  
        success: function(res) {  
            if (res.checkResult.getLocation == false) {    
                alert('你的微信版本太低，不支持微信JS接口，请升级到最新的微信版本！');    
                return;    
         }  
        }  
    });  
	var latitude;    
    var longitude;    
    var speed;    
    var accuracy;
    
	 // config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。
	wx.ready(function(){
		 wx.getLocation({    
	            success : function(res) {    
	                latitude = res.latitude; // 纬度，浮点数，范围为90 ~ -90    
	                longitude = res.longitude; // 经度，浮点数，范围为180 ~ -180。    
	                speed = res.speed; // 速度，以米/每秒计    
	                accuracy = res.accuracy; // 位置精度    
	                alert(latitude);    
	                alert(accuracy);  
	            },    
	            cancel : function(res) {    
	                alert('未能获取地理位置');    
	            }  
	    });  
		 
	   //分享朋友圈
	    wx.onMenuShareTimeline({
		    title: title, // 分享标题
		    link: link, // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
		    imgUrl: imgUrl, // 分享图标
		    success: function () { 
		        // 用户确认分享后执行的回调函数
		    },
		    cancel: function () { 
		        // 用户取消分享后执行的回调函数
		    }
		});
		
	   //分享给朋友
	    wx.onMenuShareAppMessage({
	        title: title, // 分享标题
	        desc: desc, // 分享描述
	        link: link, // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
	        imgUrl: imgUrl, // 分享图标
	        type: '', // 分享类型,music、video或link，不填默认为link
	        dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
	        success: function () { 
	            // 用户确认分享后执行的回调函数
	        },
	        cancel: function () { 
	            // 用户取消分享后执行的回调函数
	        }
	    });
		
	   //分享qq
	    wx.onMenuShareQQ({
	        title: title, // 分享标题
	        desc: desc, // 分享描述
	        link: link, // 分享链接
	        imgUrl: imgUrl, // 分享图标
	        success: function () { 
	           // 用户确认分享后执行的回调函数
	        },
	        cancel: function () { 
	           // 用户取消分享后执行的回调函数
	        }
	    });
	   
	   //分享到腾讯微博
	    wx.onMenuShareWeibo({
	        title: title, // 分享标题
	        desc: desc, // 分享描述
	        link: link, // 分享链接
	        imgUrl: imgUrl, // 分享图标
	        success: function () { 
	           // 用户确认分享后执行的回调函数
	        },
	        cancel: function () { 
	            // 用户取消分享后执行的回调函数
	        }
	    });
	   
	   //分享到qq空间
	    wx.onMenuShareQZone({
	        title: title, // 分享标题
	        desc: desc, // 分享描述
	        link: link, // 分享链接
	        imgUrl: imgUrl, // 分享图标
	        success: function () { 
	           // 用户确认分享后执行的回调函数
	        },
	        cancel: function () { 
	            // 用户取消分享后执行的回调函数
	        }
	    });
	
	});
	
	// config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
	wx.error(function(res){
	    
	});


</script>
</html>