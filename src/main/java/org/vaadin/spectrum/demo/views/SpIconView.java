package org.vaadin.spectrum.demo.views;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.spectrum.SpDivider;
import org.vaadin.spectrum.SpHtml;
import org.vaadin.spectrum.SpIcon;
import org.vaadin.spectrum.SpIconsMedium;
import org.vaadin.spectrum.demo.DemoLayout;
import org.vaadin.spectrum.demo.DemoView;
import org.vaadin.spectrum.properties.HasSizeFluent.Size;

import java.util.List;

@Route(value = "sp-icon", layout = DemoLayout.class)
public class SpIconView extends DemoView {

    public SpIconView() {
        super(SpIcon.class);

        add(new SpIconsMedium());

        add(SpHtml.header().text("Sizes").asH3());
        add(new SpDivider().setSize(Size.S));

        HorizontalLayout p1 = new HorizontalLayout();
        p1.getStyle().set("margin-top", "14px");
        p1.add();
        for (Size size : List.of(Size.S, Size.M, Size.L, Size.XL, Size.XXL)) {
            p1.add(new Span(size.name()), new SpIcon().setName("ui:Arrow100").setSize(size));
        }
        add(p1);

        add(SpHtml.header().text("Color").asH3());
        add(new SpDivider().setSize(Size.S));

        SpIcon icon = new SpIcon().setName("ui:Arrow100").setSize(Size.XL);
        icon.getStyle().set("color", "red");
        SpIcon icon2 = new SpIcon().setName("ui:Arrow100").setSize(Size.XL);
        icon2.getStyle().set("color", "green");
        SpIcon icon3 = new SpIcon().setName("ui:Arrow100").setSize(Size.XL);
        icon3.getStyle().set("color", "blue");
        add(wrapHorizontal(icon, icon2, icon3));

    }

}
