package org.vaadin.spectrum.demo.views;

import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.Route;
import org.vaadin.spectrum.SpButton;
import org.vaadin.spectrum.SpButtonGroup;
import org.vaadin.spectrum.SpDivider;
import org.vaadin.spectrum.SpHtml;
import org.vaadin.spectrum.demo.DemoLayout;
import org.vaadin.spectrum.demo.DemoView;
import org.vaadin.spectrum.properties.HasSizeFluent;

@Route(value = "sp-button-group", layout = DemoLayout.class)
public class SpButtonGroupView extends DemoView {

    private Span status = new Span();

    public SpButtonGroupView() {
        super(SpButtonGroup.class);
        add(new Paragraph(new Span("Events: "), status));
        add(new SpDivider().setSize(HasSizeFluent.Size.S));

        add(SpHtml.header().text("Horizontal").asH3());
        add(new SpDivider().setSize(HasSizeFluent.Size.S));
        Paragraph p1 = new Paragraph();
        SpButtonGroup buttonGroup = new SpButtonGroup().setSize(HasSizeFluent.Size.M);
        buttonGroup.add(buildButton("Button 1", HasSizeFluent.Size.M));
        buttonGroup.add(buildButton("Looooooonger button", HasSizeFluent.Size.M));
        buttonGroup.add(buildButton("The button", HasSizeFluent.Size.M));
        p1.add(buttonGroup);
        add(p1);

        add(SpHtml.header().text("Vertical").asH3());
        add(new SpDivider().setSize(HasSizeFluent.Size.S));
        p1 = new Paragraph();
        buttonGroup = new SpButtonGroup().setSize(HasSizeFluent.Size.M).setVertical(true);
        buttonGroup.add(buildButton("Button 1", HasSizeFluent.Size.M));
        buttonGroup.add(buildButton("Looooooonger button", HasSizeFluent.Size.M));
        buttonGroup.add(buildButton("The button", HasSizeFluent.Size.M));
        p1.add(buttonGroup);
        add(p1);
    }

    private SpButton buildButton(String text, HasSizeFluent.Size size) {
        SpButton button = new SpButton().setText(text).setSize(size);
        button.addClickListener(ev -> status.setText(ev.getSource().getText() + " clicked"));
        return button;
    }

}
