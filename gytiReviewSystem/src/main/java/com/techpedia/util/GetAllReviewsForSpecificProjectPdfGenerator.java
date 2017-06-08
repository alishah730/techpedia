/**
 * 
 */
package com.techpedia.util;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.techpedia.bean.AssignedByAndReviewDoneByMapper;
import com.techpedia.bean.OverallCalculatedReviewRatingVO;
import com.techpedia.constants.GetAllReviewsForSpecificProjectPdfConstants;

/**
 * @author 455959
 *
 */
public class GetAllReviewsForSpecificProjectPdfGenerator {
	private String HEADER_CONTENT_DESCRIPTION;
	private String HEADER_CONTENT_DESCRIPTION_CONTD;
	private String FOOTER_CONTENT_DESCRIPTION;
	private String FOOTER_CONTENT_DESCRIPTION_CONTD;
	private String FOOTER_CONTENT_DATE_CREATED;
	private String ROW1_STRING;
	private String ROW2_STRING;
	private String ROW3_STRING;
	private String ROW4_STRING;
	private String ROW5_STRING;
	private String ROW6_STRING;
	private String ROW7_STRING;
	private String ROW8_STRING;
	private String ROW9_STRING;
	private String ROW10_STRING;
	private String ROW11_STRING;
	private String ROW12_STRING;
	private String ROW13_STRING;
	private String ROW14_STRING;
	private String ROW15_STRING;
	private String ROW16_STRING;
	private String ROW17_STRING;
	private String ROW18_STRING;
	private String ROW19_STRING;
	private String ROW20_STRING;

	public GetAllReviewsForSpecificProjectPdfGenerator(String HEADER_CONTENT_DESCRIPTION, String HEADER_CONTENT_DESCRIPTION_CONTD, String FOOTER_CONTENT_DESCRIPTION, String FOOTER_CONTENT_DESCRIPTION_CONTD, String FOOTER_CONTENT_DATE_CREATED,
			String ROW1_STRING, String ROW2_STRING, String ROW3_STRING, String ROW4_STRING,
			String ROW5_STRING, String ROW6_STRING, String ROW7_STRING, String ROW8_STRING,
			String ROW9_STRING, String ROW10_STRING, String ROW11_STRING, String ROW12_STRING,
			String ROW13_STRING, String ROW14_STRING, String ROW15_STRING, String ROW16_STRING,
			String ROW17_STRING, String ROW18_STRING, String ROW19_STRING, String ROW20_STRING
			) {
		this.HEADER_CONTENT_DESCRIPTION = HEADER_CONTENT_DESCRIPTION;
		this.HEADER_CONTENT_DESCRIPTION_CONTD = HEADER_CONTENT_DESCRIPTION_CONTD;
		this.FOOTER_CONTENT_DESCRIPTION = FOOTER_CONTENT_DESCRIPTION;
		this.FOOTER_CONTENT_DESCRIPTION_CONTD = FOOTER_CONTENT_DESCRIPTION_CONTD;
		this.FOOTER_CONTENT_DATE_CREATED = FOOTER_CONTENT_DATE_CREATED;
		this.ROW1_STRING = ROW1_STRING;
		this.ROW2_STRING = ROW2_STRING;
		this.ROW3_STRING = ROW3_STRING;
		this.ROW4_STRING = ROW4_STRING;
		this.ROW5_STRING = ROW5_STRING;
		this.ROW6_STRING = ROW6_STRING;
		this.ROW7_STRING = ROW7_STRING;
		this.ROW8_STRING = ROW8_STRING;
		this.ROW9_STRING = ROW9_STRING;
		this.ROW10_STRING = ROW10_STRING;
		this.ROW11_STRING = ROW11_STRING;
		this.ROW12_STRING = ROW12_STRING;
		this.ROW13_STRING = ROW13_STRING;
		this.ROW14_STRING = ROW14_STRING;
		this.ROW15_STRING = ROW15_STRING;
		this.ROW16_STRING = ROW16_STRING;
		this.ROW17_STRING = ROW17_STRING;
		this.ROW18_STRING = ROW18_STRING;
		this.ROW19_STRING = ROW19_STRING;
		this.ROW20_STRING = ROW20_STRING;
		
	}

	private static final Logger logger = Logger.getLogger(GetAllReviewsForSpecificProjectPdfGenerator.class);
	
	public ByteArrayOutputStream createGetAllReviewsForSpecificProjectPdf(OverallCalculatedReviewRatingVO overallCalculatedReviewRating, String reviewerName){
		
		logger.info("Inside Genrator ");
		Document document = null;
		PdfWriter writer = null;
		ByteArrayOutputStream byteArrayOutputStream = null;
		Rectangle pageSize = null;
		

	    try {
	    	
	    	pageSize = new Rectangle(GetAllReviewsForSpecificProjectPdfConstants.LIST_DOCUMENT_WIDTH, GetAllReviewsForSpecificProjectPdfConstants.LIST_DOCUMENT_HEIGHT);
	    	document = new Document(pageSize, GetAllReviewsForSpecificProjectPdfConstants.LIST_DOCUMENT_MARGIN_LEFT, GetAllReviewsForSpecificProjectPdfConstants.LIST_DOCUMENT_MARGIN_RIGHT, GetAllReviewsForSpecificProjectPdfConstants.LIST_DOCUMENT_MARGIN_TOP, GetAllReviewsForSpecificProjectPdfConstants.LIST_DOCUMENT_MARGIN_BOTTOM);
	    	
	    	byteArrayOutputStream = new ByteArrayOutputStream();
	    	writer = PdfWriter.getInstance(document,byteArrayOutputStream);
	        createHeaderAndFooter(writer, reviewerName);

	        document.open();
	        createTableRows(overallCalculatedReviewRating, document);
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

	private void createTableRows(OverallCalculatedReviewRatingVO overallCalculatedReviewRating, Document document) {

		Font tableDataFont = new Font(Font.FontFamily.HELVETICA, GetAllReviewsForSpecificProjectPdfConstants.LIST_TABLE_DATA_FONT_SIZE);
		Font tableHeaderfont = new Font(Font.FontFamily.HELVETICA , GetAllReviewsForSpecificProjectPdfConstants.LIST_TABLE_DATA_FONT_SIZE, Font.BOLD);
        
        try{
        	
        	PdfPTable outerTableForBorder1 = new PdfPTable(GetAllReviewsForSpecificProjectPdfConstants.LIST_DEFAULT_BORDER_TABLE_COLMN_COUNT);
    		outerTableForBorder1.setWidthPercentage(GetAllReviewsForSpecificProjectPdfConstants.LIST_DEFAULT_BORDER_TABLE_WIDTH_PCNTGE);
    		outerTableForBorder1.getDefaultCell().setBorderColor(BaseColor.GRAY);
        	
        	PdfPTable mainDataTable = new PdfPTable(GetAllReviewsForSpecificProjectPdfConstants.LIST_TABLE_COLMN_COUNT);
        	mainDataTable.setWidths(new int[]{GetAllReviewsForSpecificProjectPdfConstants.LIST_TABLE_COLUMN1_WIDTH, GetAllReviewsForSpecificProjectPdfConstants.LIST_TABLE_COLUMN2_WIDTH});
        	mainDataTable.setWidthPercentage(GetAllReviewsForSpecificProjectPdfConstants.LIST_TABLE_WIDTH_PCNTGE);
        	mainDataTable.getDefaultCell().setBorderColor(BaseColor.WHITE);
    		
        	PdfPCell cell11 = createTDCell(new PdfPCell(), ROW1_STRING, tableHeaderfont);
	        PdfPCell cell12 = createTDCell(new PdfPCell(), ""+overallCalculatedReviewRating.getProjTitle(), tableDataFont);
	        PdfPRow row1 = createTDRow(cell11,cell12);
	        mainDataTable.getRows().add(row1);
        	
        	PdfPCell cell21 = createTDCell(new PdfPCell(), ROW2_STRING, tableHeaderfont);
	        PdfPCell cell22 = createTDCell(new PdfPCell(), ""+overallCalculatedReviewRating.getParticipantId(), tableDataFont);
	        PdfPRow row2 = createTDRow(cell21,cell22);
	        mainDataTable.getRows().add(row2);
	        
	        PdfPCell cell31 = createTDCell(new PdfPCell(), ROW3_STRING, tableHeaderfont);
	        PdfPCell cell32 = createTDCell(new PdfPCell(), ""+overallCalculatedReviewRating.getReviewedDate(), tableDataFont);
	        PdfPRow row3 = createTDRow(cell31,cell32);
	        mainDataTable.getRows().add(row3);
	        
	        PdfPCell cell41 = createTDCell(new PdfPCell(), ROW4_STRING, tableHeaderfont);
	        Chunk categoryChunk = new Chunk();
	        for(String categoryName : overallCalculatedReviewRating.getProjCategory()){
	        	categoryChunk.append(categoryName+"\n");
	        }
	        PdfPCell cell42 = createTDCell(new PdfPCell(), ""+categoryChunk, tableDataFont);
	        PdfPRow row4 = createTDRow(cell41,cell42);
	        mainDataTable.getRows().add(row4);
	        
	        PdfPCell cell5x1 = createTDCell(new PdfPCell(), ROW20_STRING, tableHeaderfont);
	        PdfPCell cell5x2 = createTDCell(new PdfPCell(), ""+overallCalculatedReviewRating.getAverageRating()+"%", tableDataFont);
	        PdfPRow row5x = createTDRow(cell5x1,cell5x2);
	        mainDataTable.getRows().add(row5x);
	        
	        outerTableForBorder1.addCell(mainDataTable);
	        
	        document.add(outerTableForBorder1);
		        
	        for(AssignedByAndReviewDoneByMapper assignedByAndReviewDoneByMapper : overallCalculatedReviewRating.getAssignedByAndReviewDoneByMapperSet()){
	        	
	        	document.add(new Phrase("\n\n"));
	        	PdfPTable outerTableForBorder = new PdfPTable(GetAllReviewsForSpecificProjectPdfConstants.LIST_DEFAULT_BORDER_TABLE_COLMN_COUNT);
	    		outerTableForBorder.setWidthPercentage(GetAllReviewsForSpecificProjectPdfConstants.LIST_DEFAULT_BORDER_TABLE_WIDTH_PCNTGE);
	    		outerTableForBorder.getDefaultCell().setBorderColor(BaseColor.GRAY);
	        	
	        	PdfPTable lowerDataTable = new PdfPTable(GetAllReviewsForSpecificProjectPdfConstants.LIST_TABLE_COLMN_COUNT);
	        	lowerDataTable.setWidths(new int[]{GetAllReviewsForSpecificProjectPdfConstants.LIST_TABLE_COLUMN1_WIDTH, GetAllReviewsForSpecificProjectPdfConstants.LIST_TABLE_COLUMN2_WIDTH});
	        	lowerDataTable.setWidthPercentage(GetAllReviewsForSpecificProjectPdfConstants.LIST_TABLE_WIDTH_PCNTGE);
	        	lowerDataTable.getDefaultCell().setBorderColor(BaseColor.WHITE);
	        
		        PdfPCell cell51 = createTDCell(new PdfPCell(), ROW5_STRING, tableHeaderfont);
		        PdfPCell cell52 = createTDCell(new PdfPCell(), ""+assignedByAndReviewDoneByMapper.getAssignedByName(), tableDataFont);
		        PdfPRow row5 = createTDRow(cell51,cell52);
		        lowerDataTable.getRows().add(row5);
		        
		        PdfPCell cell61 = createTDCell(new PdfPCell(), ROW6_STRING, tableHeaderfont);
		        PdfPCell cell62 = createTDCell(new PdfPCell(), ""+assignedByAndReviewDoneByMapper.getReviewDoneByName(), tableDataFont);
		        PdfPRow row6 = createTDRow(cell61,cell62);
		        lowerDataTable.getRows().add(row6);
		        
		        PdfPCell cell71 = createTDCell(new PdfPCell(), ROW7_STRING, tableHeaderfont);
		        PdfPCell cell72 = createTDCell(new PdfPCell(), ""+assignedByAndReviewDoneByMapper.getRevRecommendation(), tableDataFont);
		        PdfPRow row7 = createTDRow(cell71,cell72);
		        lowerDataTable.getRows().add(row7);
		        
		        PdfPCell cell7x1 = createTDCell(new PdfPCell(), ROW19_STRING, tableHeaderfont);
		        PdfPCell cell7x2 = createTDCell(new PdfPCell(), ""+assignedByAndReviewDoneByMapper.getRevNovelty(), tableDataFont);
		        PdfPRow row7x = createTDRow(cell7x1,cell7x2);
		        lowerDataTable.getRows().add(row7x);
		        
		        PdfPCell cell81 = createTDCell(new PdfPCell(), ROW8_STRING, tableHeaderfont);
		        PdfPCell cell82 = createTDCell(new PdfPCell(), ""+assignedByAndReviewDoneByMapper.getRevTechnicalRigor(), tableDataFont);
		        PdfPRow row8 = createTDRow(cell81,cell82);
		        lowerDataTable.getRows().add(row8);
		        
		        PdfPCell cell91 = createTDCell(new PdfPCell(), ROW9_STRING, tableHeaderfont);
		        PdfPCell cell92 = createTDCell(new PdfPCell(), ""+assignedByAndReviewDoneByMapper.getRevSocialApplication(), tableDataFont);
		        PdfPRow row9 = createTDRow(cell91,cell92);
		        lowerDataTable.getRows().add(row9);
		        
		        PdfPCell cell101 = createTDCell(new PdfPCell(), ROW10_STRING, tableHeaderfont);
		        PdfPCell cell102 = createTDCell(new PdfPCell(), ""+assignedByAndReviewDoneByMapper.getRevFrugality(), tableDataFont);
		        PdfPRow row101 = createTDRow(cell101,cell102);
		        lowerDataTable.getRows().add(row101);
		        
		        PdfPCell cell111 = createTDCell(new PdfPCell(), ROW11_STRING, tableHeaderfont);
		        PdfPCell cell112 = createTDCell(new PdfPCell(), ""+assignedByAndReviewDoneByMapper.getRevRatingPercentage()+"%", tableDataFont);
		        PdfPRow row11 = createTDRow(cell111,cell112);
		        lowerDataTable.getRows().add(row11);
		        
		        PdfPCell cell121 = createTDCell(new PdfPCell(), ROW12_STRING, tableHeaderfont);
		        PdfPCell cell122 = createTDCell(new PdfPCell(), ""+assignedByAndReviewDoneByMapper.getRevComments(), tableDataFont);
		        PdfPRow row12 = createTDRow(cell121,cell122);
		        lowerDataTable.getRows().add(row12);
		        
		        PdfPCell cell131 = createTDCell(new PdfPCell(), ROW13_STRING, tableHeaderfont);
		        PdfPCell cell132 = createTDCell(new PdfPCell(), ""+assignedByAndReviewDoneByMapper.getRevSuggestedLinks(), tableDataFont);
		        PdfPRow row13 = createTDRow(cell131,cell132);
		        lowerDataTable.getRows().add(row13);
		        
		        PdfPCell cell141 = createTDCell(new PdfPCell(), ROW14_STRING, tableHeaderfont);
		        PdfPCell cell142 = createTDCell(new PdfPCell(), ""+assignedByAndReviewDoneByMapper.getCanIdeaBeTakenForward(), tableDataFont);
		        PdfPRow row14 = createTDRow(cell141,cell142);
		        lowerDataTable.getRows().add(row14);
		        
		        PdfPCell cell151 = createTDCell(new PdfPCell(), ROW15_STRING, tableHeaderfont);
		        PdfPCell cell152 = createTDCell(new PdfPCell(), ""+assignedByAndReviewDoneByMapper.getCanIdeaBeTakenForwardRemarks(), tableDataFont);
		        PdfPRow row15 = createTDRow(cell151,cell152);
		        lowerDataTable.getRows().add(row15);
		        
		        PdfPCell cell161 = createTDCell(new PdfPCell(), ROW16_STRING, tableHeaderfont);
		        PdfPCell cell162 = createTDCell(new PdfPCell(), ""+assignedByAndReviewDoneByMapper.getMoreInfoNeeded(), tableDataFont);
		        PdfPRow row16 = createTDRow(cell161,cell162);
		        lowerDataTable.getRows().add(row16);
		        
		        PdfPCell cell171 = createTDCell(new PdfPCell(), ROW17_STRING, tableHeaderfont);
		        PdfPCell cell172 = createTDCell(new PdfPCell(), ""+assignedByAndReviewDoneByMapper.getMoreInfoNeededRemarks(), tableDataFont);
		        PdfPRow row17 = createTDRow(cell171,cell172);
		        lowerDataTable.getRows().add(row17);
		        
		        PdfPCell cell181 = createTDCell(new PdfPCell(), ROW18_STRING, tableHeaderfont);
		        PdfPCell cell182 = createTDCell(new PdfPCell(), ""+assignedByAndReviewDoneByMapper.getSuggestToOtherRev(), tableDataFont);
		        PdfPRow row18 = createTDRow(cell181,cell182);
		        lowerDataTable.getRows().add(row18);
		        
		        outerTableForBorder.addCell(lowerDataTable);
		        document.add(outerTableForBorder);
	        }
	        
        }
        catch(Exception e){
        	logger.error("An Unexpected Exception occured in createTableRows of createGetAllReviewsForSpecificProjectPdfGenerator :: ",e);
        }
	       
	}

	private PdfPCell createTDCell(PdfPCell cell, String text, Font font) {
		cell = new PdfPCell(new Phrase(text, font) );
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setPadding(8f);
		return cell;
	}
	private PdfPRow createTDRow(PdfPCell cell1,PdfPCell cell2) {
        PdfPCell[] cells = new PdfPCell[2];
        cells[0]=cell1;
        cells[1]=cell2;
        PdfPRow row = new PdfPRow(cells);
        return row;
	}

	public static Color hex2Rgb(String colorStr) {
	    return new Color(
	            Integer.valueOf( colorStr.substring( 1, 3 ), 16 ),
	            Integer.valueOf( colorStr.substring( 3, 5 ), 16 ),
	            Integer.valueOf( colorStr.substring( 5, 7 ), 16 ) );
	}
	

}
