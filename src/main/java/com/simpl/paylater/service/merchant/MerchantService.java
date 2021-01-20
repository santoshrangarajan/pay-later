package com.simpl.paylater.service.merchant;

import com.simpl.domain.Merchant;
import com.simpl.request.PayLaterMerchantRequest;

public interface MerchantService {

	public Merchant onBoard(PayLaterMerchantRequest simplNewMerchantRequest);
	public Merchant updateDiscounts(PayLaterMerchantRequest simplNewMerchantRequest);
	
}

