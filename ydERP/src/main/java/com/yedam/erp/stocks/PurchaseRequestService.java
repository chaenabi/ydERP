package com.yedam.erp.stocks;

import java.util.List;

public interface PurchaseRequestService {

	public List<PurchaseRequestVO> getPurchaseRequestList(PurchaseRequestVO vo);

	public void insertPurchaseRequest(PurchaseRequestVO vo);

}