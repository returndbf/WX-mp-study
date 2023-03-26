package com.dbf.boot.entity.Menu;

public class PhotoOrAlbumButton extends AbstractButton{
    private String key;
    private String type;

    public PhotoOrAlbumButton(String name) {
        super(name);
        this.type="pic_photo_or_album";
    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


}
