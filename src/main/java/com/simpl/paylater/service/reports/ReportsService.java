package com.simpl.paylater.service.reports;

import java.util.List;

import com.simpl.domain.User;
import com.simpl.request.PayLaterDiscountReportRequest;
import com.simpl.request.PayLaterDuesReportRequest;
import com.simpl.request.PayLaterTotalDuesReportRequest;
import com.simpl.request.PayLaterUsersCreditLimitReportRequest;

public interface ReportsService {

	public Double processDiscountReports(PayLaterDiscountReportRequest simplDiscountReportRequest);
	public Double processDuesReports(PayLaterDuesReportRequest simplDuesReportRequest);
	public List<User>  processUsersCreditLimitReport();
	public List<User>  processTotalDuesReport(PayLaterTotalDuesReportRequest simplDuesReportRequest);
}
