/**
 * 
 */
package com.techpedia.util;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.techpedia.bean.AssignedByAndReviewDoneByMapper;
import com.techpedia.bean.OverallCalculatedReviewRatingVO;

/**
 * @author 455959
 *
 */
public class GetAllReviewsXlsGenerator {
	
	private static final Logger logger = Logger.getLogger(GetAllReviewsXlsGenerator.class);

	public ByteArrayOutputStream createGetAllReviewsXls(List<OverallCalculatedReviewRatingVO> overallCalculatedReviewRatings) {
		
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		XSSFSheet spreadsheet = workbook.createSheet("All Reviews");
		Map <String, Object[]> overallCalculatedReviewRatingMap = new TreeMap <String, Object[]>();
		int rowCount = 1;
		overallCalculatedReviewRatingMap.put(String.valueOf(rowCount),  new Object[]{"Reviewed Date","Participant Id","Project Title","Category","Average Rating"});
		for(OverallCalculatedReviewRatingVO overallCalculatedReviewRating : overallCalculatedReviewRatings){
			rowCount++;
			overallCalculatedReviewRatingMap.put(String.valueOf(rowCount), new Object[]{overallCalculatedReviewRating.getReviewedDate(), overallCalculatedReviewRating.getParticipantId(),
				overallCalculatedReviewRating.getProjTitle(),overallCalculatedReviewRating.getProjCategory(), overallCalculatedReviewRating.getAverageRating()+"%"
			});
		}
		
		XSSFCellStyle style = workbook.createCellStyle();
		style.setFillPattern(XSSFCellStyle.FINE_DOTS);
		style.setFillBackgroundColor(IndexedColors.GREEN.index);
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		style.setFont(font);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
				int rowId = 0;
				XSSFRow row;
				row = spreadsheet.createRow(rowId++);
				int cellId = 0;
				Cell cell1 = row.createCell(cellId++);
		        cell1.setCellValue("Reviewed Date");
		        cell1.setCellStyle(style);
		        
		        Cell cell2 = row.createCell(cellId++);
		        cell2.setCellValue("Participant Id");
		        cell2.setCellStyle(style);
		        
		        Cell cell3 = row.createCell(cellId++);
		        cell3.setCellValue("Project Title");
		        cell3.setCellStyle(style);
		        
		        Cell cell4 = row.createCell(cellId++);
		        cell4.setCellValue("Category");
		        cell4.setCellStyle(style);
		        
		        Cell cell5 = row.createCell(cellId++);
		        cell5.setCellValue("Average Rating");
		        cell5.setCellStyle(style);
		        
		        Cell cell6 = row.createCell(cellId++);
		        cell6.setCellValue("Assigned By - Reviewed Done By - Frugality - Novelty - Social Application - Technical Rigor                                                            ");
		        cell6.setCellStyle(style);
		        
		        Cell cell7 = row.createCell(cellId++);
		        cell7.setCellValue("Technical Rigor Average rating");
		        cell7.setCellStyle(style);
		        
		        Cell cell8 = row.createCell(cellId++);
		        cell8.setCellValue("Frugality Average rating");
		        cell8.setCellStyle(style);
		        
		        Cell cell9 = row.createCell(cellId++);
		        cell9.setCellValue("Novelty Average rating");
		        cell9.setCellStyle(style);
		        
		        Cell cell10 = row.createCell(cellId++);
		        cell10.setCellValue("Social Application Average rating");
		        cell10.setCellStyle(style);
		        
		        for(OverallCalculatedReviewRatingVO overallCalculatedReviewRating : overallCalculatedReviewRatings){
		        	
		        	int innerCellId = 0;
		        	row = spreadsheet.createRow(rowId++);
		        	row.setHeightInPoints(30f);
		        	
		        	Cell cellx1 = row.createCell(innerCellId);
			        cellx1.setCellValue(overallCalculatedReviewRating.getReviewedDate());
			        innerCellId++;
			        
			        Cell cellx2 = row.createCell(innerCellId);
			        cellx2.setCellValue(overallCalculatedReviewRating.getParticipantId());
			        innerCellId++;
			        
			        Cell cellx3 = row.createCell(innerCellId);
			        cellx3.setCellValue(overallCalculatedReviewRating.getProjTitle());
			        innerCellId++;
			        
			        Cell cellx4 = row.createCell(innerCellId);
			        		
			        String sb = new String();
			        int count = 1;
			        for(String category : overallCalculatedReviewRating.getProjCategory()){
			        	sb = sb.concat(count++ +"."+category+"\n");
			        }
			        cellx4.setCellValue(sb.trim());
			        innerCellId++;
			        
			        Cell cellx5 = row.createCell(innerCellId);
			        cellx5.setCellValue(overallCalculatedReviewRating.getAverageRating()+"%");
			        innerCellId++;
			        
			        
			        Cell cellx6 = row.createCell(innerCellId);
			        sb = new String();
			        count = 1;
			        for(AssignedByAndReviewDoneByMapper assignedByAndReviewDoneByMapper : overallCalculatedReviewRating.getAssignedByAndReviewDoneByMapperSet()){
			        	sb = sb.concat(count++ +"."+assignedByAndReviewDoneByMapper.getAssignedByName()+ "(Assigned By) -" +assignedByAndReviewDoneByMapper.getReviewDoneByName()+"(Reviewed By) -" +assignedByAndReviewDoneByMapper.getRevFrugality()+"(Frugality) -" +assignedByAndReviewDoneByMapper.getRevNovelty()+"(Novelty) -" +assignedByAndReviewDoneByMapper.getRevSocialApplication()+"(Social Application) -" +assignedByAndReviewDoneByMapper.getRevTechnicalRigor()+"(Technical Rigor)\n");
			        }
			        cellx6.setCellValue(sb.trim());
			        innerCellId++;
			        
			        Cell cellx7 = row.createCell(innerCellId);
			        cellx7.setCellValue(overallCalculatedReviewRating.getAverageTechnicalRigorRating()+"%");
			        innerCellId++;
			        
			        Cell cellx8 = row.createCell(innerCellId);
			        cellx8.setCellValue(overallCalculatedReviewRating.getAverageFrugalityRating()+"%");
			        innerCellId++;
			        
			        Cell cellx9 = row.createCell(innerCellId);
			        cellx9.setCellValue(overallCalculatedReviewRating.getAverageNoveltyRating()+"%");
			        innerCellId++;
			        
			        Cell cellx10 = row.createCell(innerCellId);
			        cellx10.setCellValue(overallCalculatedReviewRating.getAverageSocialApplicationRating()+"%");
			        innerCellId++;
		        }
		        
	        spreadsheet.autoSizeColumn(0, true);
	        spreadsheet.autoSizeColumn(1, true);
	        spreadsheet.autoSizeColumn(2, true);
	        spreadsheet.autoSizeColumn(3, true);
	        spreadsheet.autoSizeColumn(4, true);
	        spreadsheet.autoSizeColumn(5, true);
	        spreadsheet.autoSizeColumn(6, true);
	        spreadsheet.autoSizeColumn(7, true);
	        spreadsheet.autoSizeColumn(8, true);
	        spreadsheet.autoSizeColumn(9, true);
			workbook.write(baos);
			baos.close();
		} catch (Exception e) {
			logger.error("An Unexpected Exception Occured in createGetAllReviewsXls ", e);
		}
	      
      logger.info("Writesheet.xlsx written successfully");
      return baos;
	}

}
