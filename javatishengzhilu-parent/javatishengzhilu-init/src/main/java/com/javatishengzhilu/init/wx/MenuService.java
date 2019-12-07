package com.javatishengzhilu.init.wx;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MenuService {

    public static Logger log = LoggerFactory.getLogger(MenuService.class);

    /**
     * 菜单创建（POST） 限100（次/天）
     */
    public static String MENU_CREATE = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    /**
     * 创建菜单
     *
     * @param accessToken 公众号的全局唯一token
     * @return 状态 0 表示成功、其他表示失败
     */
    public void createMenu(String accessToken){
        // 调用接口创建菜单
        int result = MenuService.createMenu(getMenu(), accessToken);

        // 判断菜单创建结果
        if (0 == result)
            log.info("菜单创建成功！");
        else
            log.info("菜单创建失败，错误码：" + result);
    }

    /**
     * 组装菜单数据
     *
     * @return
     */
    private Menu getMenu() {
        ViewButton btnDDH11 = new ViewButton();

        String urlbtnDDH11 = "http://9gj8mj.natappfree.cc//index.html";
        btnDDH11.setName("提升之路");
        String serviceUrlbtnDDH11 = OAuthService.getOauthUrlUtf8(urlbtnDDH11,
                ConstantWeChat.SCOPE_SNSAPI_BASE, ConstantWeChat.WX_STATE);
        btnDDH11.setType("view");
        btnDDH11.setUrl(serviceUrlbtnDDH11);

        System.out.println(serviceUrlbtnDDH11);

        Menu menu = new Menu();
        menu.setButton(new Button[] { btnDDH11});

        return menu;
    }

    public static Integer createMenu(Menu menu, String assessToken) {
        return createMenu(JSONObject.toJSONString(menu), assessToken);
    }

    public static Integer createMenu(String jsonMenu, String assessToken) {
        int result = 0;
        log.info(jsonMenu.toString());
        String token = assessToken;
        if (token != null) {
            // 拼装创建菜单的url
            String url = MENU_CREATE.replace("ACCESS_TOKEN", token);
            // 调用接口创建菜单
            String resultJson = HttpClientUtil.doPostJson(url, null, jsonMenu);

            if (null != resultJson) {

                JSONObject obj = JSONObject.parseObject(resultJson);
                if (0 != obj.getInteger("errcode")) {
                    result = obj.getInteger("errcode");
                    log.error("创建菜单失败 errcode:" + obj.getInteger("errcode")
                            + "，errmsg:" + obj.getString("errmsg"));
                }
            }
        }
        return result;
    }
}
