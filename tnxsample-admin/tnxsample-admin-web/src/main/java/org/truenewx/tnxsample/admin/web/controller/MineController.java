package org.truenewx.tnxsample.admin.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAuthority;
import org.truenewx.tnxsample.admin.web.util.ProjectWebUtil;

@Api("个人管理")
@Controller
@RequestMapping("/mine")
public class MineController {

    @GetMapping("/info")
    @ConfigAuthority
    public ModelAndView toUpdateInfo() {
        ModelAndView mav = new ModelAndView("/mine/info");
        mav.addObject("manager", ProjectWebUtil.getManager());
        return mav;
    }

    @ApiOperation("修改姓名")
    @PostMapping("/info/full-name")
    @ConfigAuthority
    public void updateFullName(@RequestParam("fullName") String fullName) {

    }

}
