package br.com.philipe.swaggerExample.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public abstract class AppEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1977539897407219922L;

	@ApiModelProperty(dataType = "Long", value = "Product ID", required = true)
	private Long uid;

	public AppEntity() {
		super();
	}

	public AppEntity(Long uid) {
		super();
		this.uid = uid;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

}
