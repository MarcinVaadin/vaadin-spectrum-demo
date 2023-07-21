package org.vaadin.spectrum.demo.views;

import com.vaadin.flow.router.Route;
import org.vaadin.spectrum.SpActionMenu;
import org.vaadin.spectrum.SpMenuItem;
import org.vaadin.spectrum.demo.DemoLayout;
import org.vaadin.spectrum.demo.DemoView;

@Route(value = "sp-action-menu", layout = DemoLayout.class)
public class SpActionMenuView extends DemoView {

    public SpActionMenuView() {
        super(SpActionMenu.class);

        sectionDivider("Example");

        SpActionMenu menu = new SpActionMenu();
        menu.addMenuItem(new SpMenuItem().setValue("item-1").setText("Square"));
        menu.addMenuItem(new SpMenuItem().setValue("item-2").setText("Triangle"));
        menu.addMenuItem(new SpMenuItem().setValue("item-3").setText("Star"));
        menu.addMenuItem(new SpMenuItem().setValue("item-4").setText("Circle"));
        add(menu);

    }
}
