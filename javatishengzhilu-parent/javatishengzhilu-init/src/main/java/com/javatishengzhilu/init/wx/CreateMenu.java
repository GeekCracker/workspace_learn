package com.javatishengzhilu.init.wx;

public class CreateMenu {

    public static void main(String[] args) {

        //QQ号:3614244975
        MenuService menuService = new MenuService();

        String accessToken = AccessTokenUtils.
                getAccessToken("wx819625503de7573e", "62975c2466050ad1b960c59164f4838b").getToken();

        menuService.createMenu(accessToken);
    }
}
