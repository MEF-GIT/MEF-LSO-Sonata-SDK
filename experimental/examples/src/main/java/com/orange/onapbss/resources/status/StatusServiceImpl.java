package com.orange.onapbss.resources.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.onapbss.datamodel.productordering.ProductOrderEntity;
import com.orange.onapbss.resources.status.model.ApplicationStatus;
import com.orange.onapbss.resources.status.model.StatusType;
import com.orange.soa.commons.dao.Dao;

@Service("statusService")
public class StatusServiceImpl implements StatusService {
	
	@Autowired
	private Dao<ProductOrderEntity> productOrderDao;

	@Override
	public ApplicationStatus get(final String serviceName,
			final String serviceVersion) {

		final boolean applicationIsUp = true;

		final boolean databaseIsUp = this.checkDataBase();

		final ApplicationStatus applicationStatus = new ApplicationStatus(serviceName,
				(applicationIsUp ? StatusType.OK : StatusType.KO), serviceVersion);

		final ApplicationStatus databaseStatus = new ApplicationStatus("database",
				(databaseIsUp ? StatusType.OK : StatusType.KO), serviceVersion);

		return applicationStatus.component(databaseStatus);
	}

	public boolean checkDataBase() {
		boolean isUp = true;
		// Test an operation on an entity
		try {
			this.productOrderDao.find();
		}
		catch (Throwable t) {
			isUp = false;
		}
		return isUp;
	}

	public boolean serviceIsUp() {
		return true;
	}	

}
