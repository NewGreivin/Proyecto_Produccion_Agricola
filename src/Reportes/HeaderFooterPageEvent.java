package Reportes;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

/**
 * @author Greivin
 */
public class HeaderFooterPageEvent extends PdfPageEventHelper {
    
    private static final Font TEXTO_FONT = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
    
    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        // Pie de página con número de página
        ColumnText.showTextAligned(writer.getDirectContent(),
                Element.ALIGN_CENTER,
                new Phrase("Página " + writer.getPageNumber(), TEXTO_FONT),
                (document.right() - document.left()) / 2 + document.leftMargin(),
                document.bottom() - 10, 0);
        
        // Línea separadora en el pie
        PdfContentByte cb = writer.getDirectContent();
        cb.setLineWidth(0.5f);
        cb.setColorStroke(BaseColor.GRAY);
        cb.moveTo(document.left(), document.bottom() - 5);
        cb.lineTo(document.right(), document.bottom() - 5);
        cb.stroke();
    }
}
