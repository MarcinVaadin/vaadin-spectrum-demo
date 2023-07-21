package org.vaadin.spectrum.demo.views;

import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.Route;
import org.vaadin.spectrum.SpButton;
import org.vaadin.spectrum.SpDivider;
import org.vaadin.spectrum.SpHtml;
import org.vaadin.spectrum.demo.DemoLayout;
import org.vaadin.spectrum.demo.DemoView;
import org.vaadin.spectrum.properties.HasSizeFluent;

@Route(value = "sp-button", layout = DemoLayout.class)
public class SpButtonView extends DemoView {

    private Span status = new Span();

    public SpButtonView() {
        super(SpButton.class);
        add(new Paragraph(new Span("Events: "), status));
        add(new SpDivider().setSize(HasSizeFluent.Size.S));

        add(SpHtml.header().text("Sizes").asH3());
        add(new SpDivider().setSize(HasSizeFluent.Size.S));
        Paragraph p1 = new Paragraph();
        p1.add(buildButton("s - small", HasSizeFluent.Size.S));
        p1.add(buildButton("m - medium", HasSizeFluent.Size.M));
        p1.add(buildButton("l - large", HasSizeFluent.Size.L));
        p1.add(buildButton("xl - extra large", HasSizeFluent.Size.XL));
        add(p1);

        add(SpHtml.header().text("States").asH3());
        add(new SpDivider().setSize(HasSizeFluent.Size.S));
        p1 = new Paragraph();
        p1.add(buildButton("normal", HasSizeFluent.Size.M));
        p1.add(buildButton("disabled", HasSizeFluent.Size.M).setDisabled(true));
        add(p1);

        add(SpHtml.header().text("Variants").asH3());
        add(new SpDivider().setSize(HasSizeFluent.Size.S));
        p1 = new Paragraph();
        for (SpButton.Variant variant : SpButton.Variant.values()) {
            p1.add(buildButton(variant.name(), HasSizeFluent.Size.M).setVariant(variant));
        }
        add(p1);

        add(SpHtml.header().text("Treatment").asH3());
        add(new SpDivider().setSize(HasSizeFluent.Size.S));
        p1 = new Paragraph();
        for (SpButton.Treatment treatment : SpButton.Treatment.values()) {
            p1.add(buildButton(treatment.name(), HasSizeFluent.Size.M).setTreatment(treatment));
        }
        add(p1);
    }

    private SpButton buildButton(String text, HasSizeFluent.Size size) {
        SpButton button = new SpButton(text).setSize(size);
        button.addClickListener(ev -> status.setText(ev.getSource().getText() + " clicked"));
        button.getStyle().set("margin-right", "10px");
        return button;
    }

}
