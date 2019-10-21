package com.xyz.lql.dto.req.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lql
 * @Description: TODO
 * @date 2019-2-20 16:17
 */
@Data
public abstract class ReqPage {
	@ApiModelProperty(value = "当前页数", required = true)
	private int pageNum;
	@ApiModelProperty(value = "每页条数", required = true)
	private int pageSize;
}
