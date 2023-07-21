package org.vaadin.spectrum.demo.views;

import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.Route;
import org.vaadin.spectrum.SpDivider;
import org.vaadin.spectrum.SpHtml;
import org.vaadin.spectrum.demo.DemoLayout;
import org.vaadin.spectrum.demo.DemoView;
import org.vaadin.spectrum.properties.HasSizeFluent;

@Route(value = "sp-divider", layout = DemoLayout.class)
public class SpDividerView extends DemoView {

    public SpDividerView() {
        super(SpDivider.class);

        add(SpHtml.header().text("Horizontal").asH3());
        add(new SpDivider().setSize(HasSizeFluent.Size.S));
        Paragraph p1 = new Paragraph();
        p1.add(SpHtml.header().text("Size: S").asH4());
        p1.add(new SpDivider().setSize(HasSizeFluent.Size.S));
        p1.add(SpHtml.header().text("Size: M").asH4());
        p1.add(new SpDivider().setSize(HasSizeFluent.Size.M));
        p1.add(SpHtml.header().text("Size: L").asH4());
        p1.add(new SpDivider().setSize(HasSizeFluent.Size.L));
        add(p1);

        add(SpHtml.header().text("vertical").asH3());
        add(new SpDivider().setSize(HasSizeFluent.Size.S));
        p1 = new Paragraph();
        p1.getElement().setAttribute("style", "display: flex;\n" +
                "    height: 30px;\n" +
                "    align-items: center;\n" +
                "    gap: 10px;");
        p1.add(SpHtml.header().text("Size: S -> ").asH4());
        p1.add(new SpDivider().setSize(HasSizeFluent.Size.S).setVertical(true));
        p1.add(SpHtml.header().text("Size: M -> ").asH4());
        p1.add(new SpDivider().setSize(HasSizeFluent.Size.M).setVertical(true));
        p1.add(SpHtml.header().text("Size: L -> ").asH4());
        p1.add(new SpDivider().setSize(HasSizeFluent.Size.L).setVertical(true));
        add(p1);

    }

}
