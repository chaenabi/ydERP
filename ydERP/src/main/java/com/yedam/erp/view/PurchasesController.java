package com.yedam.erp.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.erp.purchases.PurchasesService;
import com.yedam.erp.purchases.PurchasesVO;


@Controller
public class PurchasesController
{
	//서비스 injection
	@Autowired
	PurchasesService purchasesService;
	
	@RequestMapping("/getPurchasesPage")
	public String getPurchasesList(Model model, PurchasesVO vo) {
		 return "purchases/getPurchasesList";
	}
	
	//등록
	@RequestMapping("insertPurchases")
	@ResponseBody
	public PurchasesVO insertPurchases(PurchasesVO vo) {
		purchasesService.insertPurchases(vo);
		return purchasesService.getPurchases(vo);
	}
	
	//수정
	@RequestMapping("updatePurchases")
	@ResponseBody
	public PurchasesVO updatePurchases(PurchasesVO vo) {
		purchasesService.updatePurchases(vo);
		return purchasesService.getPurchases(vo);
	}
	
	//삭제
	@RequestMapping("deletePurchases")
	public PurchasesVO deletePurchases(PurchasesVO vo) {
		purchasesService.deletePurchases(vo);
		return purchasesService.getPurchases(vo);
	}
	
	//목록
	@RequestMapping("getPurchasesList") 
	@ResponseBody
	public List<PurchasesVO> getPurchasesList(PurchasesVO vo) {			
		
		return purchasesService.getPurchasesList(vo);											
	}
}