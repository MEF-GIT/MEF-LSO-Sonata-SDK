package com.orange.onapbss.resources;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface MixIn {
	 @JsonIgnore Long getHjid();
}
