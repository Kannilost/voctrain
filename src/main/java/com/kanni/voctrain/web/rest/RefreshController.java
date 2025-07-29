package com.kanni.voctrain.web.rest;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController

public class RefreshController {
    @GetMapping("/")
    protected void refreshHome(final HttpServletResponse res) throws IOException {
       res.sendRedirect("index.html");
    }

    @GetMapping("/myName")
    protected String myName() {
        return "Kanni";
    }
}
