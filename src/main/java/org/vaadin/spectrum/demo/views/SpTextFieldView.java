package org.vaadin.spectrum.demo.views;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import org.vaadin.spectrum.SpFieldLabel;
import org.vaadin.spectrum.SpTextField;
import org.vaadin.spectrum.demo.DemoLayout;
import org.vaadin.spectrum.demo.DemoView;
import org.vaadin.spectrum.demo.model.Person;

@Route(value = "sp-textfield", layout = DemoLayout.class)
public class SpTextFieldView extends DemoView {

    public SpTextFieldView() {
        super(SpTextField.class);

        sectionDivider("Basic example");

        SpTextField field = new SpTextField();
        field.setLabel("Example field");
        field.setPlaceholder("First name");
        field.setRequired(true);
        field.setNegativeHelpText("First name is required");

        Person model = new Person();

        Binder<Person> binder = new Binder<>(Person.class);
        binder.bind(field, "firstName");
        binder.setBean(model);

        add(wrapHorizontal(field));

        sectionDivider("Multiline (TextArea)");
        SpFieldLabel label = new SpFieldLabel()
                .setText("Description")
                .setFor("multiline")
                .setSideAligned(SpFieldLabel.SideAligned.END);
        SpTextField field2 = new SpTextField();
        field2.setLabel("Example field");
        field2.setPlaceholder("I'm a textarea!");
        field2.setMultiline(true);
        field2.setRows(5);
        field2.setId("multiline");

        Div div = new Div(label, field2);
        add(wrapHorizontal(div));
    }

}
