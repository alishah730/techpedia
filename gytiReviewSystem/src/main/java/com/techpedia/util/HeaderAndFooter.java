package com.techpedia.util;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;




import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.techpedia.constants.HeaderAndFooterConstants;

public class HeaderAndFooter extends PdfPageEventHelper {


    private String footer;
    private String header;
    private String HEADER_CONTENT_DESCRIPTION;
    private String HEADER_CONTENT_DESCRIPTION_CONTD;
    private String FOOTER_CONTENT_DESCRIPTION;
    private String FOOTER_CONTENT_DESCRIPTION_CONTD;
    private String FOOTER_CONTENT_DATE_CREATED;

    private static Logger logger = Logger.getLogger(HeaderAndFooter.class);
    
    /**
     * Font color for header and footer part.
     */
    
    Color headerFontColorInRGB = hex2Rgb(HeaderAndFooterConstants.HEADER_FONT_COLOR);
	int headerFontColorCode = headerFontColorInRGB.getRGB();
	BaseColor headerFontColor = new BaseColor(headerFontColorCode);
	
	Color footerFontColorInRGB = hex2Rgb(HeaderAndFooterConstants.FOOTER_FONT_COLOR);
	int footerFontColorCode = footerFontColorInRGB.getRGB();
	BaseColor footerFontColor = new BaseColor(footerFontColorCode);

    /**
     * Font for header and footer part.
     */
    private Font headerFont = new Font(Font.FontFamily.HELVETICA, HeaderAndFooterConstants.HEADER_FONT_SIZE,
            Font.BOLD,headerFontColor);

    private Font footerFont =  new Font(Font.FontFamily.HELVETICA, HeaderAndFooterConstants.FOOTER_FONT_SIZE,
            Font.NORMAL,footerFontColor);
            

    public HeaderAndFooter(String HEADER_CONTENT_DESCRIPTION, String HEADER_CONTENT_DESCRIPTION_CONTD, String FOOTER_CONTENT_DESCRIPTION, String FOOTER_CONTENT_DESCRIPTION_CONTD, String FOOTER_CONTENT_DATE_CREATED) {
    	this.HEADER_CONTENT_DESCRIPTION = HEADER_CONTENT_DESCRIPTION;
    	this.HEADER_CONTENT_DESCRIPTION_CONTD = HEADER_CONTENT_DESCRIPTION_CONTD;
		this.FOOTER_CONTENT_DESCRIPTION = FOOTER_CONTENT_DESCRIPTION;
		this.FOOTER_CONTENT_DESCRIPTION_CONTD = FOOTER_CONTENT_DESCRIPTION_CONTD;
		this.FOOTER_CONTENT_DATE_CREATED = FOOTER_CONTENT_DATE_CREATED;
	}

	public void setHeaderAndFooter(String headerValue, String footerValue) {

        this.header = headerValue;
        this.footer = footerValue;
    }
   
    /**
     * Adds a header to every page
     * @see com.itextpdf.text.pdf.PdfPageEventHelper#onEndPage(
     *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
     */
    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        PdfPTable headerTable = new PdfPTable(HeaderAndFooterConstants.HEADER_TABLE_COLMN_COUNT);
        PdfPTable footerTable = new PdfPTable(HeaderAndFooterConstants.FOOTER_TABLE_COLMN_COUNT);
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        String createdDate = dateFormat.format(date);
        Rectangle rect = document.getPageSize();
        Image logo = null;
        
        logo = getLogoImage();
        
        
        try {
        	Color colorinrgb = hex2Rgb(HeaderAndFooterConstants.HEADER_TABLE_BGCOLOR);
    		int headerBgColor = colorinrgb.getRGB();
    		BaseColor headerBgBaseColor = new BaseColor(headerBgColor);
    		headerTable.getDefaultCell().setBackgroundColor(headerBgBaseColor);
        	
        	/**
             * set header content
             */
	        headerTable.setTotalWidth(rect.getWidth()-(document.leftMargin()+document.rightMargin()));
            headerTable.setLockedWidth(true);
            headerTable.setWidths(new int[]{HeaderAndFooterConstants.HEADER_TABLE_COLUMN1_WIDTH, HeaderAndFooterConstants.HEADER_TABLE_COLUMN2_WIDTH});
           
            if(logo!=null){
              	PdfPCell cell = new PdfPCell(logo);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell.setPadding(HeaderAndFooterConstants.HEADER_PADDING);
                cell.getEffectivePaddingBottom();
                cell.setBorder(Rectangle.BOTTOM);
                logo.scaleToFit(HeaderAndFooterConstants.HEADER_LOGO_WIDTH, HeaderAndFooterConstants.HEADER_LOGO_HEIGHT);
                cell.addElement(logo);
                cell.setBackgroundColor(headerBgBaseColor);
                headerTable.addCell(cell);
           	}
            else{
            	PdfPCell cell = new PdfPCell();
            	cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell.setPaddingBottom(HeaderAndFooterConstants.HEADER_PADDING );
                cell.setFixedHeight(HeaderAndFooterConstants.HEADER_LOGO_HEIGHT);
                cell.getEffectivePaddingBottom();
                cell.setBorder(Rectangle.BOTTOM);
                cell.setBackgroundColor(headerBgBaseColor);
            	headerTable.addCell(cell);
            }
            
            
            if(HEADER_CONTENT_DESCRIPTION_CONTD==null||HEADER_CONTENT_DESCRIPTION_CONTD.equalsIgnoreCase("")){
            	PdfPCell hCell = new PdfPCell(new Phrase( "\n "+HEADER_CONTENT_DESCRIPTION, headerFont));
            	hCell.setBorder(Rectangle.BOTTOM);
            	hCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            	hCell.setBackgroundColor(headerBgBaseColor);
            	headerTable.addCell(hCell);
            }else{
	        	PdfPCell hCell = new PdfPCell(new Phrase( "\n "+HEADER_CONTENT_DESCRIPTION+ " - "+HEADER_CONTENT_DESCRIPTION_CONTD+" "+header, headerFont));
	        	hCell.setBorder(Rectangle.BOTTOM);
	        	hCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	        	hCell.setBackgroundColor(headerBgBaseColor);
	        	headerTable.addCell(hCell);
            }
            
            /**
             * set footer content
             */
            footerTable.setTotalWidth(rect.getWidth()-(document.leftMargin()+document.rightMargin()));
            footerTable.setLockedWidth(true);
            footerTable.getDefaultCell().setBorder(Rectangle.TOP);
            footerTable.setWidths(new int[]{HeaderAndFooterConstants.FOOTER_TABLE_COLUMN1_WIDTH, HeaderAndFooterConstants.FOOTER_TABLE_COLUMN2_WIDTH, HeaderAndFooterConstants.FOOTER_TABLE_COLUMN3_WIDTH});
            
            footerTable.addCell(new Phrase( FOOTER_CONTENT_DESCRIPTION +" "+footer+" "+FOOTER_CONTENT_DESCRIPTION_CONTD+" ",footerFont));
            footerTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
            footerTable.addCell(new Phrase(""));
            footerTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            footerTable.addCell(new Phrase(FOOTER_CONTENT_DATE_CREATED+" "+createdDate,footerFont));
            footerTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
            
            /**
             * set header position
             */
            headerTable.writeSelectedRows(HeaderAndFooterConstants.HEADER_ROW_START,HeaderAndFooterConstants.HEADER_ROW_END, document.leftMargin(), rect.getHeight()-document.topMargin() + HeaderAndFooterConstants.HEADER_LOGO_HEIGHT + HeaderAndFooterConstants.HEADER_LOGO_CELL_PADDING_BOTTOM + HeaderAndFooterConstants.HEADER_PADDING_BOTTOM, writer.getDirectContent());
            /**
             * set footer position
             */
            footerTable.writeSelectedRows(HeaderAndFooterConstants.HEADER_ROW_START,HeaderAndFooterConstants.HEADER_ROW_END, document.leftMargin(), document.bottomMargin()-HeaderAndFooterConstants.FOOTER_PADDING_TOP, writer.getDirectContent());
            
        }
        catch(Exception e) {
        	logger.error("An Unexpected Exception occured in onEndPage of HeaderAndFooter :: ",e);
        }
    }
    private Image getLogoImage() {

	 	Image logo = null;
		 		 try {
		 			ResourceBundle rbundle = ResourceBundle.getBundle("config");
		 			String path = rbundle.getString("techpediaLogo.path");
		 			logger.info("Logo Path :: "+path);
			 		logo = Image.getInstance(path);
		 		 } catch (Exception e) {
		 			 logger.error("An Unexpected Exception occured while getLogoImage :: ", e);
		 			 return logo;
		 		 }
		 		 return logo;
		 	
	 	
    }
    public static Color hex2Rgb(String colorStr) {
	    return new Color(
	            Integer.valueOf( colorStr.substring( 1, 3 ), 16 ),
	            Integer.valueOf( colorStr.substring( 3, 5 ), 16 ),
	            Integer.valueOf( colorStr.substring( 5, 7 ), 16 ) );
	}

}


