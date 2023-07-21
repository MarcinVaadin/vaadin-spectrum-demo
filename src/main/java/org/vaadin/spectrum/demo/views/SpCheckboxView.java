package org.vaadin.spectrum.demo.views;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.Route;
import org.vaadin.spectrum.SpCheckbox;
import org.vaadin.spectrum.SpHtml;
import org.vaadin.spectrum.demo.DemoLayout;
import org.vaadin.spectrum.demo.DemoView;

import java.util.List;

import static org.vaadin.spectrum.properties.HasSizeFluent.Size;

@Route(value = "sp-checkbox", layout = DemoLayout.class)
public class SpCheckboxView extends DemoView {

    private Span status = new Span();

    public SpCheckboxView() {
        super(SpCheckbox.class);

        sectionDivider("Size");

        for (Size size : List.of(Size.S, Size.M, Size.L, Size.XL)) {
            add(SpHtml.paragraph().components(new SpCheckbox().setText(size.name()).setSize(size)).build());
        }

        sectionDivider("Example");

        add(SpHtml.paragraph().components(new SpCheckbox().setText("Normal")).build());
        add(SpHtml.paragraph().components(new SpCheckbox().setText("Checked").setChecked(true)).build());
        add(SpHtml.paragraph().components(new SpCheckbox().setText("Indeterminate").setIndeterminate(true)).build());
        add(SpHtml.paragraph().components(new SpCheckbox().setText("Invalid").setInvalid(true)).build());
        add(SpHtml.paragraph().components(new SpCheckbox().setText("Emphasized, Checked").setEmphasized(true).setChecked(true)).build());

        sectionDivider("Events");
        add(SpHtml.paragraph().components(new Span("Events: "), status).build());
        SpCheckbox checkbox = new SpCheckbox().setText("Checkbox");
        checkbox.addClickListener(ev -> status.setText(ev.getSource().isChecked() ? "checked" : "not checked"));
        add(SpHtml.paragraph().components(checkbox).build());



    }
}
