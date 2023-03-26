package com.dbf.boot.entity.Menu;

import com.dbf.boot.utils.HttpRequest;
import com.dbf.boot.utils.Token;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class TestMenu {
    public static void main(String[] args) {
        Menu menu = new Menu();
//
        List<AbstractButton> abstractButtonList = new ArrayList<>();
//        一级菜单第一个按钮
//        ClickButton clickButton = new ClickButton("点击按钮", "CLICK_BUTTON");
//        一级菜单第二个按钮
        ViewButton viewButton = new ViewButton("查看按钮", "https://baidu.com");
//        一级菜单第三个按钮（二级菜单）
 //       SubButton subButton = new SubButton("更多");
//        二级button列表
        List<AbstractButton> subButtons = new ArrayList<>();
//        添加二级按钮
        subButtons.add(new ClickButton("二级", "SUB_CLICK_BUTTON"));
//        二级按钮加到一级上
//        subButton.setSubButton(subButtons);
//        添加所有按钮到list
//        abstractButtonList.add(clickButton);
        abstractButtonList.add(viewButton);
//        添加到menu
        menu.setButtons(abstractButtonList);

        ObjectMapper mapper = new ObjectMapper();

        try {
            String menuStr = mapper.writeValueAsString(menu);
            System.out.println(menuStr);
            String accessToken = Token.getAccessToken();
            String url  = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+accessToken;
            String postRes = HttpRequest.PostReq(url,menuStr);
            System.out.println(url);
            System.out.println(postRes);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
