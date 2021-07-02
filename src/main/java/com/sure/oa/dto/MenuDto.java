package com.sure.oa.dto;

import java.util.List;

public class MenuDto {

    private Integer menuId;
    private String menuName;
    private String menuUrl;
    private List<MenuDto> subMenus;
    public Integer getMenuId() {
        return menuId;
    }
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
    public String getMenuName() {
        return menuName;
    }
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    public String getMenuUrl() {
        return menuUrl;
    }
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }
    public List<MenuDto> getSubMenus() {
        return subMenus;
    }
    public void setSubMenus(List<MenuDto> subMenus) {
        this.subMenus = subMenus;
    }
}
