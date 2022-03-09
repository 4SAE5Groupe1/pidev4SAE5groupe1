package tn.esprit.spring.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import tn.esprit.spring.services.EmailSenderService;
import tn.esprit.spring.services.PDFGeneratorService;

import javax.mail.MessagingException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@RequestMapping("/api/test")
public class PDFExportController {

	@Autowired
	private EmailSenderService service;
    private final PDFGeneratorService pdfGeneratorService;
    public PDFExportController(PDFGeneratorService pdfGeneratorService) {
        this.pdfGeneratorService = pdfGeneratorService;
    }

    

    @GetMapping("/pdf/generate")
    public void generatePDF(HttpServletResponse response) throws IOException, MessagingException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        this.pdfGeneratorService.export(response);
        service.sendEmailWithAttachment("abessi.fakhreddine21@gmail.com",
				"This is Email Body with Attachment...",
				"This email has attachment",
				"C:\\Users\\A\\Downloads\\pdf_2022-03-09_08_11_35.pdf");

    }
}
