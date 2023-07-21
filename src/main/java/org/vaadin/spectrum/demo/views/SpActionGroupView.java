package org.vaadin.spectrum.demo.views;

import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.Route;
import org.vaadin.spectrum.SpActionButton;
import org.vaadin.spectrum.SpActionGroup;
import org.vaadin.spectrum.SpDivider;
import org.vaadin.spectrum.SpIconsWorkflow;
import org.vaadin.spectrum.demo.DemoLayout;
import org.vaadin.spectrum.demo.DemoView;
import org.vaadin.spectrum.properties.HasSizeFluent;

import java.util.function.Consumer;

@Route(value = "sp-action-group", layout = DemoLayout.class)
public class SpActionGroupView extends DemoView {

    private Span status = new Span();

    public SpActionGroupView() {
        super(SpActionGroup.class);
        add(new Paragraph(new Span("Events: "), status));
        add(new SpDivider().setSize(HasSizeFluent.Size.S));

        sectionDivider("Standard");
        SpActionGroup actionGroup = buildButtonBar(b -> {});
        add(actionGroup);

        sectionDivider("Compact");
        actionGroup = buildButtonBar(b -> {}).setCompact(true);
        add(actionGroup);

        sectionDivider("Single selection");
        actionGroup = buildButtonBar(b -> {}).setSelects(SpActionGroup.Selects.SINGLE);
        add(actionGroup);

        sectionDivider("Multiple selection");
        actionGroup = buildButtonBar(b -> {}).setSelects(SpActionGroup.Selects.MULTIPLE);
        add(actionGroup);

        sectionDivider("Vertical");
        actionGroup = buildButtonBar(b -> {}).setVertical(true);
        add(actionGroup);

        sectionDivider("Justified");
        actionGroup = buildButtonBar(b -> {}).setJustified(true);
        add(actionGroup);

    }

    private SpActionGroup buildButtonBar(Consumer<SpActionButton> modifier) {
        SpActionButton button1 = new SpActionButton().setText("Edit").setValue("Button 1");
        SpActionButton button2 = new SpActionButton().setText("Edit").setIcon(SpIconsWorkflow.EDIT.build()).setValue("Button 2");
        SpActionButton button3 = new SpActionButton().setIcon(SpIconsWorkflow.EDIT.build()).setValue("Button 3");
        SpActionButton button4 = new SpActionButton().setIcon(SpIconsWorkflow.EDIT.build()).setHoldAffordance(true).setValue("Button 4");
        modifier.accept(button1);
        modifier.accept(button2);
        modifier.accept(button3);
        modifier.accept(button4);
        SpActionGroup wrapper = new SpActionGroup();
        wrapper.addChangeEventListener(ev -> status.setText(ev.getSource().getSelected()));
        wrapper.add(button1, button2, button3, button4);
        return wrapper;
    }
}
