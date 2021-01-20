package com.simpl.paylater.service.merchant;

import com.simpl.domain.Merchant;
import com.simpl.paylater.repository.PayLaterRepository;
import com.simpl.request.PayLaterMerchantRequest;

public class MerchantServiceImpl implements MerchantService {

	private PayLaterRepository payLaterRepository;
	
	public MerchantServiceImpl(PayLaterRepository payLaterRepository) {
	      this.payLaterRepository=	payLaterRepository;
	}
	
	
	@Override
	public Merchant onBoard(PayLaterMerchantRequest simplNewMerchantRequest) {
		// TODO Auto-generated method stub
		Merchant merchant = new Merchant(simplNewMerchantRequest);
		payLaterRepository.addMerchant(merchant);
		return merchant;
	}

	@Override
	public Merchant updateDiscounts(PayLaterMerchantRequest simplNewMerchantRequest) {
		// TODO Auto-generated method stub
		Merchant merchant = new Merchant(simplNewMerchantRequest);
		payLaterRepository.updateMerchantDiscount(merchant);
		return merchant;
		
	}

}
