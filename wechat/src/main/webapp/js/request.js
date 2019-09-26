/**************接口地址**************/

/**
 * @return code 返回码 0-成功 1-失败
 */
var HOST = "http://219.143.245.173/cif/method=";//公共域名

/**
 * 销售机构列表接口
 * @method GET 
 * @param null
 */
var flash_xsjg = HOST+'flash_xsjg';

/**
 * 销售机构销售基金产品列表接口
 * @method GET 
 * @param {String} agencycode 销售机构编码
 */
var flash_xsjj = HOST+'flash_xsjj';

/**
 * 基金产品持有期限列表接口
 * @method GET 
 * @param {String} fundcode 基金代码
 */
var flash_cyqx = HOST+'flash_cyqx';

/**
 * 销售机构基金产品转换查询接口
 * @method GET 
 * @param {String} agencycode 销售机构编码
 * @param {String} outfundcode 转出基金代码
 * @param {String} infundcode 转入基金代码
 * @param {String} partid 基金持有期限id
 */
var flash_zhcx = HOST+'flash_zhcx';

/**
 * 销售机构基金产品定投查询接口
 * @method GET 
 * @param {String} agencycode 销售机构编码
 * @param {String} fundcode 定投基金代码
 */
var flash_dtcx = HOST+'flash_dtcx';

/**
 * 销售机构基金产品申购查询接口
 * @method GET 
 * @param {String} agencycode 销售机构编码
 * @param {String} fundcode 定投基金代码
 */
var flash_xsjg = HOST+'flash_sgcx';

/**
 * 直销产品定投优惠查询接口
 * @method GET 
 * @param {String} fundcode 定投基金代码
 * @param {String} fundtype 资金方式代码
 */
var flash_dtyh = HOST+'flash_dtyh';

/**
 * 直销产品申购优惠查询接口
 * @method GET 
 * @param {String} fundcode 申购基金代码
 * @param {String} fundtype 资金方式代码
 */
var flash_sgyh = HOST+'flash_sgyh';