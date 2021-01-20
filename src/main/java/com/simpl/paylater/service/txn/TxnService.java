package com.simpl.paylater.service.txn;

public interface TxnService {

	public void processTxn(String userName, String merchantName, Double amount);
}
