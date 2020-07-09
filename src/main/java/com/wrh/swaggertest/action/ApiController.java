package com.wrh.swaggertest.action;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wrh
 * @version 1.0
 * @date 2020/7/9 10:33
 * @describe
 */

@RestController
@RequestMapping("/api")
@Api(tags = "在线API文档")
public class ApiController {

    @ApiOperation(value = "cmorph 数据偏差计算入库")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "结束时间", name = "end", paramType = "query", required = true, defaultValue = "2018070810"),
            @ApiImplicitParam(value = "开始时间", name = "start", paramType = "query", required = true, defaultValue = "2018070800")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数有误"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @PostMapping("/cmorph")
    public String executeCmorph(
            @RequestParam("start") String start,
            @RequestParam("end") String end
    ) {
        return "finish，完成cmorph 数据偏差计算入库";
    }

}
