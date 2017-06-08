/**
 * 
 */
package com.techpedia.manager;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.techpedia.bean.OverallCalculatedReviewRatingVO;
import com.techpedia.bean.SubmitInnovationToGytiForPdfVO;
import com.techpedia.constants.GetAllReviewsForSpecificProjectPdfConstants;
import com.techpedia.constants.GetAllReviewsPdfConstants;
import com.techpedia.constants.GetGytiProjectDetailsPdfConstants;
import com.techpedia.constants.HeaderAndFooterConstants;
import com.techpedia.util.GetAllReviewsForSpecificProjectPdfGenerator;
import com.techpedia.util.GetAllReviewsPdfGenerator;
import com.techpedia.util.GetGytiProjectDetailsPdfGenerator;

/**
 * @author 455959
 *
 */
public class PdfManager {
	
	private static final Logger logger = Logger.getLogger(PdfManager.class);

	public ByteArrayOutputStream createGetAllReviewsPdf(List<OverallCalculatedReviewRatingVO> overallCalculatedReviewRatings, HttpServletRequest request) {
				
		logger.info("Inside Manager ");
			ByteArrayOutputStream byteArrayOutputStream = null;
			
			try{
				 
				GetAllReviewsPdfGenerator generator = new GetAllReviewsPdfGenerator( 
						GetAllReviewsPdfConstants.HEADER_CONTENT_DESCRIPTION, GetAllReviewsPdfConstants.HEADER_CONTENT_DESCRIPTION_CONTD,
						GetAllReviewsPdfConstants.FOOTER_CONTENT_DESCRIPTION, GetAllReviewsPdfConstants.FOOTER_CONTENT_DESCRIPTION_CONTD, 
						GetAllReviewsPdfConstants.FOOTER_CONTENT_DATE_CREATED, GetAllReviewsPdfConstants.LIST_HEADER_COL1_STRING, GetAllReviewsPdfConstants.LIST_HEADER_COL2_STRING, 
						GetAllReviewsPdfConstants.LIST_HEADER_COL3_STRING, GetAllReviewsPdfConstants.LIST_HEADER_COL4_STRING, GetAllReviewsPdfConstants.LIST_HEADER_COL5_STRING, 
						GetAllReviewsPdfConstants.LIST_HEADER_COL6_STRING, GetAllReviewsPdfConstants.LIST_HEADER_COL7_STRING
						);

				byteArrayOutputStream = generator.createGetAllReviewsPdf(overallCalculatedReviewRatings, (String)request.getSession().getAttribute("revfirstName")+" "+(String)request.getSession().getAttribute("revLname")); // Will be set as the creator name
				byteArrayOutputStream = manipulatePdf(byteArrayOutputStream);
				return byteArrayOutputStream;
				
				
		}
		catch (Exception e) {
			logger.error("An Unexpected exception occured in createGetAllReviewsPdf method ::", e);
			return null;
		}
			finally{
				if(byteArrayOutputStream !=null){
					try {
						byteArrayOutputStream.close();
					} catch (IOException e) {
						logger.error("An expected exception occured while closing the byteArrayOutputStream :: ", e);
					}
				}
			}
		
	}
	
	public ByteArrayOutputStream createGetAllReviewsForSpecificProjectPdf(OverallCalculatedReviewRatingVO overallCalculatedReviewRating, HttpServletRequest request) {
		
		logger.info("Inside Manager ");
			ByteArrayOutputStream byteArrayOutputStream = null;
			
			try{
				 
				GetAllReviewsForSpecificProjectPdfGenerator generator = new GetAllReviewsForSpecificProjectPdfGenerator( 
						GetAllReviewsForSpecificProjectPdfConstants.HEADER_CONTENT_DESCRIPTION, GetAllReviewsForSpecificProjectPdfConstants.HEADER_CONTENT_DESCRIPTION_CONTD,
						GetAllReviewsForSpecificProjectPdfConstants.FOOTER_CONTENT_DESCRIPTION, GetAllReviewsForSpecificProjectPdfConstants.FOOTER_CONTENT_DESCRIPTION_CONTD, 
						GetAllReviewsForSpecificProjectPdfConstants.FOOTER_CONTENT_DATE_CREATED, 
						GetAllReviewsForSpecificProjectPdfConstants.ROW1_STRING, GetAllReviewsForSpecificProjectPdfConstants.ROW2_STRING, 
						GetAllReviewsForSpecificProjectPdfConstants.ROW3_STRING, GetAllReviewsForSpecificProjectPdfConstants.ROW4_STRING, 
						GetAllReviewsForSpecificProjectPdfConstants.ROW5_STRING, GetAllReviewsForSpecificProjectPdfConstants.ROW6_STRING,
						GetAllReviewsForSpecificProjectPdfConstants.ROW7_STRING, GetAllReviewsForSpecificProjectPdfConstants.ROW8_STRING,
						GetAllReviewsForSpecificProjectPdfConstants.ROW9_STRING, GetAllReviewsForSpecificProjectPdfConstants.ROW10_STRING,
						GetAllReviewsForSpecificProjectPdfConstants.ROW11_STRING, GetAllReviewsForSpecificProjectPdfConstants.ROW12_STRING,
						GetAllReviewsForSpecificProjectPdfConstants.ROW13_STRING, GetAllReviewsForSpecificProjectPdfConstants.ROW14_STRING,
						GetAllReviewsForSpecificProjectPdfConstants.ROW15_STRING, GetAllReviewsForSpecificProjectPdfConstants.ROW16_STRING,
						GetAllReviewsForSpecificProjectPdfConstants.ROW17_STRING, GetAllReviewsForSpecificProjectPdfConstants.ROW18_STRING,
						GetAllReviewsForSpecificProjectPdfConstants.ROW19_STRING, GetAllReviewsForSpecificProjectPdfConstants.ROW20_STRING
						);

				byteArrayOutputStream = generator.createGetAllReviewsForSpecificProjectPdf(overallCalculatedReviewRating, (String)request.getSession().getAttribute("revfirstName")+" "+(String)request.getSession().getAttribute("revLname")); // Will be set as the creator name
				byteArrayOutputStream = manipulatePdf(byteArrayOutputStream);
				return byteArrayOutputStream;
				
				
		}
		catch (Exception e) {
			logger.error("An Unexpected exception occured in createGetAllReviewsForSpecificProjectPdf method ::", e);
			return null;
		}
			finally{
				if(byteArrayOutputStream !=null){
					try {
						byteArrayOutputStream.close();
					} catch (IOException e) {
						logger.error("An expected exception occured while closing the byteArrayOutputStream :: ", e);
					}
				}
			}
		
	}
	
	 public ByteArrayOutputStream manipulatePdf(ByteArrayOutputStream src) {
		 
		 ByteArrayOutputStream dest = new ByteArrayOutputStream();
		 PdfReader reader = null;
		 PdfStamper stamper = null;
		 
		 try{
			 reader = new PdfReader(src.toByteArray());
			 stamper = new PdfStamper(reader, dest);
			 int noOfPages = reader.getNumberOfPages();
			 
			 for(int i=1; i<=noOfPages; i++){
				 Font watermarkFont = new Font(FontFamily.HELVETICA, 80, Font.BOLD);
				 PdfContentByte overContent;
				 overContent = stamper.getOverContent(i);
				 Phrase watermarkPhrase = new Phrase(HeaderAndFooterConstants.WATERMARK_TEXT, watermarkFont);
				 overContent.saveState();
				 PdfGState gs1 = new PdfGState();
				 gs1.setFillOpacity(0.2f);
				 overContent.setGState(gs1);
				 ColumnText.showTextAligned(overContent, Element.ALIGN_CENTER, watermarkPhrase, HeaderAndFooterConstants.WATERMARK_POSITION_X, HeaderAndFooterConstants.WATERMARK_POSITION_Y, HeaderAndFooterConstants.WATERMARK_ROTATION);
				 overContent.restoreState();
				 
				 PdfContentByte overContentPageNumber;
				 overContentPageNumber = stamper.getOverContent(i);
				 overContentPageNumber.saveState();
				 overContentPageNumber.beginText();
				 overContentPageNumber.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED), 8.0f);
				 overContentPageNumber.setTextMatrix(GetAllReviewsPdfConstants.LIST_DOCUMENT_WIDTH / 2 - 20, GetAllReviewsPdfConstants.LIST_DOCUMENT_HEIGHT - (GetAllReviewsPdfConstants.LIST_DOCUMENT_HEIGHT - 20));
				 overContentPageNumber.showText("Page " + (i) + " of " + noOfPages);
	             overContentPageNumber.endText();
	             overContentPageNumber.restoreState();
			 }
			 stamper.close();
			 reader.close();
		 }
		catch(Exception e){
			logger.error("An expected exception occured in manipulatePdf :: ", e); 
		}
		 return dest;
	   }

	public ByteArrayOutputStream createGetGytiProjectDetailsPdf(SubmitInnovationToGytiForPdfVO gytiProjectDetails, HttpServletRequest request) {
		
		logger.info("Inside Manager ");
			ByteArrayOutputStream byteArrayOutputStream = null;
			
			try{
				 
				GetGytiProjectDetailsPdfGenerator generator = new GetGytiProjectDetailsPdfGenerator( 
						GetGytiProjectDetailsPdfConstants.HEADER_CONTENT_DESCRIPTION, GetGytiProjectDetailsPdfConstants.HEADER_CONTENT_DESCRIPTION_CONTD,/*gytiProjectDetails.getProjTitle(),*/
						GetGytiProjectDetailsPdfConstants.FOOTER_CONTENT_DESCRIPTION, GetGytiProjectDetailsPdfConstants.FOOTER_CONTENT_DESCRIPTION_CONTD, 
						GetGytiProjectDetailsPdfConstants.FOOTER_CONTENT_DATE_CREATED, GetGytiProjectDetailsPdfConstants.LIST_HEADER_COL1_STRING, GetGytiProjectDetailsPdfConstants.LIST_HEADER_COL2_STRING
						);

				byteArrayOutputStream = generator.createGetGytiProjectDetailsPdf(gytiProjectDetails, (String)request.getSession().getAttribute("revfirstName")+" "+(String)request.getSession().getAttribute("revLname")); // Will be set as the creator name
				byteArrayOutputStream = manipulatePdf(byteArrayOutputStream);
				return byteArrayOutputStream;
				
				
		}
		catch (Exception e) {
			logger.error("An Unexpected exception occured in createGetAllReviewsPdf method ::", e);
			return null;
		}
			finally{
				if(byteArrayOutputStream !=null){
					try {
						byteArrayOutputStream.close();
					} catch (IOException e) {
						logger.error("An expected exception occured while closing the byteArrayOutputStream :: ", e);
					}
				}
			}
		
	}
}
