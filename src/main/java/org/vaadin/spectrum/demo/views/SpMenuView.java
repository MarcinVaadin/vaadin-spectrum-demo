package org.vaadin.spectrum.demo.views;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.spectrum.SpDivider;
import org.vaadin.spectrum.SpHtml;
import org.vaadin.spectrum.SpLink;
import org.vaadin.spectrum.SpMenu;
import org.vaadin.spectrum.demo.DemoLayout;
import org.vaadin.spectrum.demo.DemoView;
import org.vaadin.spectrum.properties.HasSizeFluent;

@Route(value = "sp-menu", layout = DemoLayout.class)
public class SpMenuView extends DemoView {

    public SpMenuView() {
        super(SpMenu.class);

        add(SpHtml.header().text("Variants").asH3());
        add(new SpDivider().setSize(HasSizeFluent.Size.S));
        HorizontalLayout p1 = new HorizontalLayout();
        p1.getStyle().set("margin-top", "14px");
        p1.add(new SpLink("#", "standard"));
        for (SpLink.Variant variant : SpLink.Variant.values()) {
            p1.add(new SpLink("#", variant.name().toLowerCase()).setVariant(variant));
        }
        add(p1);

        add(SpHtml.header().text("Quiet").asH3());
        add(new SpDivider().setSize(HasSizeFluent.Size.S));
        p1 = new HorizontalLayout();
        p1.getStyle().set("margin-top", "14px");
        p1.add(new SpLink("#", "quiet standard").setQuiet(true));
        p1.add(new SpLink("#", "quiet secondary").setQuiet(true).setVariant(SpLink.Variant.SECONDARY));
        add(p1);

        add(SpHtml.header().text("Static").asH3());
        add(new SpDivider().setSize(HasSizeFluent.Size.S));
        p1 = new HorizontalLayout();
        p1.getStyle().set("margin-top", "14px").set("background-color", "var(--spectrum-global-color-gray-400)");
        p1.add(new SpLink("#", "normal"));
        for (SpLink.Static _static : SpLink.Static.values()) {
            p1.add(new SpLink("#", _static.name().toLowerCase()).setStatic(_static));
        }
        add(p1);
    }

}
