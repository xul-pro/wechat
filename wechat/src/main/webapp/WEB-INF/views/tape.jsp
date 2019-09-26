<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, minimum-scale=1, maximum-scale=1" />
<title>录音页面</title>
<style type="text/css">
	*{
		margin: 0;
		padding: 0;
	}
button{
	width: 90px;
	height: 30px;
	outline: medium;
	border-radius: 5px;
	-webkit-appearance: none;
	appearance: none;
}
.bto{
	width: 100%;
	text-align: center;
	position: absolute;
	bottom: 200px;
}
.bto button{
	display: block;
	margin: 20px auto;
}
.btm{
	width: 100%;
	text-align: center;
	position: absolute;
	bottom: 30px;
}
.btm button{
	margin: 10px;
}
.on{
	background: red;
	color: #ffffff;
}
</style>
</head>
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.4.1.min.js"></script>
<body>
	<div class="bto">
		<button id="btn1">点击录音</button>
		<button id="btn2">停止录音</button>
	</div>
	<div class="btm">
		<button id="btn3">播放语音</button>
		<button id="btn4">暂停播放</button>
		<button id="btn5">保存录音</button>
	</div>
</body>
<script type="text/javascript">
	window.addEventListener('touchmove', function () {
	    event.preventDefault();
	})
	wx.config({
	    debug: true,                        // 必填，开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
	    appId: '${config.appId}',           // 必填，公众号的唯一标识
	    timestamp: '${config.timestamp}',   // 必填，生成签名的时间戳
	    nonceStr: '${config.nonceStr}',     // 必填，生成签名的随机串
	    signature: '${config.signature}',   // 必填，签名，见附录1
	    jsApiList: ['startRecord','stopRecord','playVoice','pauseVoice','onVoiceRecordEnd','onVoicePlayEnd','uploadVoice'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
	});
	var localId;
	// config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。
	wx.ready(function(){
		//开始录音
		$('#btn1').click(function() {
			 wx.startRecord();//开始录音效果
			 $("#btn1").addClass('on').html('正在录音');
		});
		
		//停止录音
		$('#btn2').click(function() {
			if (localId == '') {
			      alert('请先使用 startRecord 接口录制一段声音!');
			      return;
			}
			wx.stopRecord({
			    success: function (res) {
			        localId = res.localId;
			        $("#btn1").removeClass('on').html('重新录音');
			    }
			});
		});
		
		//播放语音接口
		$('#btn3').click(function() {
			wx.playVoice({
			   localId: localId  // 需要播放的音频的本地ID，由stopRecord接口获得
			});
		});
		
		//暂停播放接口
		$('#btn4').click(function() {
			wx.pauseVoice({
			    localId: localId  // 需要暂停的音频的本地ID，由stopRecord接口获得
			});
		});
		
		//上传录音
		$('#btn5').click(function() {
			wx.uploadVoice({
			    localId: localId, // 需要上传的音频的本地ID，由stopRecord接口获得
			    isShowProgressTips: 1, // 默认为1，显示进度提示
			        success: function (res) {
			        var serverId = res.serverId; // 返回音频的服务器端ID
			    }
			});
		});
		
		//监听录音自动停止接口
	    wx.onVoiceRecordEnd({
		    // 录音时间超过一分钟没有停止的时候会执行 complete 回调
		    complete: function (res) {
		        localId = res.localId; 
		    }
		});
	    
		//监听语音播放完毕接口
		wx.onVoicePlayEnd({
		    success: function (res) {
		        localId = res.localId; // 返回音频的本地ID
		    }
		});
		
	});	
	
	// config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
	wx.error(function(res){
	    alert(res);
	});

</script>
</html>