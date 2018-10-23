package com.orange.onapbss.resources.status;

import com.orange.onapbss.resources.status.model.ApplicationStatus;

public interface StatusService {
	
	ApplicationStatus get(String serviceName,
			String serviceVersion);
	
}
