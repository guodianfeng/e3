package cn.e3mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.common.pojo.DataGridResult;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
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

	//商品列表分页查询
	public DataGridResult getItemList(int page, int rows) {
//		1、设置分页信息
		PageHelper.startPage(page, rows);
//		2、执行查询
		TbItemExample example = new TbItemExample();
		List<TbItem> list = tbItemMapper.selectByExample(example);
//		3、从查询结果中取分页信息
		PageInfo<TbItem> pageInfo=new PageInfo<>(list);
		long total = pageInfo.getTotal();
//		4、创建一个DataGridResult对象
		DataGridResult dataGridResult = new DataGridResult();
//		5、把结果封装到DataGridResult中
		dataGridResult.setTotal(total);
		dataGridResult.setRows(list);
//		6、返回DataGridResult对象
		return dataGridResult;
	}

}
