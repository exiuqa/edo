package org.framework.edo.office;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.util.DateUtils;
import com.alibaba.excel.write.merge.OnceAbsoluteMergeStrategy;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import lombok.Data;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 *
 * @Author L.Qiang
 * @Email: exiuqa@gmail.com
 * @Create 2019-11-04 11:40
 * @Version 1.0
 */

public class TemplateExcel {

    public static void main(String[] args) {
        simpleFill();
    }

    public static void simpleFill() {
        // 模板注意 用{} 来表示你要用的变量 如果本来就有"{","}" 特殊字符 用"\{","\}"代替
       String templateFileName = FileUtils.getPath() + "demo" + File.separator + "file" + File.separator + "贷后报告.xls";
        //String templateFileName = FileUtils.getPath() + "demo" + File.separator + "file" + File.separator + "simpleFill2.xls";

        // 方案1 根据对象填充
        String fileName =FileUtils.getPath() + "simpleFill" + System.currentTimeMillis() + ".xls";
        // 这里 会填充到第一个sheet， 然后文件流会自动关闭
        FillData fillData = new FillData();
        fillData.setTime(DateUtils.format(new Date(),DateUtils.DATE_FORMAT_19));
        fillData.setOrg("北京分行");
        fillData.setName("北京天逸电子有限公司");
        fillData.setProduct("订单贷");
        ExcelWriter excelWriter = EasyExcel.write(fileName).withTemplate(templateFileName).build();
        OnceAbsoluteMergeStrategy onceAbsoluteMergeStrategy = new OnceAbsoluteMergeStrategy(14,15,0,4);
        //LoopMergeStrategy loopMergeStrategy = new LoopMergeStrategy(2, 0);
        WriteSheet writeSheet = EasyExcel.writerSheet("贷后报告").registerWriteHandler(onceAbsoluteMergeStrategy).build();
        excelWriter.fill(fillData, writeSheet);

        List<Warn> warnList = new ArrayList<Warn>();
        Warn warn1 = new Warn();
        warn1.setWarnDeal("逾期");
        warn1.setWarnLevel("红色");
        warn1.setWarnMsg("冻结额度");
        Warn warn2 = new Warn();
        warn2.setWarnDeal("逾期");
        warn2.setWarnLevel("红色");
        warn2.setWarnMsg("冻结额度");
        Warn warn3 = new Warn();
        warn3.setWarnDeal("逾期");
        warn3.setWarnLevel("红色");
        warn3.setWarnMsg("冻结额度");
        warnList.add(warn1);
        warnList.add(warn2);
        warnList.add(warn3);
        FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();
        excelWriter.fill(warnList,fillConfig,writeSheet);


        excelWriter.finish();

    }


}


@Data
class FillData {
    private String time;
    private String org;
    private String name;
    private String product;
}

@Data
class Warn {
    private String warnMsg;
    private String warnLevel;
    private String warnDeal;
}