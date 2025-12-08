package Reportes;

import Modelo.Dtos.ProduccionDTO;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author Greivin
 */
public class ReporteProduccionPDF {
    
    private static final Font TITULO_FONT = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, BaseColor.DARK_GRAY);
    private static final Font SUBTITULO_FONT = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLACK);
    private static final Font HEADER_FONT = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE);
    private static final Font TEXTO_FONT = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.00");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void generarReporte(List<ProduccionDTO> producciones, String rutaArchivo) throws Exception {
        if (producciones == null || producciones.isEmpty()) {
            throw new Exception("No hay datos de producción para generar el reporte");
        }
        
        Document documento = new Document(PageSize.A4, 50, 50, 50, 50);
        
        try {
            PdfWriter writer = PdfWriter.getInstance(documento, new FileOutputStream(rutaArchivo));
            
            HeaderFooterPageEvent evento = new HeaderFooterPageEvent();
            writer.setPageEvent(evento);
            
            documento.open(); 
            agregarTitulo(documento);
            agregarInformacionGeneral(documento, producciones);
            agregarTablaProduccion(documento, producciones);

            agregarEstadisticas(documento, producciones);
            
            documento.close();
            
        } catch (Exception e) {
            if (documento.isOpen()) {
                documento.close();
            }
            throw new Exception("Error al generar el reporte PDF: " + e.getMessage(), e);
        }
    }

    private void agregarTitulo(Document documento) throws DocumentException {
        Paragraph titulo = new Paragraph("REPORTE DE PRODUCCIÓN AGRÍCOLA", TITULO_FONT);
        titulo.setAlignment(Element.ALIGN_CENTER);
        titulo.setSpacingAfter(20);
        documento.add(titulo);
    }

    private void agregarInformacionGeneral(Document documento, List<ProduccionDTO> producciones) throws DocumentException {
        Paragraph info = new Paragraph();
        info.add(new Chunk("Fecha de Generación: ", SUBTITULO_FONT));
        info.add(new Chunk(java.time.LocalDate.now().format(DATE_FORMATTER) + "\n", TEXTO_FONT));
        info.add(new Chunk("Total de Registros: ", SUBTITULO_FONT));
        info.add(new Chunk(String.valueOf(producciones.size()) + "\n", TEXTO_FONT));
        info.setSpacingAfter(15);
        documento.add(info);
        
        LineSeparator linea = new LineSeparator();
        linea.setLineColor(BaseColor.GRAY);
        documento.add(new Chunk(linea));
        documento.add(Chunk.NEWLINE);
    }

    private void agregarTablaProduccion(Document documento, List<ProduccionDTO> producciones) throws DocumentException {
        Paragraph subtitulo = new Paragraph("Detalle de Producciones", SUBTITULO_FONT);
        subtitulo.setSpacingBefore(10);
        subtitulo.setSpacingAfter(10);
        documento.add(subtitulo);
        
        // Crear tabla con 6 columnas
        PdfPTable tabla = new PdfPTable(6);
        tabla.setWidthPercentage(100);
        tabla.setSpacingBefore(10);
        tabla.setSpacingAfter(10);
        
        // Definir anchos relativos de columnas
        float[] anchos = {1f, 2f, 2f, 1.5f, 1.5f, 2f};
        tabla.setWidths(anchos);
        
        // Agregar encabezados
        agregarCeldaEncabezado(tabla, "ID");
        agregarCeldaEncabezado(tabla, "Fecha");
        agregarCeldaEncabezado(tabla, "Cultivo");
        agregarCeldaEncabezado(tabla, "Cantidad (kg)");
        agregarCeldaEncabezado(tabla, "Calidad");
        agregarCeldaEncabezado(tabla, "Destino");
        
        // Agregar datos
        for (ProduccionDTO produccion : producciones) {
            agregarCeldaDato(tabla, String.valueOf(produccion.getId()));
            agregarCeldaDato(tabla, produccion.getFecha().format(DATE_FORMATTER));
            agregarCeldaDato(tabla, produccion.getIdCultivo().getNombre());
            agregarCeldaDato(tabla, DECIMAL_FORMAT.format(produccion.getCantidadRecolectada()));
            agregarCeldaDato(tabla, produccion.getCalidad().getCalidad());
            agregarCeldaDato(tabla, produccion.getDestino().getDestino());
        }
        
        documento.add(tabla);
    }
    
    private void agregarEstadisticas(Document documento, List<ProduccionDTO> producciones) throws DocumentException {
        documento.add(Chunk.NEWLINE);
        
        Paragraph subtitulo = new Paragraph("Resumen Estadístico", SUBTITULO_FONT);
        subtitulo.setSpacingBefore(10);
        subtitulo.setSpacingAfter(10);
        documento.add(subtitulo);
        
        double totalKg = 0;
        int porCalidad[] = new int[6]; // Extra, Primera, Segunda, Tercera, Industrial, Descarte
        int porDestino[] = new int[4]; // Venta, Consumo, Almacenamiento, Descarte
        
        for (ProduccionDTO prod : producciones) {
            totalKg += prod.getCantidadRecolectada();
            
            switch (prod.getCalidad().name()) {
                case "EXTRA": porCalidad[0]++; break;
                case "PRIMERA": porCalidad[1]++; break;
                case "SEGUNDA": porCalidad[2]++; break;
                case "TERCERA": porCalidad[3]++; break;
                case "INDUSTRIAL": porCalidad[4]++; break;
                case "DESCARTE": porCalidad[5]++; break;
            }
            
            switch (prod.getDestino().name()) {
                case "VENTA": porDestino[0]++; break;
                case "CONSUMO": porDestino[1]++; break;
                case "ALMACENAMIENTO": porDestino[2]++; break;
                case "DESCARTE": porDestino[3]++; break;
            }
        }
        
        // Crear tabla de estadísticas
        PdfPTable tablaStats = new PdfPTable(2);
        tablaStats.setWidthPercentage(100);
        
        agregarEstadistica(tablaStats, "Total Kilogramos:", DECIMAL_FORMAT.format(totalKg) + " kg");
        agregarEstadistica(tablaStats, "Promedio por Producción:", DECIMAL_FORMAT.format(totalKg / producciones.size()) + " kg");
        
        // Agregar separador
        PdfPCell separador = new PdfPCell(new Phrase("Distribución por Calidad", SUBTITULO_FONT));
        separador.setColspan(2);
        separador.setBackgroundColor(BaseColor.LIGHT_GRAY);
        separador.setPadding(5);
        separador.setHorizontalAlignment(Element.ALIGN_CENTER);
        tablaStats.addCell(separador);
        
        agregarEstadistica(tablaStats, "Extra:", porCalidad[0] + " registros");
        agregarEstadistica(tablaStats, "Primera:", porCalidad[1] + " registros");
        agregarEstadistica(tablaStats, "Segunda:", porCalidad[2] + " registros");
        agregarEstadistica(tablaStats, "Tercera:", porCalidad[3] + " registros");
        agregarEstadistica(tablaStats, "Industrial:", porCalidad[4] + " registros");
        agregarEstadistica(tablaStats, "Descarte:", porCalidad[5] + " registros");
        
        // Agregar separador
        separador = new PdfPCell(new Phrase("Distribución por Destino", SUBTITULO_FONT));
        separador.setColspan(2);
        separador.setBackgroundColor(BaseColor.LIGHT_GRAY);
        separador.setPadding(5);
        separador.setHorizontalAlignment(Element.ALIGN_CENTER);
        tablaStats.addCell(separador);
        
        agregarEstadistica(tablaStats, "Venta:", porDestino[0] + " registros");
        agregarEstadistica(tablaStats, "Consumo:", porDestino[1] + " registros");
        agregarEstadistica(tablaStats, "Almacenamiento:", porDestino[2] + " registros");
        agregarEstadistica(tablaStats, "Descarte:", porDestino[3] + " registros");
        
        documento.add(tablaStats);
    }
    
    private void agregarCeldaEncabezado(PdfPTable tabla, String texto) {
        PdfPCell celda = new PdfPCell(new Phrase(texto, HEADER_FONT));
        celda.setBackgroundColor(new BaseColor(52, 73, 94));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda.setPadding(8);
        tabla.addCell(celda);
    }

    private void agregarCeldaDato(PdfPTable tabla, String texto) {
        PdfPCell celda = new PdfPCell(new Phrase(texto, TEXTO_FONT));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda.setPadding(5);
        celda.setBorderColor(BaseColor.LIGHT_GRAY);
        tabla.addCell(celda);
    }
    
    private void agregarEstadistica(PdfPTable tabla, String etiqueta, String valor) {
        PdfPCell celdaEtiqueta = new PdfPCell(new Phrase(etiqueta, SUBTITULO_FONT));
        celdaEtiqueta.setBorder(Rectangle.NO_BORDER);
        celdaEtiqueta.setPadding(5);
        tabla.addCell(celdaEtiqueta);
        
        PdfPCell celdaValor = new PdfPCell(new Phrase(valor, TEXTO_FONT));
        celdaValor.setBorder(Rectangle.NO_BORDER);
        celdaValor.setPadding(5);
        tabla.addCell(celdaValor);
    }
}
