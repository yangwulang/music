package top.yangwulang.pojo.qq;

import lombok.Data;

import java.util.List;

/**
 * @author yangwulang
 */
@Data
public class SemanticBean {

    /**
     * curnum : 0
     * curpage : 2
     * list : []
     * totalnum : 0
     */

    private int curnum;
    private int curpage;
    private int totalnum;
    private List<?> list;

}
