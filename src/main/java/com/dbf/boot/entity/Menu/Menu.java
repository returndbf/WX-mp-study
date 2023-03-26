package com.dbf.boot.entity.Menu;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Menu {
    @JsonProperty("button")
  private List<AbstractButton> buttons;

    public List<AbstractButton> getButtons() {
        return buttons;
    }

    public void setButtons(List<AbstractButton> buttons) {
        this.buttons = buttons;
    }
}
