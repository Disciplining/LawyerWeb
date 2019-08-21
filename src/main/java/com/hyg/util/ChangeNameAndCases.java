package com.hyg.util;

import com.hyg.pojo.Case;
import lombok.Data;

import java.util.List;

/**
 * 罪名和其对应的所有案例
 */
@Data
public class ChangeNameAndCases
{
	private String chargeName;
	private List<Case> cases;
}