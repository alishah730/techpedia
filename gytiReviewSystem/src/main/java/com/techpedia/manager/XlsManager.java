/**
 * 
 */
package com.techpedia.manager;

import java.io.ByteArrayOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.techpedia.bean.OverallCalculatedReviewRatingVO;
import com.techpedia.util.GetAllReviewsXlsGenerator;

/**
 * @author 455959
 *
 */
public class XlsManager {
	
	private static final Logger logger = Logger.getLogger(XlsManager.class);

	public ByteArrayOutputStream createGetAllReviewsXls(List<OverallCalculatedReviewRatingVO> overallCalculatedReviewRatings, HttpServletRequest request) {
		
		ByteArrayOutputStream byteArrayOutputStream = null;
		GetAllReviewsXlsGenerator generator = new GetAllReviewsXlsGenerator();
		byteArrayOutputStream = generator.createGetAllReviewsXls(overallCalculatedReviewRatings);
		
		return byteArrayOutputStream;
	}

}
