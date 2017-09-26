package cn.e3mall.service;

import cn.e3mall.common.pojo.DataGridResult;
import cn.e3mall.pojo.TbItem;

public interface ItemService {
	
	TbItem getItemById(Long id);
	//商品列表查询
	DataGridResult getItemList(int page,int rows);

}
