package tn.esprit.spring.entites;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.stream.Stream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import tn.esprit.spring.entites.Complaint;

public class GeneratePdf {
	
	public static ByteArrayInputStream Report(List<Complaint> list) throws MalformedURLException, IOException {
		Document document = new Document();
		document.setMargins(40, 40, 40, 40);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		try {

			PdfWriter.getInstance(document, out);
			document.open();
			// Add Text to PDF file ->
						Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
						Paragraph para = new Paragraph( "Complaints List", font);
						para.setAlignment(Element.ALIGN_CENTER);
						document.add(para);
						document.add(Chunk.NEWLINE);
			        	
			        	PdfPTable table = new PdfPTable(5);
						Stream.of("ID", "Title","Content", "Decision","User Email")
						    .forEach(headerTitle -> {
						          PdfPCell header = new PdfPCell();
						          Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
						          header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						          header.setHorizontalAlignment(Element.ALIGN_CENTER);
						          header.setBorderWidth(2);
						          header.setPhrase(new Phrase(headerTitle, headFont));
						          table.addCell(header);
						    });
			            
			            for (Complaint recl : list) {
			            	
			            	PdfPCell idCell = new PdfPCell(new Phrase(String.valueOf(recl.getIdComplaint())));
			            	idCell.setPaddingLeft(4);
			            	idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			            	idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			                table.addCell(idCell);
			                
			                PdfPCell titleCell = new PdfPCell(new Phrase(String.valueOf(recl.getTitle())));
			                titleCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			                titleCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			                titleCell.setPaddingRight(4);
			                table.addCell(titleCell);
			                

			                PdfPCell ContentCell = new PdfPCell(new Phrase(recl.getContent()));
			                ContentCell.setPaddingLeft(4);
			                ContentCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			                ContentCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			                table.addCell(ContentCell);

			               
			                PdfPCell decisionCell = new PdfPCell(new Phrase(String.valueOf(recl.getDecision())));
			                decisionCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			                decisionCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			                decisionCell.setPaddingRight(4);
			                table.addCell(decisionCell);
			                
			                PdfPCell userCell = new PdfPCell(new Phrase(String.valueOf(recl.getUser().getEmail())));
			                userCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			                userCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			                userCell.setPaddingRight(4);
			                table.addCell(userCell);
			                
			                /* PdfPCell dateCell = new PdfPCell(new Phrase(recl.getUser().getFirstName()+""+recl.getUser().getLastName()));
			                dateCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			                dateCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			                dateCell.setPaddingRight(4);
			                table.addCell(dateCell); */
			            }
			            document.add(table);
         
  
			
			document.close();

		} catch (DocumentException ex) {
					System.out.println(ex.getMessage());
		}
		return new ByteArrayInputStream(out.toByteArray());
	}

}
