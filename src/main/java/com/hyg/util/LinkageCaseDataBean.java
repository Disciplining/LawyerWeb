package com.hyg.util;

import lombok.Data;

import java.util.List;

/**
 * 网站下方 展示案例的联动数据
 */
@Data
public class LinkageCaseDataBean
{
	private String charTypeName; // 罪名分类名称
	private List<ChangeNameAndCases> chargeNamesAndCases;
}

/*----------------------------------------------------
[
    {
        "charTypeName": "民事罪",
        "chargeNamesAndCases":
        [
            {
                "chargeName": "杀人",
                "cases":
                [
                    {},
                    {}
                ]
            },
            {
                "chargeName": "抢劫",
                "cases":
                [
                    {},
                    {}
                ]
            }
        ]
    },
    {
    },
    {
    }
]
----------------------------------------------------*/