package com.dbf.boot.entity.Menu;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SubButton extends AbstractButton{
    @JsonProperty("sub_button")
    private List<AbstractButton> subButtons;
    public SubButton(String name) {
        super(name);
    }

    public List<AbstractButton> getSubButtons() {
        return subButtons;
    }

    public void setSubButton(List<AbstractButton> subButtons) {
        this.subButtons = subButtons;
    }
}
