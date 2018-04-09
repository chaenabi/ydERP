package com.yedam.erp.impl;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yedam.erp.sales.SaleDetailsVO;

@Repository
public class SaleDetailsMybatisDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	/* 판매 상세 정보 조회 */
	public List<SaleDetailsVO> getSaleDetail(SaleDetailsVO saleDetailsVO) {
		return mybatis.selectList("sales.getSaleDetail", saleDetailsVO);
	}
	
	/* 미승인 주문 상세 정보 조회 */
	public List<SaleDetailsVO> getOrderDetail(SaleDetailsVO saleDetailsVO) {
		return mybatis.selectList("sales.getOrderDetail", saleDetailsVO);
	}
	
	/* 미승인 주문 상세 정보 삭제 */
	public void deleteOrderDetail(ArrayList<String> saleCode) {
		mybatis.delete("sales.deleteOrderDetail", saleCode);
	}
}