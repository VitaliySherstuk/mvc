package util;


import beans.models.Ticket;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Random;


public class PdfDoc {

    private final static Logger LOG = Logger.getLogger(PdfDoc.class);

    public static String createPdfDocument(List<Ticket> tickets) throws FileNotFoundException, DocumentException {

        Random rand = new Random();
        String id = String.valueOf(rand.nextInt(999999999));
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(id+"_tickets.pdf"));

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 11, BaseColor.BLACK);


        StringBuilder s = new StringBuilder();

        tickets.stream().forEach(r ->{

                Paragraph chapterTitle = new Paragraph(String.valueOf("TicketId: " + r.getId()));
                Chapter ch = new Chapter(chapterTitle, 1);

            Paragraph sectionTitle = new Paragraph("Event: " +r.getEvent().getName());
            Section section = ch.addSection(sectionTitle);
            section.add(new Paragraph("Date: " +r.getDateTime().toString()));
            section.add(new Paragraph("Auditorium: "+ r.getEvent().getAuditorium().getName()));
            section.add(new Paragraph("Seats: " + r.getSeats()));
            section.add(new Paragraph("User email" + r.getUser().getEmail()));
            section.add(new Paragraph("Price: " + String.valueOf(r.getPrice())));
            try {
                document.add(ch);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        });

        LOG.info(s.toString());


        document.close();

        return id;
    }
}
