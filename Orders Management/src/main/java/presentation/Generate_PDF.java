package presentation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class Generate_PDF {

    private static int id = 1;

    public static void generateBill(String root, String cName, String addr, String product, int priceUnit, int qty, int tPrice ){

        StringBuilder sb = new StringBuilder();
        sb.append(root + id + ".pdf");

        Document document = new Document();

        try {
            PdfWriter.getInstance(document,new FileOutputStream(String.valueOf(sb)));
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        document.open();

        Paragraph para =  new Paragraph("Order Bill\n");

        para.setAlignment(Element.ALIGN_CENTER);
        para.setSpacingAfter(40);

        try {
            document.add(para);
        } catch (DocumentException e) {
            e.printStackTrace();
        }


        //add a table

        PdfPTable table = new PdfPTable(7);
        PdfPCell c1 = new PdfPCell(new Phrase("OrderID"));
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Client Name"));
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Address"));
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Product"));
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Price Per Unit"));
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Quantity"));
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Total Price"));
        table.addCell(c1);
        table.setHeaderRows(1);

        table.addCell(String.valueOf(id));
        table.addCell(cName);
        table.addCell(addr);
        table.addCell(product);
        table.addCell(String.valueOf(priceUnit));
        table.addCell(String.valueOf(qty));
        table.addCell(String.valueOf(tPrice));

        try {
            document.add(table);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        para =  new Paragraph("Date & Time");
        para.setSpacingBefore(105);
        para.setIndentationLeft(50);

        try {
            document.add(para);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        para =  new Paragraph(formatter.format(date));
        para.setIndentationLeft(50);

        try {
            document.add(para);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        document.close();

        id++;
        System.out.println("Bill successfully generated!");



    }

}
