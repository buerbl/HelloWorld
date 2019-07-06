package com.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: boolean
 * @Date: 2019/4/29 19:24
 * @description:
 */
@Getter
@Setter
public class JsonTest {
    private String name;
    private List<String> list;
    private Integer[] array;

//    public JsonTest(List<String> list) {
//        this.list = list;
//        list.add(1, "A");
//        list.add(2, "HasmMapTest");
//        list.add(3, "v");
//    }
    public void init(JsonTest jsonTest){
        jsonTest.setName(name = "chen");
        List<String> list = new ArrayList<>();
        list.add(0, "A");
        list.add(1, "HasmMapTest");
        list.add(2, "c");
        jsonTest.setList(list);
        Integer[] array = new Integer[]{1,2,3,4,5,6};
        jsonTest.setArray(array);
    }

    @Setter@Getter
    class Name{
        private BigDecimal name;
        private String pass="dsds";
        private Integer pass1;

    }
    @Test
    public void jsonTest(){
//        String old = "name";
        Name name = new Name();
        name.setName(BigDecimal.valueOf(0));
        String str = JSONObject.toJSONString(name, Boolean.parseBoolean("ss"));
        name.setPass("3");
        String str1 = JSONObject.toJSONString(name);
//        System.out.println(str);

        JSONObject obj = new JSONObject();
        obj.put("name", name.getPass());
        System.out.println(obj.getClass());
//        System.out.println(obj.getString("name"));

        String a = "{\"name\":\"3\"}";
        System.out.println(JSONObject.parseObject(a).getString("name"));


        String s2 = new Gson().toJson(name.pass);
//        System.out.println(s2);
    }


    class Person{
        private String  name;
        private String age;
    }
    @Test
    public void test3(){
        String name ="{\"name\":\"cjen\"}";
        Gson gson = new Gson();
        System.out.println(gson.fromJson(name, Person.class).toString());
    }

    @Test
    public void test4(){
        JsonTest jsonTest  = new JsonTest();
        init(jsonTest);
        Gson gson = new Gson();
        String a = gson.toJson(jsonTest);
        System.out.println(a);
        String[] stringArray = new String[]{a};
        System.out.println(gson.toJson(stringArray));

    }

    //规则转json
    @Test
    public void test5(){
        Gson gson = new Gson();
        String rules = "1、2016年1月11日-2016年1月24日期间，每位客户限抽1次。\n" +
                "\n" +
                "2、实物奖品抽中后，我们将为您免费配送至所选体验馆；到货后请凭中奖手机号（带手机）到店自提。在接到领奖通知次日起，7天内未领取的，直接取消领奖资格，实物奖品不退换、不补件。\n" +
                "\n" +
                "3、红包奖品发放：抽中红包后，红包序列号将以短信形式发送至手机，请注意查收。\n" +
                "\n" +
                "4、红包使用方法：凭序列号短信到对应体验馆在体验馆人员帮助下下单使用。\n" +
                "\n" +
                "5、红包使用条件：红包不能抵扣快递、物流或服务费；体验馆特卖、团购、拍卖、秒杀产品及第三方配送产品除外。每个订单只能使用一个红包，本红包不能与其他红包/预约券/抵扣券/优惠码同时使用。\n" +
                "\n" +
                "6、红包使用时间：使用本抽奖红包的订单不再享受活动满减优惠。\n" +
                "\n" +
                "7、红包注意事项：此红包仅限抽奖获得，不找零、不折现，限一次性使用完；如使用后发生退款，红包金额不作为退款款项。\n" +
                "\n" +
                "8、其他：抽中“精美到店礼品”的客户，直接到所选体验馆领取即可，数量有限，先到先得。";
        String a = gson.toJson(rules);
        System.out.println(a);
    }

}
