package com.hyg.util;

import com.hyg.pojo.Case;
import lombok.Data;

import java.util.List;

/**
 * 网站下方 展示案例的联动数据
 */
@Data
public class LinkageCaseDataBean
{
	private String charTypeName;
	private List<String> chargeNames;
	private List<Case> cases;
}

/*----------------------------------------------------
[
    {
        "charTypeName": "民事罪",
        "chargeNames": ["杀人","放火","抢劫"],
        "cases":
        [
            {
                "id": 21,
                "chargeId": 45,
                "title": "张三杀了一个人",
                "desc": "张三在大街上杀了一个人",
                "process": "警察在路上把他抓住了",
                "result": "成功抓获嫌疑人",
                "lessions": "警察要有个好身体",
                "publishDate": "2019-08-19 19:57:35",
                "successFlag": 1,
                "editDate": "2019-08-19 19:57:35",
                "count": 0,
                "deleteFlag": "0",
                "chargeName": "杀人"
              },
              {
                  ...
              },
              {
                  ...
              }
        ]
    },
    {
        ...
    },
    {
        ...
    }
]
----------------------------------------------------*/