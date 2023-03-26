package com.dbf.boot.entity.Menu;

public class ViewButton extends AbstractButton {
    private String type;
    private String url;

    public ViewButton(String name, String url) {
        super(name);
        this.url = url;
        this.type = "view";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
