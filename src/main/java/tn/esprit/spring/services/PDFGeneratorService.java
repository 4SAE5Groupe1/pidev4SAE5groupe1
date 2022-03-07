package tn.esprit.spring.services;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;

import tn.esprit.spring.entites.User;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;


import java.awt.Color;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

@Service
public class PDFGeneratorService {
	
 User user ;
	
	private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode.png";
	public static void generateQRCodeImage(String text, int width, int height, String filePath)
            throws IOException, WriterException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
       
    }
    public void export(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());


        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE);
        fontTitle.setSize(30);
        fontTitle.setColor(Color.RED);
        
        Paragraph paragraph = new Paragraph("Certificate", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontParagraph = FontFactory.getFont(FontFactory.TIMES_BOLDITALIC);
        fontParagraph.setSize(18);

        Paragraph paragraph2 = new Paragraph("This is to certify that "+" Has successfully passed the certification exam for", fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);
        
        
        try {
			this.generateQRCodeImage("fakhri", 100, 100,"./src/main/resources/QRCode.png" );
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Paragraph parag = new Paragraph("signature", fontParagraph) ;
        parag.setAlignment(parag.ALIGN_RIGHT);
        String filename1 = "./src/main/resources/woman.png";
        Image image2 = Image.getInstance(filename1);
        image2.setAlignment(Image.RIGHT);
        image2.scaleToFit(100, 100);
        
        
        String filename = "./src/main/resources/QRCode.png";
        Image image = Image.getInstance(filename);
        image.setAlignment(Image.LEFT);
        
        
        document.add(paragraph);
        document.add(paragraph2);
        document.add(image);
        document.add(parag);
        document.add(image2);
        
      
        document.close();
    }
}
