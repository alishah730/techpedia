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
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.techpedia.bean.AssignedByAndReviewDoneByMapper;
import com.techpedia.bean.Branch;
import com.techpedia.bean.OverallCalculatedReviewRatingVO;
import com.techpedia.bean.SubmitInnovationToGytiForPdfVO;
import com.techpedia.constants.GetGytiProjectDetailsPdfConstants;

/**
 * @author charan_teja
 *
 */
public class GetGytiProjectDetailsPdfGenerator {
	private String HEADER_CONTENT_DESCRIPTION;
	private String HEADER_CONTENT_DESCRIPTION_CONTD;
	private String FOOTER_CONTENT_DESCRIPTION;
	private String FOOTER_CONTENT_DESCRIPTION_CONTD;
	private String FOOTER_CONTENT_DATE_CREATED;
	private String LIST_HEADER_COL1_STRING;
	private String LIST_HEADER_COL2_STRING;

	public GetGytiProjectDetailsPdfGenerator(String HEADER_CONTENT_DESCRIPTION, String HEADER_CONTENT_DESCRIPTION_CONTD, String FOOTER_CONTENT_DESCRIPTION, String FOOTER_CONTENT_DESCRIPTION_CONTD, String FOOTER_CONTENT_DATE_CREATED,
			String LIST_HEADER_COL1_STRING, String LIST_HEADER_COL2_STRING) {
		this.HEADER_CONTENT_DESCRIPTION = HEADER_CONTENT_DESCRIPTION;
		this.HEADER_CONTENT_DESCRIPTION_CONTD = HEADER_CONTENT_DESCRIPTION_CONTD;
		this.FOOTER_CONTENT_DESCRIPTION = FOOTER_CONTENT_DESCRIPTION;
		this.FOOTER_CONTENT_DESCRIPTION_CONTD = FOOTER_CONTENT_DESCRIPTION_CONTD;
		this.FOOTER_CONTENT_DATE_CREATED = FOOTER_CONTENT_DATE_CREATED;
		this.LIST_HEADER_COL1_STRING = LIST_HEADER_COL1_STRING;
		this.LIST_HEADER_COL2_STRING = LIST_HEADER_COL2_STRING;
	}

	private static final Logger logger = Logger.getLogger(GetGytiProjectDetailsPdfGenerator.class);
	
	public ByteArrayOutputStream createGetGytiProjectDetailsPdf(SubmitInnovationToGytiForPdfVO gytiProjectDetails, String reviewerName){
		
		logger.info("Inside gyti Project Details Genrator ");
		Document document = null;
		PdfWriter writer = null;
		ByteArrayOutputStream byteArrayOutputStream = null;
		Rectangle pageSize = null;
		

	    try {
	    	
	    	pageSize = new Rectangle(GetGytiProjectDetailsPdfConstants.LIST_DOCUMENT_WIDTH, GetGytiProjectDetailsPdfConstants.LIST_DOCUMENT_HEIGHT);
	    	document = new Document(pageSize, GetGytiProjectDetailsPdfConstants.LIST_DOCUMENT_MARGIN_LEFT, GetGytiProjectDetailsPdfConstants.LIST_DOCUMENT_MARGIN_RIGHT, GetGytiProjectDetailsPdfConstants.LIST_DOCUMENT_MARGIN_TOP, GetGytiProjectDetailsPdfConstants.LIST_DOCUMENT_MARGIN_BOTTOM);
	    	
	    	byteArrayOutputStream = new ByteArrayOutputStream();
	    	writer = PdfWriter.getInstance(document,byteArrayOutputStream);
	        createHeaderAndFooter(writer, reviewerName);

	        document.open();
	        createTableRows(gytiProjectDetails, document);
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

	private void createTableRows(SubmitInnovationToGytiForPdfVO gytiProjectDetails, Document document) {

		Font tableDataFont = new Font(Font.FontFamily.HELVETICA  , GetGytiProjectDetailsPdfConstants.LIST_TABLE_DATA_FONT_SIZE);
	     
		PdfPTable outerTableForBorder = new PdfPTable(GetGytiProjectDetailsPdfConstants.LIST_DEFAULT_BORDER_TABLE_COLMN_COUNT);
		outerTableForBorder.setWidthPercentage(GetGytiProjectDetailsPdfConstants.LIST_DEFAULT_BORDER_TABLE_WIDTH_PCNTGE);
		outerTableForBorder.getDefaultCell().setBorderColor(BaseColor.GRAY);
		outerTableForBorder.setSpacingBefore(0.5f);
        try{
		        
	        	PdfPTable mainDataTable = new PdfPTable(GetGytiProjectDetailsPdfConstants.LIST_TABLE_COLMN_COUNT);
	        	mainDataTable.setWidths(new int[]{GetGytiProjectDetailsPdfConstants.LIST_TABLE_COLUMN1_WIDTH, GetGytiProjectDetailsPdfConstants.LIST_TABLE_COLUMN2_WIDTH });
	        	mainDataTable.setWidthPercentage(GetGytiProjectDetailsPdfConstants.LIST_TABLE_WIDTH_PCNTGE);
	        	mainDataTable.getDefaultCell().setBorderColor(BaseColor.WHITE);
	        	
	        	Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN  , 13, Font.BOLD);
	    		Color colorinrgb = hex2Rgb("#808080");
	    		int titleBgColor = colorinrgb.getRGB();
	    		BaseColor titleBgBaseColor = new BaseColor(titleBgColor);
	        	
		        PdfPCell cell11 = createTDCell(new PdfPCell(), " Innovation Title :", tableDataFont);
		        cell11.setBackgroundColor(titleBgBaseColor);
		        PdfPCell cell12 = createTDCell(new PdfPCell(), ""+gytiProjectDetails.getProjTitle(), titleFont);
		        cell12.setBackgroundColor(titleBgBaseColor);
		        PdfPRow row1 = createTDRow(cell11,cell12);
		        mainDataTable.getRows().add(row1);
		        
		        PdfPCell cell21 = createTDCell(new PdfPCell(), " Synopsis / Abstract of innovation :", tableDataFont);
		        PdfPCell cell22 = createTDCell(new PdfPCell(), ""+gytiProjectDetails.getProjAbstract(), tableDataFont);
		        PdfPRow row2 = createTDRow(cell21,cell22);
		        mainDataTable.getRows().add(row2);
		        
		        PdfPCell cell31 = createTDCell(new PdfPCell(), " Innovation Category :", tableDataFont);
		        Chunk categoryChunk = new Chunk();
		        for(Branch branch : gytiProjectDetails.getProjBranchList()){
		        	categoryChunk.append(branch.getBranchName()+"\n\n");
		        }
		        PdfPCell cell32 = createTDCell(new PdfPCell(), ""+categoryChunk, tableDataFont);
		        PdfPRow row3 = createTDRow(cell31,cell32);
		        mainDataTable.getRows().add(row3);
		        
		        
		        PdfPCell cell41 = createTDCell(new PdfPCell(), " Academic Program :", tableDataFont);
		        PdfPCell cell42 = createTDCell(new PdfPCell(), ""+gytiProjectDetails.getProjAcademicProgram(), tableDataFont);
		        PdfPRow row4 = createTDRow(cell41,cell42);
		        mainDataTable.getRows().add(row4);
		        
		        PdfPCell cell51 = createTDCell(new PdfPCell(), " Innovation Status :", tableDataFont);
		        PdfPCell cell52 = createTDCell(new PdfPCell(), ""+gytiProjectDetails.getProjStatusInfo(), tableDataFont);
		        PdfPRow row5 = createTDRow(cell51,cell52);
		        mainDataTable.getRows().add(row5);
		        
		        PdfPCell cell61 = createTDCell(new PdfPCell(), "  Filed patent/copyright :", tableDataFont);
		        PdfPCell cell62 = createTDCell(new PdfPCell(), ""+gytiProjectDetails.getProjCopyrightInfo(), tableDataFont);
		        PdfPRow row6 = createTDRow(cell61,cell62);
		        mainDataTable.getRows().add(row6);
		        
		        PdfPCell cell71 = createTDCell(new PdfPCell(), " Have you developed proof of concept/model/formulation/process/product of your innovation :", tableDataFont);
		        PdfPCell cell72 = createTDCell(new PdfPCell(), ""+gytiProjectDetails.getProjProofInfo(), tableDataFont);
		        PdfPRow row7 = createTDRow(cell71,cell72);
		        mainDataTable.getRows().add(row7);
		        
		        PdfPCell cell81 = createTDCell(new PdfPCell(), " What is the exact problem that your project has addressed :", tableDataFont);
		        PdfPCell cell82 = createTDCell(new PdfPCell(), ""+gytiProjectDetails.getProjObjectiveInfo(), tableDataFont);
		        PdfPRow row8 = createTDRow(cell81,cell82);
		        mainDataTable.getRows().add(row8);
		        
		        PdfPCell cell91 = createTDCell(new PdfPCell(), " Proposed outcome/impact of your innovation :", tableDataFont);
		        PdfPCell cell92 = createTDCell(new PdfPCell(), ""+gytiProjectDetails.getProjImpactInfo(), tableDataFont);
		        PdfPRow row9 = createTDRow(cell91,cell92);
		        mainDataTable.getRows().add(row9);
		        
		        PdfPCell cell101 = createTDCell(new PdfPCell(), " For research work to develop into a commercially viable product/service, what would be the resources required? :", tableDataFont);
		        PdfPCell cell102 = createTDCell(new PdfPCell(), ""+gytiProjectDetails.getProjRequiredResource(), tableDataFont);
		        PdfPRow row10 = createTDRow(cell101,cell102);
		        mainDataTable.getRows().add(row10);
		        
		        PdfPCell cell111 = createTDCell(new PdfPCell(), " Who have made contribution towards this project and specific detail i.e. student team, faculty,mentor, anyone else. :", tableDataFont);
		        PdfPCell cell112 = createTDCell(new PdfPCell(), ""+gytiProjectDetails.getProjContributeInfo(), tableDataFont);
		        PdfPRow row11 = createTDRow(cell111,cell112);
		        mainDataTable.getRows().add(row11);
		        
		        PdfPCell cell121 = createTDCell(new PdfPCell(), " Have you filed any patent for your research work? Yes or No If yes please give details :", tableDataFont);
		        PdfPCell cell122 = createTDCell(new PdfPCell(), ""+gytiProjectDetails.getProjPatentWork(), tableDataFont);
		        PdfPRow row12 = createTDRow(cell121,cell122);
		        mainDataTable.getRows().add(row12);
		        
		        PdfPCell cell131 = createTDCell(new PdfPCell(), " Have you published any Research paper in refereed Journal? Yes or No If yes please attach a copy or give reference :", tableDataFont);
		        PdfPCell cell132 = createTDCell(new PdfPCell(), ""+gytiProjectDetails.getProjPublishedPaper(), tableDataFont);
		        PdfPRow row13 = createTDRow(cell131,cell132);
		        mainDataTable.getRows().add(row13);
		        
		        PdfPCell cell141 = createTDCell(new PdfPCell(), " Any other information about your research you would like to share? :", tableDataFont);
		        PdfPCell cell142 = createTDCell(new PdfPCell(), ""+gytiProjectDetails.getProjOtherInfo()	, tableDataFont);
		        PdfPRow row14 = createTDRow(cell141,cell142);
		        mainDataTable.getRows().add(row14);
		        
		        PdfPCell cell151 = createTDCell(new PdfPCell(), " How do you feel that your innovation/project can 'Create more value/benefit from less resource/cost/effort for more and More People'? :", tableDataFont);
		        PdfPCell cell152 = createTDCell(new PdfPCell(), ""+gytiProjectDetails.getProjBenefitInfo(), tableDataFont);
		        PdfPRow row15 = createTDRow(cell151,cell152);
		        mainDataTable.getRows().add(row15);
		        
		        outerTableForBorder.addCell(mainDataTable);
		        document.add(outerTableForBorder);
	       }
		        
	        catch(Exception e){
	        	logger.error("An Unexpected Exception occured in createTableRows of GetAllReviewsPdfGenerator :: ",e);
	        }
	       
	}

	private PdfPCell createTDCell(PdfPCell cell, String text, Font font) {
		cell = new PdfPCell(new Phrase(text, font) );
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(Rectangle.BOX);
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

	private PdfPCell createTHCell(PdfPCell cell, String text, Font font, BaseColor bgColor) {
		cell = new PdfPCell(new Phrase(text, font) );
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setBackgroundColor(bgColor);
		return cell;
	}

	private void createTableHeader(Document document) {
		
		Font tableHeaderfont = new Font(Font.FontFamily.HELVETICA  , 8, Font.BOLD);
		Color colorinrgb = hex2Rgb(GetGytiProjectDetailsPdfConstants.LIST_HEADER_TABLE_BGCOLOR);
		int tableHeaderBgColor = colorinrgb.getRGB();
		BaseColor tableHeaderBgBaseColor = new BaseColor(tableHeaderBgColor);
		PdfPTable headerContentTable = new PdfPTable(GetGytiProjectDetailsPdfConstants.LIST_TABLE_COLMN_COUNT);
		try{
				headerContentTable.setWidths(new int[]{GetGytiProjectDetailsPdfConstants.LIST_TABLE_COLUMN1_WIDTH, GetGytiProjectDetailsPdfConstants.LIST_TABLE_COLUMN2_WIDTH});
		        headerContentTable.setWidthPercentage(100);
		        
		        PdfPCell tableHeaderCol1 = createTHCell(new PdfPCell(), LIST_HEADER_COL1_STRING, tableHeaderfont, tableHeaderBgBaseColor);
		        headerContentTable.addCell(tableHeaderCol1);
		        
		        PdfPCell tableHeaderCol2 = createTHCell(new PdfPCell(), LIST_HEADER_COL2_STRING, tableHeaderfont, tableHeaderBgBaseColor);
		        headerContentTable.addCell(tableHeaderCol2);
		        
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

