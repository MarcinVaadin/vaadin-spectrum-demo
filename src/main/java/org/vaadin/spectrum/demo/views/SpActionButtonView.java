package org.vaadin.spectrum.demo.views;

import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.spectrum.SpActionButton;
import org.vaadin.spectrum.SpDivider;
import org.vaadin.spectrum.SpIconsWorkflow;
import org.vaadin.spectrum.demo.DemoLayout;
import org.vaadin.spectrum.demo.DemoView;
import org.vaadin.spectrum.properties.HasSizeFluent;

import java.util.function.Consumer;

@Route(value = "sp-action-button", layout = DemoLayout.class)
public class SpActionButtonView extends DemoView {

    private Span status = new Span();

    public SpActionButtonView() {
        super(SpActionButton.class);
        add(new Paragraph(new Span("Events: "), status));
        add(new SpDivider().setSize(HasSizeFluent.Size.S));

        sectionDivider("Sizes");
        VerticalLayout wrapper = wrapVertical();
        for (HasSizeFluent.Size size : HasSizeFluent.Size.values()) {
            HorizontalLayout layout = buildButtonBar(null, b -> b.setSize(size));
            layout.addComponentAsFirst(new H4(size.name()));
            wrapper.add(layout);
        }
        add(wrapper);

        sectionDivider("Variants");
        wrapper = wrapVertical();
        for (SpActionButton.Variant variant : SpActionButton.Variant.values()) {
            HorizontalLayout layout = buildButtonBar(null, b -> b.setVariant(variant));
            layout.addComponentAsFirst(new H4(variant.name()));
            wrapper.add(layout);
        }
        add(wrapper);

        sectionDivider("Quiet");
        addFeaturePreviewBar(b -> b.setQuiet(true));

        sectionDivider("Emphasized");
        addFeaturePreviewBar(b -> b.setEmphasized(true));

        sectionDivider("Emphasized+Quiet");
        addFeaturePreviewBar(b -> b.setEmphasized(true).setQuiet(true));

        sectionDivider("Toggles");
        add(wrapHorizontal(buildButtonBar(null, b -> b.setToggles(true))));
    }

    private void addFeaturePreviewBar(Consumer<SpActionButton> modifier) {
        VerticalLayout wrapper = wrapVertical();
        wrapper.add(buildButtonBar("Default", modifier));
        wrapper.add(buildButtonBar("Selected", modifier.andThen(c -> c.setSelected(true))));
        wrapper.add(buildButtonBar("Disabled", modifier.andThen(c -> c.setDisabled(true))));
        wrapper.add(buildButtonBar("Disabled+Selected", modifier.andThen(c -> c.setDisabled(true).setSelected(true))));
        add(wrapper);
    }

    private HorizontalLayout buildButtonBar(String title, Consumer<SpActionButton> modifier) {
        SpActionButton button1 = new SpActionButton().setText("Edit");
        SpActionButton button2 = new SpActionButton().setText("Edit").setIcon(SpIconsWorkflow.EDIT.build());
        SpActionButton button3 = new SpActionButton().setIcon(SpIconsWorkflow.EDIT.build());
        SpActionButton button4 = new SpActionButton().setIcon(SpIconsWorkflow.EDIT.build()).setHoldAffordance(true);
        button1.addClickListener(ev -> status.setText("Button 1 clicked, selected: " + ev.getSource().isSelected()));
        button1.addLongPressEventListener(ev -> status.setText("Button 1 long pressed"));
        button2.addClickListener(ev -> status.setText("Button 2 clicked, selected: " + ev.getSource().isSelected()));
        button2.addLongPressEventListener(ev -> status.setText("Button 2 long pressed"));
        button3.addClickListener(ev -> status.setText("Button 3 clicked, selected: " + ev.getSource().isSelected()));
        button3.addLongPressEventListener(ev -> status.setText("Button 3 long pressed"));
        button4.addClickListener(ev -> status.setText("Button 4 clicked, selected: " + ev.getSource().isSelected()));
        button4.addLongPressEventListener(ev -> status.setText("Button 4 long pressed"));
        modifier.accept(button1);
        modifier.accept(button2);
        modifier.accept(button3);
        modifier.accept(button4);
        HorizontalLayout wrapper = new HorizontalLayout();
        wrapper.setAlignItems(FlexComponent.Alignment.CENTER);
        wrapper.add(new H4(title), button1, button2, button3, button4);
        return wrapper;
    }

}