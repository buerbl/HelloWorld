import org.junit.Test;

/**
 * @author boolean
 * Date: 2019/7/9 14:05
 * description:
 */
public class a {

    @Test
    public void test(){
        String name  = "select source_id as sourceId,max(update_time) updateTime from qu_mall_product_browse_record where user_id = #{userId} and type=#{type} and is_hide = 0 group by source_id order by max(update_time) desc";
        System.out.println(name);
    }
}
