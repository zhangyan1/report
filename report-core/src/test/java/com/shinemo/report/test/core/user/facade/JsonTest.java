package com.shinemo.report.test.core.user.facade;

import com.google.gson.JsonObject;
import com.shinemo.client.util.GsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 *
 * @author zhangyan
 * @date 2019-05-10
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationTest.class)
public class JsonTest {

    @Test
    public void testJsonObj(){
        String a = "{\"orderSnapshot\":{\"payWay\":\"PRIPER\",\"freight\":0,\"totalPrice\":15417,\"proPrice\":15417,\"thirdId\":\"95107097985\",\"proDetail\":[{\"skuId\":\"4510086\",\"num\":1,\"type\":\"NORMAL\",\"oid\":\"0\",\"thirdPrice\":4990,\"saleprice\":4990,\"agreementPrice\":4840,\"totalPrice\":4990,\"name\":\"蓝月亮芦荟抑菌洗手液套装：洗手液瓶500g×3+洗手液瓶补500g×3\",\"img\":\"jfs/t22987/295/2346368808/326239/e3358b39/5b7e2f0dNeb37b448.jpg\",\"category\":16782,\"tax\":13,\"paramInfo\":\"芦荟抑菌套装\",\"thirdSaleInfo\":\"null\",\"needGift\":true,\"integralPrice\":4990,\"payExtend\":[{\"payChannel\":1,\"payType\":16,\"amount\":4990,\"refundAmount\":0}],\"shopId\":-1,\"shopName\":\"京东官方自营店\",\"itemId\":4510086,\"grossProfit\":150,\"couponPrice\":0},{\"skuId\":\"5267006\",\"num\":1,\"type\":\"NORMAL\",\"oid\":\"0\",\"thirdPrice\":2490,\"saleprice\":2289,\"agreementPrice\":2180,\"totalPrice\":2289,\"name\":\"立白 茶籽洗洁精双瓶省心装 1.45kg*2瓶 茶籽精华 除菌去油\",\"img\":\"jfs/t20386/5/1004319541/235818/c5dcf94b/5b1e4835N1f9f049f.jpg\",\"category\":15930,\"tax\":13,\"paramInfo\":\"茶籽洗洁精 1.45kg*2\",\"thirdSaleInfo\":\"null\",\"needGift\":true,\"integralPrice\":2289,\"payExtend\":[{\"payChannel\":1,\"payType\":16,\"amount\":2289,\"refundAmount\":0}],\"shopId\":-1,\"shopName\":\"京东官方自营店\",\"itemId\":5267006,\"grossProfit\":109,\"couponPrice\":0},{\"skuId\":\"237570\",\"num\":2,\"type\":\"NORMAL\",\"oid\":\"0\",\"thirdPrice\":2590,\"saleprice\":2089,\"agreementPrice\":1990,\"totalPrice\":4178,\"name\":\"威猛先生 多功能玻璃清洁剂 双包装 500g+420g 玻璃水 不留水痕 去污防尘【新老包装随机发货】\",\"img\":\"jfs/t13225/274/2481940306/165935/98e6fc1f/5a432d3aNb5a600c5.jpg\",\"category\":15937,\"tax\":13,\"paramInfo\":\"500g+420g\",\"thirdSaleInfo\":\"null\",\"needGift\":true,\"integralPrice\":4178,\"payExtend\":[{\"payChannel\":1,\"payType\":16,\"amount\":4178,\"refundAmount\":0}],\"shopId\":-1,\"shopName\":\"京东官方自营店\",\"itemId\":237570,\"grossProfit\":198,\"couponPrice\":0},{\"skuId\":\"4682026\",\"num\":4,\"type\":\"NORMAL\",\"oid\":\"0\",\"thirdPrice\":990,\"saleprice\":990,\"agreementPrice\":990,\"totalPrice\":3960,\"name\":\"得力(deli)0.5mm办公中性笔 水笔签字笔 12支/盒黑色34567\",\"img\":\"jfs/t3157/328/9791857244/88917/3777047a/58d880dfN9d2f5e59.jpg\",\"category\":2603,\"tax\":13,\"paramInfo\":\"12支黑色\",\"thirdSaleInfo\":\"null\",\"needGift\":true,\"integralPrice\":3960,\"payExtend\":[{\"payChannel\":1,\"payType\":16,\"amount\":3960,\"refundAmount\":0}],\"shopId\":-1,\"shopName\":\"京东官方自营店\",\"itemId\":4682026,\"grossProfit\":0,\"couponPrice\":0}],\"calendar\":{\"promiseDate\":\"05月15日[周三]\",\"promiseTimeRange\":\"09:00-21:00\",\"promiseTimeRangeCode\":4,\"needInstall\":false},\"grossProfit\":457,\"shopId\":-1,\"shopName\":\"京东官方自营店\",\"isVirtualOrder\":false},\"address\":{\"id\":2387,\"appType\":\"CAIYUN\",\"isDefault\":true,\"deleteStatus\":1,\"recipientUserName\":\"鲍敏\",\"recipientUserPhone\":\"13738014342\",\"detailAddress\":\"郡原公元里13幢402\",\"thirdAddress\":\"[{\\\"id\\\":15,\\\"name\\\":\\\"浙江\\\"},{\\\"id\\\":1213,\\\"name\\\":\\\"杭州市\\\"},{\\\"id\\\":3411,\\\"name\\\":\\\"西湖区\\\"},{\\\"id\\\":52667,\\\"name\\\":\\\"城区\\\"}]\",\"userId\":10101001212664376,\"userName\":\"鲍敏燕\",\"gmtCreate\":\"2019-04-28 16:29:36.000\",\"gmtModified\":\"2019-04-28 16:29:39.000\"},\"invoiceType\":0,\"isNeedSplitOrder\":false}";
        JsonObject obj = GsonUtil.fromGson2Obj(a,JsonObject.class);
        JsonObject objA = obj.getAsJsonObject("orderSnapshot");
        System.out.println(objA.get("freight"));
    }

}
