package com.sunarmy.cn.controller;

import com.github.cage.Cage;
import com.github.cage.IGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by wb-wsj429645 on 2018/8/27.
 */
@Controller
public class VerificationController {

    private Cage cage = new Cage(null,null,null,null,null, new IGenerator() {
        private int length = 4;
        private String charsetdir = "23456789abcdefghijkmnpqrstuvwxyzABCDEFGHIJKLMNPQRSTUVWXYZ";
        private final Random r = new Random(37);

        @Override
        public String next() {
            StringBuffer sb = new StringBuffer();
            int len = charsetdir.length();
            for (int i = 0; i < length; i++) {
                sb.append(charsetdir.charAt(r.nextInt(len - 1)));
            }
            return sb.toString();
        }
    }, null);



    @RequestMapping(method= RequestMethod.GET, value="/captcha")
    public void v2(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            // flush it in the response
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/jpeg");

            String captcha = cage.getTokenGenerator().next();
            HttpSession session = request.getSession();
            session.setAttribute(session.getId(), captcha);
            cage.draw(captcha, response.getOutputStream());
            //request.getSession().setAttribute("sessionCaptcha", captcha.toUpperCase());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
