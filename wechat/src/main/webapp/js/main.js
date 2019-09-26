/**
 * 兼容IE input placeholder 属性
 * */
function setInputPlaceholder() {
	jQuery('[placeholder]').focus(function() {
		var input = jQuery(this);
		if(input.val() == input.attr('placeholder')) {
			input.val('');
			input.removeClass('placeholder');
		}
	}).blur(function() {
		var input = jQuery(this);
		if(input.val() == '' || input.val() == input.attr('placeholder')) {
			input.addClass('placeholder');
			input.val(input.attr('placeholder'));
		}
	}).blur().parents('form').submit(function() {
		jQuery(this).find('[placeholder]').each(function() {
			var input = jQuery(this);
			if(input.val() == input.attr('placeholder')) {
				input.val('');
			}
		})
	});
}

//request
function request(type,url,async,data,cb,cd){
	var type = type || 'get';
		url = url || '';
		async = async || true;
		data = data || null;
		cb = cb || null;
		cd = cd || null;

	if(url != '' && typeof url == 'string'){
		$.ajax({
			type:type,
			url:url,
			async:async,
			data:data,
			success: function(res){
				typeof cb == "function" && cb(res);
			},
			error:function(res){
				typeof cd == 'function' && cd(res);
			}
		});
	}else{
		console.log("typeof url is error")
	}
}

/**
 * 添加模拟select选择框以及事件
 * */
function selectList(dom,jsons) {
	var str = '',
		jsons = jsons;
	var dom = dom;
	if(typeof dom == 'object') {
		str = '<ul class="select-content">请按步骤完成操作</ul>';
		dom.append(str);
		if(jsons != "null" && jsons != null && typeof jsons == 'object'){
			addlist(dom,jsons);
		}
	} else {
		console.log('dom is not DOM')
	}
	
	$('.select-warp input').click(function() {
		var $_this = $(this).parent('.select-warp');
		
		$('.select-content').hide();
		$('.select-input').removeClass('select-input');
		$_this.find('.select-content').show();
		
		var state = $_this.find('.select-content').is(":hidden");
		
		if(state){
			$_this.find('input').removeClass('select-input');
		}else{
			$_this.find('input').addClass('select-input');
		}
	})

	$('.icon-triangle').click(function() {
		var $_tihs = $(this).parent('.select-warp');
		if(!$_tihs.find('input').hasClass('select-input')){
			$_tihs.find('input').addClass('select-input');
		}else{
			$_tihs.find('input').removeClass('select-input');
		}
		$_tihs.find('.select-content').toggle();
	})

	$('.select-warp').delegate('ul li', 'click', function() {
		var selectVal = $(this).html();
		$(this).parents('.select-warp').find('input').val(selectVal);
		$(this).parents('.select-warp').find('input').removeClass('placeholder select-input');
		$(this).parents('.select-content').hide();

	})

	$('body').not('.select-content').click(function() {
		$('.select-content').hide();
		$('.select-input').removeClass('select-input');
	})

	$('.select-warp').click(function(event) {
		event.stopPropagation()
	})
}
/**
 * 添加数据列表
 * */
function addlist(dom,jsons){
	var list = '';
	for(var i = 0; i < jsons.length; i++) {
		list += '<li>' + jsons[i].agencyname + jsons[i].agencyno + '</li>'
	}
	dom.find('.select-content').html(list);
}

/**
 * 查询匹配
 * */
function search(str,list){
	var lists = '';
	var listLen = list.length;
	var strLen = str.length;
	var arr = [],keyWord='',count = 0,arrNum = [];
	
    for(var t = 0; t < listLen; t++){
		lists = list[t].agencyname+list[t].agencyno;
    	keyWord = str;
    	if(lists.indexOf(keyWord)>=0){
    		if(arr.indexOf(list[t])){
    			arr.push(list[t]);	
    		}
	    }
    }

    if(arr.length == 0){
		for(var i = 0; i < listLen; i++){
		    //如果字符串中不包含目标字符会返回-1
		    count = 0;
		    lists = list[i].agencyname+list[i].agencyno;
		    for(var j = 0; j < strLen; j++){
		    	keyWord = str[j];

		    	if(lists.indexOf(keyWord)>=0){
		    		if(strLen <= 3){
		    			count++;
			    		if(count>=2){
			    			if(arrNum.indexOf(i) < 0){
			    				console.log(i)
			    				arrNum.push(i)
			    				arr.push(list[i]);
			    			}
			    		}
		    		}
		    		if(strLen <= 4 && strLen > 3){
		    			count++;
			    		if(count>=3){
			    			if(arrNum.indexOf(i) < 0){
			    				console.log(i)
			    				arrNum.push(i)
			    				arr.push(list[i]);
			    			}
			    		}
		    		}
		    		if(strLen <= 5 && strLen > 4){
		    			count++;
			    		if(count>=4){
			    			if(arrNum.indexOf(i) < 0){
			    				console.log(i)
			    				arrNum.push(i)
			    				arr.push(list[i]);
			    			}	
			    		}
		    		}
			    }
		    }
		}
    }
	return arr;
}

//获取数据处理函数
function GetData(){
	this.agencycode = ''
	this.fundcode = ''
	this.outfundcode = ''
	this.infundcode = ''
	this.partid = ''
	this.fundtype = ''
	
	this._init = function(){
		this.agencycode = ''
		this.fundcode = ''
		this.outfundcode = ''
		this.infundcode = ''
		this.partid = ''
		this.fundtype = ''
	}
	this._getDisChannel = function(){
		request(
			'get',
			HOST+flash_xsjg,
			'false',
			'',
			function(res){
				console.log(res)
			},
			function(res){
				console.log(res)
			}
		)
	}
	this._salesFund = function(){
		request(
			'get',
			'a.json',
			'false',
			{
				agencycode:this.agencycode
			},
			function(res){
				console.log(res)
			},
			function(res){
				console.log(res)
			}
		)
	}
	this._holdingPeriod = function(){
		request(
			'get',
			'a.json',
			'false',
			{
				fundcode:this.fundcode
			},
			function(res){
				console.log(res)
			},
			function(res){
				console.log(res)
			}
		)
	}
	this._search = function(){
		request(
			'get',
			'a.json',
			'false',
			{
				agencycode: this.agencycode,
				outfundcode: this.outfundcode,
				infundcode:this.fundcode,
				partid: this.partid
			},
			function(res){
				console.log(res)
			},
			function(res){
				console.log(res)
			}
		)
	}
}