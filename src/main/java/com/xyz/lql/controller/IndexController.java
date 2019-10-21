package com.xyz.lql.controller;

import com.xyz.lql.dto.rep.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lql
 * @Description: TODO
 * @date 2019-1-28 16:46
 */

@RestController
@RequestMapping("index")
public class IndexController {
	private final static Logger logger = LoggerFactory.getLogger(IndexController.class);
}
