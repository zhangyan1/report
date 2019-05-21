package com.shinemo.report.test.core.consumer;
import com.shinemo.client.common.Result;
import com.shinemo.client.util.GsonUtil;
import com.shinemo.report.client.db.domain.ReportMetaDataColumn;
import com.shinemo.report.client.table.domain.TableInfoDO;
import com.shinemo.report.client.table.domain.TableQueryParamDO;
import com.shinemo.report.client.table.facade.TableFacadeService;
import com.shinemo.report.test.core.application.TableApplication;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TableApplication.class)
public class TableServiceTest {

    @Resource
    private TableFacadeService tableFacadeService;

    @Test
    public void testReportMetaDataColumn(){
        Result<List<ReportMetaDataColumn>> rs =  tableFacadeService.getReportMetaDataColumn(1L,"select * from buy_order_new limit 1");
        System.out.println(GsonUtil.toJson(rs));
    }

    @Test
    public void getTableInfo(){
        List<TableQueryParamDO> params = Lists.newArrayList();
        Result<TableInfoDO> rs = tableFacadeService.getTableInfo(1L,params);
        System.out.println(rs);
    }
}
