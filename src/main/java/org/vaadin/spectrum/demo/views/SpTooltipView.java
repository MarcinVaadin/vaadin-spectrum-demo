package org.vaadin.spectrum.demo.views;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.spectrum.*;
import org.vaadin.spectrum.demo.DemoLayout;
import org.vaadin.spectrum.demo.DemoView;
import org.vaadin.spectrum.properties.HasSizeFluent;
import org.vaadin.spectrum.utils.Placement;

@Route(value = "sp-tooltip", layout = DemoLayout.class)
public class SpTooltipView extends DemoView {

    public SpTooltipView() {
        super(SpTooltip.class);

        add(SpHtml.header().text("Variants").asH3());
        add(new SpDivider().setSize(HasSizeFluent.Size.S));
        HorizontalLayout p1 = new HorizontalLayout();
        p1.getStyle().set("margin-top", "14px");
        p1.add(new SpTooltip().setText("standard").setOpen(true));
        for (SpTooltip.Variant variant : SpTooltip.Variant.values()) {
            p1.add(new SpTooltip().setText(variant.name().toLowerCase()).setVariant(variant).setOpen(true));
        }
        add(p1);

        add(SpHtml.header().text("Placement").asH3());
        add(new SpDivider().setSize(HasSizeFluent.Size.S));
        p1 = new HorizontalLayout();
        p1.getStyle().set("margin-top", "14px");
        p1.add(new SpTooltip().setText("top").setOpen(true).setPlacement(Placement.TOP));
        p1.add(new SpTooltip().setText("right").setOpen(true).setPlacement(Placement.RIGHT));
        p1.add(new SpTooltip().setText("bottom").setOpen(true).setPlacement(Placement.BOTTOM));
        p1.add(new SpTooltip().setText("left").setOpen(true).setPlacement(Placement.LEFT));
        add(p1);

        add(SpHtml.header().text("With icon").asH3());
        add(new SpDivider().setSize(HasSizeFluent.Size.S));
        add(new SpIconsMedium());
        p1 = new HorizontalLayout();
        p1.getStyle().set("margin-top", "14px");
        p1.add(new SpTooltip().setText("info").setVariant(SpTooltip.Variant.INFO).setOpen(true).setPlacement(Placement.TOP).setIcon(new SpIcon().setName("ui:Arrow100")));
        p1.add(new SpTooltip().setText("error").setVariant(SpTooltip.Variant.NEGATIVE).setOpen(true).setPlacement(Placement.TOP).setIcon(new SpIcon().setName("ui:Arrow100")));
        p1.add(new SpTooltip().setText("success").setVariant(SpTooltip.Variant.POSITIVE).setOpen(true).setPlacement(Placement.TOP).setIcon(new SpIcon().setName("ui:Arrow100")));
        add(p1);
    }

}
