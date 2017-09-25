package cn.e3mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	TbItemMapper tbItemMapper;

	//根据id查询商品
	public TbItem getItemById(Long id) {
		TbItem tbItem = tbItemMapper.selectByPrimaryKey(id);
		return tbItem;
	}

}
