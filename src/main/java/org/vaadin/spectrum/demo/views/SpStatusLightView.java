package org.vaadin.spectrum.demo.views;

import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.Route;
import org.vaadin.spectrum.SpDivider;
import org.vaadin.spectrum.SpHtml;
import org.vaadin.spectrum.SpStatusLight;
import org.vaadin.spectrum.demo.DemoLayout;
import org.vaadin.spectrum.demo.DemoView;
import org.vaadin.spectrum.properties.HasSizeFluent;

@Route(value = "sp-status-light", layout = DemoLayout.class)
public class SpStatusLightView extends DemoView {

    public SpStatusLightView() {
        super(SpStatusLight.class);

        add(SpHtml.header().text("Sizes").asH3());
        add(new SpDivider().setSize(HasSizeFluent.Size.S));
        Paragraph p1 = new Paragraph();
        p1.add(new SpStatusLight().setText("s - small").setSize(HasSizeFluent.Size.S));
        p1.add(new SpStatusLight().setText("m - medium").setSize(HasSizeFluent.Size.M));
        p1.add(new SpStatusLight().setText("l - large").setSize(HasSizeFluent.Size.L));
        p1.add(new SpStatusLight().setText("xl - extra large").setSize(HasSizeFluent.Size.XL));
        add(p1);

        add(SpHtml.header().text("Variants").asH3());
        add(new SpDivider().setSize(HasSizeFluent.Size.S));
        Paragraph p2 = new Paragraph();
        for(SpStatusLight.Variant variant : SpStatusLight.Variant.values()) {
            p2.add(new SpStatusLight().setVariant(variant).setText(variant.name().toLowerCase()));
        }
        add(p2);

        add(SpHtml.header().text("Disabled").asH3());
        add(new SpDivider().setSize(HasSizeFluent.Size.S));
        add(new Paragraph(new SpStatusLight().setText("disabled").setDisabled(true)));

    }
}
