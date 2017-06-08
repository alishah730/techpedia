/**
 * 
 */
package com.techpedia.projectmanagement.util;

import java.util.Comparator;

import com.techpedia.projectmanagement.bean.OverallCalculatedReviewRatingVO;

/**
 * @author 455959
 *
 */
public class OverAllRatingsComparator implements Comparator<OverallCalculatedReviewRatingVO> {

	@Override
	public int compare(OverallCalculatedReviewRatingVO o1, OverallCalculatedReviewRatingVO o2) {
		return o2.getReviewedDate().compareTo(o1.getReviewedDate());
	}
}
