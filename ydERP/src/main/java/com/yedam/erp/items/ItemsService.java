package com.yedam.erp.items;

import java.util.ArrayList;
import java.util.List;

public interface ItemsService {

	
	
	public void insertItems(ItemsVO vo);
	public void updateItems(ItemsVO vo);
	public void deleteItems(ItemsVO vo);
	public ItemsVO getItems(ItemsVO vo);
	public List<ItemsVO> getItemsList(ItemsVO vo);
	public void deleteItemsList(ArrayList<String> seq);
	public int getCount(ItemsVO vo);
}
