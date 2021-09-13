package oki.test.admin.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import oki.test.admin.domain.SysLoginLog;
import oki.test.admin.services.SysLoginLogService;
import oki.test.admin.vo.LoginBean;
import oki.test.common.utils.IOUtils;
import oki.test.core.http.HttpResult;
import oki.test.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.PrivateKey;
import java.util.List;

@RestController
@RequestMapping("loginlog")
public class SysLoginLogController {

    @Autowired
    private Producer producer;
    @Autowired
    private SysLoginLogService sysLoginLogService;

    @PostMapping(value="/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysLoginLogService.findPage(pageRequest));
    }

    @PostMapping(value="/delete")
    public HttpResult delete(@RequestBody List<SysLoginLog> records) {
        return HttpResult.ok(sysLoginLogService.delete(records));
    }

    @GetMapping("captcha.jpg")
    public void captcha(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setHeader("Cache-Control","no-store,no-cache");
        response.setContentType("image/jpeg");

        String text = producer.createText();

        BufferedImage image = producer.createImage(text);

        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY,text);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image,"jpg",out);
        IOUtils.closeQuietly(out);
    }




}
