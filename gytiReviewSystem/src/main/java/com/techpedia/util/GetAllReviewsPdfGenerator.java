/**
 * 
 */
package com.techpedia.util;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.techpedia.bean.AssignedByAndReviewDoneByMapper;
import com.techpedia.bean.OverallCalculatedReviewRatingVO;
import com.techpedia.constants.GetAllReviewsPdfConstants;

/**
 * @author 455959
 *
 */
public class GetAllReviewsPdfGenerator {
	private String HEADER_CONTENT_DESCRIPTION;
	private String HEADER_CONTENT_DESCRIPTION_CONTD;
	private String FOOTER_CONTENT_DESCRIPTION;
	private String FOOTER_CONTENT_DESCRIPTION_CONTD;
	private String FOOTER_CONTENT_DATE_CREATED;
	private String LIST_HEADER_COL1_STRING;
	private String LIST_HEADER_COL2_STRING;
	private String LIST_HEADER_COL3_STRING;
	private String LIST_HEADER_COL4_STRING;
	private String LIST_HEADER_COL5_STRING;
	private String LIST_HEADER_COL6_STRING;
	private String LIST_HEADER_COL7_STRING;

	public GetAllReviewsPdfGenerator(String HEADER_CONTENT_DESCRIPTION, String HEADER_CONTENT_DESCRIPTION_CONTD, String FOOTER_CONTENT_DESCRIPTION, String FOOTER_CONTENT_DESCRIPTION_CONTD, String FOOTER_CONTENT_DATE_CREATED,
			String LIST_HEADER_COL1_STRING, String LIST_HEADER_COL2_STRING, String LIST_HEADER_COL3_STRING, String LIST_HEADER_COL4_STRING,
			String LIST_HEADER_COL5_STRING, String LIST_HEADER_COL6_STRING, String LIST_HEADER_COL7_STRING) {
		this.HEADER_CONTENT_DESCRIPTION = HEADER_CONTENT_DESCRIPTION;
		this.HEADER_CONTENT_DESCRIPTION_CONTD = HEADER_CONTENT_DESCRIPTION_CONTD;
		this.FOOTER_CONTENT_DESCRIPTION = FOOTER_CONTENT_DESCRIPTION;
		this.FOOTER_CONTENT_DESCRIPTION_CONTD = FOOTER_CONTENT_DESCRIPTION_CONTD;
		this.FOOTER_CONTENT_DATE_CREATED = FOOTER_CONTENT_DATE_CREATED;
		this.LIST_HEADER_COL1_STRING = LIST_HEADER_COL1_STRING;
		this.LIST_HEADER_COL2_STRING = LIST_HEADER_COL2_STRING;
		this.LIST_HEADER_COL3_STRING = LIST_HEADER_COL3_STRING;
		this.LIST_HEADER_COL4_STRING = LIST_HEADER_COL4_STRING;
		this.LIST_HEADER_COL5_STRING = LIST_HEADER_COL5_STRING;
		this.LIST_HEADER_COL6_STRING = LIST_HEADER_COL6_STRING;
		this.LIST_HEADER_COL7_STRING = LIST_HEADER_COL7_STRING;
		
	}

	private static final Logger logger = Logger.getLogger(GetAllReviewsPdfGenerator.class);
	
	public ByteArrayOutputStream createGetAllReviewsPdf(List<OverallCalculatedReviewRatingVO> overallCalculatedReviewRatings, String reviewerName){
		
		logger.info("Inside Genrator ");
		Document document = null;
		PdfWriter writer = null;
		ByteArrayOutputStream byteArrayOutputStream = null;
		Rectangle pageSize = null;
		

	    try {
	    	
	    	pageSize = new Rectangle(GetAllReviewsPdfConstants.LIST_DOCUMENT_WIDTH, GetAllReviewsPdfConstants.LIST_DOCUMENT_HEIGHT);
	    	document = new Document(pageSize, GetAllReviewsPdfConstants.LIST_DOCUMENT_MARGIN_LEFT, GetAllReviewsPdfConstants.LIST_DOCUMENT_MARGIN_RIGHT, GetAllReviewsPdfConstants.LIST_DOCUMENT_MARGIN_TOP, GetAllReviewsPdfConstants.LIST_DOCUMENT_MARGIN_BOTTOM);
	    	
	    	byteArrayOutputStream = new ByteArrayOutputStream();
	    	writer = PdfWriter.getInstance(document,byteArrayOutputStream);
	        createHeaderAndFooter(writer, reviewerName);

	        document.open();
	        createTableHeader(document);
	        createTableRows(overallCalculatedReviewRatings, document);
	        return byteArrayOutputStream;
	        
	        
	    } catch(Exception e){
	    		logger.error("An Unexpected Exception occured in createPDF of GetAllReviewsPdfGenerator :: ",e);
	    		return null;
	    }
	    finally{
	    	if(document!=null){
	    		document.close();
	    		logger.debug("document closed");
	    	}
	    	if(writer!=null){
	    		writer.close();
	    		logger.debug("writer closed");
	    	}
	    	if(byteArrayOutputStream!=null){
	    		try {
	    			byteArrayOutputStream.close();
					logger.debug("byteArrayOutputStream closed");
				} catch (IOException e) {
					logger.info("An Unexpected exception occured while closing byteArrayOutputStream :: ",e);
				}
	    		
	    	}
	    }


	}

	private void createHeaderAndFooter(PdfWriter writer, String reviewerName) {
		HeaderAndFooter headerAndFooter = new HeaderAndFooter(HEADER_CONTENT_DESCRIPTION,HEADER_CONTENT_DESCRIPTION_CONTD,FOOTER_CONTENT_DESCRIPTION,FOOTER_CONTENT_DESCRIPTION_CONTD,FOOTER_CONTENT_DATE_CREATED);
		headerAndFooter.setHeaderAndFooter("", reviewerName);
		writer.setPageEvent(headerAndFooter);
	}

	private void createTableRows(List<OverallCalculatedReviewRatingVO> overallCalculatedReviewRatings, Document document) {

		Font tableDataFont = new Font(Font.FontFamily.HELVETICA  , GetAllReviewsPdfConstants.LIST_TABLE_DATA_FONT_SIZE);
	     
		PdfPTable outerTableForBorder = new PdfPTable(GetAllReviewsPdfConstants.LIST_DEFAULT_BORDER_TABLE_COLMN_COUNT);
		outerTableForBorder.setWidthPercentage(GetAllReviewsPdfConstants.LIST_DEFAULT_BORDER_TABLE_WIDTH_PCNTGE);
		outerTableForBorder.getDefaultCell().setBorderColor(BaseColor.GRAY);
        
        try{
        	
        for(OverallCalculatedReviewRatingVO overallCalculatedReviewRating : overallCalculatedReviewRatings){
		        
	        	PdfPTable mainDataTable = new PdfPTable(GetAllReviewsPdfConstants.LIST_TABLE_COLMN_COUNT);
	        	mainDataTable.setWidths(new int[]{GetAllReviewsPdfConstants.LIST_TABLE_COLUMN1_WIDTH, GetAllReviewsPdfConstants.LIST_TABLE_COLUMN2_WIDTH, GetAllReviewsPdfConstants.LIST_TABLE_COLUMN3_WIDTH, GetAllReviewsPdfConstants.LIST_TABLE_COLUMN4_WIDTH, GetAllReviewsPdfConstants.LIST_TABLE_COLUMN5_WIDTH, GetAllReviewsPdfConstants.LIST_TABLE_COLUMN6_WIDTH, GetAllReviewsPdfConstants.LIST_TABLE_COLUMN7_WIDTH });
	        	mainDataTable.setWidthPercentage(GetAllReviewsPdfConstants.LIST_TABLE_WIDTH_PCNTGE);
	        	mainDataTable.getDefaultCell().setBorderColor(BaseColor.WHITE);
		        
		        PdfPCell col1 = createTDCell(new PdfPCell(), ""+overallCalculatedReviewRating.getReviewedDate(), tableDataFont);
		        mainDataTable.addCell(col1);
		        
		        PdfPCell col2 = createTDCell(new PdfPCell(), ""+overallCalculatedReviewRating.getParticipantId(), tableDataFont);
		        mainDataTable.addCell(col2);
		        
		        PdfPCell col3 = createTDCell(new PdfPCell(), ""+overallCalculatedReviewRating.getProjTitle(), tableDataFont);
		        mainDataTable.addCell(col3);
		        
		        Chunk categoryChunk = new Chunk();
		        for(String categoryName : overallCalculatedReviewRating.getProjCategory()){
		        	categoryChunk.append(categoryName+"\n\n");
		        }
		        PdfPCell col4 = createTDCell(new PdfPCell(), ""+categoryChunk, tableDataFont);
		        mainDataTable.addCell(col4);
		        
		        Chunk assignedByNameChunk = new Chunk();
		        for(AssignedByAndReviewDoneByMapper assignedByAndReviewDoneByMapper : overallCalculatedReviewRating.getAssignedByAndReviewDoneByMapperSet()){
		        	String assignedByName = assignedByAndReviewDoneByMapper.getAssignedByName();
		        	assignedByNameChunk.append(assignedByName+"\n\n");
		        }
		        PdfPCell col5 = createTDCell(new PdfPCell(), ""+assignedByNameChunk, tableDataFont);
		        mainDataTable.addCell(col5);
		        
		        Chunk reviewDoneByNameChunk = new Chunk();
		        for(AssignedByAndReviewDoneByMapper assignedByAndReviewDoneByMapper : overallCalculatedReviewRating.getAssignedByAndReviewDoneByMapperSet()){
		        	String reviewDoneByName = assignedByAndReviewDoneByMapper.getReviewDoneByName();
		        	reviewDoneByNameChunk.append(reviewDoneByName+"\n\n");
		        }
		        PdfPCell col6 = createTDCell(new PdfPCell(), ""+reviewDoneByNameChunk, tableDataFont);
		        mainDataTable.addCell(col6);
		        
		        PdfPCell col7 = createTDCell(new PdfPCell(), ""+overallCalculatedReviewRating.getAverageRating()+"%", tableDataFont);
		        mainDataTable.addCell(col7);
		        
		        outerTableForBorder.addCell(mainDataTable);
        	}
        	document.add(outerTableForBorder);
	       }
		        
	        catch(Exception e){
	        	logger.error("An Unexpected Exception occured in createTableRows of GetAllReviewsPdfGenerator :: ",e);
	        }
	       
	}

	private PdfPCell createTDCell(PdfPCell cell, String text, Font font) {
		cell = new PdfPCell(new Phrase(text, font) );
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(Rectangle.NO_BORDER);
		return cell;
	}

	private PdfPCell createTHCell(PdfPCell cell, String text, Font font, BaseColor bgColor) {
		cell = new PdfPCell(new Phrase(text, font) );
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setBackgroundColor(bgColor);
		return cell;
	}

	private void createTableHeader(Document document) {
		
		Font tableHeaderfont = new Font(Font.FontFamily.HELVETICA  , 8, Font.BOLD);
		Color colorinrgb = hex2Rgb(GetAllReviewsPdfConstants.LIST_HEADER_TABLE_BGCOLOR);
		int tableHeaderBgColor = colorinrgb.getRGB();
		BaseColor tableHeaderBgBaseColor = new BaseColor(tableHeaderBgColor);
		PdfPTable headerContentTable = new PdfPTable(GetAllReviewsPdfConstants.LIST_TABLE_COLMN_COUNT);
		try{
				headerContentTable.setWidths(new int[]{GetAllReviewsPdfConstants.LIST_TABLE_COLUMN1_WIDTH, GetAllReviewsPdfConstants.LIST_TABLE_COLUMN2_WIDTH, GetAllReviewsPdfConstants.LIST_TABLE_COLUMN3_WIDTH, GetAllReviewsPdfConstants.LIST_TABLE_COLUMN4_WIDTH, GetAllReviewsPdfConstants.LIST_TABLE_COLUMN5_WIDTH, GetAllReviewsPdfConstants.LIST_TABLE_COLUMN6_WIDTH, GetAllReviewsPdfConstants.LIST_TABLE_COLUMN7_WIDTH });
		        headerContentTable.setWidthPercentage(100);
		        
		        PdfPCell tableHeaderCol1 = createTHCell(new PdfPCell(), LIST_HEADER_COL1_STRING, tableHeaderfont, tableHeaderBgBaseColor);
		        headerContentTable.addCell(tableHeaderCol1);
		        
		        PdfPCell tableHeaderCol2 = createTHCell(new PdfPCell(), LIST_HEADER_COL2_STRING, tableHeaderfont, tableHeaderBgBaseColor);
		        headerContentTable.addCell(tableHeaderCol2);
		
		        PdfPCell tableHeaderCol3 = createTHCell(new PdfPCell(), LIST_HEADER_COL3_STRING, tableHeaderfont, tableHeaderBgBaseColor);
		        headerContentTable.addCell(tableHeaderCol3);
		
		        PdfPCell tableHeaderCol4 = createTHCell(new PdfPCell(), LIST_HEADER_COL4_STRING, tableHeaderfont, tableHeaderBgBaseColor);
		        headerContentTable.addCell(tableHeaderCol4);
		        
		        PdfPCell tableHeaderCol5 = createTHCell(new PdfPCell(), LIST_HEADER_COL5_STRING, tableHeaderfont, tableHeaderBgBaseColor);
		        headerContentTable.addCell(tableHeaderCol5);
		        
		        PdfPCell tableHeaderCol6 = createTHCell(new PdfPCell(), LIST_HEADER_COL6_STRING, tableHeaderfont, tableHeaderBgBaseColor);
		        headerContentTable.addCell(tableHeaderCol6);
		        
		        PdfPCell tableHeaderCol7 = createTHCell(new PdfPCell(), LIST_HEADER_COL7_STRING, tableHeaderfont, tableHeaderBgBaseColor);
		        headerContentTable.addCell(tableHeaderCol7);
		        
		        document.add(headerContentTable);
		        
		}catch(Exception e){
			logger.error("An Unexpected Exception occured in createTableHeader of GetAllReviewsPdfGenerator :: ",e);
		}
		
	}
	
	public static Color hex2Rgb(String colorStr) {
	    return new Color(
	            Integer.valueOf( colorStr.substring( 1, 3 ), 16 ),
	            Integer.valueOf( colorStr.substring( 3, 5 ), 16 ),
	            Integer.valueOf( colorStr.substring( 5, 7 ), 16 ) );
	}
	

}
