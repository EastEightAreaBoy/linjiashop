package cn.enilu.flash.api.controller.admin.shop;

import cn.enilu.flash.bean.constant.factory.PageFactory;
import cn.enilu.flash.bean.core.BussinessLog;
import cn.enilu.flash.bean.dictmap.CommonDict;
import cn.enilu.flash.bean.entity.shop.Favorite;
import cn.enilu.flash.bean.enumeration.BizExceptionEnum;
import cn.enilu.flash.bean.exception.ApplicationException;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.service.shop.FavoriteService;
import cn.enilu.flash.utils.StringUtil;
import cn.enilu.flash.utils.factory.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop/favorite")
public class AdminFavoriteController {
	private  Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private FavoriteService favoriteService;

	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list() {
		Page<Favorite> page = new PageFactory<Favorite>().defaultPage();
		page = favoriteService.queryPage(page);
		return Rets.success(page);
	}
	@RequestMapping(method = RequestMethod.POST)
	@BussinessLog(value = "编辑用户收藏", key = "name",dict= CommonDict.class)
	public Object save(@ModelAttribute Favorite tShopFavorite){
		if(tShopFavorite.getId()==null){
			favoriteService.insert(tShopFavorite);
		}else {
			favoriteService.update(tShopFavorite);
		}
		return Rets.success();
	}
	@RequestMapping(method = RequestMethod.DELETE)
	@BussinessLog(value = "删除用户收藏", key = "id",dict= CommonDict.class)
	public Object remove(Long id){
		if (StringUtil.isEmpty(id)) {
			throw new ApplicationException(BizExceptionEnum.REQUEST_NULL);
		}
		favoriteService.deleteById(id);
		return Rets.success();
	}
}
