package com.orange.onapbss.resources.status.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ApplicationStatus implements Serializable {

	private final static long serialVersionUID = 11L;

	private String name;

	private StatusType status;

	private String version;

	private Set<ApplicationStatus> components = new HashSet<>();

	/**
	 * Builds a new {@code ApplicationStatus} with the following attributes :
	 * 
	 * @param name name of the service
	 * @param state state of the service ({@code OK} | {@code KO})
	 * @param version version of the service ({@code x.y.z})
	 */
	public ApplicationStatus(final String name, final StatusType status,
			final String version) {
		this.name = name;
		this.status = status;
		this.version = version;
	}

	public String getName() {
		return this.name;
	}

	public StatusType getStatus() {
		return this.status;
	}

	public String getVersion() {
		return this.version;
	}

	public Set<ApplicationStatus> getComponents() {
		return this.components;
	}

	public ApplicationStatus component(final ApplicationStatus componentStatus) {
		this.components.add(componentStatus);
		return this;
	}

}
