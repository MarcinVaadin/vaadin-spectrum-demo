package org.vaadin.spectrum.demo.views;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.spectrum.SpBadge;
import org.vaadin.spectrum.SpIcon;
import org.vaadin.spectrum.SpIconsMedium;
import org.vaadin.spectrum.demo.DemoLayout;
import org.vaadin.spectrum.demo.DemoView;

import java.util.List;

import static org.vaadin.spectrum.properties.HasSizeFluent.Size;

@Route(value = "sp-badge", layout = DemoLayout.class)
public class SpBadgeView extends DemoView {

    public SpBadgeView() {
        super(SpBadge.class);

        sectionDivider("Sizes");

        add(new SpIconsMedium());

        for(Size size : List.of(Size.S, Size.M, Size.L, Size.XL)) {
            SpBadge badge1 = new SpBadge().setText("Label").setSize(size);
            SpBadge badge2 = new SpBadge().setText("Icon and label")
                    .setIcon(new SpIcon().setName("ui:Asterisk75"))
                    .setSize(size);
            add(wrapHorizontal(new Span(size.name()), badge1, badge2));
        }

        sectionDivider("Variants");

        HorizontalLayout wrapper = wrapHorizontal();
        for (SpBadge.Variant variant : SpBadge.Variant.values()) {
            wrapper.add(new SpBadge().setText(variant.name()).setVariant(variant));
        }
        add(wrapper);

        sectionDivider("Fixed");

        wrapper = wrapHorizontal();
        for (SpBadge.Fixed fixed : SpBadge.Fixed.values()) {
            wrapper.add(new SpBadge().setText(fixed.name()).setFixed(fixed));
        }
        add(wrapper);

    }
}